/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;
import frc.robot.commands.moveFWD;
import frc.robot.commands.LimitCommand;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
/*
  public WPI_TalonSRX leftMaster = new WPI_TalonSRX(0);
  public WPI_TalonSRX rightMaster = new WPI_TalonSRX(1);
  public WPI_TalonSRX leftSlave = new WPI_TalonSRX(2);
  public WPI_TalonSRX rightSlave = new WPI_TalonSRX(3);
  public DifferentialDrive drive = new DifferentialDrive(leftMaster, rightMaster);
  */
  
  // PWM configeration -----------------------------------------------------------
	public PWMVictorSPX frontLeft = new PWMVictorSPX(RobotMap.FrontLeftChannel);
	public PWMVictorSPX rearLeft = new PWMVictorSPX(RobotMap.RearLeftChannel);
	public PWMVictorSPX frontRight = new PWMVictorSPX(RobotMap.FrontRightChannel);
	public PWMVictorSPX rearRight = new PWMVictorSPX(RobotMap.RearRightChannel);
  SpeedControllerGroup leftMotorGroup = new SpeedControllerGroup(frontLeft, rearLeft);
  SpeedControllerGroup rightMotorGroup = new SpeedControllerGroup(frontRight, rearRight);
  public DifferentialDrive drive = new DifferentialDrive(leftMotorGroup, rightMotorGroup);
  
  // PWM configeration -----------------------------------------------------------


  //MecanumDrive drive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);
  public DriveTrain () {

  }



 public void teleopDrive(double move, double turn){
   /*
  leftSlave.follow(leftMaster);
  rightSlave.follow(rightMaster);
  */
  if (Math.abs(move) < 0.10) {

    move = 0;
  }
  if (Math.abs(turn) < 0.10) {

    turn = 0;
  }
  if (Math.abs(turn) > 0.7) {

    turn = 0.7;
  }
  if (Math.abs(move) > 0.7) {

    move = 0.7;
  }

  drive.arcadeDrive(move, turn);

 }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     setDefaultCommand(new moveFWD());
  }
}
