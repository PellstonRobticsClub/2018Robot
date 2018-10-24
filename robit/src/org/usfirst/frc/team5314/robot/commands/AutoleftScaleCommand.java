package org.usfirst.frc.team5314.robot.commands;

import org.usfirst.frc.team5314.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoleftScaleCommand extends CommandGroup {
	

    public AutoleftScaleCommand() {
    	
    	addSequential(new closeJawCommand(),.1);
    	addParallel(new liftUpCommand(),2.3);
    	addSequential(new driveToXDistanceCommand(20,1));   
    	addSequential(new rotateToAngleCommmand(30));
    	addSequential(new liftStopCommand(),.1);    
    	addSequential(new driveToXDistanceCommand(2.3,.7));
    	addSequential(new autointakecontroll(-.25),2);
    	addSequential(new autointakecontroll(0),.1);
    	addSequential(new driveToXDistanceCommand(-2,.7));
       	addParallel(new liftDownCommand(),2.3);
       	addSequential(new rotateToAngleCommmand(150));
       	addSequential(new liftStopCommand(),.1);
    //  addsequential(new openJawCommand(),.1 	
    // addparallel(new driveToXDistanceCommand(1,.7)):
    //  addSequential(new autointakecontroll(.5),4);
    //	addSequential(new autointakecontroll(0),.1);
    //  addsequential(new closeJawCommand(),.1); 	
    //  addsequential(new driveToXDistance(-1,.7)); 
    //  addparallel(new rotateToAngleCommand(30));
    //  addsequential(new liftUpCommand(),2.6);
    //  addsequential(new driveToXDistanceCommand(2.3,.7)); 	
    //  addSequential(new autointakecontroll(-.25),2);
    //	addSequential(new autointakecontroll(0),.1); 	
    //  addsequential(new driveToXDistanceCommand(-2.3,.7));	
    //  addParallel(new liftDownCommand(),2.3); 
    //  addSequential(new rotateToAngleCommmand(130)); 	
    	
       	
       	
       	//String gamedata;
    	//addSequential(new openJawCommand());	
        //gamedata=DriverStation.getInstance().getGameSpecificMessage();
    	//SmartDashboard.putString("test", gamedata);
    	//if(gamedata.length()>0) {
    	//	SmartDashboard.putBoolean("test", (gamedata.charAt(0)=='L'));
    	//addSequential(new liftUpCommand(),2);
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
