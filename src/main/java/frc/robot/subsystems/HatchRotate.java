/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.HatchCommand;

/**
 * Add your docs here.
 */
public class HatchRotate extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
	public WPI_VictorSPX hatchMotor = new WPI_VictorSPX(RobotMap.hatchRotateChannel);


public void hatchUp(double output){
hatchMotor.set(0.5*output);


}
public void hatchdown(double output){
  hatchMotor.set(output);
  
  
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     setDefaultCommand(new HatchCommand());
  }
}
