//for copying purposes only. Use this as a starter for any other code you may be working on.

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.ColorSensor;

import java.util.List;

@TeleOp(name="Basic: Linear OpMode", group="Linear Opmode")

public class DefaultMecanum extends LinearOpMode {
    
    DcMotor leftFront, rightFront, rightBack, leftBack;
    ElapsedTime runtime = new ElapsedTime();
    
      
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
        leftBack.setDirection(DcMotor.Direction.FORWARD);
        
        
        waitForStart();
        runtime.reset();
        
        while (opModeIsActive()) {
            
            double lX1, lY1, rX1, rY1;
            
            lX1 = gamepad1.left_stick_x;
            lY1 = gamepad1.left_stick_y;
            rX1 = gamepad1.right_stick_x;
            rY1 = gamepad1.right_stick_y;
            
            double a = lY1 + lX1;
            double b = rY1 - lX1;
            double c = lY1 - lX1;
            double d = rY1 + lX1;
            
            a = Range.clip(a, -1, 1);
            b = Range.clip(b, -1, 1);
            c = Range.clip(c, -1, 1);
            d = Range.clip(d, -1, 1);
            
            leftFront.setPower(a);
            rightFront.setPower(b);
            leftBack.setPower(c);
            rightBack.setPower(d);
            
            
            
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();
        }
    }
}

