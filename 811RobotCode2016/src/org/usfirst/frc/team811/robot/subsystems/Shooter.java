package org.usfirst.frc.team811.robot.subsystems;

import org.usfirst.frc.team811.robot.Config;
import org.usfirst.frc.team811.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;

/**
 *
 */

// 2 motors, encoder??	TODO

public class Shooter extends Subsystem implements Config {
	
	Joystick joy2 = RobotMap.joystick2;
	
	SpeedController shooterTalon1 = RobotMap.shooterTalon1;
	SpeedController shooterTalon2 = RobotMap.shooterTalon2;
	Encoder shooterEncoder = RobotMap.shooterEncoder;
	
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
    	shooterTalon2.set(SHOOTER_SPEED);
    	if (isFullSpeed()) {
    		if (!intakeLimit.get()) {
    			shootingEndTime = System.currentTimeMillis();
    		}
    	}
    	
    	
    	if (shot()) {
    		shooterTalon1.set(0);
    	}
    	
    }
    
    public void autoShoot() {
    	
    	//get distance from camera
    	
    	//insert equation thing
    	
    }
    
    public boolean shot() {
    	return shootingEndTime + SHOOTER_END_WAIT_TIME > System.currentTimeMillis();
    }
}

