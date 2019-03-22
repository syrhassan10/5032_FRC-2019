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

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public WPI_TalonSRX frontLeft = new WPI_TalonSRX(RobotMap.frontLeftChannel);
  public WPI_TalonSRX rearLeft= new WPI_TalonSRX(RobotMap.rearLeftChannel); 
  public WPI_TalonSRX frontRight = new WPI_TalonSRX(RobotMap.frontRightChannel);
  public WPI_TalonSRX rearRight = new WPI_TalonSRX(RobotMap.rearRightChannel); // CHANGE BACK TO ID: 3.
  SpeedControllerGroup leftMotorGroup = new SpeedControllerGroup(frontLeft, rearLeft);
  SpeedControllerGroup rightMotorGroup = new SpeedControllerGroup(frontRight, rearRight);
  public DifferentialDrive drive = new DifferentialDrive(rightMotorGroup, leftMotorGroup);


  /*/ PWM configeration -----------------------------------------------------------
	public PWMVictorSPX frontLeft = new PWMVictorSPX(RobotMap.FrontLeftChannel);
	public PWMVictorSPX rearLeft = new PWMVictorSPX(RobotMap.RearLeftChannel);
	public PWMVictorSPX frontRight = new PWMVictorSPX(RobotMap.FrontRightChannel);
	public PWMVictorSPX rearRight = new PWMVictorSPX(RobotMap.RearRightChannel);
  SpeedControllerGroup leftMotorGroup = new SpeedControllerGroup(frontLeft, rearLeft);
  SpeedControllerGroup rightMotorGroup = new SpeedControllerGroup(frontRight, rearRight);
  public DifferentialDrive drive = new DifferentialDrive(leftMotorGroup, rightMotorGroup);
  */
  // PWM configeration -----------------------------------------------------------


  //MecanumDrive drive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);
  public DriveTrain () {
   
   // rearLeft.follow(frontLeft);
    //rearRight.follow(frontRight);
   


     //config all talons
    ConfigTalons(frontLeft);
    ConfigTalons(rearLeft);
    ConfigTalons(frontRight);
    ConfigTalons(rearRight);

  
    
  }
  public void ConfigTalons(WPI_TalonSRX tSRX){
    tSRX.configPeakOutputForward(1, 0);
    tSRX.configPeakOutputReverse(-1, 0);
    

    // current itslef so we dont blow breaker
    tSRX.configPeakCurrentLimit(40, 0);
    tSRX.enableCurrentLimit(true);
    tSRX.configContinuousCurrentLimit(40, 0);

    //max current 40 amps for 250 millis
    tSRX.configPeakCurrentDuration(250, 0);
    //max voltage is 12 v
    //tSRX.configVoltageCompSaturation(12,0);

  }


 public void teleopDrive(double move, double turn){
  frontRight.setInverted(true);
  rearRight.setInverted(true);
  drive.arcadeDrive(move, turn);
 }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     setDefaultCommand(new moveFWD());
  }
}
