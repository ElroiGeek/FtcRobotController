package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

// Imports
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@Autonomous
public class Automation_Right extends LinearOpMode {

    private DcMotor lMotor;
    private DcMotor rMotor;

    private DcMotor intakeMotor;

    private DcMotor launcher;
    private Servo gate;

    @Override
    public void runOpMode(){

        lMotor = hardwareMap.get(DcMotor.class, "lMotor");
        rMotor = hardwareMap.get(DcMotor.class, "rMotor");
        intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");
        launcher = hardwareMap.get(DcMotor.class, "launcherMotor");
        gate = hardwareMap.get(Servo.class, "rSpinner");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()){


        }

        intakeMotor.setPower(0);
    }
}

