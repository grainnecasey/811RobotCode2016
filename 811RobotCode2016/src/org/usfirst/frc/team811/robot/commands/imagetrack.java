package org.usfirst.frc.team811.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team811.robot.Config;
import org.usfirst.frc.team811.robot.Robot;
import org.usfirst.frc.team811.robot.RobotMap;

/**
 *
 */
public class imagetrack extends Command implements Config{
	
	double[] x;

    public imagetrack() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.tracker);
    	//requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.tracker.positionX();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (SmartDashboard.getString("Position X") == "Center");
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.driveTrain.arcadeDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	RobotMap.driveTrain.arcadeDrive(0, 0);
    }
}
