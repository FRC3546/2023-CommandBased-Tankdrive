
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;


public class DrivetrainSubsystem extends SubsystemBase{
    
    private VictorSP leftMotor;
    private VictorSP rightMotor;

    public DrivetrainSubsystem(){

        leftMotor = new VictorSP(0);
        rightMotor = new VictorSP(2);

        leftMotor.setInverted(true);

    }

    public void tankDrive(double leftSpeed, double rightSpeed){

        leftMotor.set(leftSpeed);
        rightMotor.set(rightSpeed);

    }


}
