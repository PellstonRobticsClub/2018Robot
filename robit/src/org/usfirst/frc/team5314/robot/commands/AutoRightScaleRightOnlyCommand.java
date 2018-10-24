package org.usfirst.frc.team5314.robot.commands;

import org.usfirst.frc.team5314.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoRightScaleRightOnlyCommand extends CommandGroup {
	

    public AutoRightScaleRightOnlyCommand() {
    	
    	addSequential(new closeJawCommand(),.1);
    	addParallel(new liftUpCommand(),2.3);
    	addSequential(new driveToXDistanceCommand(25,1));   
    	addSequential(new rotateToAngleCommmand(-90));
    	//addSequential(new liftStopCommand(),.1);    
    	//addSequential(new driveToXDistanceCommand(2.3,.7));
    	addSequential(new autointakecontroll(-.5),1);
    	addSequential(new autointakecontroll(0),.1);
    	//addSequential(new driveToXDistanceCommand(-2,.7));
    	addSequential(new rotateToAngleCommmand(-180));
       	addSequential(new liftDownCommand(),2.3);
       	addSequential(new liftStopCommand(),.1);
       	

    	
    	//String gamedata;
    	//addSequential(new openJawCommand());	
        //gamedata=DriverStation.getInstance().getGameSpecificMessage();
    	//SmartDashboard.putString("test", gamedata);
    	//if(gamedata.length()>0) {
    	//	SmartDashboard.putBoolean("test", (gamedata.charAt(0)=='L'));
    	
    	//}
    	
    	
    	// Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
