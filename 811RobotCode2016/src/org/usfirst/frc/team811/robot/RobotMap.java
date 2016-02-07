package org.usfirst.frc.team811.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
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
	public static Joystick joystick2;
	
	public static SpeedController drivefrontright;
    public static SpeedController drivefrontleft;
    public static SpeedController drivebackleft;
    public static SpeedController drivebackright;
    public static Encoder driveEncoder;
    public static RobotDrive driveTrain;
    public static AnalogGyro driveGyro;
    public static PIDController pid;
    
    public static SpeedController intakeTalon;
    public static DigitalInput intakeLimit;
    //limit switch set in
    
    public static SpeedController shooterTalon1;
    public static SpeedController shooterTalon2;
    public static Encoder shooterEncoder;
    
    public static CANTalon climberTalon1;
    public static CANTalon climberTalon2;
    public static Encoder climberEncoder;
    
    public static NetworkTable visionTable;
    //encoder set in
    
    
    public void init() {
    	
    	drivefrontright = new Talon(FRONT_RIGHT_PORT);
        drivefrontleft = new Talon(FRONT_LEFT_PORT);
        drivebackleft = new Talon(BACK_LEFT_PORT);
        drivebackright = new Talon(BACK_RIGHT_PORT);
        driveTrain = new RobotDrive(drivefrontleft, drivebackleft,
                drivefrontright, drivebackright);
        driveEncoder = new Encoder(DRIVE_ENCODER_PORT_1, DRIVE_ENCODER_PORT_2);
        driveGyro = new AnalogGyro(GYRO_CHANNEL);
        
        intakeTalon = new Talon(INTAKE_TALON_PORT);
        intakeLimit = new DigitalInput(INTAKE_LIMIT_PORT);
        
        shooterTalon1 = new Talon(SHOOTER_TALON_1_PORT);
        shooterTalon2 = new Talon(SHOOTER_TALON_2_PORT);
        shooterEncoder = new Encoder(SHOOTER_ENCODER_PORT_1, SHOOTER_ENCODER_PORT_2);
        
        climberTalon1 = new CANTalon(CLIMBER_TALON_1_PORT);
        climberTalon2 = new CANTalon(CLIMBER_TALON_2_PORT);
        
        visionTable = NetworkTable.getTable("GRIP/myContoursReport");
    }
}
