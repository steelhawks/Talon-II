package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
 	// for Chassis Subsystem
        // In a 4-slot cRIO, slot = 1. in an 8-slot cRIO, the first 4 modules are in slot 1 
        // and the 2nd 4 modules are in slot 2 (channels 1 - 4)
        // Channels refer to the channel #s on the digital sidecar for the connected 
        // controllers
	public static final int frontLeftMotorSlot = 1;
	public static final int frontLeftMotorChannel = 1;
	public static final int frontRightMotorSlot = 1;
	public static final int frontRightMotorChannel = 4;
        
	//to be used if have 4 motors in the drivetrain
	public static final int rearLeftMotorSlot = 1;
	public static final int rearLeftMotorChannel = 2;
	public static final int rearRightMotorSlot = 1;
	public static final int rearRightMotorChannel = 3;
            
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    
    public static final int SOLENOID_CRIO_SLOT = 1;
    // solenoids
    public static final int LEFT_HOOK_SOLENOID_EXTEND = 5;
    public static final int LEFT_HOOK_SOLENOID_RETRACT = 6;
  //  public static final int RIGHT_HOOK_SOLENOID_EXTEND = 9;
   // public static final int RIGHT_HOOK_SOLENOID_RETRACT = 8;
    public static final int SLIDER_SOLENOID_RETRACT = 1;
    public static final int SLIDER_SOLENOID_EXTEND = 2;
    
    // compressor
    public static final int PRESSURE_SWITCH_SLOT = 1;
    public static final int PRESSURE_SWITCH_CHANNEL = 2;
    public static final int COMPRESSOR_RELAY_SLOT = 1;
    public static final int COMPRESSOR_RELAY_CHANNEL = 1;
    
    //servo
    public static final int PAN_SERVO_SLOT = 1;
    public static final int PAN_SERVO_CHANNEL = 7;
}
