package frc.robot;

import frc.robot.commands.MidtakeRun;
import frc.robot.commands.MidtakeRunReverse;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {

  public RobotContainer() {
    configureBindings();
  }

  private CommandXboxController driverController = new CommandXboxController(0);

  private void configureBindings() {
    Trigger shooter = driverController.leftTrigger();
    Trigger intake = driverController.rightTrigger();
    Trigger intakeReverse = driverController.rightBumper();
    shooter.whileTrue(new MidtakeRun());
    intake.whileTrue(new MidtakeRun());
    intakeReverse.whileTrue(new MidtakeRunReverse());
  }
}
