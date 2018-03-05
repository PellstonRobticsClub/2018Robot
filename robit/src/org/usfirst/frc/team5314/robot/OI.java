/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5314.robot;

import org.usfirst.frc.team5314.robot.commands.closeJawCommand;
import org.usfirst.frc.team5314.robot.commands.liftDownCommand;
import org.usfirst.frc.team5314.robot.commands.liftUpCommand;
import org.usfirst.frc.team5314.robot.commands.openJawCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	Joystick drivestick=new Joystick(RobotMap.drivestick);
	JoystickButton buttonX=new JoystickButton(drivestick, 3);
	JoystickButton buttonY=new JoystickButton(drivestick, 4);
	JoystickButton buttonA=new JoystickButton(drivestick, 1);
	JoystickButton buttonB=new JoystickButton(drivestick, 2);
	public double getDriveX() {
		return drivestick.getX();
		
	}
	public double getDrivey() {
		return -drivestick.getY();
		
	}
	public double getDrivez() {
		return drivestick.getRawAxis(4);
		
		
	}
	public double getintake() {
	return drivestick.getRawAxis(2)-drivestick.getRawAxis(3);	
	}
	public OI() {
		buttonX.whenPressed(new closeJawCommand());
		buttonY.whenPressed(new openJawCommand());
		buttonA.whileHeld(new liftDownCommand());
		buttonB.whileHeld(new liftUpCommand());
	}
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
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

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
