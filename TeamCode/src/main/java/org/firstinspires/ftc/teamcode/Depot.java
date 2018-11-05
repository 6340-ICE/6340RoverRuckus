package org.firstinspires.ftc.teamcode;

//TODO redo all auto after land
//TODO make smaller lifting mechanism
//Import FTC modules

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

//Define as Autonomous
//@Disabled
@Autonomous(name = "Depot", group = "Linear Opmode")
public class Depot extends Team6340Controls {

    @Override
    public void runOpMode() throws InterruptedException {
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
        String position = getMineralPosition();
        telemetry.addData("Position from Depot: ",position);

        if (POSITION_CENTER.equals(position)) {                             //If the mineral position is Center
            lift(-.5, 16, 10);//Land
            gyroDrive(DRIVE_SPEED, 60, -5, 10);    //Move forward 43 inches
            trophy.setPosition(.7);                                         //drop trophy set servo .7/up
            gyroHold(TURN_SPEED, 0, 1);                      //stop for 1 sec
            gyroTurn(TURN_SPEED, 215, 5);                    //turn 320 degrees right
            gyroDrive(DRIVE_SPEED, 72, 215, 10);    //move forward 43 inches
            trophy.setPosition(1.0);                                         //set servo to .40/down

        } else if (POSITION_LEFT.equals(position)) {                       //If the mineral position is Left
            lift(-.5, 16, 10);//Land
            gyroTurn(TURN_SPEED, 20, 5);                    //turn Left for 20 degrees
            gyroDrive(DRIVE_SPEED, 43, 20, 10);    //Move forward 43 inches
            gyroTurn(TURN_SPEED, -40, 5);                     //turn right -45 degrees
            gyroDrive(DRIVE_SPEED, 20, -40, 10);    //Move forward 20 inches
            trophy.setPosition(.7);                                         //drop trophy set servo .7/up
            gyroHold(TURN_SPEED, -50, 1);                      //stop for 1 sec
            gyroDrive(DRIVE_SPEED, -95, -50, 10);    //move backward 85 inches
           trophy.setPosition(1.0);

        } else if (POSITION_RIGHT.equals(position)) {                       //If the mineral position is Right
            lift(-.5, 16, 10);//Land
            gyroTurn(TURN_SPEED, -20, 5);                    //turn Right for 20 degrees
            gyroDrive(DRIVE_SPEED, 53, -20, 10);    //Move forward 53 inches
            gyroTurn(TURN_SPEED, 45, 5);                     //turn left to 45 degrees
            gyroDrive(DRIVE_SPEED, 20, 45, 10);    //Move forward 20 inches
            trophy.setPosition(.7);                                         //drop trophy set servo .7/up
            gyroHold(TURN_SPEED, 50, 1);                      //stop for 1 sec
            gyroDrive(DRIVE_SPEED, -95, 50, 10);    //move backward 85 inches
            trophy.setPosition(1.0);
        } else {
            telemetry.addData("No position from TensorFlow", "Run default program");
            //TODO add default code here
        }

    }
}
