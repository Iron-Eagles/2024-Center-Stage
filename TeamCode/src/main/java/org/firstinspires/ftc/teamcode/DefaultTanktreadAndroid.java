//for copying purposes only

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="TankAndroid", group="Linear Opmode")

public class DefaultTanktreadAndroid extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    DcMotor left, right;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        left  = hardwareMap.get(DcMotor.class, "Left");
        right = hardwareMap.get(DcMotor.class, "Right");

        left.setDirection(DcMotor.Direction.FORWARD);
        right.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();
        runtime.reset();


        while (opModeIsActive()) {

            double lY1, rY1;

            lY1 = gamepad1.left_stick_y;
            rY1 = gamepad1.right_stick_y;

            left.setPower(lY1);
            right.setPower(rY1);

            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();
        }
    }
}
