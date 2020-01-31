/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

/*****
 * IDK WHAT IM DOING DONT LOOK TOO HARD AT IT YET
 * IM TRYING MY BEST
 * NONE OF THIS MAKES SENSE RN
 */

public class ExampleSubsystem extends SubsystemBase {

  private int m_leftDeviceID = 1; //placeholder constant
  private int m_leftDevicesID = 2; //placeholder constant
  private int m_rightDeviceID = 3; //placeholder constant
  private int m_rightDevicesID = 4; //placeholder constant

  //motors on either side of the drive - set speed using speed controlling devices
  private SpeedControllerGroup m_leftMotor = new SpeedControllerGroup(new TalonFX(m_leftDeviceID), new TalonFX(m_leftDevicesID)); //need constants?
  private SpeedControllerGroup m_rightMotor = new SpeedControllerGroup(new TalonFX(m_rightDeviceID), new TalonFX(m_rightDevicesID)); //need constants?

  //robot's drive
  private DifferentialDrive m_drive = new DifferentialDrive(m_leftMotor, m_rightMotor);

  //drive encoders on either side
  private Encoder m_leftEncoder = new Encoder(channelA, channelB, indexChannel); //need constants?
  private Encoder m_rightEncoder = new Encoder(channelA, channelB, indexChannel); //need constants?

  /**
   * Creates a new ExampleSubsystem.
   */
  public ExampleSubsystem() {

    m_leftEncoder.setDistancePerPulse(distancePerPulse); //need constants?
    m_rightEncoder.setDistancePerPulse(distancePerPulse); //need constants?

  }

  public void arcadeDrive(double fwd, double rot) {
    m_drive.arcadeDrive(fwd, rot);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
