/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.vision.VisionThread;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ClawMech;
import frc.robot.commands.moveFWD;
import frc.robot.subsystems.BallIntake;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.HatchRotate;
import frc.robot.subsystems.PivotRotate;


//import frc.robot.subsystems.GripPipeline;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */


public class Robot extends TimedRobot {
  public static DriveTrain moveForward  = new DriveTrain();
  public static BallIntake suckBall= new BallIntake();;
  public static Elevator elevator = new Elevator();
  public static HatchRotate HatchMove= new HatchRotate();
  public static Claw claw = new Claw();
  public static DigitalOutput lEDOutput= new DigitalOutput(1);
  public static PivotRotate pivotInstance = new PivotRotate();
  public static ClawMech ClawMech = new ClawMech();
  public static moveFWD moveFW = new moveFWD();

 // public static LimitSwitch spitter = new LimitSwitch();
  public static OI m_oi;
  Command m_autonomousCommand;
  UsbCamera source;
  SendableChooser<Command> m_chooser = new SendableChooser<>();
  private VisionThread visionThread;
  private double centerX = 0.0;
  public NetworkTable table;
	
	private final Object imgLock = new Object();
  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    //table = NetworkTable.getTable("GRIP/myLinesReport");

    m_oi = new OI();
    
   // SmartDashboard.putBoolean("isPressed", Robot.driveTrain.isSwitchPressed());
    /*
    source = CameraServer.getInstance().startAutomaticCapture();
		source.setExposureManual(20);
		source.setResolution(640, 480); 
    visionThread = new VisionThread(source, new GripPipeline(), pipeline -> {
      if (!pipeline.filterContoursOutput().isEmpty()) {
          Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
          synchronized (imgLock) {
              centerX = r.x + (r.width / 2);
          }
      }
  });
  visionThread.start();
  */
    //m_chooser.setDefaultOption("Default Auto", new moveFWD());
    //m_chooser.setDefaultOption("Default Auto", new arcadeDrive());
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *s
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    
   
    

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    

    /*
    double centerX;
    synchronized (imgLock) {
        centerX = this.centerX;
    }
    
    double turn = centerX - (640 / 2);
    System.out.println(turn);
    if (turn > 0){

    driveTrain.teleopDrive(0.6, -turn * 0.005);
    */
    Scheduler.getInstance().run();
    
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    //SmartDashboard.putBoolean("isPressed", Robot.driveTrain.isSwitchPressed());

    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    //SmartDashboard.putBoolean("isPressed", Robot.driveTrain.isSwitchPressed());

    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
