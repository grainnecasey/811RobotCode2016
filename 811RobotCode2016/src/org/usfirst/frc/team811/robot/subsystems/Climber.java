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
	
	CANTalon climberMotor = RobotMap.climberTalon1;
	CANTalon climberWinch = RobotMap.climberTalon2;
	Joystick joy2 = RobotMap.joystick2;
	
	public Climber() {
		climberMotor.changeControlMode(CANTalon.TalonControlMode.Position); //makes it so will go to position when you use .set()
		climberMotor.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder); //sets device so knows what it's looking for
		climberMotor.setPID(1.0, 0.0, 0.0); //numbers are temporary
		climberMotor.setForwardSoftLimit(CLIMBER_FORWARD_LIMIT);
		climberMotor.setReverseSoftLimit(CLIMBER_REVERSE_LIMIT);
		
		climberWinch.changeControlMode(CANTalon.TalonControlMode.Position); //makes it so will go to position when you use .set()
		climberWinch.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder); //sets device so knows what it's looking for
		climberWinch.setPID(1.0, 0.0, 0.0); //numbers are temporary
		climberWinch.setForwardSoftLimit(CLIMBER_FORWARD_LIMIT);
		climberWinch.setReverseSoftLimit(CLIMBER_REVERSE_LIMIT);
		
	}


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    
    public void climbUp() {
    	
    	climberMotor.changeControlMode(CANTalon.TalonControlMode.Position);
    	
    	climberMotor.set(CLIMBER_UP_POSITION);
    }
    
    public void climbDown() {
    	
    	climberWinch.changeControlMode(CANTalon.TalonControlMode.Position);
    	
    	climberWinch.set(CLIMBER_DOWN_POSITION);
    }
    
    public void reset() {
    	
    	climberMotor.setPosition(0);
    	climberWinch.setPosition(0);
    	
    }
}

