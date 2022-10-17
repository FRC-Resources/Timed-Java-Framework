package frc.robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Auto extends RobotSubsystems{
    static Timer time = new Timer();
    static int state;

  public void robotInit() {
    m_chooser.setDefaultOption("Default Comp. Auto", Default);
    m_chooser.addOption("Auto 0", kCustomAuto);
    m_chooser.addOption("Auto 1", kCustomAuto1);
    SmartDashboard.putData("Auto choices", m_chooser);
    }

    public static final String Default = "Default Comp. Auto";
    public static final String kCustomAuto = "Auto 0";
    public static final String kCustomAuto1 = "Auto 1";
    public String m_autoSelected;
    private final SendableChooser<String> m_chooser = new SendableChooser<>();

    /*<p>You can add additional auto modes by adding additional comparisons to the switch structure
    * below with additional strings. If using the SendableChooser make sure to add them to the
    * chooser code above as well.*/

    public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    System.out.println("Auto selected: " + m_autoSelected);

    time.reset();
    time.start();
    }

    /** This autonomous (along with the chooser code above) shows how to select between different
    * autonomous modes using the dashboard. The sendable chooser code works with the Java
     * SmartDashboard.*/
    public void autonomousPeriodic() {
      if(m_autoSelected == null)  {
        //auto if none is selected or selection not found
      } else {
        switch (m_autoSelected) {
          case kCustomAuto:
            //custom auto 0
            break;
          case kCustomAuto1:
            //custom auto 1
            break;
          case Default:
          default:
            //default auto, null auto should match this in most cases
        }
      }
    }
    public void testInit()  {}
}