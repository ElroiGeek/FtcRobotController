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

    private Servo flipper;

    @Override
    public void runOpMode(){

        lMotor = hardwareMap.get(DcMotor.class, "lMotor");
        rMotor = hardwareMap.get(DcMotor.class, "rMotor");
        intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");
        launcher = hardwareMap.get(DcMotor.class, "launcherMotor");
        gate = hardwareMap.get(Servo.class, "rSpinner");
        flipper= hardwareMap.get(Servo.class, "flipper");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        if(opModeIsActive()) {
            //shoot balls at hive
            gate.setDirection(Servo.Direction.FORWARD);
            gate.setPosition(0.93);
            move(1000, "f");
            move(325, "r");
            launcher.setPower(0.62);
            sleep(2000);
            gate.setDirection(Servo.Direction.REVERSE);
            gate.setPosition(0.5);
            sleep(5000);
            gate.setDirection(Servo.Direction.FORWARD);
            gate.setPosition(0.93);
            launcher.setPower(0);
            flipper.setDirection(Servo.Direction.FORWARD);
            flipper.setPosition(0.5);
            //move to garden
            move(325, "l");
            move(1100, "f");
            move(350, "l");
            move(2000, "f");
            move(350, "l");
            move(500, "f");
            move(350, "r");
            move(100, "f");
            move(300, "r");
            //sweep garden
            intakeMotor.setPower(1);
            sleep(1000);
            move(350, "f");
            flipper.setDirection(Servo.Direction.REVERSE);
            flipper.setPosition(0);
            sleep(500);
            flipper.setDirection(Servo.Direction.FORWARD);
            flipper.setPosition(0.5);
            //launch garden balls
            launcher.setPower(0.62);
            sleep(2000);
            gate.setDirection(Servo.Direction.REVERSE);
            gate.setPosition(0.5);
            sleep(5000);
            gate.setDirection(Servo.Direction.FORWARD);
            gate.setPosition(0.93);
            intakeMotor.setPower(0);
            launcher.setPower(0);
            sleep(1000);
            //park at loading station
            move(580, "r");
            move(2300, "f");
            move(350, "l");
            move(500, "f");

        }
    }
    public void move(int time, String direction)
    {
        int lPower=0;
        int rPower=0;
        switch(direction)
        {
            case "f":
                lPower=1;
                rPower=-1;
                break;
            case "b":
                lPower=-1;
                rPower=1;
                break;
            case"l":
                lPower=-1;
                rPower=-1;
                break;
            case "r":
                lPower=1;
                rPower=1;
                break;

        }

        lMotor.setPower(lPower);
        rMotor.setPower(rPower);
        sleep(time);
        lMotor.setPower(0);
        rMotor.setPower(0);
    }
}

