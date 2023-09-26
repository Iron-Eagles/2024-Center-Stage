/*

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Basic: Linear OpMode", group="Linear Opmode")

public class MotorTest extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor testMotor;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        
        testMotor = hardwareMap.get(DcMotorEx.class, "TestMotor");

        
        
        
        waitForStart();
        runtime.reset();

        
        while (opModeIsActive()) {

            
            double rotation = gamepad1.left_stick_y;
            testMotor.setPower(rotation);

            
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();
        }
    }
}


*/


