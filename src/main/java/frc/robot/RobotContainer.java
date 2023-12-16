// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

// This is a github test

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commandgroups.ForwardBackForward;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.DriveXTimeCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.DriveXTimeCommand;
import frc.robot.commands.ExtendIntakeCommand;
import frc.robot.commands.LoadingCommand;
import frc.robot.commands.RetractIntakeCommand;
import frc.robot.subsystems.LauncherSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private SendableChooser<Command> autonSelector = new SendableChooser<>();


  private final DrivetrainSubsystem drivetrainSubsystem = new DrivetrainSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final LauncherSubsystem launcherSubsystem = new LauncherSubsystem();

  private final Joystick leftJoystick = new Joystick(1);
  private final Joystick rightJoystick = new Joystick(0);

  // Replace with CommandPS4Controller or CommandJoystick if needed
  // private final CommandXboxController m_driverController =
  //     new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings

    autonSelector.addOption("drive for 5 seconds", new DriveXTimeCommand(drivetrainSubsystem, 5, 0.5));
    autonSelector.addOption("drive for 2 seconds", new DriveXTimeCommand(drivetrainSubsystem, 2, 0.5));
    autonSelector.addOption("drive forward and bakkwards", new ForwardBackForward(drivetrainSubsystem));


    configureBindings();
    drivetrainSubsystem.setDefaultCommand(new DriveCommand(drivetrainSubsystem, leftJoystick, rightJoystick));

    SmartDashboard.putData("Auton Selector", autonSelector);
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {

    new JoystickButton(rightJoystick, 1)
      .onTrue(new ExtendIntakeCommand(intakeSubsystem))
      .onFalse(new RetractIntakeCommand(intakeSubsystem));

    new JoystickButton(leftJoystick, 1)
      .onTrue(new LoadingCommand(0.5, launcherSubsystem));
    
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    // new Trigger(m_exampleSubsystem::exampleCondition)
    //     .onTrue(new ExampleCommand(m_exampleSubsystem));

    // // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // // cancelling on release.
    // m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return autonSelector.getSelected();
  }
}
