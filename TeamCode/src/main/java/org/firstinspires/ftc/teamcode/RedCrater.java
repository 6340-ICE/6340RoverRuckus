package org.firstinspires.ftc.teamcode;

//TODO redo all auto after land

//Import FTC modules

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

//Define as Autonomous
@Disabled
@Autonomous(name = "RedCrater", group = "Linear Opmode")
public class
RedCrater extends Team6340Controls {

    @Override
    public void runOpMode() throws InterruptedException {
        // Initialize the hardware
        initializeHardware();


        // Wait for the game to start (driver presses PLAY)
        telemetry.addData("Status", "Waiting for Start.");
        telemetry.update();
        waitForStart();

        // Insert Autonomous Code Here
        lift(-.5,16,10);//Land
       gyroTurn(TURN_SPEED, 45, 5);         // Turn 45 Degrees Left
       gyroDrive(DRIVE_SPEED, 47, 45);      // Move Forward 42 Degrees
       gyroTurn(TURN_SPEED, 135, 5);        // Turn Left 90 Degrees (Heading 130 Inches)
       gyroDrive(DRIVE_SPEED, 66, 135);     // Move Forward 66 Inches
       gyroTurn(TURN_SPEED, 315, 5);
        marker.setPosition(.7);                           // Deliver Trophy
        gyroHold(TURN_SPEED, 135,1);                                             //Wait 1.5 second
        gyroDrive(DRIVE_SPEED, 100, 135);   // Move Reverse 100 Inches
        marker.setPosition(1.0);                          //Reset Servo to down

   }
}
