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
        String position = getPositionFromLeftTwoMinerals(5); //wait 10 sec if you don't get the mineral position run default case
        telemetry.addData("Position from Depot: ",position);
        if (POSITION_CENTER.equals(position)) {                             //If the mineral position is Center
            lift(-1, 14, 8);
            gyroDrive(DRIVE_SPEED, 60, 0, 10);    //Move forward 64 inches
            marker.setPosition(.4);                                         //drop marker set servo .2/up
//            gyroHold(TURN_SPEED, 0, 1);                      //stop for 1 sec
//            marker.setPosition(0.8);
            gyroHold(DRIVE_SPEED, 45, 1);
           // lift(.5, -14, 8);//Land
            gyroDrive(DRIVE_SPEED, -10,0, 5 );         //Drive Back from wall
            gyroTurn(TURN_SPEED, 90, 5);                    //turn 120 degrees right
            gyroDrive(DRIVE_SPEED, 10, 90, 10);    //move forward 67 inches
            gyroTurn(TURN_SPEED, 120, 5);                    //turn 120 degrees right
            gyroDrive(DRIVE_SPEED, 20, 120, 10);    //move forward 67 inches
            //armRotate2();
        } else if (POSITION_LEFT.equals(position)) {                       //If the mineral position is Left
            lift(-1, 14, 8);
            gyroDrive(DRIVE_SPEED, 4, 0, 4);         //drive forward 4 inches
            gyroTurn(TURN_SPEED, 30, 5);                    //turn Left for 20 degrees
            gyroDrive(DRIVE_SPEED, 58, 30, 10);    //Move forward 58 inches
            gyroTurn(TURN_SPEED, -45, 5);                     //turn right -40 degrees
            gyroDrive(DRIVE_SPEED, 15, -40, 10);    //Move forward 20 inches
            //armRotate2();
            marker.setPosition(0.4);
            gyroHold(DRIVE_SPEED, 45, 1);
            //lift(.5, -14, 5);//Land
            gyroTurn(TURN_SPEED, -45, 5);
            gyroDrive(DRIVE_SPEED, -91, -45, 10);    //move backward 90 inches

        } else if (POSITION_RIGHT.equals(position)) {                       //If the mineral position is Right
            lift(-1, 14, 8);
            gyroDrive(DRIVE_SPEED, 4, 0, 4);         //drive forward 4 inches
            gyroTurn(TURN_SPEED, -20, 5);                    //turn Right for 20 degrees
            gyroDrive(DRIVE_SPEED, 45, -20, 10);    //Move forward 53 inches
            gyroTurn(TURN_SPEED, 45, 5);                     //turn left to 45 degrees
            gyroDrive(DRIVE_SPEED, 20, 45, 10);    //Move forward 20 inches
            //armRotate2();
            marker.setPosition(0.4);
            gyroHold(DRIVE_SPEED, 45, 1);
            //lift(.5, -14, 5);//Land
            gyroDrive(DRIVE_SPEED, -12,-140,5  );//Backup
            gyroTurn(TURN_SPEED,90, 5);                            //Turn Left 45 Degrees
            gyroDrive(DRIVE_SPEED, 20, 90);                      //Drive Forword
            gyroTurn(TURN_SPEED, 115, 5);                       //Turn Left 45 Degrees
            gyroDrive(DRIVE_SPEED, 75, 115, 10);      //Drive Forward
            //extenedArm(-1, 15, 7);


        } else {                                                               //default case
            lift(-1, 14 , 8);
            gyroDrive(DRIVE_SPEED, 4, 0, 4);         //drive forward 4 inches
            gyroTurn(TURN_SPEED, -20, 5);                    //turn Right for 20 degrees
            gyroDrive(DRIVE_SPEED, 45, -20, 10);    //Move forward 53 inches
            gyroTurn(TURN_SPEED, 45, 5);                     //turn left to 45 degrees
            gyroDrive(DRIVE_SPEED, 20, 45, 10);    //Move forward 20 inches
            //armRotate2();
            marker.setPosition(0.4);
            gyroHold(DRIVE_SPEED, 45, 1);
            //lift(.5, -14, 8);//Land
            gyroDrive(DRIVE_SPEED, -12,-140,5  );//Backup
            gyroTurn(TURN_SPEED,90, 5);                            //Turn Left 45 Degrees
            gyroDrive(DRIVE_SPEED, 20, 90);                      //Drive Forword
            gyroTurn(TURN_SPEED, 115, 5);                       //Turn Left 45 Degrees
            gyroDrive(DRIVE_SPEED, 75, 115, 10);      //Drive Forward
            //extenedArm(-1, 15, 7);
        }

    }
}
