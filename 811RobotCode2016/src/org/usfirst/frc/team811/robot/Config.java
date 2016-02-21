package org.usfirst.frc.team811.robot;

public interface Config {
	
	//ports
	
	int FRONT_RIGHT_PORT = 3;	
	int FRONT_LEFT_PORT = 1;	
	int BACK_RIGHT_PORT = 4;	
	int BACK_LEFT_PORT = 2;		
	
	int DRIVE_ENCODER_PORT_1 = 2;
	int DRIVE_ENCODER_PORT_2 = 3;
	
	int INTAKE_TALON_PORT = 0;
	int INTAKE_LIMIT_PORT = 6;
	
	int SHOOTER_TALON_1_PORT = 5; 	
	int SHOOTER_TALON_2_PORT = 6;	
	int SHOOTER_ENCODER_PORT_1 = 0;
	int SHOOTER_ENCODER_PORT_2 = 1;
	
	int LIFTER_TALON_PORT = 7;
	int LIFTER_LIMIT_TOP_PORT = 8;
	int LIFTER_LIMIT_BOTTOM_PORT = 11;

	int CLIMBER_TALON_1_PORT = 1;
	int CLIMBER_TALON_2_PORT = 0;
	
	int SERVO_PORT = 9; 
	
	int LIMIT_SWITCH_PORT = 6;
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
	
	
	double turnR = 1;
	double turnL = -1;
	int framethres = 10;
	int framesizeX = 250;
	int framesizeY = 250;
	double AREA_TO_DISTANCE = 30/600; //TODO distance/area 			Eric: Area to distance isn't a linear relationship, just fyi
	double HEIGHT_TO_DISTANCE = 30/600; //TODO distance/height
	
	boolean CAN_SHOOT = false;
	
	int CLIMBER_UP_POSITION = 500; 	//TODO
	int CLIMBER_DOWN_POSITION = 0;	//TODO
	int CLIMBER_FORWARD_LIMIT = 700; 	//TODO
	int CLIMBER_REVERSE_LIMIT = 0; 	//TODO
	int CLIMBER_DIFFERENCE_VALUE = 20; 	//TODO
	
	double kP = 0.03;
    double kI = 0.00;
    double kD = 0.00;
    double kF = 0.00;
    
    double kToleranceDegrees = 2.0f;
	
	
	//controls

	int FORWARD_DRIVE_AXIS = 1;	
	int TURN_DRIVE_AXIS = 4; 	
	int GYRO_RESET_BUTTON = 1;
	
	int SERVO_AXIS = 5;	//triggers
	
	int INTAKE_IN_BUTTON = 1;	//a
	int INTAKE_OUT_BUTTON = 2;	//b
	int INTAKE_STOP_BUTTON = 7;	//back
	
	int SHOOTER_BUTTON = 3;
	
	int CLIMBER_UP_BUTTON = 5;
	int CLIMBER_DOWN_BUTTON = 6;
	
	int PORT_AXIS = 1;
	
	int SERVO_PRESET_BUTTON = 2;
}
