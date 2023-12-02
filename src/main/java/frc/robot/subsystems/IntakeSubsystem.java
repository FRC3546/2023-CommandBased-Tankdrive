package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class IntakeSubsystem extends SubsystemBase{

    private VictorSP intakeMotor;

    private DoubleSolenoid intakeSolenoid;


    public IntakeSubsystem(){

        intakeMotor = new VictorSP(6);
        intakeSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 3, 4);
        
    }

    public void retractIntake(){

        intakeSolenoid.set(Value.kReverse);

    }

    public void extendIntake(){

        intakeSolenoid.set(Value.kForward);

    }

    public void extendIntakeMotor(){
        
        intakeMotor.set(0.5);

    }

    public void retractIntakeMotor(){
        
        intakeMotor.set(-0.5);

    }

    public void turnOffIntakeMotor(){

        intakeMotor.set(0);

    }
    
}
