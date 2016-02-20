package org.usfirst.frc.team811.robot.subsystems;

import org.usfirst.frc.team811.robot.Config;
import org.usfirst.frc.team811.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;

/**
 *
 */

// 2 motors, encoder??	TODO

public class Shooter extends Subsystem implements Config {
	
	Joystick joy2 = RobotMap.joystick2;
	
	SpeedController shooterTalon1 = RobotMap.shooterTalon1;
	//SpeedController shooterTalon2 = RobotMap.shooterTalon2;
	Encoder shooterEncoder = RobotMap.shooterEncoder;
	NetworkTable visionTable = RobotMap.visionTable;
	
	DigitalInput intakeLimit = RobotMap.intakeLimit;
	
	boolean shooting = false;
	double shootingTime = 0;
	double shootingEndTime = 0;
	
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void shootWJoy() {
    	
    	if (joy2.getRawButton(SHOOTER_BUTTON)) {
    		shoot();
    	}
    	
    }
    
    public boolean isFullSpeed() {
    	
    	shooterEncoder.setDistancePerPulse(SHOOTER_DISTANCE_PER_PULSE);
    	//1 revolution = about 260 
    	
    	return shooterEncoder.getRate() >= SHOOTER_FULL_SPEED_RATE;
    	
    	//return (shootingTime + SHOOTER_WAIT_TIME > System.currentTimeMillis()) && !(shootingEndTime + SHOOTER_END_WAIT_TIME > System.currentTimeMillis());
    }
    
    public void shoot() {
    	
    	shootingTime = System.currentTimeMillis();
    	shooterTalon1.set(SHOOTER_SPEED);
    	//shooterTalon2.set(-SHOOTER_SPEED);
    	if (isFullSpeed()) {
    		RobotMap.intakeTalon.set(INTAKE_SPEED);
    		if (!intakeLimit.get()) {
    			shootingEndTime = System.currentTimeMillis();
    		}
    	}
    	
    	
    	if (shot()) {
    		shooterTalon1.set(0);
    		//shooterTalon2.set(0);
    	}
    	
    }
    
    public void autoShoot() {
    	
    	//get distance from camera
    	
    	//insert equation thing
    	
    	double distance = 116 * .0254;
    	double lateralVelocity = 12.38394617 * distance - 17.05999456; //meters per second
    	
    	//lateral velocity = 12.38394617 * distance - 17.05999456
    	
    	double time = Math.pow(distance/lateralVelocity, 2);
    	
    	double speed;
    	
    	double x = 50 * 3.1415926535/180; //angle in radians
    	
    	double sinDeg = Math.sin(x);
    	
    	double radius = .0762; 	//.046736
    	
    	speed = ((2.4638 + (4.9 * time))/((distance/lateralVelocity) * sinDeg * 2 * radius * 3.1415926535)) * 60;
    	SmartDashboard.putNumber("speed", speed);
    	
    	double rps = speed/60;
    	SmartDashboard.putNumber("rps", rps);
    	
    	double speedScale = rps/70;
    	SmartDashboard.putNumber("speedScale", speedScale);
    	
    	shooterTalon1.set(speedScale);
    	//shooterTalon2.set(-speedScale);
    	
    	if (!intakeLimit.get()) {
			shootingEndTime = System.currentTimeMillis();
		}
    	
    	if (shot()) {
    		shooterTalon1.set(0);
    		//shooterTalon2.set(0);
    	}
    	
    }
    
    public void stopShooter() {
    	shooterTalon1.set(0);
    	//shooterTalon2.set(0);
    }
    
    
    public boolean shot() {
    	return shootingEndTime + SHOOTER_END_WAIT_TIME > System.currentTimeMillis();
    }
}