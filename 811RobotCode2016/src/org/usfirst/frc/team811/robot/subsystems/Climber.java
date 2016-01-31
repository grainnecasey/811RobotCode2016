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
	
	CANTalon climberTalon1 = RobotMap.climberTalon1;
	CANTalon climberTalon2 = RobotMap.climberTalon2;
	Joystick joy2 = RobotMap.joystick2;
	
	public Climber() {
		climberTalon1.changeControlMode(CANTalon.TalonControlMode.Position); //makes it so will go to position when you use .set()
		climberTalon1.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder); //sets device so knows what it's looking for
		climberTalon1.setPID(1.0, 0.0, 0.0); //numbers are temporary
		climberTalon1.setForwardSoftLimit(CLIMBER_FORWARD_LIMIT);
		climberTalon1.setReverseSoftLimit(CLIMBER_REVERSE_LIMIT);
		
	}


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void climbWJoy() {
    	
    	climberTalon1.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	
    	double input;
    	
    	if ((joy2.getRawAxis(CLIMBER_AXIS) < .2) && (joy2.getRawAxis(CLIMBER_AXIS) > -.2)) {
    		input = 0;
    	} else {
    		input = joy2.getRawAxis(CLIMBER_AXIS);
    	}
    	
    	climberTalon1.set(input);
    	
    }
    
    public void climbUp() {
    	
    	climberTalon1.changeControlMode(CANTalon.TalonControlMode.Position);
    	
    	climberTalon1.set(CLIMBER_UP_POSITION);
    }
    
    public void climbDown() {
    	
    	climberTalon2.changeControlMode(CANTalon.TalonControlMode.Position);
    	
    	climberTalon2.set(CLIMBER_DOWN_POSITION);
    }
    
    public void reset() {
    	
    	climberTalon1.setPosition(0);
    	climberTalon2.setPosition(0);
    	
    }
}

