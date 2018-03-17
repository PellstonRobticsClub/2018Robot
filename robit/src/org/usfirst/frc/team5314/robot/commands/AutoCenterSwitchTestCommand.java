package org.usfirst.frc.team5314.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.ConditionalCommand;

public class AutoCenterSwitchTestCommand extends ConditionalCommand {
	
	public AutoCenterSwitchTestCommand() {
		super(new autoCenterSwitchLeftCommand(),new autoCenterSwitchRightCommand());
	}

	@Override
	protected boolean condition() {
		// TODO Auto-generated method stub
		return DriverStation.getInstance().getGameSpecificMessage().charAt(0)=='L';
	}

}
