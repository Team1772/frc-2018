package org.team1772.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climb extends Subsystem {
	private Talon m1, m2;
	
	public Climb() {
		m1 = new Talon(6);
		m2 = new Talon(7);
		m2.setInverted(true);
	}
	
	public void setSpeed(double sp) {
		m1.set(sp);
		m2.set(sp);
	}

	@Override
	protected void initDefaultCommand() {
	}
}
