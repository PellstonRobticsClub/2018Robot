package org.usfirst.frc.team5314.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.ConditionalCommand;

public class AutoRightTestCommand extends ConditionalCommand {
	
	public AutoRightTestCommand() {
		super(new AutoLeft2ScaleCommand(),new AutoRightSwitchCommand());
	}

	@Override
	protected boolean condition() {
		// TODO Auto-generated method stub
		return DriverStation.getInstance().getGameSpecificMessage().charAt(0)=='L';
	}

}
