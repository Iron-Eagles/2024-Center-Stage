//for copying purposes only. Use this as a starter for any other code you may be working on.
/*
package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.ColorSensor;

import java.util.List;

@TeleOp(name="Iteration 5 - Active", group="Linear Opmode")

public class Iteration5 extends LinearOpMode {
    
    DcMotorEx leftFront, rightFront, rightBack, leftBack;
    DcMotor conveyor, intake1, intake2;
    ElapsedTime runtime = new ElapsedTime();
    boolean turboMode = false, reset;
    double driveConst;
    
    
    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        
        
        leftFront = hardwareMap.get(DcMotorEx.class, "LeftFront");
        rightFront = hardwareMap.get(DcMotorEx.class, "RightFront");
        rightBack = hardwareMap.get(DcMotorEx.class, "RightBack");
        leftBack = hardwareMap.get(DcMotorEx.class, "LeftBack");
        
        leftFront.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        
        leftFront.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        leftBack.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        
        conveyor = hardwareMap.get(DcMotor.class, "Conveyor");
        intake1 = hardwareMap.get(DcMotor.class, "Intake1");
        intake2 = hardwareMap.get(DcMotor.class, "Intake2");
        
        leftFront.setDirection(DcMotorEx.Direction.FORWARD);
        rightFront.setDirection(DcMotorEx.Direction.REVERSE);
        rightBack.setDirection(DcMotorEx.Direction.REVERSE);
        leftBack.setDirection(DcMotorEx.Direction.FORWARD);
        
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
            
            
            if (gamepad1.a == true) {
              turboMode = Toggle(turboMode);
            } else {
              reset = false;
            }
            
            if(turboMode == true) {
              driveConst = 1;
            } else {
              driveConst = 0.5;
            }
            
            leftFront.setPower(-a * driveConst);
            rightFront.setPower(-b * driveConst);
            leftBack.setPower(-c * driveConst);
            rightBack.setPower(-d * driveConst);
            
            if (gamepad1.dpad_up) {
              conveyor.setPower(-1);
              intake1.setPower(1);
              intake2.setPower(-1);
            } else if (gamepad1.dpad_down || gamepad1.dpad_right) {
              conveyor.setPower(0);
              intake1.setPower(0);
              intake2.setPower(0);
            } else if (gamepad1.dpad_left) {
              conveyor.setPower(1);
              intake1.setPower(-1);
              intake2.setPower(1);
            }
            
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Status", "Turbo: " + turboMode);
            telemetry.update();
        }
    }
    
    boolean Toggle(boolean tog) {
      boolean value;
      
      if (reset == false) {
        reset = true;
        if (tog == true) {
          value = false;
          return value;
        } else if (tog == false) {
          value = true;
          return value;
        } else {
          return tog;
        }
      }
       return tog;
    }
}

*/


