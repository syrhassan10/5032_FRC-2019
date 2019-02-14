/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.LimitCommand;


public class BallIntake extends Subsystem {

  public DigitalInput LimitSwitch = new DigitalInput(RobotMap.limitSwitchChannel);
  public TalonSRX ballIntakeController = new TalonSRX(0); 
    public BallIntake () {


    }
/*
    public void test(){
      ballIntakeController.set(1);

    }
    */
  public void ball(double output){
   
     
     ballIntakeController.set(ControlMode.PercentOutput,output); 
      if (LimitSwitch.get()) { // if not pressed
        System.out.println("true");
        ballIntakeController.set(ControlMode.PercentOutput,output);
        System.out.println(output);
      // 
      }
      else {
        System.out.println("false"); // if pressed
        ballIntakeController.set(ControlMode.PercentOutput, 0.2); 
        
        try {
        Thread.sleep(50);
      } catch (InterruptedException e) {
        
        e.printStackTrace();
      }
      ballIntakeController.set(ControlMode.PercentOutput,0);
    }
   System.out.println(output);
   // spitter.set(output);
    
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     setDefaultCommand(new LimitCommand());
  }
}
