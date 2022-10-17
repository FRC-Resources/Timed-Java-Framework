package frc.robot;

//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.cameraserver.CameraServer;

/**Handles all encoders, cameras, and general outputs to the driverstation */
public class Display extends RobotSubsystems{
    int loopCount = 0;

    public void robotInit() {
        //shoulkd activate camera if not uncomment the activation in teleopInit & testInit
        CameraServer.startAutomaticCapture();
    }

    public void robotPeriodic() {
       int printskips = 50;
       
        if (loopCount % printskips == 0) {
           //data to smartdashboard here
        }
        loopCount++;
    }

    public void teleopInit() {
        //activates camera
        //CameraServer.startAutomaticCapture();
    }

    public void teleopPeriodic() {}

    public void autonomousInit() {}

    public void autonomousPeriodic() {}

    public void testInit() {
        //activates camera for test mode
        //CameraServer.startAutomaticCapture();
    }

    public void testPeriodic() {}
}