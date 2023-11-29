package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;

public class DriveXTimeCommand extends CommandBase{
    
    private DrivetrainSubsystem drivetrainSubsystem;
    private double driveTime;
    private double speed;
    private Timer timer = new Timer();

    public DriveXTimeCommand(DrivetrainSubsystem drivetrainSubsystem, double driveTime, double speed){
        
        this.drivetrainSubsystem = drivetrainSubsystem;
        this.driveTime = driveTime;
        this.speed = speed;

        addRequirements(drivetrainSubsystem);

    }

    @Override
    public void initialize() {

        timer.start();

    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {

        drivetrainSubsystem.tankDrive(speed, speed);

    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        timer.stop();
        timer.reset();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return timer.get() >= driveTime;
    }
}
