package org.team1772.robot.routines;

import org.team1772.Core.util.XboxControl;
import org.team1772.robot.Robot;

public enum Teleop {
	INSTANCE;

	private XboxControl pilot;
	private XboxControl coPilot;
	
    public void init() {
    	pilot = new XboxControl(0);
    	coPilot = new XboxControl(1);
    }

    public void periodic() {
    
    	Robot.driver.arcadeDrive(pilot.getAxisLeftY(),pilot.getAxisRightX());
    	if (pilot.getButtonB())
    		Robot.driver.reset();
    	
    	if(coPilot.getButtonL1()) {
    		Robot.intakeBox.pullBox();
    	} else if (coPilot.getButtonR1()) {
    		Robot.intakeBox.pushBox();
    	} else {
    		Robot.intakeBox.stopBox();
    	}
    	Robot.elevator.upDownElevator(coPilot.getAxisLeftY());
    	
    }
}
