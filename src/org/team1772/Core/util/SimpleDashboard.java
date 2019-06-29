package org.team1772.Core.util;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SimpleDashboard {
	public int getDeviceID(String name, double defaultValue) {
		SmartDashboard.putNumber(name, SmartDashboard.getNumber(name, defaultValue));
		return (int) SmartDashboard.getNumber(name, defaultValue);
	}
	public double getNumber(String name) {
		SmartDashboard.putNumber(name, SmartDashboard.getNumber(name, 0.5)); 
		return SmartDashboard.getNumber(name, 0.5);
	}
	
	private static SimpleDashboard instance;
	public static SimpleDashboard getInstance() {
		if (instance == null)
			instance = new SimpleDashboard();
		
		return instance;
	}
}
