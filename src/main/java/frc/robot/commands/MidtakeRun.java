package frc.robot.commands;

import edu.wpi.first.math.filter.LinearFilter;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Midtake;

public class MidtakeRun extends CommandBase {
    boolean end = false;
    LinearFilter voltageFilter;

    public MidtakeRun() {
        voltageFilter = LinearFilter.movingAverage(5);
        addRequirements(Midtake.get());
    }

    @Override
    public void initialize() {
        Midtake.get().runMidtakeMotor();
    }

    @Override
    public void execute() {
        if (voltageFilter.calculate(Math.abs(Midtake.get().getMidtakeMotorCurrent())) > Constants.MIDTAKE_CURRENT_LIMIT) {
            end = true;
        }
    }

    @Override
    public boolean isFinished() {
        return end;
    }

    @Override
    public void end(boolean interrupted) {
        Midtake.get().stopMidtakeMotor();
    }
}
