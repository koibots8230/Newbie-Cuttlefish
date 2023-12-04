package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakePosition;

public class IntakeMove extends CommandBase {

    private DoubleSupplier speed;

    public IntakeMove(DoubleSupplier speed) {
        this.speed = speed;
        
        addRequirements(IntakePosition.get());
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        IntakePosition.get().setIntakePositionMotor(
            speed.getAsDouble()
        );
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
