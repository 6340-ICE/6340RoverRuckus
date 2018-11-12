package org.firstinspires.ftc.teamcode;

//TODO redo all auto after land

//Import FTC modules

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

//Define as Autonomous
//@Disabled
@Autonomous(name = "Crater", group = "Linear Opmode")
public class
Crater extends Team6340Controls {

    @Override
    public void runOpMode() {
        // Initialize the hardware
        initializeHardware();


        // Wait for the game to start (driver presses PLAY)
        telemetry.addData("Status", "Waiting for Start.");
        telemetry.update();
        waitForStart();

        // Insert Autonomous Code Here
        lift(-.5,4,5);                       //Land
        gyroDrive(DRIVE_SPEED, 5, 0, 2);        //move forward 1 inch
        gyroTurn(TURN_SPEED, 35, 5);                       // Turn 45 degrees left
        gyroDrive(DRIVE_SPEED, 47, 35, 10);      // Move Forward 42"
        gyroTurn(TURN_SPEED, 115, 10);                   // Turn Left 90 degrees (Heading 130)
        gyroDrive(DRIVE_SPEED,  58, 115, 10); // Move forward 66"
        trophy.setPosition(.7);                                    // Deliver Trophy
        gyroHold(DRIVE_SPEED, 120, 1);
        gyroDrive(DRIVE_SPEED, -80 ,120,20);     //move forward 108 inches
        gyroHold(DRIVE_SPEED, 120, 5);
        trophy.setPosition(1.0);
    }}
