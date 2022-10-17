# Timed-Java-Framework

A starting Java framework for FRC robots, allowing for easy value 
changes without rebuilding code through a conf file and WinSCP
and a separated subsystem structure, allowing for code separation
along with independent work on different subsystems by multiple 
programmers simultaneously.

## STEPS
1: change team number in "Robot.java" and "wpilib_preferences.json"

2: update the vendor deps to the newest version using online update

3: update gradle

4: check for depreciations caused by updated libraries

5: check the values in robot_config_value.conf to make sure the
   IP address, device IDs, & inversions for drive train motors are
   correctly set up for your robot

6: place robot_config_values.conf in "/etc/" by using winSCP, 
   navigating to the top level of the file structure "/", and
   then clicking on "etc"

7: give your drivetrain a test

## NOTES
Not finished!! an official package will be published as version 1.0.0
when we are sure the framework is stable. late Oct. to early Nov.

This framework is designed for java. It is set up to function with
smartdashboard within Display.java but this can be easily swapped
to your preferred dashboard software. The framework currently is 
setup for a talon based drive train with CAN but can easily be 
switched out to venoms or vex and set over to PWM without any major 
difficulties or issues.
