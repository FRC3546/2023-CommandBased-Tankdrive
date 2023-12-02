package frc.robot.commandgroups;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveXTimeCommand;
import frc.robot.subsystems.DrivetrainSubsystem;

public class ForwardBackForward extends SequentialCommandGroup{
    public ForwardBackForward(DrivetrainSubsystem drivetrainSubsystem){
        addCommands(
                new DriveXTimeCommand(drivetrainSubsystem, 2, 0.5),
                new DriveXTimeCommand(drivetrainSubsystem, 2, -0.5),
                new DriveXTimeCommand(drivetrainSubsystem, 2, 0.5),
                new DriveXTimeCommand(drivetrainSubsystem, 2, -0.5)

        );
    }
}

