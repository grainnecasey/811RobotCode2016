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
		climberMotor.changeControlMode(CANTalon.TalonControlMode.PercentVbus); //makes it so will go at a speed
		climberMotor.setPID(1.0, 0.0, 0.0); //numbers are temporary
		climberMotor.enableLimitSwitch(true, true);
		
		climberWinch.changeControlMode(CANTalon.TalonControlMode.PercentVbus); //makes it so will go at a speed
		climberWinch.setPID(1.0, 0.0, 0.0); //numbers are temporary
		climberWinch.enableLimitSwitch(true, true);
		
	}


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    
    public void climbUp() {
    	
    	climberMotor.set(.5);
    }
    
    public void climbDown() {
    	
    	climberWinch.set(.5);
    }
    

}

