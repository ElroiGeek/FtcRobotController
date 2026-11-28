package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;


// Imports
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;




@Autonomous
public class Automation_Middle extends LinearOpMode {


    private DcMotor lMotor;
    private DcMotor rMotor;


    private DcMotor intakeMotor;


    private DcMotor launcher;
    private Servo gate;


    private Servo flipper;


    private static final double FLIPPER_ORIGINAL = 0.15;
    private static final double FLIPPER_SWEEP = 0.65;


    @Override
    public void runOpMode() {


        lMotor = hardwareMap.get(DcMotor.class, "lMotor");
        rMotor = hardwareMap.get(DcMotor.class, "rMotor");
        intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");
        launcher = hardwareMap.get(DcMotor.class, "launcherMotor");
        gate = hardwareMap.get(Servo.class, "rSpinner");
        flipper = hardwareMap.get(Servo.class, "flipper");


        gate.setDirection(Servo.Direction.FORWARD);
        gate.setPosition(0.93);
        flipper.setPosition(FLIPPER_ORIGINAL);


        telemetry.addData("Status", "Initialized");
        telemetry.update();


        waitForStart();


        if (opModeIsActive()) {




            move("f", 1000, 1);


            move("r", 1000, 1);


            move("l", 1000, 1);


            move("r", 1000, 1);


            shoot4Balls();





            //turn left
            move("l", 0.30, 1);
            //drive forward to garden
            move("f", 0.35, 2);
            //turn left at garden leaving a little space to turn again
            move("l", 0.30, 1);
            //drive forward a little
            move("f", 0.35, 1);
            //turn right
            move("r", 0.30, 1);
            //turn right again
            move("r", 0.30, 1);
            //drive forward
            move("f", 0.25, 2);


            intakeMotor.setPower(1);


            move("f", 0.20, 1);


            intakeMotor.setPower(1);
            flipper.setPosition(FLIPPER_SWEEP);


            sleep(800);


            flipper.setPosition(FLIPPER_ORIGINAL);


            sleep(300);


            launchCollectedBalls();


            //parking
            move("r", 0.30, 1);


            move("f", 0.35, 2);


            stopRobot();


        }
        intakeMotor.setPower(0);




    }
    private void move (String direction,double power, int time)
    {
        double lPower = 0;
        double rPower = 0;


        switch (direction) {


            case "f":
                lPower = power;
                rPower = -power;
                break;


            case "b":
                lPower = -power;
                rPower = power;
                break;


            case "l":
                lPower = -power;
                rPower = -power;
                break;


            case "r":
                lPower = power;
                rPower = power;
                break;
        }


        lMotor.setPower(lPower);
        rMotor.setPower(rPower);


        sleep(time * 1000);


        lMotor.setPower(0);
        rMotor.setPower(0);
    }


    private void shoot4Balls() {


        launcher.setPower(0.62);


        intakeMotor.setPower(1);


        gate.setDirection(Servo.Direction.FORWARD);
        gate.setPosition(0.93);


        sleep(1500);


        for (int i = 0; i < 4; i++){
            gate.setDirection(Servo.Direction.REVERSE);
            gate.setPosition(0.5);
            sleep(450);


            gate.setDirection(Servo.Direction.FORWARD);
            gate.setPosition(0.93);
            sleep(450);
        }


        intakeMotor.setPower(0);
        launcher.setPower(0);


    }


    private void launchCollectedBalls() {
        launcher.setPower(0.62);
        intakeMotor.setPower(1);


        gate.setDirection(Servo.Direction.FORWARD);
        gate.setPosition(0.93);


        sleep(1500);


        for (int i = 0; i < 4; i++) {
            gate.setDirection(Servo.Direction.REVERSE);
            gate.setPosition(0.5);
            sleep(450);


            gate.setDirection(Servo.Direction.FORWARD);
            gate.setPosition(0.93);
            sleep(450);
        }


        intakeMotor.setPower(0);
        launcher.setPower(0);
    }


    private void stopRobot() {
        lMotor.setPower(0);
        rMotor.setPower(0);


        intakeMotor.setPower(0);
        launcher.setPower(0);


        gate.setPosition(0.93);
        flipper.setPosition(FLIPPER_ORIGINAL);
    }


}





