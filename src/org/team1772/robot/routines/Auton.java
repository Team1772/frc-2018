package org.team1772.robot.routines;

import java.util.ArrayList;

import org.team1772.robot.autons.*;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public enum Auton {
	INSTANCE;

	private Command autonomousCommand;
	private ArrayList<Command> autons;
	
	public void init() {
		// INSERT HERE YOUR AUTONOMOUS 
		autons = new ArrayList<>();

		/*autons.add();//              0 GEAR NO CENTRO BOMBANDO
		autons.add(new LeftSideGearNavx());//        1
		autons.add(new RightSideGearNavx());//       2
		autons.add(new FirstHopperToBoiler());//     3
		autons.add(new TwoGearsCenter(-120, 117));// 4 gear a esquerda
		autons.add(new TwoGearsCenter(120, -102));// 5 gear a direita
		autons.add(new Test());//                    6
		autons.add(new Stop());//*/                    

        SmartDashboard.putNumber("Auto mode", SmartDashboard.getNumber("Auto mode", 0));
	}
	
	// Methods to manage the status
    public void start() {
    	autonomousCommand = getAutonSelected();
    	if (autonomousCommand != null) {
    		System.out.println("AUTONOMOUS START :" + autonomousCommand.getName());
    		SmartDashboard.putString("Autonomos selected:", autonomousCommand.getName());
    		autonomousCommand.start();
    	}
    }
    public void periodic() {
    	Scheduler.getInstance().run();
    }
    public void cancel() {
    	if (autonomousCommand != null) {
    		System.out.println("AUTONOMOUS END :" + autonomousCommand.getName());
    		SmartDashboard.putString("Autonomos selected:", autonomousCommand.getName());
    		autonomousCommand.cancel();
    	}
    }
	private Command getAutonSelected() {
		int number = (int)SmartDashboard.getNumber("Auto mode", 0);
        return autons.size() > number ? autons.get(number) : autons.get(0);
	}
}