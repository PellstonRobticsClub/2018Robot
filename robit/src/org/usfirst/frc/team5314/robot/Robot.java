/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5314.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer.StaticInterface;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.logging.Logger;

import org.usfirst.frc.team5314.robot.commands.AutoCenterSwitchTestCommand;
import org.usfirst.frc.team5314.robot.commands.AutoDriveFowardCommand;
import org.usfirst.frc.team5314.robot.commands.AutoLeftTestCommand;
import org.usfirst.frc.team5314.robot.commands.AutoRightSwitchCommand;
import org.usfirst.frc.team5314.robot.commands.AutoRightTestCommand;
import org.usfirst.frc.team5314.robot.commands.AutoleftSwitchCommand;
import org.usfirst.frc.team5314.robot.commands.autoDoNothing;
import org.usfirst.frc.team5314.robot.commands.autoCenterSwitchLeftCommand;
import org.usfirst.frc.team5314.robot.subsystems.DriveTrianSubsystem;
import org.usfirst.frc.team5314.robot.subsystems.IntakeSubsystem;
import org.usfirst.frc.team5314.robot.subsystems.JawSubsystem;
import org.usfirst.frc.team5314.robot.subsystems.LEDSubsystem;
import org.usfirst.frc.team5314.robot.subsystems.liftsubsystem;

import com.kauailabs.navx.frc.AHRS;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {

	public static final liftsubsystem kLiftSubsystem=new liftsubsystem();
	public static final DriveTrianSubsystem kDriveTrianSubsystem=new DriveTrianSubsystem();
	public static final IntakeSubsystem kIntakeSubsystem=new IntakeSubsystem();
	public static final JawSubsystem kjawSubsystem = new JawSubsystem();
	public static final LEDSubsystem kLEDSubsystem = new LEDSubsystem();
	public static OI m_oi;
	public static Compressor c=new Compressor(0);
	private static PowerDistributionPanel PDP=new PowerDistributionPanel(0);
	public static AHRS ahrs =new AHRS(SPI.Port.kMXP);
	public static final int IMG_WIDTH =320;
	public static final int IMG_HEIGHT =240;
	private static Boolean fmsSwitchOnLeft=true;
	private static Boolean fmsMessageRecieved =false;
	//public static String Data="";

	
	
	
	

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();
		m_chooser.addObject("driveForward", new AutoDriveFowardCommand() );
		 m_chooser.addDefault("Do Nothing", new autoDoNothing() );
		 m_chooser.addObject("right switch", new  AutoRightTestCommand());
		 m_chooser.addObject("center switch", new  AutoCenterSwitchTestCommand());
		 m_chooser.addObject("left switch", new  AutoLeftTestCommand());
		 
		 
		SmartDashboard.putData("Auto", m_chooser);
		
		UsbCamera camera1=CameraServer.getInstance().startAutomaticCapture();
		camera1.setResolution(IMG_WIDTH, IMG_HEIGHT);
		UsbCamera camera2=CameraServer.getInstance().startAutomaticCapture();
		camera2.setResolution(IMG_WIDTH, IMG_HEIGHT);
		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		//Data=DriverStation.getInstance().getGameSpecificMessage();
		
			
		
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		String msg=null;
		while(msg ==null||msg.length()<2) {
			msg=DriverStation.getInstance().getGameSpecificMessage();
		}
		if (msg.length()>0){
			fmsMessageRecieved=true;
		}
		fmsSwitchOnLeft= msg.substring(0,1).equals("L");
		SmartDashboard.putBoolean("fms msg recieved", fmsMessageRecieved);
		SmartDashboard.putBoolean("fms Switch on Left", fmsSwitchOnLeft);
		
		//Logger.info("FMS auto message: "+msg);
		
		m_autonomousCommand = m_chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
		kDriveTrianSubsystem.resetEnc();
		
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		updateStatus();
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
		
	}
	
	public void updateStatus() {
		SmartDashboard.putNumber("amps 8", PDP.getCurrent(8));
		SmartDashboard.putNumber("amps 9", PDP.getCurrent(9));
		SmartDashboard.putNumber("amps 10", PDP.getCurrent(10));
		SmartDashboard.putNumber("amps 11", PDP.getCurrent(11));
	}
	public static boolean scaleOnLeft() {
		return fmsSwitchOnLeft;
	}

}