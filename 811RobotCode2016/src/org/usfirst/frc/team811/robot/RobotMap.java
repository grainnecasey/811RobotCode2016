package org.usfirst.frc.team811.robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.*;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap implements Config {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	public static Joystick joystick1;
	
	public static SpeedController drivefrontright;
    public static SpeedController drivefrontleft;
    public static SpeedController drivebackleft;
    public static SpeedController drivebackright;
    
    public static RobotDrive driveRobotDrive41;
    
    public static void init() {
    	
    	drivefrontright = new Talon(FRONT_RIGHT_PORT);
        LiveWindow.addActuator("Drive", "frontright", (Talon) drivefrontright);
        
        drivefrontleft = new Talon(FRONT_LEFT_PORT);
        LiveWindow.addActuator("Drive", "frontleft", (Talon) drivefrontleft);
        
        drivebackleft = new Talon(BACK_LEFT_PORT);
        LiveWindow.addActuator("Drive", "backleft", (Talon) drivebackleft);
        
        drivebackright = new Talon(BACK_RIGHT_PORT);
        LiveWindow.addActuator("Drive", "backright", (Talon) drivebackright);
        
        
    }
}
