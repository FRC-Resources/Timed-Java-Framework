// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;

/** The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.*/
public class Robot extends TimedRobot {
  //change to match your team number
  static final int TEAM_NUMBER=3044;
  
  /** To call on these type Robot.controller# 
  Works for xbox 360 & one controllers*/
  public static XboxController controllerOne = new XboxController(0);
  public static XboxController controllerTwo = new XboxController(1);

  //list all subsystems here
  public static Display Display;
  public static Drive Drive;
  public static Auto Auto;
  public static Import Import;
  
  // This method should (a) initalize the Subsystems collection and 
  // (b) call robotInit on all Subsystem modules
  void initializeSystems()  {
    Robot.Drive = new Drive();
    Robot.Auto = new Auto();
    Robot.Display = new Display();
    Robot.Import = new Import();
  }

  /** This function is run when the robot is first started up and should be used for any
   * initialization code.*/
  @Override
  public void robotInit() {
    initializeSystems();
    Robot.Drive.robotInit();
    Robot.Auto.robotInit();
    Robot.Display.robotInit();
    //only needed here to import the files? check if needed everywhere
    Robot.Import.robotInit();
  }

  /** This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.*/
  @Override
  public void robotPeriodic() {
    Robot.Drive.robotPeriodic();
    Robot.Auto.robotPeriodic();
    Robot.Display.robotPeriodic();
  }

  /** This function is called once when autonomous is enabled. */
  @Override
  public void autonomousInit() {
    Robot.Auto.autonomousInit();
    Robot.Display.autonomousInit();
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    Robot.Auto.autonomousPeriodic();
    Robot.Display.autonomousPeriodic();
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
    Robot.Drive.teleopInit();
    Robot.Auto.teleopInit();
    Robot.Display.teleopInit();
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    Robot.Drive.teleopPeriodic();
    Robot.Auto.teleopPeriodic();
    Robot.Display.teleopPeriodic();
  }

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {
    Robot.Display.testInit();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {
    System.out.println("test");
    System.out.println(leftFrontCanID);
  }
  
  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}
}