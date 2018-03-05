package org.usfirst.frc.team5314.robot.subsystems;

import org.usfirst.frc.team5314.robot.RobotMap;
import org.usfirst.frc.team5314.robot.commands.driveWithJoystick;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 *
 */
public class DriveTrianSubsystem extends Subsystem {
	private WPI_TalonSRX rightFrontMotor=new WPI_TalonSRX(RobotMap.rightFrontMotor);
	private WPI_TalonSRX leftFrontMotor=new WPI_TalonSRX(RobotMap.leftFrontMotor);
	private WPI_TalonSRX rightRearMotor=new WPI_TalonSRX(RobotMap.rightRearMotor);
	private WPI_TalonSRX leftRearMotor=new WPI_TalonSRX(RobotMap.leftRearMotor);
	private MecanumDrive MecDrive=new MecanumDrive(leftFrontMotor, leftRearMotor, rightFrontMotor, rightRearMotor);
	
	public void drive(double x ,double y , double z) {
		MecDrive.driveCartesian(x, y, z);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
    public void initDefaultCommand() {
    	setDefaultCommand(new driveWithJoystick());
     
    }
    public void stop() {
    	MecDrive.stopMotor();
    }
}

   // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());