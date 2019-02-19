/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.ClawMech;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * Add your docs here.
 */
public class Claw extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  Compressor c;
 
  TalonSRX talon = new TalonSRX(0);
  DoubleSolenoid ClawSolenoid = new DoubleSolenoid(0,1);


    //Sets the value for the solenoid, opens valve
  public void Open(){
  ClawSolenoid.set(DoubleSolenoid.Value.kForward);
   }
  //Closes Vlave
  public void Close(){
  ClawSolenoid.set(DoubleSolenoid.Value.kReverse);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new ClawMech());
  }
}
