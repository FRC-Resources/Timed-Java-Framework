package frc.robot;

import java.io.*;
import java.util.Properties;

public class Import extends RobotSubsystems {

    // This file can be edited in-place on the robot with WinSCP 
    // or, copied over w/ SCP. 
    static final String CONFIG_PATH="/etc/robot_config_values.conf";
    public static Properties RobotConfiguration = new Properties();

    public static void importConfig() {
        try {
            FileInputStream input = new FileInputStream(CONFIG_PATH);
            RobotConfiguration.load(input);

            //test function
            //System.out.println(RobotConfiguration.getProperty("drive_left_front_canid"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //imports config file on robotInit
    public void robotInit() {
        importConfig();
    }
}
