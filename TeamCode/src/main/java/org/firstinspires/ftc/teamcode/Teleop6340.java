package org.firstinspires.ftc.teamcode;

//Import FTC modules

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;

//Define as teleop
@TeleOp(name = "6340Teleop", group = "Linear Opmode")

public class Teleop6340 extends Team6340Controls {


    @Override
    public void runOpMode() {
        // Initialize the hardware
        initializeHardware();

        // Reset the motor modes so the robot doesn't drive erratically
        rightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Wait for the game to start (driver presses PLAY)
        telemetry.addData("Status", "Waiting for Start.");
        telemetry.update();
        waitForStart();

        // Run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            // Retrieve sensor data from the REV hub's built-in accelerometer
            angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);


            // Control the chassis Gamepad1 controls driving Gamepad2 controls others
            if (gamepad1.right_trigger < .5) {
                leftMotor.setPower((-gamepad1.left_stick_y + gamepad1.right_stick_x) / 1.5); //closer to 1.0 is faster 2.0 is half speed
                rightMotor.setPower((-gamepad1.left_stick_y - gamepad1.right_stick_x) / 1.5); //closer to 1.0 is faster 1.5 is 2/3 speed

            }

            if (gamepad1.right_trigger > .5) {
                leftMotor.setPower(-gamepad1.left_stick_y + gamepad1.right_stick_x); //Full Speed
                rightMotor.setPower(-gamepad1.left_stick_y - gamepad1.right_stick_x); //Full Speed
            }

            liftMotor.setPower(gamepad2.right_stick_x);

            armRotationMotor.setPower((-gamepad2.right_stick_y)/8);
            extendMotor.setPower(-gamepad2.left_stick_y);

            //marker pad up press y/yellow
            if (gamepad2.y) {
                intakeMotor.setPower(0);      //servo up/out/dump

            }








                if (gamepad2.x) {
                intakeMotor.setPower(.5);
                }

                if (gamepad2.a) {
                intakeMotor.setPower(-.5);
                }


                //Stop everything
                if (gamepad2.back || gamepad1.back) {
                    liftMotor.setPower(0);
                    rightMotor.setPower(0);
                    leftMotor.setPower(0);
                    armRotationMotor.setPower(0);
                    extendMotor.setPower(0);
                    intakeMotor.setPower(0);

                }


                // Update the telemetry
                // Inform the user of important debug information
                telemetry.addData("Status", "Run Time: " + runtime.toString());
                // Add telemetry data related to motors
                telemetry.addData("Left motor power", leftMotor.getPower());
                telemetry.addData("Right motor power", rightMotor.getPower());
                // Update telemetry
                telemetry.update();
                // end of main teleop loop

                telemetry.addData("Status", "Done");
                telemetry.update();
            }
        }// end of opMode()
    }// end of class
