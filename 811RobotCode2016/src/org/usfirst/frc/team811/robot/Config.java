package org.usfirst.frc.team811.robot;

public interface Config {
	
	//ports
	
	int FRONT_RIGHT_PORT = 3;	
	int FRONT_LEFT_PORT = 1;	
	int BACK_RIGHT_PORT = 4;	
	int BACK_LEFT_PORT = 2;		
	
	int DRIVE_ENCODER_PORT_1 = 1;	//TODO
	int DRIVE_ENCODER_PORT_2 = 2; 	//TODO
	
	int INTAKE_TALON_PORT = 0;
	int INTAKE_LIMIT_PORT = 9; 	//TODO
	
	int SHOOTER_TALON_1_PORT = 5; 	
	int SHOOTER_TALON_2_PORT = 6;	
	int SHOOTER_ENCODER_PORT_1 = 3;	//TODO
	int SHOOTER_ENCODER_PORT_2 = 4;	//TODO
	
	int CLIMBER_TALON_1_PORT = 8;	//TODO
	int CLIMBER_TALON_2_PORT = 9;   //TODO
	
	int GYRO_CHANNEL = 1; //TODO
	
	
	//variables
	
	double SPEED_SCALE = 0.75;
	double DRIVE_DISTANCE_PER_PULSE = 1/14.5;	//TODO
	double GYRO_DIFFERENCE_VALUE = 10; //TODO
	
	int INTAKE_SPEED = 1;	//TODO
	
	int SHOOTER_SPEED = 1;	//TODO
	double SHOOTER_WAIT_TIME = 50;		//TODO
	double SHOOTER_END_WAIT_TIME = 50;	//TODO
	double SHOOTER_FULL_SPEED_RATE = 20; //TODO
	double SHOOTER_DISTANCE_PER_PULSE = 260; 	//TODO
	
	boolean CAN_SHOOT = false;
	
	int CLIMBER_UP_POSITION = 500; 	//TODO
	int CLIMBER_DOWN_POSITION = 0;	//TODO
	int CLIMBER_FORWARD_LIMIT = 700; 	//TODO
	int CLIMBER_REVERSE_LIMIT = 0; 	//TODO
	int CLIMBER_DIFFERENCE_VALUE = 20; 	//TODO
	
	
	//controls

	int FORWARD_DRIVE_AXIS = 1;	
	int TURN_DRIVE_AXIS = 4; 	
	int GYRO_RESET_BUTTON = 1;
	
	int INTAKE_IN_BUTTON = 1;
	int INTAKE_OUT_BUTTON = 2;
	int INTAKE_STOP_BUTTON = 7;
	
	int SHOOTER_BUTTON = 3;
	
	int CLIMBER_UP_BUTTON = 5;
	int CLIMBER_DOWN_BUTTON = 6;
}
