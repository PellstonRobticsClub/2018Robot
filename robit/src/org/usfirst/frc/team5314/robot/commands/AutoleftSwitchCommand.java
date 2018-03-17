package org.usfirst.frc.team5314.robot.commands;

import org.usfirst.frc.team5314.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoleftSwitchCommand extends CommandGroup {
	

    public AutoleftSwitchCommand() {
    	
    	addSequential(new closeJawCommand(),.1);
    	addSequential(new liftUpCommand(),1);
    	addSequential(new liftStopCommand(),.1);
    	addSequential(new DriveSetSpeedCommand(.5 , 0 , 0 , 1.0));
    	addSequential(new driveStopCommand(),2);
    	//String gamedata;
    	//gamedata=DriverStation.getInstance().getGameSpecificMessage();
    	//SmartDashboard.putString("test", gamedata);
    	//if(gamedata.length()>0) {
    	//	SmartDashboard.putBoolean("test", (gamedata.charAt(0)=='L'));
    	
    	addSequential(new autointakecontroll(-5),1);
    	addSequential(new autointakecontroll(0),.2);
        		//addSequential(new openJawCommand());	
        
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
