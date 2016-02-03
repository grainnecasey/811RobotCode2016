package org.usfirst.frc.team811.robot.subsystems;


import org.usfirst.frc.team811.robot.RobotMap;
import org.usfirst.frc.team811.robot.commands.drive_w_joysticks;
import org.usfirst.frc.team811.robot.Config;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */

public class Drive extends Subsystem implements Config {
	
    Joystick joy1 = RobotMap.joystick1;
    SpeedController frontright = RobotMap.drivefrontright;
    SpeedController frontleft = RobotMap.drivefrontleft;
    SpeedController backleft = RobotMap.drivebackleft;
    SpeedController backright = RobotMap.drivebackright;
    RobotDrive driveTrain = RobotMap.driveTrain;
    Encoder driveEncoder = RobotMap.driveEncoder;
    AnalogGyro driveGyro = RobotMap.driveGyro;
    
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void driveWithJoy() {
    	
    	double moveVal;
    	double turnVal;
    	
    	if ((joy1.getRawAxis(FORWARD_DRIVE_AXIS) < .2) && (joy1.getRawAxis(FORWARD_DRIVE_AXIS) > -.2)) { 
    		moveVal = 0;
    	} else {
    		moveVal = joy1.getRawAxis(FORWARD_DRIVE_AXIS);
    	}
    	
    	if ((joy1.getRawAxis(TURN_DRIVE_AXIS) < .2) && (joy1.getRawAxis(TURN_DRIVE_AXIS) > -.2)) { 
    		turnVal = 0;
    	} else {
    		turnVal = joy1.getRawAxis(FORWARD_DRIVE_AXIS);
    	}
    	
    	driveTrain.arcadeDrive(moveVal * SPEED_SCALE, turnVal);
    	
    	
    	/* double leftVal = joy1.getRawAxis(FORWARD_DRIVE_AXIS); in case Joe wants tankdrive
    	 * double rightVal = joy1.getRawAxis(TURN_DRIVE_AXIS);
    	 * driveRobotDrive41.tankDrive(leftVal, rightVal);
    	 */
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new drive_w_joysticks());
    }
    
    public void driveAuto(double driveDistance) {		//TODO drive distance!
    	double turnVal = driveGyro.getAngle();
    	
    	driveEncoder.setDistancePerPulse(DRIVE_DISTANCE_PER_PULSE);
    	
    	while (driveEncoder.getDistance() <= driveDistance) {
    		driveTrain.arcadeDrive(SPEED_SCALE, turnVal * -1);
    	}
    }
    
    public void gyroReset() {
    	driveGyro.reset();
    }
}

