package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

//I added this to try to test servos
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="Motor Test", group="Linear Opmode")
public class MotorTest extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor testMotor;

    //I will admit I have no idea if this works
    private Servo testServo;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        
        testMotor = hardwareMap.get(DcMotorEx.class, "TestMotor");

        Servo testServo = hardwareMap.get(Servo.class, "testServo");
        
        
        waitForStart();
        runtime.reset();
        double angle = 0;
        
        while (opModeIsActive()) {

            
            double rotation = gamepad1.left_stick_y;
            //testMotor.setPower(rotation);
            angle = angle + rotation;
            testServo.setPosition(20);
            
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();
        }
    }
}




