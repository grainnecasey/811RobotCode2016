package org.usfirst.frc.team811.robot.subsystems;

import org.usfirst.frc.team811.robot.Config;
import org.usfirst.frc.team811.robot.RobotMap;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

//winch, encoder	TODO

public class Climber extends Subsystem implements Config {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	CANTalon climberTalon = RobotMap.climberTalon;
	Joystick joy2 = RobotMap.joystick2;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void climbWJoy() {
    	
    	double input;
    	
    	if ((joy2.getRawAxis(CLIMBER_AXIS) < .2) && (joy2.getRawAxis(CLIMBER_AXIS) > -.2)) {
    		input = 0;
    	} else {
    		input = joy2.getRawAxis(CLIMBER_AXIS);
    	}
    	
    }
}

