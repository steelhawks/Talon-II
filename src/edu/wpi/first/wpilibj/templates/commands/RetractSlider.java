/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Developer
 */
public class RetractSlider extends CommandBase {
    
    public RetractSlider(double timeout) {
        // Use requires() here to declare subsystem dependencies
        requires(slider);
        setTimeout(timeout);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//        System.out.println("Retract Init");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        slider.retract();
        System.out.println("Retract exec");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
//        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
