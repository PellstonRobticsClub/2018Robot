
package org.usfirst.frc.team5314.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.ConditionalCommand;

public class AutoRightScaleRightOnlyTestCommand extends ConditionalCommand {
	
	public AutoRightScaleRightOnlyTestCommand() {
		super(new AutoRightScaleRightOnlyCommand(),new Autodrivefoward());
	}

	@Override
	protected boolean condition() {
		// TODO Auto-generated method stub
		return DriverStation.getInstance().getGameSpecificMessage().charAt(1)=='R';
	}




}
