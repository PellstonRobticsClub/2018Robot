
package org.usfirst.frc.team5314.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.ConditionalCommand;

public class AutoRightScaleTestCommand extends ConditionalCommand {
	
	public AutoRightScaleTestCommand() {
		super(new AutoRightScaleCommand(),new AutoDriveFowardCommand());
	}

	@Override
	protected boolean condition() {
		// TODO Auto-generated method stub
		return DriverStation.getInstance().getGameSpecificMessage().charAt(1)=='R';
	}




}
