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


        // Wait for the game to start (driver presses PLAY)
        telemetry.addData("Status", "Waiting for Start.");
        telemetry.update();
        waitForStart();

        // Insert Autonomous Code Here

        lift(-.5,16,10);//Land
        gyroDrive(DRIVE_SPEED, 60, -5, 10 );    //Move forward 43 inches
        trophy.setPosition(.7);                                       // drop trophy set servo .7/up
       gyroHold(TURN_SPEED, 0, 1);                      //stop for 1 sec
        gyroTurn(TURN_SPEED, 215, 5);                    //turn 320 degrees right
        gyroDrive(DRIVE_SPEED, 72, 215, 10);    //move forward 43 inches
        trophy.setPosition(1.0);                                         //set servo to .40/down

   }
}
