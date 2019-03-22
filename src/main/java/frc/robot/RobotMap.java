/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // Gamepads ---------------------------------
	public static int stick1Channel = 0;
  public static int stick2Channel = 1;
  //Sensors ---------------------------------------
  public static int limitSwitchChannel = 4;

  //Talon SRX CAN bus IDs-------------------------------------
  public static int frontLeftChannel = 3;
  public static int rearLeftChannel = 4;
  public static int frontRightChannel = 1;//
  public static int rearRightChannel = 2; //CORRECT
  
  //Victor SPX CAN bus IDs-------------------------------
  //Elevator Motor Controllers
  public static int elevator1Channel = 1;
  public static int elevator2Channel = 3;
  public static int elevator3Channel = 5;
  public static int elevator4Channel = 6;

  //Ball Pivot
  public static int ballPivotChannel = 4;

  //Ball Intake
  public static int ballIntakeChannel = 2;

  //Hatch
  public static int hatchRotateChannel = 7;



  

  

 
}
