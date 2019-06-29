package org.team1772.robot.subsystems;

import org.team1772.Core.util.SimpleDashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SensorBase;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Elevator extends Subsystem {
	private TalonSRX motorRight;
	private TalonSRX motorLeft;
	// private DigitalInput limitUp, limitDown;	
	public Elevator() {
		motorRight = new TalonSRX(SimpleDashboard.getInstance().getDeviceID("MOTOR_ELEVATOR_RIGHT", 3));
		motorLeft = new TalonSRX(SimpleDashboard.getInstance().getDeviceID("MOTOR_ELEVATOR_LEFT", 0));
		//limitUp   = new DigitalInput(SimpleDashboard.getInstance().getDeviceID("SENSOR_ELEVATOR_UP"));
		//limitDown = new DigitalInput(SimpleDashboard.getInstance().getDeviceID("SENSOR_ELEVATOR_DOWN"));
	}
	public void upDownElevator(double speed) {
		/*if(limitUp.get() && speed < 0) {
			motorRight.set(ControlMode.PercentOutput, speed);
			motorLeft.set(ControlMode.PercentOutput, speed);
		}
		else if(limitDown.get() && speed > 0) {
			motorRight.set(ControlMode.PercentOutput, speed);
			motorLeft.set(ControlMode.PercentOutput, speed);	
		}
		else {
			motorRight.set(ControlMode.PercentOutput, 0);
			motorLeft.set(ControlMode.PercentOutput, 0);
		}*/
		motorRight.set(ControlMode.PercentOutput, speed);
		motorLeft.set(ControlMode.PercentOutput, speed);
	}
		@Override
	protected void initDefaultCommand() {

	}

}
