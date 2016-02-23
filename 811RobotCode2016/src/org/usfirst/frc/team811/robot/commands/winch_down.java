package org.usfirst.frc.team811.robot.commands;

import org.usfirst.frc.team811.robot.Config;
import org.usfirst.frc.team811.robot.Robot;
import org.usfirst.frc.team811.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class winch_down extends Command implements Config{

    public winch_down() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.climber);
    	setTimeout(3); 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.climber.winchDown();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.climberTalon2.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	RobotMap.climberTalon2.set(0);
    }
}
