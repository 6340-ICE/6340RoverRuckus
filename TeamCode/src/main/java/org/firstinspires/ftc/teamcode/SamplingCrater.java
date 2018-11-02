package org.firstinspires.ftc.teamcode;

//TODO further testing of rev robotics hex motor encoders

//Import FTC modules

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

//Define as Autonomous
@Disabled
@Autonomous(name = "AutoTemplate", group = "Linear Opmode")
public class
SamplingCrater extends Team6340Controls {

    @Override
    public void runOpMode() {
        // Initialize the hardware
        initializeHardware();


        // Wait for the game to start (driver presses PLAY)
        telemetry.addData("Status", "Waiting for Start.");
        telemetry.update();
        waitForStart();

        // Insert Autonomous Code Here

   }
}
