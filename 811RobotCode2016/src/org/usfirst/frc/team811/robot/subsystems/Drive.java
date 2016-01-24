package org.usfirst.frc.team811.robot.subsystems;

import org.usfirst.frc.team811.robot.RobotMap;
import org.usfirst.frc.team811.robot.commands.drive_w_joysticks;
import org.usfirst.frc.team811.robot.Config;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

//still needs encoder     TODO

public class Drive extends Subsystem implements Config {
	
    Joystick joy1 = RobotMap.joystick1;
    SpeedController frontright = RobotMap.drivefrontright;
    SpeedController frontleft = RobotMap.drivefrontleft;
    SpeedController backleft = RobotMap.drivebackleft;
    SpeedController backright = RobotMap.drivebackright;
    RobotDrive driveRobotDrive41 = RobotMap.driveTrain;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void driveWithJoy()
    {
    	double moveVal = joy1.getRawAxis(FORWARD_DRIVE_AXIS);
    	double turnVal = joy1.getRawAxis(TURN_DRIVE_AXIS);
    	driveRobotDrive41.arcadeDrive(moveVal, turnVal);
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
}

