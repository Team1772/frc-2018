package org.team1772.Core.superclasses;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.team1772.Core.superclasses.SimpleCommand;

public class JoystickManager {
	private ArrayList<Button> buttonActions;
	private Map<Integer, Joystick> joys;

	public JoystickManager() {
		buttonActions = new ArrayList<>();
		joys = new HashMap<>();
	}

	public void whenPressed (int usb, int buttonId, IStep step) {
		Button x = new JoystickButton(getUsbJoystick(usb), buttonId);
		x.whenPressed(SimpleCommand.toCommand(step));
		buttonActions.add(x);
	}

	public void whenReleased (int usb, int buttonId, IStep step) {
		Button x = new JoystickButton(getUsbJoystick(usb), buttonId);
		x.whenReleased(SimpleCommand.toCommand(step));
		buttonActions.add(x);
	}

	public void cancelWhenPressed (int usb, int buttonId, IStep step) {
		Button x = new JoystickButton(getUsbJoystick(usb), buttonId);
		x.cancelWhenPressed(SimpleCommand.toCommand(step));
		buttonActions.add(x);
	}

	public void toggleWhenPressed (int usb, int buttonId, IStep step) {
		Button x = new JoystickButton(getUsbJoystick(usb), buttonId);
		x.toggleWhenPressed(SimpleCommand.toCommand(step));
		buttonActions.add(x);
	}

	private Joystick getUsbJoystick(int usb) {
		if (!joys.containsKey(usb))
			joys.put(usb, new Joystick(usb));
		return joys.get(usb);
	}
}