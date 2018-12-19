package org.firstinspires.ftc.teamcode;

//TODO redo all auto after land

//Import FTC modules

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

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
        //adding timeout Ex: getMineralPosition(15)
        // String position = getMineralPosition(5); //wait 10 sec if you don't get the mineral position run default case
        String position = getPositionFromLeftTwoMinerals(5);
        telemetry.addData("Position from Depot: ",position);
        telemetry.update();


        if (POSITION_CENTER.equals(position)) {                             //If the mineral position is Center
            lift(-.5, 9, 8);//Land
            gyroDrive(DRIVE_SPEED, 28, 0, 10);   //Move forward 32 inches
            gyroDrive(DRIVE_SPEED, -15, 0, 5);                    //move back 15 inches
            gyroTurn(TURN_SPEED, 90, 10);
            gyroDrive(DRIVE_SPEED, 40, 85, 10);    //move forward 40 inches
            gyroTurn(TURN_SPEED, 120, 10);                  //turn to face depot
            gyroDrive(DRIVE_SPEED, 60, 125, 10);    //drive to depot
            trophy.setPosition(.4);                                         //drop trophy
            gyroHold(TURN_SPEED, 125, 1);                   //wait a sec.
            gyroDrive(DRIVE_SPEED, -95, 125,10);    //drive backwards to crater
            trophy.setPosition(.9);

        } else if (POSITION_LEFT.equals(position)) {                       //If the mineral position is Left
            lift(-.5, 9, 6);//Land
            gyroDrive(DRIVE_SPEED, 4, 0, 5);
            gyroTurn(TURN_SPEED, 20, 10);
            gyroDrive(DRIVE_SPEED, 28,20, 10);   //Move forward 32 inches
            gyroDrive(DRIVE_SPEED, -14, 20, 5);                    //move back 16 inches
            gyroTurn(TURN_SPEED, 90, 10);
            gyroDrive(DRIVE_SPEED, 40, 90, 10);    //move forward 40 inches
            gyroTurn(TURN_SPEED, 120, 10);                  //turn to face depot
            gyroDrive(DRIVE_SPEED, 50, 125, 10);    //drive to depot
            trophy.setPosition(.4);                                         //drop trophy
            gyroHold(TURN_SPEED, 125, 1);                   //wait a sec.
            gyroDrive(DRIVE_SPEED, -95, 125,10);    //drive backwards to crater
            trophy.setPosition(0.9);

        } else if (POSITION_RIGHT.equals(position)) {                       //If the mineral position is Right
            lift(-.5, 9, 8);//Land
            gyroDrive(DRIVE_SPEED, 4, 0, 5);
            gyroTurn(TURN_SPEED, 340, 10);
            gyroDrive(DRIVE_SPEED, 24,340, 10);   //Move forward 32 inches
            gyroDrive(DRIVE_SPEED, -15, 340, 5);                    //move back 16 inches
            gyroTurn(TURN_SPEED, 85, 10);
            gyroDrive(DRIVE_SPEED, 50, 80, 10);    //move forward 40 inches
            gyroTurn(TURN_SPEED, 120, 10);                  //turn to face depot
            gyroDrive(DRIVE_SPEED, 60, 125, 10);    //drive to depot
            trophy.setPosition(.4);                                         //drop trophy
            gyroHold(TURN_SPEED, 125, 1);                   //wait a sec.
            gyroDrive(DRIVE_SPEED, -100, 125,10);    //drive backwards to crater
            trophy.setPosition(.9);

        } else {                                                               //default case
            lift(-.5, 9, 8);//Land
            gyroDrive(DRIVE_SPEED, 28, 0, 10);   //Move forward 32 inches
            gyroDrive(DRIVE_SPEED, -15, 0, 5);                    //move back 15 inches
            gyroTurn(TURN_SPEED, 90, 10);
            gyroDrive(DRIVE_SPEED, 40, 85, 10);    //move forward 40 inches
            gyroTurn(TURN_SPEED, 120, 10);                  //turn to face depot
            gyroDrive(DRIVE_SPEED, 60, 125, 10);    //drive to depot
            trophy.setPosition(.4);                                         //drop trophy
            gyroHold(TURN_SPEED, 125, 1);                   //wait a sec.
            gyroDrive(DRIVE_SPEED, -95, 125,10);    //drive backwards to crater
            trophy.setPosition(.9);
        }
    }}
