/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.BallIntake;

public class intakeIN extends Command {
  public intakeIN() {
    // Use requires() here to declare subsystem dependencies
     requires(Robot.suckBall);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    boolean buttonIn = Robot.m_oi.stick2.getRawButton(1);
    boolean buttonOut = Robot.m_oi.stick2.getRawButton(2);
    //double move = Robot.m_oi.stick1.getY();
    //Robot.suckBall.intakeON(move);
    //Robot.suckBall.test();
    /*
    if (buttonIn == true){
        
      
        Robot.suckBall.intakeON(1);
    }else{
        Robot.suckBall.intakeON(0);
      }
    
    if (buttonOut == true)  {
      //Opens the Clamp when button 6 is pressed and prints
      Robot.suckBall.intakeOut(-1);
    }else{
      Robot.suckBall.intakeOut(0);

    }
*/
   

      if (buttonIn == true){
        Robot.suckBall.intakeON(1);
      }else if (buttonOut){
        Robot.suckBall.intakeON(-1);
      } else{
        Robot.suckBall.intakeON(0);
      }
     
    }
    
  
    /*
    if (buttonIn){
      Robot.suckBall.intakeON(-1);
      
    }
    else if(buttonIn == false){
      Robot.suckBall.intakeON(0);

    }
    
    if (buttonOut)
    {
      Robot.suckBall.intakeOut(1);
      
    }
    else if (buttonOut==false){
      Robot.suckBall.intakeOut(0);

    }
    */
    
  

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
  }
}
