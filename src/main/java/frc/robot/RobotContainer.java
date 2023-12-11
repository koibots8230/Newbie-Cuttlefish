package frc.robot;

import frc.robot.Constants;
import frc.robot.commands.MidtakeRun;
import frc.robot.subsystems.Midtake;
import edu.wpi.first.wpilibj.drive.RobotDriveBase.MotorType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {
  private CommandXboxController driverController = new CommandXboxController(0);

  private void configureBindings() {
    Trigger driverLeftTrigger = driverController.leftTrigger();
    Trigger driverRightTrigger = driverController.rightTrigger();

    driverLeftTrigger.whileTrue(new MidtakeRun());
    driverRightTrigger.whileTrue(new MidtakeRun());
  }
}
