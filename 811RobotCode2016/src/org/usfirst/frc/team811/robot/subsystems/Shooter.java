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
    		shooting = true;
    	}
    	
    	if (shooting) {
    		shootingTime = System.currentTimeMillis();
    		shooterTalon1.set(SHOOTER_SPEED);
    		shooterTalon2.set(SHOOTER_SPEED);
    		if (shootingTime + SHOOTER_WAIT_TIME > System.currentTimeMillis()) {
    			//canShoot = true;	TODO
    			if (!intakeLimit.get()) {
    				shootingEndTime = System.currentTimeMillis();
    			}
    		}
    	}
    	
    	if (shootingEndTime + SHOOTER_END_WAIT_TIME > System.currentTimeMillis()) {
    		shooterTalon1.set(0);
    		shooterTalon1.set(0);
    		//canShoot = false;	TODO
    	}
    	
    }
}

