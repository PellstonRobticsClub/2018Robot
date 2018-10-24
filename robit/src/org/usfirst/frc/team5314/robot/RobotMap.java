/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5314.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
//can ports 

	public static int leftRearMotor=1;
	public static int rightFrontMotor=2;
	public static int rightRearMotor=3;
	public static int leftFrontMotor=4;
    public static int liftMotor1=6;
    public static int liftMotor2=5;
		public static int liftMotor3=7;
	//usb
	public static int drivestick=0;
//pwm
	public static int intakeMotor1=0;

	public static int intakeMotor2=1;
	
	public static int intakeMotor3=2;
	
	public static int intakeMotor4=3;
	
	public static int liftmotor=2;
	public static int Blinkin=9;
//digital input
	public static int downSwitch=0;
	public static int upSwitch=1;

	

}
		// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;