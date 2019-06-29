package org.team1772.robot.subsystems;

import org.team1772.Core.util.SimpleDashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class IntakeBox extends Subsystem {
	TalonSRX motorLeft, motorRight;
	public IntakeBox() {
		motorLeft = new TalonSRX(SimpleDashboard.getInstance().getDeviceID("INTAKE_MOTOR_LEFT", 2));
		motorRight = new TalonSRX(SimpleDashboard.getInstance().getDeviceID("INTAKE_MOTOR_RIGHT", 1));
	}
	
	public void pullBox() {
		motorLeft.set(ControlMode.PercentOutput, SimpleDashboard.getInstance().getNumber("INTAKE_SPEED"));
		motorRight.set(ControlMode.PercentOutput, SimpleDashboard.getInstance().getNumber("INTAKE_SPEED"));
	}
	public void pushBox() {
		motorLeft.set(ControlMode.PercentOutput, SimpleDashboard.getInstance().getNumber("INTAKE_SPEED") * -1);
		motorRight.set(ControlMode.PercentOutput, SimpleDashboard.getInstance().getNumber("INTAKE_SPEED") * -1);
	}
	public void stopBox() {
		motorLeft.set(ControlMode.PercentOutput, 0);
		motorRight.set(ControlMode.PercentOutput, 0);
	}
	@Override
	protected void initDefaultCommand() {
	}

}
