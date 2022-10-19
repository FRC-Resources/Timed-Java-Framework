package frc.robot;

import java.io.*;
import java.util.Properties;

public class Import extends RobotSubsystems {
//
    // This file can be edited in-place on the robot with WinSCP 
    // or, copied over w/ SCP. 
    static final String CONFIG_PATH="/etc/robot_config_values.conf";
    public static Properties RobotConfiguration = new Properties();

    public static int leftFrontCanID;
    public static int rightFrontCanID;
    public static int leftBackCanID;
    public static int rightBackCanID;

    public static boolean isLeftFrontInverted;
    public static boolean isRightFrontInverted;
    public static boolean isLeftBackInverted;
    public static boolean isRightBackInverted;

    public static float deadbandValue;

    public static int teamNumber;

    public static void importConfig() {
        try {
            FileInputStream input = new FileInputStream(CONFIG_PATH);
            RobotConfiguration.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //imports config file on robotInit
    public void robotInit() {
        importConfig();
        teamNumber = Integer.parseInt(
        RobotConfiguration.getProperty("TeamNumber", "3044"));

        leftFrontCanID = Integer.parseInt(
        RobotConfiguration.getProperty("drive_left_front_canid", "1"));
        rightFrontCanID = Integer.parseInt(
        RobotConfiguration.getProperty("drive_right_front_canid", "99"));
        leftBackCanID = Integer.parseInt(
        RobotConfiguration.getProperty("drive_left_back_canid", "3"));
        rightBackCanID = Integer.parseInt(
        RobotConfiguration.getProperty("drive_right_back_canid", "4"));

        isLeftFrontInverted = Boolean.parseBoolean(
        RobotConfiguration.getProperty("is_drive_left_front_inverted", "false"));
        isRightFrontInverted = Boolean.parseBoolean(
        RobotConfiguration.getProperty("is_drive_right_front_inverted", "false"));
        isLeftBackInverted = Boolean.parseBoolean(
        RobotConfiguration.getProperty("is_drive_left_back_inverted", "false"));
        isRightBackInverted = Boolean.parseBoolean(
        RobotConfiguration.getProperty("is_drive_right_back_inverted", "false"));

        deadbandValue = Float.parseFloat(
        RobotConfiguration.getProperty("deadband_value", "0.15"));
    }
}
