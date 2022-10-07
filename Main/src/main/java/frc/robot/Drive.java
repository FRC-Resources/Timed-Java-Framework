package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;

public class Drive extends RobotSubsystems
{
  /*Use of TalonSRXs over CAN as motor controllers is only an example and can easily be switched out for any 
  other motor controller or switched over to PWM. */

  //gets drivetrain talon IDs from robot_config_values.conf
  static int leftFrontCanID = Integer.parseInt(
    Import.RobotConfiguration.getProperty("drive_left_front_canid", "1"));
  static int rightFrontCanID = Integer.parseInt(
    Import.RobotConfiguration.getProperty("drive_right_front_canid", "2"));
  static int leftBackCanID = Integer.parseInt(
    Import.RobotConfiguration.getProperty("drive_left_back_canid", "3"));
  static int rightBackCanID = Integer.parseInt(
    Import.RobotConfiguration.getProperty("drive_right_back_canid", "4"));

  public static TalonSRX leftFront = new TalonSRX(leftFrontCanID);
  public static TalonSRX rightFront = new TalonSRX(rightFrontCanID);
  public static TalonSRX leftBack = new TalonSRX(leftBackCanID);
  public static TalonSRX rightBack = new TalonSRX(rightBackCanID);

  //checks if drivetrain motors motors should be inverted
  boolean isLeftFrontInverted = Boolean.parseBoolean(
    Import.RobotConfiguration.getProperty("is_drive_left_front_inverted", "false"));
  boolean isRightFrontInverted = Boolean.parseBoolean(
    Import.RobotConfiguration.getProperty("is_drive_right_front_inverted", "false"));
  boolean isLeftBackInverted = Boolean.parseBoolean(
    Import.RobotConfiguration.getProperty("is_drive_left_back_inverted", "false"));
  boolean isRightBackInverted = Boolean.parseBoolean(
    Import.RobotConfiguration.getProperty("is_drive_right_back_inverted", "false"));

  //gets the deadband value from robot_config_values.conf
  public static float deadbandValue = Float.parseFloat(
    Import.RobotConfiguration.getProperty("deadband_value", "0.15"));

  public void robotInit() {
    //sets drivetrain motor inversion based on robot_config_values.conf
    leftFront.setInverted(isLeftFrontInverted);
    rightFront.setInverted(isRightFrontInverted);
    leftBack.setInverted(isLeftBackInverted);
    rightBack.setInverted(isRightBackInverted);

    //set rear motors to follow front set for tank drive
    leftBack.follow(leftFront);
    rightBack.follow(rightFront);
  }

  public void robotPeriodic() {}

  public void teleopInit() {}

  public void teleopPeriodic() {
    //pases the controller joystick values in to the drive function after applying the deadband to prevent drift
    exponentialDrive(deadband(Robot.controllerOne.getLeftY()), deadband(Robot.controllerOne.getRightY()));
  }
  
  public void autonomousInit() {}

  public void autonomousPeriodic() {}

  public void testInit() {
  }

  public double deadband(double input) {
    double output;
    if(Math.abs(input) < deadbandValue) {
      output = 0;
    } else {
      output = input;
    }
    return output;
  }

  public void exponentialDrive(double left, double right) {
    leftFront.set(TalonSRXControlMode.PercentOutput, -(0.2*Math.tan(1.4*left)));
    rightFront.set(TalonSRXControlMode.PercentOutput, -(0.2*Math.tan(1.4*left)));
  }
}