package org.team1772.robot.autons.commands;

import org.team1772.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveForwardToPoint extends Command {
	
	private double leftSpeed, rightSpeed, targetInches;

	public DriveForwardToPoint(double left, double right, double inches) {
		leftSpeed    = left;
		rightSpeed   = right;
		targetInches = Math.abs(inches);
	}

	@Override
	protected boolean isFinished() {
		Robot.driver.setSpeed(leftSpeed, rightSpeed);
		return isTimedOut() || (targetInches > 0 && Math.abs(Robot.driver.getRightDistance()) > targetInches);
	}

}
