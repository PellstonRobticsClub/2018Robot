package org.usfirst.frc.team5314.robot.commands;

import org.usfirst.frc.team5314.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class autoCenterSwitchLeftCommand extends CommandGroup {

    public autoCenterSwitchLeftCommand() {
    	
    	addSequential(new closeJawCommand(),.1);
    	addSequential(new liftUpCommand(),1);
    	addSequential(new liftStopCommand(),.1);

        addSequential(new rotateToAngleCommmand(-30));
    	//addSequential(new DriveSetSpeedCommand(.0 , .0 , -.4 , .5));
        addSequential(new DriveSetSpeedCommand(.5 , .0 , 0 , 1.2));
    	addSequential(new driveStopCommand(),2);
    	addSequential(new rotateToAngleCommmand(0));
    	addSequential(new DriveSetSpeedCommand(.3, 0, 0, .5));
    	addSequential(new autointakecontroll(-5),1);
		addSequential(new autointakecontroll(0),.2);
		addSequential(new driveToXDistanceCommand(-1, .7));
		addParallel(new  rotateToAngleCommmand(90));
		addSequential(new liftDownCommand(),1);
    		//addSequential(new openJawCommand(),.1);
    	    	//String gamedata;
    	//gamedata=DriverStation.getInstance().getGameSpecificMessage();
    	//SmartDashboard.putString("test", gamedata);
    	//if(gamedata.length()>0) {
   
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
