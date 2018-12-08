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
        initVuforia();
        initTfod();

        // Wait for the game to start (driver presses PLAY)
        telemetry.addData("Status", "Waiting for Start.");
        telemetry.update();
        waitForStart();

        // Insert Autonomous Code Here
        //TODO Try adding timeout Ex: getMineralPosition(15)
        String position = getMineralPosition(1); //wait 10 sec if you don't get the mineral position run default case
        telemetry.addData("Position from Depot: ",position);

//        lift(-.5,4,5);                       //Land
//        gyroDrive(DRIVE_SPEED, 5, 0, 2);        //move forward 1 inch
//        gyroTurn(TURN_SPEED, 35, 5);                       // Turn 45 degrees left
//        gyroDrive(DRIVE_SPEED, 47, 35, 10);      // Move Forward 42"
//        gyroTurn(TURN_SPEED, 115, 10);                   // Turn Left 90 degrees (Heading 130)
//        gyroDrive(DRIVE_SPEED,  58, 115, 10); // Move forward 66"
//        trophy.setPosition(.7);                                    // Deliver Trophy
//        gyroHold(DRIVE_SPEED, 120, 1);
//        gyroDrive(DRIVE_SPEED, -80 ,120,20);     //move forward 108 inches
//        gyroHold(DRIVE_SPEED, 120, 5);
//        trophy.setPosition(1.0);
        if (POSITION_CENTER.equals(position)) {                             //If the mineral position is Center
            lift(-.5, 16, 5);//Land
            gyroDrive(DRIVE_SPEED, 4, 0, 10);    //Move forward 4 inches
            lift(.5, -16, 5);               //land
            gyroDrive(DRIVE_SPEED, 28, 0, 10);    //Move forward 28 inches
            gyroDrive(TURN_SPEED, -16, 0, 5);                    //turn 320 degrees right
            gyroDrive(DRIVE_SPEED, 67, -120, 10);    //move forward 43 inches
            trophy.setPosition(6.0);                                         //set servo to .40/down

        } else if (POSITION_LEFT.equals(position)) {                       //If the mineral position is Left
            lift(-.5, 16, 5);//Land
            gyroDrive(DRIVE_SPEED, 4, 0, 4);         //drive forward 4 inches
            lift(.5, -16, 5);
            gyroTurn(TURN_SPEED, 20, 5);                    //turn Left for 20 degrees
            gyroDrive(DRIVE_SPEED, 58, 20, 10);    //Move forward 58 inches
            gyroTurn(TURN_SPEED, -40, 5);                     //turn right -40 degrees
            gyroDrive(DRIVE_SPEED, 20, -40, 10);    //Move forward 20 inches
            trophy.setPosition(.7);                                         //drop trophy set servo .7/up
            gyroHold(TURN_SPEED, -50, 1);                      //stop for 1 sec
            gyroDrive(DRIVE_SPEED, -90, -50, 10);    //move backward 90 inches
            trophy.setPosition(6.0);

        } else if (POSITION_RIGHT.equals(position)) {                       //If the mineral position is Right
            lift(-.5, 16, 5);//Land
            gyroDrive(DRIVE_SPEED, 4, 0, 4);         //drive forward 4 inches
            lift(.5, -16, 5);
            gyroTurn(TURN_SPEED, -20, 5);                    //turn Right for 20 degrees
            gyroDrive(DRIVE_SPEED, 53, -20, 10);    //Move forward 53 inches
            gyroTurn(TURN_SPEED, 45, 5);                     //turn left to 45 degrees
            gyroDrive(DRIVE_SPEED, 20, 45, 10);    //Move forward 20 inches
            trophy.setPosition(.7);                                         //drop trophy set servo .7/up
            gyroHold(TURN_SPEED, 50, 1);                      //stop for 1 sec
            gyroDrive(DRIVE_SPEED, -95, 50, 10);    //move backward 95 inches
            trophy.setPosition(6.0);
        } else {                                                               //default case
            telemetry.addData("No position from TensorFlow", "Run default program");
            //If we dont have position, assume LEFT position
            lift(-.5, 12, 5);//Land
            gyroDrive(DRIVE_SPEED, 4, 0, 10);    //Move forward 4 inches
            lift(.5, -16, 5);
            gyroDrive(DRIVE_SPEED, 28, 0, 10);    //Move forward 28 inches
            gyroDrive(TURN_SPEED, -16, 0, 5);                    //turn 320 degrees right
            gyroTurn(TURN_SPEED, 80, 10);
            gyroDrive(DRIVE_SPEED, 42, 75, 10);
            gyroTurn(TURN_SPEED, 125, 10);
            gyroDrive(DRIVE_SPEED, 79, 125, 10);
            trophy.setPosition(.3);
            gyroHold(TURN_SPEED, 125, 1);                      //stop for 1 sec
            gyroDrive(DRIVE_SPEED, -87, 135, 10);    //move backward 90 inches
            //trophy.setPosition(1.0);

        }
    }}
