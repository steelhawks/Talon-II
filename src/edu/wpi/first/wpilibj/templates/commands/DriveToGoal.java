/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Developer
 */
public class DriveToGoal extends CommandGroup {
    
    public DriveToGoal() {
        addSequential(new DriveStraight(3.25));
        Timer.delay(0.5);
        
        addSequential(new StopDriving(0.5));
     //   addSequential(new TurnRight(0.75));
     //   addSequential(new StopDriving(0.5));
     //   addSequential(new DriveStraight(0.5));
     //   addSequential(new StopDriving(0.5));

        addSequential(new ExtendSlider(2.75));
        addSequential(new RetractSlider(1.0));
        addSequential(new DriveBack(1.15));
        addSequential(new StopDriving(0.5));
        addSequential(new TurnBothRight(0.70)); //make sure to change to compensate for battery level
        addSequential(new DriveStraight(2.75));
    }
    
}
