/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class LimitCommand extends Command {
  public LimitCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);\
    requires(Robot.suckBall);
  }
  
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //Robot.suckBall.ballIntakeController.set(ControlMode.PercentOutput, 0);
    Robot.suckBall.ballIntakeController.configFactoryDefault();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //Robot.m_oi.limitSwitchButton.whileHeld(new LimitCommand());
   // double move =1;
   // double turn =1;

    
   // Robot.driveTrain.limitHit();
   double move = Robot.m_oi.stick1.getY();
   //LimitSwitch = new DigitalInput(RobotMap.limitSwitchChannel);
   //Robot.suckBall.test();
   //boolean in = Robot.m_oi.stick1.getRawButtonPressed(1);
   // boolean out = Robot.m_oi.stick1.getRawButtonPressed(2);
   // double output =0;
   // System.out.println(in);
   // System.out.println(out);
   Robot.suckBall.ball(move);
   /*
    if (in) {
      System.out.println(in);
      Robot.suckBall.ball(output);
      
    } 
    else if (out) {
      Robot.suckBall.ball(-output);
      
    }
*/
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
