/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

/**
 *
 * @author priscilla
 */
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.*;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Chassis extends Subsystem {
	RobotDrive drive;
	Jaguar leftJaguar;
        Jaguar rightJaguar;
	Jaguar leftJaguar2;
        Jaguar rightJaguar2;
        int NUMERICAL_DIRECTION = 1;
        double MAXIMUM_INCREMENT = 0.01;
        double ABS_MAX_SPEED = 1.0;
        double LEFT_MAX_SPEED = 0.95;
        double RIGHT_MAX_SPEED = 1.0;
        double MEAN_ESTIMATED_SPEED = 0.0;
        double AUTO_SPEED = 0.75;
        double currentLeftVal = 0.0;
        double currentRightVal = 0.0;
        double LEFT_ADJ = -1;
        
        public static final double FULL_SPEED = 1.0;
        public static final double SLOW_SPEED = 0.5;
        
	protected void initDefaultCommand() {
		setDefaultCommand(new DriveWithJoystick());   // set default command
	}
	public Chassis() {
                leftJaguar = new Jaguar(RobotMap.frontLeftMotorSlot, RobotMap.frontLeftMotorChannel);
                rightJaguar = new Jaguar(RobotMap.frontRightMotorSlot, RobotMap.frontRightMotorChannel);
                leftJaguar2 = new Jaguar(RobotMap.rearLeftMotorSlot, RobotMap.rearLeftMotorChannel);
                rightJaguar2 = new Jaguar(RobotMap.rearRightMotorSlot, RobotMap.rearRightMotorChannel);

                //  drive = new RobotDrive (leftJaguar, rightJaguar);
                
		drive = new RobotDrive (leftJaguar, leftJaguar2, rightJaguar, rightJaguar2);
		// change constructor if we have more motors on drivetrain - i.e. 4 motors total
		drive.setSafetyEnabled(false);
	}

	public void straight() {   // sets the motor speeds to drive straight (no turn)
		//drive.arcadeDrive(1.0, 0.0);
                drive.tankDrive(-1.0 * LEFT_ADJ * AUTO_SPEED, AUTO_SPEED);
                //System.out.println("go straight");
        }
	public void reverse() {   // sets the motor speeds to drive in reverse (no turn)
		drive.tankDrive(LEFT_ADJ * AUTO_SPEED, -1.0 * AUTO_SPEED);
//                System.out.println("reverse");
	}
	public void turnLeft() {    // sets the motor speeds to start a left turn
		drive.tankDrive(0.0, AUTO_SPEED);
  //              System.out.println("turn left");
	}
	public void turnRight() {    // sets the motor speeds to start a right turn
		drive.tankDrive(AUTO_SPEED, 0.0);
//                System.out.println("turn right");
	}
        public void turnBothRight(){
                drive.tankDrive(AUTO_SPEED, -1.0*AUTO_SPEED);
  //              System.out.println("turn both wheels right");
        }
        public void stop() {
            drive.tankDrive(0.0, 0.0);
        }

        public void setMaxSpeed() {
             ABS_MAX_SPEED = FULL_SPEED;
             System.out.println("set full speed");
        }
        public void setSlowSpeed() {
            ABS_MAX_SPEED = SLOW_SPEED;
            System.out.println("Set slow speed");
        }
        
        //driveWithJoystick = drive with dumper facing forwards, appropriate controls
	public void driveWithJoystick(Joystick leftStick, Joystick rightStick) {
    
            if(rightStick.getRawButton(1)){
                LEFT_MAX_SPEED = 0.5;
                RIGHT_MAX_SPEED = 0.5;
            }

            SmartDashboard.putNumber("Speed setting (trigger): ", ABS_MAX_SPEED);

            double leftVal = getLeftMotor(leftStick);
            double rightVal = getRightMotor(rightStick)*-1;
            
            drive.tankDrive(rightVal,leftVal); //drive reversed for dumper forwards
            SmartDashboard.putNumber("Left Jaguar:" , leftJaguar.getSpeed());
            SmartDashboard.putNumber("Right Jaguar:", rightJaguar.getSpeed()*-1.0);
            //SmartDashboard.putNumber("Left Jaguar2:" , leftJaguar2.getSpeed());
            //SmartDashboard.putNumber("Right Jaguar2:", rightJaguar2.getSpeed()*-1.0);
            SmartDashboard.putString("Direction Status: ", "Dumper Forwards");
        }
        
        public void driveAsClimber(Joystick leftStick, Joystick rightStick){
              
            if(rightStick.getRawButton(1)){
                LEFT_MAX_SPEED = 0.5;
                RIGHT_MAX_SPEED = 0.5;
            }

            SmartDashboard.putNumber("Speed setting (trigger): ", ABS_MAX_SPEED);
            
            double leftVal = (getLeftMotor(leftStick)*-1);
            double rightVal = getRightMotor(rightStick);
            
            drive.tankDrive(leftVal,rightVal);
            SmartDashboard.putNumber("Left Jaguar:" , leftJaguar.getSpeed()*-1.0);
            SmartDashboard.putNumber("Right Jaguar:", rightJaguar.getSpeed());
            //SmartDashboard.putNumber("Left Jaguar2:" , leftJaguar2.getSpeed()*-1.0);
            //SmartDashboard.putNumber("Right Jaguar2:", rightJaguar2.getSpeed());
            SmartDashboard.putString("Direction Status: ", "Climber Forwards");
            
        }
        private double getLeftMotor(Joystick joy) {
            return joy.getY() * ABS_MAX_SPEED * -1.0;
        }
        private double getRightMotor (Joystick joy) {
            return joy.getY() * ABS_MAX_SPEED;
        }
  /*      private double normalizeSpeed(double val) {
            if (val > ABS_MAX_SPEED) {
                return ABS_MAX_SPEED;
            }
            if (val < -1.0 * ABS_MAX_SPEED) {
                return -1.0 * ABS_MAX_SPEED;
            }
            if (val < 0.006 && val > 0.0) {
                return 0.0;
            }
            System.out.println("normalize: " + val);
            return val;
        }*/
}
