/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Developer
 */
public class DriveBack extends CommandBase {
    
    private double jaguarTimeout;
    
    public DriveBack(double timeout) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        jaguarTimeout = timeout;
        requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(jaguarTimeout);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        chassis.reverse();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
