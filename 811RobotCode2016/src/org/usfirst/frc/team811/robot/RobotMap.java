package org.usfirst.frc.team811.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;
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
    public static AHRS ahrs;
    public static PIDController turnController;
    
    public static SpeedController intakeTalon;
    public static DigitalInput intakeLimit;
    //limit switch set in
    
    public static SpeedController shooterTalon1;
    //public static SpeedController shooterTalon2;
    public static Encoder shooterEncoder;
    
    public static CANTalon climberTalon1;
    public static CANTalon climberTalon2;
    
    public static NetworkTable visionTable;
    
    public static Servo servoCam;
    
    public void init() {
    	
    	joystick1 = new Joystick(1);
        joystick2 = new Joystick(2);
    	
    	drivefrontright = new Talon(FRONT_RIGHT_PORT);
        drivefrontleft = new Talon(FRONT_LEFT_PORT);
        drivebackleft = new Talon(BACK_LEFT_PORT);
        drivebackright = new Talon(BACK_RIGHT_PORT);
        driveTrain = new RobotDrive(drivefrontleft, drivebackleft,
                drivefrontright, drivebackright);
        driveEncoder = new Encoder(DRIVE_ENCODER_PORT_1, DRIVE_ENCODER_PORT_2);
        driveEncoder.setReverseDirection(false);
        ahrs = new AHRS(SPI.Port.kMXP);
        
        intakeTalon = new Talon(INTAKE_TALON_PORT);
        intakeLimit = new DigitalInput(INTAKE_LIMIT_PORT);
        
        shooterTalon1 = new Talon(SHOOTER_TALON_1_PORT);
        //shooterTalon2 = new Talon(SHOOTER_TALON_2_PORT);
        shooterEncoder = new Encoder(SHOOTER_ENCODER_PORT_1, SHOOTER_ENCODER_PORT_2);
        
        climberTalon1 = new CANTalon(CLIMBER_TALON_1_PORT);
        climberTalon2 = new CANTalon(CLIMBER_TALON_2_PORT);
        
        visionTable = NetworkTable.getTable("GRIP/811Contour");
        
        servoCam = new Servo(SERVO_PORT);
        
    }
}
