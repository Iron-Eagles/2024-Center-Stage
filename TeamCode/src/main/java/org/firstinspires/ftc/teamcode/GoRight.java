package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.ColorSensor;

import java.util.List;

@Autonomous
public class GoRight extends LinearOpMode {
  private DcMotor LeftFront, RightFront, RightBack, LeftBack;
  private ElapsedTime     runtime = new ElapsedTime();
  
  
  @Override
  public void runOpMode() {
    
    //this freaking sucks
    LeftFront = hardwareMap.get(DcMotor.class, "RightBack");
    RightFront = hardwareMap.get(DcMotor.class, "LeftBack");
    RightBack = hardwareMap.get(DcMotor.class, "LeftFront");
    LeftBack = hardwareMap.get(DcMotor.class, "RightFront");
    
    
    
    waitForStart();
    
    while (opModeIsActive()) {
      runtime.reset();
      
      
      while (runtime.seconds() < 1) {
        LeftFront.setPower(-1);
        RightFront.setPower(-1);
        RightBack.setPower(1);
        LeftBack.setPower(1);
      } 
      while (runtime.seconds() > 1) {
        LeftFront.setPower(0);
        RightFront.setPower(0);
        RightBack.setPower(0);
        LeftBack.setPower(0);
      }
      
    }
  }
}
