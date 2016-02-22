package org.usfirst.frc.team811.robot.commands;

import org.usfirst.frc.team811.robot.Robot;
import org.usfirst.frc.team811.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class shoot extends Command {

	public shoot() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.shooter);
		setTimeout(3);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.shooter.shoot();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		// RobotMap.shooterTalon1.set(0);
		// RobotMap.intakeTalon.set(0);
		// RobotMap.shooterTalon2.set(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		// RobotMap.shooterTalon1.set(0);
		// RobotMap.intakeTalon.set(0);
	}
}
