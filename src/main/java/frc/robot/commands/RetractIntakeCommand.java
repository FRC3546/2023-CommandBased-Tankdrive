package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj.Timer;

public class RetractIntakeCommand extends CommandBase{

    private IntakeSubsystem intakeSubsystem;
    private Timer timer = new Timer();
    private double stopTime = 3;
    
    public RetractIntakeCommand(IntakeSubsystem intakeSubsystem){

        this.intakeSubsystem = intakeSubsystem;

        addRequirements(intakeSubsystem);

    }

    @Override
    public void initialize() {

        intakeSubsystem.retractIntakeMotor();
        intakeSubsystem.retractIntake(); 
        timer.start();
        
        
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {

       

    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {

        intakeSubsystem.turnOffIntakeMotor();

        timer.stop();
        timer.reset();

    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return timer.get() >= stopTime;
    }
}
