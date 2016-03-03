package org.usfirst.frc.team811.robot.subsystems;

import org.usfirst.frc.team811.robot.Config;

import org.usfirst.frc.team811.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class PortcullisLifter extends Subsystem implements Config{
    
	Talon lifterMotor1 = RobotMap.lifterTalon;
	Relay lifterMotor2 = RobotMap.lifterRelay;
	Joystick joy2 = RobotMap.joystick2;
    DigitalInput lifterLimitTop = RobotMap.lifterLimitTop;
    DigitalInput lifterLimitBottom = RobotMap.lifterLimitBottom;
    
	
	public PortcullisLifter() {
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void liftUp() {
    	
    	lifterMotor1.set(.5);
    }
    
    public void liftDown() {
    	
    	lifterMotor1.set(-.5);
    }
    public void liftStop() {
    	
    	lifterMotor1.set(0);
    }
    public void motorSpin() {
    	lifterMotor2.set(Relay.Value.kForward);
    }
    public void motorStop(){
    	lifterMotor2.set(Relay.Value.kOff);
    }
    
    public void portJoy() {
    	if ((joy2.getRawAxis(PORT_LIFT_AXIS) > .2) && (lifterLimitTop.get())) {
    		lifterMotor1.set(joy2.getRawAxis(PORT_LIFT_AXIS));
    	} else if (joy2.getRawAxis(PORT_LIFT_AXIS) < -.2) {
    		 lifterMotor1.set(joy2.getRawAxis(PORT_LIFT_AXIS));
    	}
    }
}

