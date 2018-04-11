package org.usfirst.frc.team5314.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDriveFowardCommand extends CommandGroup {

    public AutoDriveFowardCommand() {
    	addSequential(new closeJawCommand(),.1);
    	addParallel(new liftUpCommand(),1);
    	addSequential(new driveToXDistanceCommand(19,1));
    	addSequential(new liftStopCommand(),.1);
    	addSequential(new rotateToAngleCommmand(90));
    	addSequential(new driveToXDistanceCommand(17,.7));
    	addParallel(new liftUpCommand(),2.5);
    	addSequential(new rotateToAngleCommmand(-30));
    	addSequential(new driveToXDistanceCommand(2.3, .7));
    	addSequential(new autointakecontroll(-.5),1);
    	addSequential(new autointakecontroll(0),.1);
    	addSequential(new driveToXDistanceCommand(-2.3,.7));
       	addParallel(new liftDownCommand(),3);
       	addSequential(new rotateToAngleCommmand(180));
       	addSequential(new liftStopCommand(),.1);  
    	
    	// Add Commands here:
    	  	
    //	addSequential(new DriveSetSpeedCommand(.5 , 0 , 0 , 1.0));
    //	addSequential(new driveStopCommand(),2);
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
