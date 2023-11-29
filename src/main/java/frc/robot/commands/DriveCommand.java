package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj.Joystick;

public class DriveCommand extends CommandBase{
    
    private DrivetrainSubsystem drivetrainSubsystem;
    private Joystick lefJoystick;
    private Joystick righJoystick;

    public DriveCommand(DrivetrainSubsystem drivetrainSubsystem, Joystick leftJoystick, Joystick rightJoystick){
        
        this.drivetrainSubsystem = drivetrainSubsystem;
        this.lefJoystick = leftJoystick;
        this.righJoystick = rightJoystick;

        addRequirements(drivetrainSubsystem);

    }

    @Override
    public void initialize() {}

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {

        drivetrainSubsystem.tankDrive(lefJoystick.getY(), righJoystick.getY());

    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
