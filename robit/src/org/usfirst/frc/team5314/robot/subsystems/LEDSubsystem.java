package org.usfirst.frc.team5314.robot.subsystems;

import org.usfirst.frc.team5314.robot.Robot;
import org.usfirst.frc.team5314.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LEDSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Spark blinkin = new Spark(RobotMap.Blinkin);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void periodic() {
    	DriverStation.Alliance color;
		color = DriverStation.getInstance().getAlliance();
    	if (!Robot.kLiftSubsystem.isupSwitchSet()){
    		blinkin.set(0.77 );
    	}else if(!Robot.kLiftSubsystem.isDownSwitchSet()) {
    		blinkin.set(0.65 );
    	} else if(color == DriverStation.Alliance.Blue){ 
    		blinkin.set(-0.29 );
    	}else if(color == DriverStation.Alliance.Red) {
    		blinkin.set(-0.31  );
    	} else {
    		blinkin.set(-0.55);
    	}
    	
    }
}

