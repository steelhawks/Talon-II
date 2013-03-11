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
public class AutoBackRight extends CommandGroup {
    
    public AutoBackRight() {
/*        System.out.println("AutoBackRight");
        //Drive to goal, drive back and prepare for teleoperated mode
        //addSequential(new DriveStraight(1.0));
        addSequential(new DriveStraight(0.1));
        addSequential(new StopDriving(0.5));
        addSequential(new ExtendSlider(2.75));
        addSequential(new RetractSlider(1.0));
        addSequential(new DriveBack(0.8));
        addSequential(new TurnBothRight(0.6)); //make sure to change to compensate for battery level
        addSequential(new DriveStraight(0.6));
        * */
        addSequential(new StopDriving(7.75));  //added this line for quarterfinal matches
        addSequential(new DriveStraight(3.0));
                
        addSequential(new StopDriving(0.5));
     //   addSequential(new TurnRight(0.75));
     //   addSequential(new StopDriving(0.5));
     //   addSequential(new DriveStraight(0.5));
     //   addSequential(new StopDriving(0.5));

        addSequential(new ExtendSlider(2.75));
        addSequential(new RetractSlider(1.0));
        addSequential(new DriveBack(0.2));
        addSequential(new StopDriving(0.5));
        addSequential(new TurnBothRight(0.65)); //make sure to change to compensate for battery level
        addSequential(new DriveStraight(1.5));
        
    }
    
}
