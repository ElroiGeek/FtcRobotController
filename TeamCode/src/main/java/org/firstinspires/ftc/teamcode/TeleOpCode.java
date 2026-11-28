package org.firstinspires.ftc.teamcode;




import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp




public class TeleOpCode extends LinearOpMode {
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
        double tgtPowerY=0;
        double tgtPowerX=0;
        double launcherPower=0.62;
        launcher.setPower(0.62);
        intakeMotor.setPower(1);
        while (opModeIsActive()){


            tgtPowerY = -this.gamepad1.left_stick_y;
            tgtPowerX = -this.gamepad1.left_stick_x;
            lMotor.setPower(tgtPowerY-tgtPowerX);
            rMotor.setPower((-1*tgtPowerY)-tgtPowerX);
            if(gamepad1.right_trigger_pressed)
            {
                gate.setDirection(Servo.Direction.REVERSE);
                gate.setPosition(0.5);


            }
            else
            {
                gate.setDirection(Servo.Direction.FORWARD);
                gate.setPosition(0.93);
            }
            if(gamepad1.x)
                launcherPower=0.62;
            else if(gamepad1.y)
                launcherPower=0.7;
            launcher.setPower(launcherPower);
            telemetry.addData("Status", "Running");
            telemetry.update();


        }
        lMotor.setPower(0);
        rMotor.setPower(0);


    }
}

