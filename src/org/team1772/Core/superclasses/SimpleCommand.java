package org.team1772.Core.superclasses;

import edu.wpi.first.wpilibj.command.Command;

public class SimpleCommand {
	public static Command toCommand(int stepNumber, IStep step) {
		return new Command() {
			@Override
			protected boolean isFinished() {
				return step.run();
			}
			
			@Override
			protected void execute() {
			}
			
			@Override
			protected void interrupted() {
				System.out.println(stepNumber + " Interrupted");
			}
			
			@Override
			protected void initialize() {
				System.out.println(stepNumber + " Initialize");
			}
			
			@Override
			protected void end() {
				System.out.println(stepNumber + " End");
			}
		};
	}
	public static Command toCommand(IStep step) {
		return toCommand(0, step);
	}
}
