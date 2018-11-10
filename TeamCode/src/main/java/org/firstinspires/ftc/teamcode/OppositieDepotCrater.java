package org.firstinspires.ftc.teamcode;

//TODO redo all auto after land
//TODO make smaller lifting mechanism
//Import FTC modules
//Needs To Be Tested
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

//Define as Autonomous
//@Disabled
@Autonomous(name = "OppositeDepotCrater", group = "Linear Opmode")
public class OppositieDepotCrater extends Team6340Controls {

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
        String position = getMineralPosition(10); //wait 10 sec if you don't get the mineral position run default case
        telemetry.addData("Position from Depot: ",position);

        if (POSITION_CENTER.equals(position)) {                             //If the mineral position is Center
            lift(-.5, 16, 10);//Land
            gyroDrive(DRIVE_SPEED, 64, 0, 10);    //Move forward 43 inches
            trophy.setPosition(.7);                                         //drop trophy set servo .7/up
            gyroHold(TURN_SPEED, 0, 1);                      //stop for 1 sec
            gyroDrive(DRIVE_SPEED, -10,0, 5 );
            gyroTurn(TURN_SPEED, -120, 5);                    //turn 320 degrees right
            gyroDrive(DRIVE_SPEED, -12, 0, 5);//Backup
            gyroTurn(TURN_SPEED, 90, 5);//Turn Left 90 Degrees
            gyroDrive(DRIVE_SPEED, 12, 90, 5);//Drive Forword
            gyroTurn(TURN_SPEED, 130, 5);//Turn Left 45 Degrees
            gyroDrive(DRIVE_SPEED, 50, 130, 10);//Drive Forward
            trophy.setPosition(1.0);                                         //set servo to .40/down

        } else if (POSITION_LEFT.equals(position)) {                       //If the mineral position is Left
            lift(-.5, 16, 10);//Land
            gyroDrive(DRIVE_SPEED, 4, 0, 4);         //drive forward 4 inches
            gyroTurn(TURN_SPEED, 20, 5);                    //turn Left for 20 degrees
            gyroDrive(DRIVE_SPEED, 58, 20, 10);    //Move forward 58 inches
            gyroTurn(TURN_SPEED, -40, 5);                     //turn right -40 degrees
            gyroDrive(DRIVE_SPEED, 20, -40, 10);    //Move forward 20 inches
            trophy.setPosition(.7);                                         //drop trophy set servo .7/up
            gyroHold(TURN_SPEED, -50, 1);                      //stop for 1 sec
            gyroDrive(DRIVE_SPEED, -90, -50, 10);    //move backward 90 inches
           trophy.setPosition(1.0);

        } else if (POSITION_RIGHT.equals(position)) {                       //If the mineral position is Right
            lift(-.5, 16, 10);//Land
            gyroDrive(DRIVE_SPEED, 4, 0, 4);         //drive forward 4 inches
            gyroTurn(TURN_SPEED, -20, 5);                    //turn Right for 20 degrees
            gyroDrive(DRIVE_SPEED, 53, -20, 10);    //Move forward 53 inches
            gyroTurn(TURN_SPEED, 45, 5);                     //turn left to 45 degrees
            gyroDrive(DRIVE_SPEED, 20, 45, 10);    //Move forward 20 inches
            trophy.setPosition(.7);                                         //drop trophy set servo .7/up
            gyroHold(TURN_SPEED, 50, 1);                      //stop for 1 sec
            gyroDrive(DRIVE_SPEED, -12,-140,5  );//Backup
            gyroTurn(TURN_SPEED,90, 5);//Turn Left 45 Degrees
            gyroDrive(DRIVE_SPEED, 20, 5);//Drive Forword
            gyroTurn(TURN_SPEED, 130, 5);//Turn Left 45 Degrees
            gyroDrive(DRIVE_SPEED, 50, 130, 10);//Drive Forward
            trophy.setPosition(1.0);

        } else {                                                               //default case
            telemetry.addData("No position from TensorFlow", "Run default program");
            //If we dont have position, assume LEFT position
            lift(-.5, 16, 10);//Land
            gyroDrive(DRIVE_SPEED, 4, 0, 4);         //drive forward 4 inches
            gyroTurn(TURN_SPEED, 20, 5);                    //turn Left for 20 degrees
            gyroDrive(DRIVE_SPEED, 58, 20, 10);    //Move forward 58 inches
            gyroTurn(TURN_SPEED, -40, 5);                     //turn right -40 degrees
            gyroDrive(DRIVE_SPEED, 20, -40, 10);    //Move forward 20 inches
            trophy.setPosition(.7);                                         //drop trophy set servo .7/up
            gyroHold(TURN_SPEED, -50, 1);                      //stop for 1 sec
            gyroDrive(DRIVE_SPEED, -90, -50, 10);    //move backward 90 inches
        }

    }
}
