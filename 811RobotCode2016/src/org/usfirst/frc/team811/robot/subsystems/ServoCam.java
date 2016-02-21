package org.usfirst.frc.team811.robot.subsystems;

import org.usfirst.frc.team811.robot.Config;
import org.usfirst.frc.team811.robot.RobotMap;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ServoCam extends Subsystem implements Config{
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Servo servoCam = RobotMap.servoCam;
	Joystick joy1 = RobotMap.joystick1;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void joyControl() {
    	
    	if (joy1.getRawAxis(SERVO_AXIS) > .1) {
    		servoCam.set(joy1.getRawAxis(SERVO_AXIS));
    	} else if (joy1.getRawAxis(SERVO_AXIS) < -.1) {
    		servoCam.set(joy1.getRawAxis(SERVO_AXIS));
    	}
    	
    }
    
    public void servoUp() {
    	servoCam.set(1);
    }
    
    public void servoDown() {
    	servoCam.set(-1);
    }
}

