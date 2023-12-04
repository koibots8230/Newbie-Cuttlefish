package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.IntakeMove;
import frc.robot.subsystems.IntakePosition;

public class RobotContainer {
    private final CommandXboxController controller =
        new CommandXboxController(0);

    public RobotContainer() {
        configureBindings();
    }

    private void configureBindings() {
        CommandPS4Controller operatorController = new CommandPS4Controller(0);

        IntakePosition.get().setDefaultCommand(
            new IntakeMove(
                controller::getLeftY
            )
        );
    }
}
