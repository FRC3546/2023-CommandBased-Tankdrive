package frc.robot.commandgroups;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveXTimeCommand;

public class ForwardBackForward extends SequentialCommandGroup{
    public ForwardBackForward(){
        addCommands(
                new DriveXTimeCommand(null, 2, 0.5),
                new DriveXTimeCommand(null, 2, -0.5),
                new DriveXTimeCommand(null, 2, 0.5),
                new DriveXTimeCommand(null, 2, -0.5)

        );
    }
}

