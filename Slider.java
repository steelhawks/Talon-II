/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

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
        setDefaultCommand(new RetractSlider());
    }
    public void retract() {
        if (sliderSolenoids[0] == null) {
            sliderSolenoids[0] = new Solenoid (RobotMap.SOLENOID_CRIO_SLOT, RobotMap.SLIDER_SOLENOID_RETRACT);
            sliderSolenoids[1] = new Solenoid (RobotMap.SOLENOID_CRIO_SLOT, RobotMap.SLIDER_SOLENOID_EXTEND);
        }
        sliderSolenoids[0].set(false);
        sliderSolenoids[1].set(true);
        
    }
    public void extend() {
      sliderSolenoids[0].set(true);
      sliderSolenoids[1].set(false);
    }

}
