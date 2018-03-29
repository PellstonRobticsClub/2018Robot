package org.usfirst.frc.team5314.robot.subsystems;

import org.usfirst.frc.team5314.robot.Robot;
import org.usfirst.frc.team5314.robot.RobotMap;
import org.usfirst.frc.team5314.robot.commands.driveWithJoystick;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrianSubsystem extends Subsystem {
	private AnalogInput DistanceSenor=new AnalogInput(0);
	private WPI_TalonSRX rightFrontMotor=new WPI_TalonSRX(RobotMap.rightFrontMotor);
	private WPI_TalonSRX leftFrontMotor=new WPI_TalonSRX(RobotMap.leftFrontMotor);
	private WPI_TalonSRX rightRearMotor=new WPI_TalonSRX(RobotMap.rightRearMotor);
	private WPI_TalonSRX leftRearMotor=new WPI_TalonSRX(RobotMap.leftRearMotor);
	private MecanumDrive MecDrive=new MecanumDrive(leftFrontMotor, leftRearMotor, rightFrontMotor, rightRearMotor);
	
	public void drive(double x ,double y , double z, double gyroAngle) {
		//MecDrive.driveCartesian(x, y, z);
		MecDrive.driveCartesian(x, y, z, gyroAngle);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
    public void initDefaultCommand() {
    	setDefaultCommand(new driveWithJoystick());
     
    }
    public void stop() {
    	MecDrive.stopMotor();
    }
    public void periodic() {
    	double inches=DistanceSenor.getVoltage()/.0093532;
    	SmartDashboard.putNumber("angle", Robot.ahrs.getAngle());
    	SmartDashboard.putNumber("distance",inches);
    	SmartDashboard.putNumber("Right Encoder", rightRearMotor.getSensorCollection().getQuadraturePosition());
    	SmartDashboard.putNumber("left Encoder", leftRearMotor.getSensorCollection().getQuadraturePosition());
    }
    public void resetEnc(){
    	rightRearMotor.getSensorCollection().setQuadraturePosition(0, 10);
    	leftRearMotor.getSensorCollection().setQuadraturePosition(0, 10);
    	
    }
}

   // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());