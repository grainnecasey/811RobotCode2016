package org.usfirst.frc.team811.robot;

import org.usfirst.frc.team811.robot.commands.*;
import org.usfirst.frc.team811.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI implements Config {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	public JoystickButton intake_in;
	public JoystickButton intake_out;
	public JoystickButton intake_stop;
	public JoystickButton shoot;
	public JoystickButton stopShoot;
	public JoystickButton climber_up;
	public JoystickButton climber_down;
	public JoystickButton gyro_reset;
	
	public OI() {
		
		intake_in = new JoystickButton(RobotMap.joystick2, INTAKE_IN_BUTTON);
		intake_in.whenPressed(new intake());
		intake_out = new JoystickButton(RobotMap.joystick2, INTAKE_OUT_BUTTON);
		intake_out.whenPressed(new intake_backspin());
		intake_stop = new JoystickButton(RobotMap.joystick2, INTAKE_STOP_BUTTON);
		intake_stop.whenPressed(new intake_stop());
		
		shoot = new JoystickButton(RobotMap.joystick2, SHOOTER_BUTTON);
		shoot.whenPressed(new shoot_aimshoot());
		stopShoot = new JoystickButton(RobotMap.joystick2, 4);
		stopShoot.whenPressed(new shoot_stop());
		
		climber_up = new JoystickButton(RobotMap.joystick2, CLIMBER_UP_BUTTON);
		climber_up.whenPressed(new climb_up());
		climber_down = new JoystickButton(RobotMap.joystick2, CLIMBER_DOWN_BUTTON);
		climber_down.whenPressed(new climb_down());
		
		gyro_reset = new JoystickButton(RobotMap.joystick1, GYRO_RESET_BUTTON);
		gyro_reset.whenPressed(new gyro_reset());

		
		SmartDashboard.putData("auto_breach", new auto_breach());
		SmartDashboard.putData("auto_breachshootFrontGoal", new auto_breachshootFrontGoal());
		SmartDashboard.putData("auto_breachshootLeftGoal", new auto_breachshootLeftGoal());
		SmartDashboard.putData("auto_breachshootRightGoal", new auto_breachshootRightGoal());
		SmartDashboard.putData("auto_reach", new auto_reach());
		
		SmartDashboard.putData("climb_down", new climb_down());
		SmartDashboard.putData("climb_up", new climb_up());
		
		SmartDashboard.putData("drive_auto(30)", new drive_auto(-164));
		SmartDashboard.putData("drive_turn_auto(30)", new drive_turn_auto(30));
		SmartDashboard.putData("drive_w_joysticks", new drive_w_joysticks());
		
		SmartDashboard.putData("gyro_reset", new gyro_reset());
		SmartDashboard.putData("drive encoder reset", new drive_encoder_reset());
		
		SmartDashboard.putData("intake", new intake());
		SmartDashboard.putData("intake back spin", new intake_backspin());
		
		SmartDashboard.putData("shoot_auto_aim", new shoot_aimshoot());
		SmartDashboard.putData("shoot_w_joysticks", new shoot_w_joysticks());
		SmartDashboard.putData("shoot", new shoot());
		SmartDashboard.putData("shoot stop", new shoot_stop());
	
	}
}