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
	
	public Climber() {
		climberTalon.changeControlMode(CANTalon.TalonControlMode.Position); //makes it so will go to position when you use .set()
		climberTalon.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder); //sets device so knows what it's looking for
		climberTalon.setPID(1.0, 0.0, 0.0); //numbers are temporary
		climberTalon.setForwardSoftLimit(CLIMBER_FORWARD_LIMIT);
		climberTalon.setReverseSoftLimit(CLIMBER_REVERSE_LIMIT);
		
	}


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void climbWJoy() {
    	
    	climberTalon.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	
    	double input;
    	
    	if ((joy2.getRawAxis(CLIMBER_AXIS) < .2) && (joy2.getRawAxis(CLIMBER_AXIS) > -.2)) {
    		input = 0;
    	} else {
    		input = joy2.getRawAxis(CLIMBER_AXIS);
    	}
    	
    	climberTalon.set(input);
    	
    }
    
    public void climbUp() {
    	
    	climberTalon.changeControlMode(CANTalon.TalonControlMode.Position);
    	
    	climberTalon.set(CLIMBER_UP_POSITION);
    }
    
    public void climbDown() {
    	
    	climberTalon.changeControlMode(CANTalon.TalonControlMode.Position);
    	
    	climberTalon.set(CLIMBER_DOWN_POSITION);
    }
    
    public void reset() {
    	
    	climberTalon.setPosition(0);
    	
    }
}

