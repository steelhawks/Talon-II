/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
 
/**
 *
 * @author developer
 */
public class AutoFrontRight extends CommandGroup {
    
    public AutoFrontRight() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
        System.out.println("AutoFrontRight");
        //Drive to goal, drive back and prepare for teleoperated mode
        addSequential(new StopDriving(7.75));  // added this line for quarterfinal matches
        addSequential(new DriveStraight(1.75));
        addSequential(new StopDriving(0.5));
        addSequential(new ExtendSlider(2.0));
        addSequential(new RetractSlider(0.5));
        
        addSequential(new DriveBack(0.2));
        addSequential(new StopDriving(0.5));
        addSequential(new TurnBothRight(0.65)); //make sure to change to compensate for battery level
        addSequential(new StopDriving(0.5));
        addSequential(new DriveStraight(1.5));
        
        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
