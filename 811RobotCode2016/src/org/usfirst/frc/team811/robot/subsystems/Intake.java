package org.usfirst.frc.team811.robot.subsystems;

import org.usfirst.frc.team811.robot.Config;
import org.usfirst.frc.team811.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;

/**
 *
 */

//1 motor, 1 limit switch	TODO

public class Intake extends Subsystem implements Config {
	
	Joystick joy2 = RobotMap.joystick2;
	
	SpeedController intakeTalon = RobotMap.intakeTalon;
	DigitalInput intakeLimit = RobotMap.intakeLimit;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void intakeJoyControl() {
    	
    	if (joy2.getRawButton(INTAKE_IN_BUTTON)) {
    		if (!intakeLimit.get()) {
    			intakeTalon.set(INTAKE_SPEED);
    		} else {
    			if (CAN_SHOOT) {
    				intakeTalon.set(INTAKE_SPEED);
    			}
    		}
    	} else if (joy2.getRawButton(INTAKE_OUT_BUTTON)) {
    		if (intakeLimit.get() && !CAN_SHOOT) {
    			intakeTalon.set(-INTAKE_SPEED);
    		}
    	}
    	
    	
    }
}

