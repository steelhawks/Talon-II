/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.ResetClimber;

/**
 *
 * @author priscilla
 */
public class Climber extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    Solenoid leftHookSolenoids[] = new Solenoid[2];
   // Solenoid rightHookSolenoids[] = new Solenoid[2];
    
    
    public void Climber() {
      leftHookSolenoids[0] = new Solenoid (RobotMap.SOLENOID_CRIO_SLOT, RobotMap.LEFT_HOOK_SOLENOID_EXTEND);
      leftHookSolenoids[1] = new Solenoid (RobotMap.SOLENOID_CRIO_SLOT, RobotMap.LEFT_HOOK_SOLENOID_RETRACT);
   //     rightHookSolenoids[0] = new Solenoid (RobotMap.SOLENOID_CRIO_SLOT, RobotMap.RIGHT_HOOK_SOLENOID_EXTEND);
   //     rightHookSolenoids[1] = new Solenoid (RobotMap.SOLENOID_CRIO_SLOT, RobotMap.RIGHT_HOOK_SOLENOID_RETRACT);

    }    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new ResetClimber());
    }
    public void reset() {
        //System.out.println("Reset");
        if (leftHookSolenoids[0] == null) {
            //System.out.println("reconstruct solenoids");
            leftHookSolenoids[0] = new Solenoid (RobotMap.SOLENOID_CRIO_SLOT, RobotMap.LEFT_HOOK_SOLENOID_EXTEND);
            leftHookSolenoids[1] = new Solenoid (RobotMap.SOLENOID_CRIO_SLOT, RobotMap.LEFT_HOOK_SOLENOID_RETRACT);
        }
//        if (leftHookSolenoids[0] != null) { 
          leftHookSolenoids[0].set(false);
          leftHookSolenoids[1].set(true);
//        rightHookSolenoids[0].set(false);
//        rightHookSolenoids[1].set(true);
       //System.out.println("Reset if");
  //      }
                 System.out.println("Resetting climber, going down.");
    }
    public void pullup() {
        System.out.println("Pull up");
       // if (leftHookSolenoids[0] != null){
        leftHookSolenoids[0].set(true);
        leftHookSolenoids[1].set(false);
       // System.out.println("Pull Up if");
  //      rightHookSolenoids[0].set(true);
  //      rightHookSolenoids[1].set(false);
        //}
                //System.out.println("Climbing up");
    }
}
