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
  //Left
  int frontLeftChannel = 1;
  int rearLeftChannel = 4;
  //Right
  int frontRightChannel = 2;
  int rearRightChannel = 3;
  
  
  //Victor SPX CAN bus IDs-------------------------------
  //Elevators
  int elevator1Channel = 1;
  int elevator2Channel = 2;
  int elevator3Channel = 3;
  int elevator4Channel = 4;


  

  //Intake
  public static int ballIntakeChannel = 6;

  //
  

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
