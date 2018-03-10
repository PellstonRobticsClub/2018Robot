package org.usfirst.frc.team5314.robot.subsystems;

import org.usfirst.frc.team5314.robot.RobotMap;
import org.usfirst.frc.team5314.robot.commands.intakeWithJoystick;


import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSubsystem extends Subsystem {
	private SpeedController intakeMotor1=new Talon(RobotMap.intakeMotor1);
	private SpeedController intakeMotor2=new Talon(RobotMap.intakeMotor2);
	private SpeedController intakeMotor3=new Talon(RobotMap.intakeMotor3);
	private SpeedController intakeMotor4=new Talon(RobotMap.intakeMotor4);
	

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new intakeWithJoystick());
    	
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void rotate (double speed) {
    	intakeMotor1.set(speed);
    	intakeMotor2.set(-speed);
    	
    }
    
}

