package org.usfirst.frc.team5314.robot.subsystems;

import org.usfirst.frc.team5314.robot.RobotMap;
import org.usfirst.frc.team5314.robot.commands.liftStopCommand;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class liftsubsystem extends Subsystem {
	private WPI_TalonSRX liftMotor1=new WPI_TalonSRX(RobotMap.liftMotor1);
	private WPI_TalonSRX liftMotor2=new WPI_TalonSRX(RobotMap.liftMotor2);
	private WPI_TalonSRX liftMotor3=new WPI_TalonSRX(RobotMap.liftMotor3);
	
	private DigitalInput downLimitSwitch=new DigitalInput(RobotMap.downSwitch);
	private DigitalInput upLimitSwitch=new DigitalInput(RobotMap.upSwitch);
	
	public void up() {
		if (upLimitSwitch.get()) {
		liftMotor1.set(-0.60);
		liftMotor2.set(-0.60);
		
		}else {
			liftMotor1.set(0);
			liftMotor2.set(0);
		}
			liftMotor3.set(-01.0);
	}
public void down() {
	if (downLimitSwitch.get()) {
		liftMotor1.set(0.60);
		liftMotor2.set(0.60);
		
	}else {
		liftMotor1.set(0);
		liftMotor2.set(0);
		
	}

		liftMotor3.set(01.0);
}
public void downBackup() {
	if (downLimitSwitch.get() && liftMotor3.getSensorCollection().isFwdLimitSwitchClosed()) {
		liftMotor1.set(0.60);
		liftMotor2.set(0.60);
		
	}else {
		liftMotor1.set(0);
		liftMotor2.set(0);
		
	}

		liftMotor3.set(01.0);
}
public void stop() {
	liftMotor1.set(0);
	liftMotor2.set(0);
	liftMotor3.set(0);
}
public Boolean isDownSwitchSet() {
	if(liftMotor3.getSensorCollection().isFwdLimitSwitchClosed()) {
		return downLimitSwitch.get();
	} else {
		return true;
	}
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
    public void periodic() {
    	SmartDashboard.putBoolean("upper switch", liftMotor3.getSensorCollection().isFwdLimitSwitchClosed());
    	SmartDashboard.putBoolean("lower switch", liftMotor3.getSensorCollection().isRevLimitSwitchClosed());
    	SmartDashboard.putNumber("lift speed", liftMotor3.getMotorOutputPercent());
    }
    
}

