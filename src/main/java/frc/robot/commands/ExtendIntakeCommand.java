package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class ExtendIntakeCommand extends CommandBase {

    private IntakeSubsystem intakeSubsystem;
    

    public ExtendIntakeCommand(IntakeSubsystem intakeSubsystem){

        this.intakeSubsystem = intakeSubsystem;

        addRequirements(intakeSubsystem);


    }

    @Override
    public void initialize() {

        intakeSubsystem.extendIntake();
        intakeSubsystem.extendIntakeMotor();
        
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {


    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
 
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
