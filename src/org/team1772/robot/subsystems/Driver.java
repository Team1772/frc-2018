package org.team1772.robot.subsystems;

import org.team1772.Core.components.GearBox;
import org.team1772.Core.components.SmartNavx;
import org.team1772.Core.util.SimpleDashboard;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Driver extends Subsystem {
	// Components teste
	private GearBox leftGearBox, rightGearBox;
	private SmartNavx navx;

    public Driver () {
    	leftGearBox  = new GearBox(new VictorSP(SimpleDashboard.getInstance().getDeviceID("DRIVER_MOTOR_LEFT_1", 0)), new VictorSP(SimpleDashboard.getInstance().getDeviceID("DRIVER_MOTOR_LEFT_2", 1)), new Encoder(2, 3), 0.02662830636845544737048296408458);
    	rightGearBox = new GearBox(new VictorSP(SimpleDashboard.getInstance().getDev iceID("DRIVER_MOTOR_RIGHT_1", 2)), new VictorSP(SimpleDashboard.getInstance().getDeviceID("DRIVER_MOTOR_RIGHT_2", 3)), new Encoder(0, 1), true, true, 0.0265748358737396733797791830322);
		navx         = new SmartNavx();

		rightGearBox.setEncoderInverted(true);
    }
    
    public double getLeftPulses() {
    	return leftGearBox.getPulses();
    }
    
    public double getRightPulses() {
    	return rightGearBox.getPulses();
    }
    
    public double getLeftDistance() {
    	return leftGearBox.getDistance();
    }

    public double getRightDistance() {
    	return rightGearBox.getDistance();
    }

    public double getAngle() {
    	return navx.getAngle();
    }
    
    public boolean reset() {
    	rightGearBox.reset();
    	leftGearBox.reset();
    	navx.reset();
    	return true;
    }
    
    public boolean setSpeed(double left, double right) {
    	leftGearBox.setSpeed(-left);
		rightGearBox.setSpeed(-right);
		
		return true;
    }

	double minR = 0.4D, difR = 0.5D;
	public void arcadeDrive(double sp, double rotation) {
		double mod = minR + difR * Math.pow(1 - Math.abs(sp), 2);
		double r = Math.pow(rotation, 3) * mod;
		leftGearBox.setSpeed((sp - r) * 0.6);
		rightGearBox.setSpeed((sp + r) * 0.7);
	}
	
	@Override
	protected void initDefaultCommand() {}
}
