//Power Play 2024 Push Bot

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="_Push Bot - CS 2024", group="Linear Opmode")

public class PushBot_CS_2024 extends LinearOpMode {
    
    DcMotor leftFront, rightFront, rightBack, leftBack;
    //servo example
    Servo leftClaw, rightClaw;
    ElapsedTime runtime = new ElapsedTime();

    boolean attempted = false;


    double normalSpeed = 0.5;
    double turboSpeed = 1.0;
    double precisionSpeed = 0.25;

    double realSpeed = 1;
    boolean turboMode = false, reset = false;

    @Override
    public void runOpMode() {
        leftFront = hardwareMap.get(DcMotor.class, "LeftFront");
        rightFront = hardwareMap.get(DcMotor.class, "RightFront");
        rightBack = hardwareMap.get(DcMotor.class, "RightBack");
        leftBack = hardwareMap.get(DcMotor.class, "LeftBack");

        //leftClaw = hardwareMap.get(Servo.class, "LeftyClaw");
        //rightClaw = hardwareMap.get(Servo.class, "RightyClaw");


        leftFront.setDirection(DcMotor.Direction.FORWARD);
        rightFront.setDirection(DcMotor.Direction.REVERSE);
        rightBack.setDirection(DcMotor.Direction.REVERSE);
        leftBack.setDirection(DcMotor.Direction.REVERSE); //tell ELI To fix this motor gear

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();
        
        while (opModeIsActive()) {
            
            double lx, ly, rx;
            
            lx = gamepad1.left_stick_x;
            ly = gamepad1.left_stick_y;
            rx = gamepad1.right_stick_x;
            
            double a = ly - rx - lx;
            double b = ly + rx - lx;
            double c = ly + rx + lx;
            double d = ly - rx + lx;

            a = Range.clip(a, -1, 1);
            b = Range.clip(b, -1, 1);
            c = Range.clip(c, -1, 1);
            d = Range.clip(d, -1, 1);

            if (gamepad1.right_bumper) {
                realSpeed = turboSpeed;
            } else if (gamepad1.left_bumper) {
                realSpeed = precisionSpeed;
            } else {
                realSpeed = normalSpeed;
            }

            leftFront.setPower(a * realSpeed);
            rightFront.setPower(b * realSpeed);
            rightBack.setPower(c * realSpeed);
            leftBack.setPower(d * realSpeed);

            telemetry.addData("Turbo", turboMode);
            telemetry.addData("Elapsed Time", runtime.seconds());
            telemetry.update();


            if (gamepad1.a) {
                //leftClaw.setPosition(0.25);
                //rightClaw.setPosition(0.75);
            }
            if (gamepad1.b) {
                //leftClaw.setPosition(0.5);
                //rightClaw.setPosition(0.5);
            }
        }
    }
    /*
    boolean Toggle(boolean input) {
        if (reset == false) {
            reset = true;
            return !input;
        } else {
            return input;

        }

    }

     */
}

