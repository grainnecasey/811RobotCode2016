package org.usfirst.frc.team811.robot.commands;

import org.usfirst.frc.team811.robot.Config;
import org.usfirst.frc.team811.robot.Robot;
import org.usfirst.frc.team811.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class drive_turn_auto extends Command implements Config {
	
	double turnVal;

    public drive_turn_auto(double gyroTurnVal) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	turnVal = gyroTurnVal;
    	requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.turnAuto(turnVal);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (RobotMap.driveGyro.getAngle() < turnVal - GYRO_DIFFERENCE_VALUE) || (RobotMap.driveGyro.getAngle() > turnVal + GYRO_DIFFERENCE_VALUE);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
