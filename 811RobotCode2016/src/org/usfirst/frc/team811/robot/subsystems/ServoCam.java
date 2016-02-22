package org.usfirst.frc.team811.robot.subsystems;

import org.usfirst.frc.team811.robot.Config;
import org.usfirst.frc.team811.robot.RobotMap;
import org.usfirst.frc.team811.robot.commands.servo_joy_control;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ServoCam extends Subsystem implements Config
{

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	Servo servoCam = RobotMap.servoCam;
	Joystick joy1 = RobotMap.joystick1;

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new servo_joy_control());
	}

	public void joyControl()
	{

		if (joy1.getRawButton(5))
		{
			servoCam.set(servoCam.get() + .01);
		} else if (joy1.getRawButton(6))
		{
			servoCam.set(servoCam.get() - .01);
		}

	}

	public void servoPreset()
	{
		servoCam.set(0.336);
	}

	public void servoUp()
	{
		servoCam.set(1);
	}

	public void servoDown()
	{
		servoCam.set(0);
	}
}
