/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Developer
 */
public class CameraMovement extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

        public Servo pan = new Servo(RobotMap.PAN_SERVO_SLOT,RobotMap.PAN_SERVO_CHANNEL);
        public double panPos;
        
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void reset(){
        pan.setAngle(0);
        SmartDashboard.putNumber("CAMERA:", pan.get());
    }
    
    public void manualMoveLeft(){
        panPos = pan.getAngle();
        //Timer.delay(0.5);
        pan.setAngle(panPos-15);
        //Timer.delay(0.5);
        SmartDashboard.putNumber("CAMERA:", pan.getAngle()*-1.0);
    }   
    
    public void manualMoveRight(){
        panPos = pan.getAngle();
        //Timer.delay(0.5);
        pan.setAngle(panPos+15);
        //Timer.delay(0.5);
        SmartDashboard.putNumber("CAMERA:", pan.getAngle()*-1.0);
    }
  
}
