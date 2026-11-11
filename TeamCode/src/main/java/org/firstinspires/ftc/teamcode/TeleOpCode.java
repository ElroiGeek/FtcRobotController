package org.firstinspires.ftc.teamcode;




import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp




public class TeleOpCode extends LinearOpMode {
    private DcMotor lMotor;
    private DcMotor rMotor;


    @Override
    public void runOpMode(){
        lMotor = hardwareMap.get(DcMotor.class, "lMotor");
        rMotor = hardwareMap.get(DcMotor.class, "rMotor");


        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        double tgtPowerY=0;
        double tgtPowerX=0;
        while (opModeIsActive()){


            tgtPowerY = -this.gamepad1.left_stick_y;
            tgtPowerX = -this.gamepad1.left_stick_x;
            lMotor.setPower(tgtPowerY+tgtPowerX);
            rMotor.setPower((-1*tgtPowerY)+tgtPowerX);
            telemetry.addData("Status", "Running");
            telemetry.update();


        }
        lMotor.setPower(0);
        rMotor.setPower(0);


    }
}

