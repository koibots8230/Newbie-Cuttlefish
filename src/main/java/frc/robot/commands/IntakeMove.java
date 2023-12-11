package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
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
    public void end(boolean interrupted) {
        IntakePosition.get().setIntakePositionMotor(0);
    }

    // Returns true when the command should end.

    private double current;
    private double encoderPosition;

    @Override
    public boolean isFinished() {

        current = IntakePosition.get().getMotorCurrent();
        encoderPosition = IntakePosition.get().getEncoderPosition();
        
        // Stop if the encoder is too far
        if (Math.abs(encoderPosition) > Constants.INTAKE_POSITION_ENCODER_LIMIT) {
            return true;
        }

        // Stop if the current is too high :)
        if (Math.abs(current) >= Constants.INTAKE_POSITION_CURRENT_CAP) {
            return true;
        }

        return false;
    }

}
