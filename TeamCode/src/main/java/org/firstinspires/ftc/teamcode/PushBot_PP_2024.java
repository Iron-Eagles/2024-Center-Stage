//Power Play 2024 Push Bot

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="_Push Bot - PP 2024", group="Linear Opmode")

public class PushBot_PP_2024 extends LinearOpMode {
    
    DcMotor leftFront, rightFront, rightBack, leftBack;
    ElapsedTime runtime = new ElapsedTime();

    boolean attempted = false;

    double adjSpeedConstant = 0.4;
    double realSpeed = 1;
    boolean turboMode = false, reset = false;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        leftFront = hardwareMap.get(DcMotor.class, "LeftFront");
        rightFront = hardwareMap.get(DcMotor.class, "RightFront");
        rightBack = hardwareMap.get(DcMotor.class, "RightBack");
        leftBack = hardwareMap.get(DcMotor.class, "LeftBack");

        leftFront.setDirection(DcMotor.Direction.FORWARD);
        rightFront.setDirection(DcMotor.Direction.REVERSE);
        rightBack.setDirection(DcMotor.Direction.REVERSE);
        leftBack.setDirection(DcMotor.Direction.REVERSE); //tell ELI To fix this motor gear

        waitForStart();
        runtime.reset();
        
        while (opModeIsActive()) {
            
            double lX1, lY1, rY1;
            
            lX1 = gamepad1.left_stick_x;
            lY1 = gamepad1.left_stick_y;
            rY1 = gamepad1.right_stick_y;
            
            double a = lY1 - lX1;
            double b = rY1 - lX1;
            double c = lY1 + lX1;
            double d = rY1 + lX1;

            a = Range.clip(a, -1, 1);
            b = Range.clip(b, -1, 1);
            c = Range.clip(c, -1, 1);
            d = Range.clip(d, -1, 1);

            if (gamepad1.a) {
                turboMode = Toggle(turboMode);
            } else {
                reset = false;
            }

            if (turboMode) {
                realSpeed = 0.6;
            } else {
                realSpeed = adjSpeedConstant;
            }

            leftFront.setPower(a * adjSpeedConstant);
            rightFront.setPower(b * adjSpeedConstant);
            leftBack.setPower(c * adjSpeedConstant);
            rightBack.setPower(d * adjSpeedConstant);

            telemetry.addData("Turbo", turboMode);
            telemetry.addData("Elapsed Time", runtime.seconds());
            telemetry.update();
        }
    }

    boolean Toggle(boolean input) {
        if (reset == false) {
            reset = true;
            attempted = true;
            return !input;
        } else {
            return input;

        }
    }
}

