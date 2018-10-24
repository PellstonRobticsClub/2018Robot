package org.usfirst.frc.team5314.robot.commands;

import org.usfirst.frc.team5314.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class driveToXDistanceCommand extends PIDCommand {

	private double distance;
	private double angle;
	
    public driveToXDistanceCommand(double feet,double Maxspeed) {
     super("driveToXDistanceCommand", .0002, 0, .002, .02);
     angle = Robot.ahrs.getAngle();
     getPIDController().setAbsoluteTolerance(500);
     getPIDController().setOutputRange(-Maxspeed, Maxspeed);
     distance=feet*2329;
 
     requires(Robot.kDriveTrianSubsystem);
     Robot.kDriveTrianSubsystem.resetEncoder();
     
     
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
    @Override
    protected double returnPIDInput() {
    	return Robot.kDriveTrianSubsystem.getEncoder();
    	
    	
    }
    
    @Override
    protected void usePIDOutput(double output) {
    	int sign =(int)Math.signum(output);
    	double minSpeed=.3;
    	double finaloutput=sign*Math.max(minSpeed, Math.abs(output));
    	double error = Robot.ahrs.getAngle()-angle;
    	error*= .1;
    	
    	Robot.kDriveTrianSubsystem.drive(0, finaloutput, 0, 0);
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.setTimeout(5);
    	
        SmartDashboard.putNumber("target", distance);
    	Robot.kDriveTrianSubsystem.resetEncoder();
    	getPIDController().setSetpoint(distance);
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("setpoint", getPIDController().getSetpoint());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut()||getPIDController().onTarget();
        
        
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.kDriveTrianSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
