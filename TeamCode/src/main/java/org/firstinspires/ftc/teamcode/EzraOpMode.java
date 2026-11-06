package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp


public class EzraOpMode extends LinearOpMode {


    private DcMotor rightMotor;
    private DcMotor leftMotor;


    @Override
    public void runOpMode() {


        // Connect motors
        leftMotor = hardwareMap.get(DcMotor.class, "lMotor");
        rightMotor = hardwareMap.get(DcMotor.class, "rMotor");



        telemetry.addData("Status", "Ready");
        telemetry.update();


        // Wait for PLAY
        waitForStart();


        while (opModeIsActive()) {


            // Read joystick values
            double leftPower = -this.gamepad1.left_stick_y;
            double rightPower = -this.gamepad1.right_stick_y * -1;


            // Control left motors
            leftMotor.setPower(leftPower);


            // Control right motors
            rightMotor.setPower(rightPower);
        }
        leftMotor.setPower(0);
        rightMotor.setPower(0);
    }
}