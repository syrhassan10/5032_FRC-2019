/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

import frc.robot.RobotMap;


/**
 * An example command.  You can replace me with your own command.
 */

public class moveFWD extends Command {
  public moveFWD() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.moveForward);
  }
 // public float sens = 0.5;
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    //Robot.moveForward.frontLeft.setInverted(true);
    //Robot.moveForward.rearLeft.setInverted(true);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
public void execute() {
    
    Robot.moveForward.teleopDrive(Robot.m_oi.stick1.getX(), Robot.m_oi.stick1.getY());// FIRST JOYSTICK: LEFT STICK

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
    
  }
}
