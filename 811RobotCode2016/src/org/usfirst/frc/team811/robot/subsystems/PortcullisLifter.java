package org.usfirst.frc.team811.robot.subsystems;

import org.usfirst.frc.team811.robot.Config;
import org.usfirst.frc.team811.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PortcullisLifter extends Subsystem implements Config{
    
	Talon lifterMotor = RobotMap.lifterTalon;
	Joystick joy2 = RobotMap.joystick2;
    DigitalInput lifterLimitTop = RobotMap.lifterLimitTop;
    DigitalInput lifterlimitBottom = RobotMap.lifterlimitBottom;
	
	public PortcullisLifter() {
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void liftUp() {
    	
    	lifterMotor.set(.5);
    }
    
    public void liftDown() {
    	
    	lifterMotor.set(-.5);
    }
    public void liftStop() {
    	
    	lifterMotor.set(0);
    }
    
    public void portJoy() {
    	if ((joy2.getRawAxis(PORT_LIFT_AXIS) > .2) && (lifterLimitTop.get())) {
    		lifterMotor.set(joy2.getRawAxis(PORT_LIFT_AXIS));
    	} else if (joy2.getRawAxis(PORT_LIFT_AXIS) < -.2) {
    		 lifterMotor.set(joy2.getRawAxis(PORT_LIFT_AXIS));
    	}
    }
}

