package org.usfirst.frc.team5314.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class JawSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	DoubleSolenoid jaw = new DoubleSolenoid(0, 1);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void open() {
    	jaw.set(Value.kForward);
    }
    public void close() {
    	jaw.set(Value.kReverse);
    }
}

