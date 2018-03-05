package org.usfirst.frc.team5314.robot.subsystems;

import org.usfirst.frc.team5314.robot.RobotMap;
import org.usfirst.frc.team5314.robot.commands.liftStopCommand;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class liftsubsystem extends Subsystem {
	private Talon liftmotor=new Talon(RobotMap.liftmotor);
	private DigitalInput downLimitSwitch=new DigitalInput(RobotMap.downSwitch);
	private DigitalInput upLimitSwitch=new DigitalInput(RobotMap.upSwitch);
	
	public void up() {
		if (upLimitSwitch.get()) {
		liftmotor.set(01.0);	
		}else {
			liftmotor.set(0);	
		}
	}
public void down() {
	if (downLimitSwitch.get()) {
		liftmotor.set(-0.3);
	}else {
		liftmotor.set(0);
	}
}
public void stop() {
	liftmotor.set(0);
}
public Boolean isDownSwitchSet() {
	return downLimitSwitch.get();
}
public Boolean isupSwitchSet() {
	return upLimitSwitch.get(); 
		
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new liftStopCommand());
    }
    
}

