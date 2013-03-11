package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.RetractSlider;
/**
 *
 * @author Developer
 */
public class Slider extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Solenoid sliderSolenoids[] = new Solenoid[2];

    public void Slider() {
      sliderSolenoids[0] = new Solenoid (RobotMap.SOLENOID_CRIO_SLOT, RobotMap.SLIDER_SOLENOID_RETRACT);
      sliderSolenoids[1] = new Solenoid (RobotMap.SOLENOID_CRIO_SLOT, RobotMap.SLIDER_SOLENOID_EXTEND);
    }    

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new RetractSlider(0.5));
    }
    public void retract() {
        if (sliderSolenoids[0] == null) {
            sliderSolenoids[0] = new Solenoid (RobotMap.SOLENOID_CRIO_SLOT, RobotMap.SLIDER_SOLENOID_RETRACT);
            sliderSolenoids[1] = new Solenoid (RobotMap.SOLENOID_CRIO_SLOT, RobotMap.SLIDER_SOLENOID_EXTEND);
        }
        
        sliderSolenoids[0].set(false);
        sliderSolenoids[1].set(true);
        //System.out.println("Retracting slider");
    }
    
    public void extend() {
        if (sliderSolenoids[0] == null) {
            sliderSolenoids[0] = new Solenoid (RobotMap.SOLENOID_CRIO_SLOT, RobotMap.SLIDER_SOLENOID_RETRACT);
            sliderSolenoids[1] = new Solenoid (RobotMap.SOLENOID_CRIO_SLOT, RobotMap.SLIDER_SOLENOID_EXTEND);
        }
      sliderSolenoids[0].set(true);
      sliderSolenoids[1].set(false);
      //System.out.println("Extending slider");
    }
    
    public boolean isExtended(){
      //Timer.delay(1.5); //wait for piston to extend
      return sliderSolenoids[0].get();
    }
    
    public boolean isRetracted(){
      //Timer.delay(1.5); //wait for piston to retract
      return sliderSolenoids[1].get();
    }

}
