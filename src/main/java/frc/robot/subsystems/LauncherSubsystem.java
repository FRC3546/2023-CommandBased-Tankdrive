package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class LauncherSubsystem extends SubsystemBase{

    private DoubleSolenoid stopSolenoid;
    private VictorSP conveyorMotor;
    private VictorSP shooterMotor;
        
    
    public LauncherSubsystem(){
    conveyorMotor = new VictorSP(7);
    stopSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 3, 4);
    shooterMotor = new VictorSP(4);
    }

    public void retractStop(){
        stopSolenoid.set(Value.kReverse);
    }

    public void extendStop(){
        stopSolenoid.set(Value.kForward);
    }

    public void runConveyor(){
        conveyorMotor.set(0.5);
    }
    
    public void stopConveyor(){
        conveyorMotor.set(0);
    }


    public void shooterMotorOff(){
        shooterMotor.set(0);
    }

    public void shooteMotorHalf(){
        shooterMotor.set(0.5);
    }
    
    public void shooterMotorFull(){
        shooterMotor.set(1);
    }

    public void shooterMotorSpeed(double speed){
        shooterMotor.set(speed);
    }
}
