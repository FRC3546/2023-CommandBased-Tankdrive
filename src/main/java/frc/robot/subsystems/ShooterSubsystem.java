package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class ShooterSubsystem extends SubsystemBase{
    private DoubleSolenoid stopSolenoid;
    private VictorSP conveyorMotor;
    private VictorSP shooterMotor;
}

public ShooterSubsystem(){

        conveyorMotor = new VictorSP();
        shooterMotor = new VictorSP();
        stopSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 3, 4);
        
    }
public void extendStops(){

        stopSolenoid.set(Value.kForward);

    }
    
