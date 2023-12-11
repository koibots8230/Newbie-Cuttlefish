package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class IntakePosition extends SubsystemBase {

    private static IntakePosition intakeUpDown = new IntakePosition();

    public static IntakePosition get() {
        return intakeUpDown;
    }

    public final CANSparkMax intakePositionMotor;
    public final RelativeEncoder intakePositionEncoder;
    
    private IntakePosition() {
        intakePositionMotor = new CANSparkMax(
            Constants.INTAKE_POSITION_MOTOR_PORT,
            MotorType.kBrushless
        );

        intakePositionMotor.setIdleMode(IdleMode.kBrake);

        intakePositionEncoder = intakePositionMotor.getEncoder();
        intakePositionEncoder.setPosition(0);
    }

    @Override
    public void periodic() {

    }

    public void setIntakePositionMotor(double speed) {
        intakePositionMotor.set(
            checkDeadzone(speed) * Constants.INTAKE_POSITION_MAX_SPEED
        );
    }

    public double checkDeadzone(double number) {
        return 
            Math.abs(number) < Constants.INTAKE_POSITION_JOYSTICK_DEADZONE 
            ? 0.0 : number;
    }

    public double getMotorCurrent() {
        return intakePositionMotor.getOutputCurrent();
    }

    public double getEncoderPosition() {
        return intakePositionEncoder.getPosition();
    }
    
}

