package org.usfirst.frc.team811.robot.commands;

import org.usfirst.frc.team811.robot.Config;
import org.usfirst.frc.team811.robot.Robot;
import org.usfirst.frc.team811.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class drive_turn_w_ahrs extends Command implements Config{

	double setPoint;
	
    public drive_turn_w_ahrs(double setpoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    	setPoint = setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.rotateToAngle(setPoint);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return ((RobotMap.ahrs.getAngle() < setPoint + GYRO_DIFFERENCE_VALUE) && (RobotMap.ahrs.getAngle() > setPoint - GYRO_DIFFERENCE_VALUE));
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}