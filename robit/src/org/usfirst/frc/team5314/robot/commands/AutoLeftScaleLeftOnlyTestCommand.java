
package org.usfirst.frc.team5314.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.ConditionalCommand;

public class AutoLeftScaleLeftOnlyTestCommand extends ConditionalCommand {
	
	public AutoLeftScaleLeftOnlyTestCommand() {
		super(new AutoleftScaleCommand(),new Autodrivefoward());
	}

	@Override
	protected boolean condition() {
		// TODO Auto-generated method stub
		return DriverStation.getInstance().getGameSpecificMessage().charAt(1)=='L';
	}




}
