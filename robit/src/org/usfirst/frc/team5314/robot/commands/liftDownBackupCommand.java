package org.usfirst.frc.team5314.robot.commands;

import org.usfirst.frc.team5314.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class liftDownBackupCommand extends Command {

    public liftDownBackupCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires (Robot.kLiftSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.kLiftSubsystem.downBackup();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (!Robot.kLiftSubsystem.isDownSwitchSet());
        
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.kLiftSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
