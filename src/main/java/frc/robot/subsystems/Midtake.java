package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Midtake extends SubsystemBase {
    private static Midtake m_Midtake = new Midtake();

    private CANSparkMax midtakeMotor;

    
    private Midtake() {
        midtakeMotor = new CANSparkMax(Constants.MIDTAKE_MOTOR, MotorType.kBrushless);
    }

    public void runMidtakeMotor() {
        midtakeMotor.set(0.75);
    }

    public void stopMidtakeMotor() {
        midtakeMotor.set(0);
    }

    public double getMidtakeMotorCurrent() {
        return midtakeMotor.getOutputCurrent();
    }

    public static Midtake get() {
        return m_Midtake;
    }
}