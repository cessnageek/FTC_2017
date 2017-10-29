package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by dawso on 10/1/2017.
 */


@Autonomous(name = "Simple Auto", group = "Sensor")
//@Disabled                            // Comment this out to add to the opmode list
public class CF_Simple_Auto extends LinearOpMode
{
   CF_Hardware robot = new CF_Hardware();
   CF_Color_Sensor sensor = new CF_Color_Sensor();
   CF_Master_Motor_Library mech = new CF_Master_Motor_Library();

   private enum states
   {
      BACKUP, JEWELPUSHER, ENDOPMODE
   }

   @Override
   public void runOpMode() throws InterruptedException
   {
      sensor.init();

      states State = states.BACKUP;

      float hsvValues[] = {0F, 0F, 0F};
      final float values[] = hsvValues;

      waitForStart();

      while (opModeIsActive())
      {
         switch (State)
         {
            case BACKUP:

               mech.setMode(robot, DcMotor.RunMode.RUN_USING_ENCODER);
               //Set direction, distance, and motor powers of mecanum wheels
               mech.setMode(robot, DcMotor.RunMode.STOP_AND_RESET_ENCODER);
               //Tell encoders to run to a set position
               mech.setMode(robot, DcMotor.RunMode.RUN_TO_POSITION);
               mech.setMechPowers(robot, 1, -0.5, -0.5, -0.5, -0.5, 0);
               mech.setEncoderTargetPosition(robot, 850, 850, 850, 850);
               telemetry.addData("1", " and done");
               telemetry.update();
               break;
            case JEWELPUSHER:
               if (sensor.hueVal = true)
               {
                  //robot.SetJewelPusherPositoin()
                  telemetry.addData("Blue" , "");
               }

               else if (sensor.hueVal = false)
               {
                  //robot.SetJewelPusherPosition(0.70);
                  telemetry.addData("Red" , "");
                  telemetry.update();
               }

               else
               {
                  telemetry.addData("Neither", "");
               }

               telemetry.update();

                break;

            case ENDOPMODE:
               telemetry.addData("Done", "");
               telemetry.update();
               break;
         }

      }
   }
}