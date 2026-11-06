package org.firstinspires.ftc.teamcode;

// Imports
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class IntakeCode extends LinearOpMode {

    private DcMotor intakeMotor;

    @Override
    public void runOpMode(){

        intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()){
            if (gamepad1.right_bumper){
                intakeMotor.setPower(0.7);
            }
            else if (gamepad1.left_bumper){
                intakeMotor.setPower(-0.7);
            }
            else{
                intakeMotor.setPower(0);
            }

        }

        intakeMotor.setPower(0);
    }
}
