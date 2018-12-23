package org.firstinspires.ftc.teamcode;

//Import FTC modules

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

//Define as Autonomous
@Disabled
@Autonomous(name = "Depot", group = "Linear Opmode")
public class Depot extends Team6340Controls {

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
        // Try adding timeout Ex: getMineralPosition(15)
        String position = getMineralPosition(5); //wait 10 sec if you don't get the mineral position run default case
        //String position = getPositionFromLeftTwoMinerals(5);
        telemetry.addData("Position from Depot: ",position);
        telemetry.update();

        if (POSITION_CENTER.equals(position)) {                             //If the mineral position is Center
            lift(-.5, 17.5, 8);//Land
            gyroDrive(DRIVE_SPEED, 64, 0, 10);    //Move forward 64 inches
            marker.setPosition(.4);                                         //drop marker set servo .2/up
            gyroHold(TURN_SPEED, 0, 1);                      //stop for 1 sec
            gyroDrive(DRIVE_SPEED, -10,0, 5 );         //Drive Back from wall
            gyroTurn(TURN_SPEED, -120, 5);                    //turn 120 degrees right
            gyroDrive(DRIVE_SPEED, 67, -120, 10);    //move forward 67 inches
            marker.setPosition(.9);                                         //set servo to 0.0/down

        } else if (POSITION_LEFT.equals(position)) {                       //If the mineral position is Left
            lift(-.5, 9, 8);                          //Land
            gyroDrive(DRIVE_SPEED, 4, 0, 4);          //Drive forward 4 inches
            gyroTurn(TURN_SPEED, 20, 5);                      //Turn towards mineral
            gyroDrive(DRIVE_SPEED, 46, 20, 10);      //knock over mineral
            gyroTurn(TURN_SPEED, -40, 5);                    //turn towards depot
            gyroDrive(DRIVE_SPEED, 16, -40, 10);    //drive into depot
            marker.setPosition(.4);                                        //DROP of marker
            gyroHold(TURN_SPEED, -50, 1);                  //Hold for a second
            gyroDrive(DRIVE_SPEED, -6 , -50, 10);  //Drive away from wall
            gyroTurn(TURN_SPEED, -120, 5);                 //turn towards crater
            gyroDrive(DRIVE_SPEED, 72, -115, 10); //drive towards crater
            marker.setPosition(.9);


        } else if (POSITION_RIGHT.equals(position)) {                       //If the mineral position is Right
            lift(-.5, 9, 8);                        //Land
            gyroDrive(DRIVE_SPEED, 4, 0, 4);         //drive forward 4 inches
            gyroTurn(TURN_SPEED, -20, 5);                    //turn Right for 20 degrees
            gyroDrive(DRIVE_SPEED, 48, -20, 10);    //Move forward 53 inches
            gyroTurn(TURN_SPEED, 45, 5);                     //turn left to 45 degrees
            gyroDrive(DRIVE_SPEED, 20, 45, 10);    //Move forward 20 inches
            marker.setPosition(.4);                                         //drop marker set servo .2/up
            gyroHold(TURN_SPEED, 50, 1);                      //stop for 1 sec
            gyroDrive(DRIVE_SPEED, -95, 50, 10);    //move backward 95 inches
            marker.setPosition(.9);

        } else {                                                               //default case
            lift(-.5, 9, 8);                        //Land
            gyroDrive(DRIVE_SPEED, 60, 0, 10);    //Move forward 64 inches
            marker.setPosition(.4);                                         //drop marker set servo .2/up
            gyroHold(TURN_SPEED, 0, 1);                      //stop for 1 sec
            gyroDrive(DRIVE_SPEED, -10,0, 5 );         //Drive Back from wall
            gyroTurn(TURN_SPEED, -120, 5);                    //turn 120 degrees right
            gyroDrive(DRIVE_SPEED, 67, -120, 10);    //move forward 67 inches
            marker.setPosition(.9);

        }

    }
}