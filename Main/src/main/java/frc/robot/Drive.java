package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;

public class Drive extends RobotSubsystems
{
  //gets drivetrain talon IDs from robot_config_values.conf
  public static TalonSRX leftFront = new TalonSRX(Import.leftFrontCanID);
  public static TalonSRX rightFront = new TalonSRX(Import.rightFrontCanID);
  public static TalonSRX leftBack = new TalonSRX(Import.leftBackCanID);
  public static TalonSRX rightBack = new TalonSRX(Import.rightBackCanID);

  public void robotInit() {
    //sets drivetrain motor inversion based on robot_config_values.conf
    leftFront.setInverted(Import.isLeftFrontInverted);
    rightFront.setInverted(Import.isRightFrontInverted);
    leftBack.setInverted(Import.isLeftBackInverted);
    rightBack.setInverted(Import.isRightBackInverted);

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

  public void testInit() {}

  public double deadband(double input) {
    double output;
    if(Math.abs(input) < Import.deadbandValue) {
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