
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.templates.commands.CameraReset;
import edu.wpi.first.wpilibj.templates.commands.ClimbUp;
import edu.wpi.first.wpilibj.templates.commands.DriveAsClimber;
import edu.wpi.first.wpilibj.templates.commands.DriveStraightTeleop;
import edu.wpi.first.wpilibj.templates.commands.DriveToGoal;
import edu.wpi.first.wpilibj.templates.commands.DriveWithJoystick;
import edu.wpi.first.wpilibj.templates.commands.ResetClimber;
import edu.wpi.first.wpilibj.templates.commands.ExtendSlider;
import edu.wpi.first.wpilibj.templates.commands.MoveCamLeft;
import edu.wpi.first.wpilibj.templates.commands.MoveCamRight;
import edu.wpi.first.wpilibj.templates.commands.RetractSlider;
import edu.wpi.first.wpilibj.templates.commands.SetFastSpeed;
import edu.wpi.first.wpilibj.templates.commands.SetSlowSpeed;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public static final int LEFT_JOYSTICK_PORT = 1;
    public static final int RIGHT_JOYSTICK_PORT = 2;
    private Joystick leftStick;
    private Joystick rightStick;
    private JoystickButton climbButton; //climb on pyramid with R stick, 4
    private JoystickButton resetButton; //return from pyramid with R stick, 5
    private JoystickButton sliderButton; //open dumper with R stick, 3
    private JoystickButton sliderUpButton; //close dumper with R stick, 2
    private JoystickButton camLeftButton; //turn camera left with L stick, 4
    private JoystickButton camRightButton; //turn camera right with L stick, 5
    private JoystickButton camResetButton; //reset camera with L stick, 3
    private JoystickButton changeSpeedButton; //drive fast/slow with L stick, 1
    private JoystickButton driveStraightButton; //drive straight ahead with R stick, 1
    private JoystickButton driveAsDumperButton; //drive with dumper as forward with L stick, 3
    private JoystickButton driveAsClimberButton; //drive with climber as forward with L stick, 2
    
    public OI() {
        leftStick = new Joystick(LEFT_JOYSTICK_PORT);
        rightStick = new Joystick(RIGHT_JOYSTICK_PORT);

        // RIGHT JOYSTICK
        //pneumatics/solenoids buttons; 
        // use 4 and 5 on the right joystick for climber
        climbButton = new JoystickButton(leftStick, 4);
        climbButton.whenPressed(new ClimbUp());
    
        resetButton = new JoystickButton(leftStick, 5);
        resetButton.whenPressed(new ResetClimber());

        // use 2 and 3 on right joystick for slider
        sliderButton = new JoystickButton(leftStick, 3);
        sliderButton.whenPressed(new ExtendSlider(1.5));
        //sliderButton.whenReleased(new RetractSlider());

        sliderUpButton = new JoystickButton(leftStick, 2);
        sliderUpButton.whenPressed(new RetractSlider(0.5));
        
        //driveStraightButton = new JoystickButton(rightStick, 1);
        //driveStraightButton.whileHeld(new DriveStraightTeleop());

        // LEFT JOYSTICK
        //changeSpeedButton = new JoystickButton(leftStick, 1);
        //changeSpeedButton.whileHeld(new SetSlowSpeed());
        //changeSpeedButton.whenReleased(new SetFastSpeed());
        
        camLeftButton = new JoystickButton(rightStick, 5);
        camLeftButton.whileHeld(new MoveCamLeft());
       
        camRightButton = new JoystickButton(rightStick, 4);
        camRightButton.whileHeld(new MoveCamRight());
        
        camResetButton = new JoystickButton(rightStick, 10);
        camResetButton.whenPressed(new CameraReset());       
       
        driveAsDumperButton = new JoystickButton(rightStick, 3);
        driveAsDumperButton.whenPressed(new DriveWithJoystick());
        
        driveAsClimberButton = new JoystickButton(rightStick, 2);
        driveAsClimberButton.whenPressed(new DriveAsClimber());
        
    }
        
        public Joystick getLeftJoystick() {
            return leftStick;
        }
        public Joystick getRightJoystick() {
            return rightStick;
        }
    
    
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

