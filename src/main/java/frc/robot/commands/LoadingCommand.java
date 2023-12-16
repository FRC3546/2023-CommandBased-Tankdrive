package frc.robot.commands;

import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LauncherSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class LoadingCommand extends CommandBase{
    
    private boolean isStopsUp;
    private double conveyorSpeed;
    private LauncherSubsystem launcherSubsystem;
    
    public LoadingCommand(double speed, LauncherSubsystem subsystem){

        conveyorSpeed = speed;
        launcherSubsystem = subsystem;

        addRequirements(launcherSubsystem);

    }

    @Override
    public void initialize() {

        launcherSubsystem.extendStop();
        launcherSubsystem.runConveyor();
        
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
