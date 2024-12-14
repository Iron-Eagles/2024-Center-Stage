//Power Play 2024 Push Bot

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="_Push Bot - CS 2024", group="Linear Opmode")

public class PushBot_CS_2024 extends LinearOpMode {

    DcMotor rightBack, leftBack, rightFront, leftFront;
    //servo example
    Servo leftClaw, rightClaw;
    ElapsedTime runtime = new ElapsedTime();


    //The speeds were originally nor:0.5  turbo:1   pre:0.25
    boolean attempted = false;
    //swear count, very temp.
    int swearCount = 57;
    double normalSpeed = 0.5;
    //every time Eli swears, I will reduce this speed by 0.01, current 0.18
    double turboSpeed = 1;
    double precisionSpeed = 0.25;

    double realSpeed = 0.5;
    boolean turboMode = false, reset = false;

    @Override
    public void runOpMode() {
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");

        //leftClaw = hardwareMap.get(Servo.class, "LeftyClaw");
        //rightClaw = hardwareMap.get(Servo.class, "RightyClaw");


        leftFront.setDirection(DcMotor.Direction.REVERSE);
        rightFront.setDirection(DcMotor.Direction.REVERSE);
        rightBack.setDirection(DcMotor.Direction.FORWARD);
        leftBack.setDirection(DcMotor.Direction.FORWARD); //tell ELI To fix this motor gear + tell ELI To fix this wheel

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        int temp = 0;

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {

            double lx, ly, ry;

            lx = gamepad1.left_stick_x;
            ly = gamepad1.left_stick_y;
            ry = gamepad1.right_stick_y;

            //double a = ly - ry - lx;
            //double b = ly + ry - lx;
            //double c = ly - ry + lx;
            //double d = ly + ry + lx;

            double a = ly - lx;
            double b = ry + lx;
            double c = ry - lx;
            double d = ly + lx;
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
            /*
            if (temp > 0) {
                temp = temp - 1;
                leftFront.setPower(realSpeed);
                rightFront.setPower(realSpeed);
                rightBack.setPower(realSpeed);
                leftBack.setPower(realSpeed);
            }
            */
            telemetry.addData("Turbo", turboMode);
            telemetry.addData("Elapsed Time", runtime.seconds());
            telemetry.update();

            /*
            if (gamepad1.a) {
                temp = 200;
            }
            */
            //if (gamepad1.b) {
                //leftClaw.setPosition(0.5);
                //rightClaw.setPosition(0.5);
                //It will be more like myservo.write(dir)
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
