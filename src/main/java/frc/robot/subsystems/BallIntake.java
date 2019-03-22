/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.Counter.Mode;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import frc.robot.commands.intakeIN;



public class BallIntake extends Subsystem {

  public DigitalInput LimitSwitch = new DigitalInput(RobotMap.limitSwitchChannel);

  
  public WPI_VictorSPX ballIntakeController = new WPI_VictorSPX(RobotMap.ballIntakeChannel); // Victor ID:4

  
  public void intakeON(double output){
    ballIntakeController.set(output);

  }
   /* 
  public void intakeON(double output){
    //ballIntakeController.set(output); WITHOUT LIMIT SWITCH

//************** WITH LIMIT SWITCH***********************************
    if (LimitSwitch.get()) { 
      // if not pressed
      ballIntakeController.set(output);
    }
    else {
      // if pressed
      ballIntakeController.set(0.2); 
      try {
      Thread.sleep(50);
    } catch (InterruptedException e) {
      
      e.printStackTrace();
    }
    //ballIntakeController.set(0);
  }
*/



 /*
 public void disableMotors()
 {
  ballIntakeController.set(output);

 }
*/
    //ballIntakeController.set(output);
     //ballIntakeController.set(0); 
     /*
      if (LimitSwitch.get()) { 
        // if not pressed
        ballIntakeController.set(output);
      }
      else {
        // if pressed
        ballIntakeController.set(0.2); 
        try {
        Thread.sleep(50);
      } catch (InterruptedException e) {
        
        e.printStackTrace();
      }
      //ballIntakeController.set(0);
    }


    ballIntakeController.set(output);
  }
  */
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    

     setDefaultCommand(new intakeIN());
  }
}
