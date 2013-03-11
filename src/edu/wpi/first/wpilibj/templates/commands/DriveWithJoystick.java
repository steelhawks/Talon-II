/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author priscilla
 */
public class DriveWithJoystick extends CommandBase {
	public DriveWithJoystick() {
        requires(chassis);  // reserve the chassis subsystem
    }

    public DriveWithJoystick(Joystick leftStick, Joystick rightStick) {
    }
	
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	protected void execute() {
		chassis.driveWithJoystick(oi.getLeftJoystick(), oi.getRightJoystick());
	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	protected void end() {
		// TODO Auto-generated method stub

	}

	protected void interrupted() {
		// TODO Auto-generated method stub

	}    
}
