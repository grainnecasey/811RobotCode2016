package org.usfirst.frc.team811.robot;

public interface Config {
	
	//ports
	
	int FRONT_RIGHT_PORT = 1;	//TODO
	int FRONT_LEFT_PORT = 2;	//TODO
	int BACK_RIGHT_PORT = 3;	//TODO
	int BACK_LEFT_PORT = 4;		//TODO
	
	int DRIVE_ENCODER_PORT_1 = 1;	//TODO
	int DRIVE_ENCODER_PORT_2 = 2; 	//TODO
	
	int INTAKE_TALON_PORT = 1;	//TODO
	int INTAKE_LIMIT_PORT = 1; 	//TODO
	
	int SHOOTER_TALON_1_PORT = 5; 	//TODO
	int SHOOTER_TALON_2_PORT = 6;	//TODO
	int SHOOTER_ENCODER_PORT_1 = 1;	//TODO
	int SHOOTER_ENCODER_PORT_2 = 2;	//TODO
	
	int CLIMBER_TALON_PORT = 1;	//TODO
	
	
	//variables
	
	double SPEED_SCALE = 1;
	double DRIVE_DISTANCE_PER_PULSE = 260;	//TODO
	
	int INTAKE_SPEED = 1;	//TODO
	
	int SHOOTER_SPEED = 1;	//TODO
	double SHOOTER_WAIT_TIME = 50;		//TODO
	double SHOOTER_END_WAIT_TIME = 50;	//TODO
	double SHOOTER_FULL_SPEED_RATE = 20; //TODO
	double SHOOTER_DISTANCE_PER_PULSE = 260; 	//TODO
	
	boolean CAN_SHOOT = false;
	
	
	//controls

	int FORWARD_DRIVE_AXIS = 1;	//TODO
	int TURN_DRIVE_AXIS = 3; 	//TODO
	
	int INTAKE_IN_BUTTON = 6;
	int INTAKE_OUT_BUTTON = 7;
	
	int SHOOTER_BUTTON = 1;
}
