package org.usfirst.frc.team811.robot.commands;

import org.usfirst.frc.team811.robot.Config;
import org.usfirst.frc.team811.robot.Robot;
import org.usfirst.frc.team811.robot.RobotMap;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class drive_auto extends Command implements Config {

	double distance;

	public drive_auto(double inches) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drive);
		distance = inches;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		//RobotMap.driveEncoder.setDistancePerPulse(DRIVE_DISTANCE_PER_PULSE);
		
		setTimeout(5);
		RobotMap.driveEncoder.reset();
		RobotMap.driveEncoder.setDistancePerPulse(.2);

		RobotMap.pid = new PIDController(1, .6, 3, new PIDSource() 
		{
			public double pidGet()
			{
				SmartDashboard.putNumber("Auto value",
						RobotMap.driveEncoder.getDistance());
				return RobotMap.driveEncoder.getDistance();
			}
			@Override
			public void setPIDSourceType(PIDSourceType pidSource) {
			}

			@Override
			public PIDSourceType getPIDSourceType() {
				return null;
			}
		}, new PIDOutput() {
			public void pidWrite(double d) {
				System.out.println(d);
				RobotMap.driveTrain.arcadeDrive(d * .5, 0);
				SmartDashboard.putString("drive status", "in pidloop for driving");
			}
		});
		RobotMap.driveEncoder.reset();
		RobotMap.pid.setAbsoluteTolerance(1);
		RobotMap.pid.setSetpoint(distance); // -17
		RobotMap.pid.setOutputRange(-1, 1);
		RobotMap.pid.setContinuous(false);
		RobotMap.pid.enable();

		SmartDashboard.putString("drive status", "drive forward auto"); 

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		//Robot.drive.driveAuto(distance);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		//return RobotMap.pid.onTarget() || isTimedOut();
		return (RobotMap.driveEncoder.getDistance() >= distance);
	}

	// Called once after isFinished returns true
	protected void end() {
		RobotMap.driveTrain.arcadeDrive(0, 0);
		RobotMap.pid.disable();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		RobotMap.driveTrain.arcadeDrive(0, 0);
		RobotMap.pid.disable();
	}
}
