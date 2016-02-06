package org.usfirst.frc.team811.robot;

import org.usfirst.frc.team811.robot.commands.*;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
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
	
	public OI() {
		SmartDashboard.putData("auto_breach", new auto_breach());
		SmartDashboard.putData("auto_breachshootFrontGoal", new auto_breachshootFrontGoal());
		SmartDashboard.putData("auto_breachshootLeftGoal", new auto_breachshootLeftGoal());
		SmartDashboard.putData("auto_breachshootRightGoal", new auto_breachshootRightGoal());
		SmartDashboard.putData("auto_reach", new auto_reach());
		
		SmartDashboard.putData("climb_down", new climb_down());
		SmartDashboard.putData("climb_up", new climb_up());
		
		SmartDashboard.putData("drive_auto(12)", new drive_auto(12));
		SmartDashboard.putData("drive_turn_auto(30)", new drive_turn_auto(30));
		SmartDashboard.putData("drive_w_joysticks", new drive_w_joysticks());
		
		SmartDashboard.putData("gyro_reset", new gyro_reset());
		
		SmartDashboard.putData("intake_w_joysticks", new intake_w_joysticks());
		SmartDashboard.putData("intake", new intake());
		
		SmartDashboard.putData("shoot_auto_aim", new shoot_auto_aim());
		SmartDashboard.putData("shoot_w_joysticks", new shoot_w_joysticks());
		SmartDashboard.putData("shoot", new shoot());
		
	}
}

