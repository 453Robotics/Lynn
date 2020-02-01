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
import edu.wpi.first.wpilibj.PWMTalonFX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
//import edu.wpi.first.wpilibj.

public class ExampleSubsystem extends SubsystemBase {
  //placeholder constants
  private int m_leftDeviceID = 1;
  private int m_leftDevicesID = 2;
  private int m_rightDeviceID = 3;
  private int m_rightDevicesID = 4;
  
  //motors on either side of the drive - set speed using speed controlling devices
  private SpeedControllerGroup m_leftMotor = new SpeedControllerGroup(new PWMTalonFX(m_leftDeviceID), new PWMTalonFX(m_leftDevicesID)); //need constants
  private SpeedControllerGroup m_rightMotor = new SpeedControllerGroup(new PWMTalonFX(m_rightDeviceID), new PWMTalonFX(m_rightDevicesID)); //need constants

  //robot's drive
  private DifferentialDrive m_drive = new DifferentialDrive(m_leftMotor, m_rightMotor);

  //drive encoders on either side - accounts for rotation/turning
  private Encoder m_leftEncoder = new Encoder(m_leftDeviceID, m_leftDevicesID, m_leftDeviceID); //should have 2 encoder ports & encoder reversed
  private Encoder m_rightEncoder = new Encoder(m_rightDeviceID, m_rightDevicesID, m_rightDeviceID); //should have 2 encoder ports & encoder reversed

  /**
   * Creates a new ExampleSubsystem.
   */
  public void DriveSystem() {
    //determines distance driven
    m_leftEncoder.setDistancePerPulse(m_leftDeviceID); 
    m_rightEncoder.setDistancePerPulse(m_rightDeviceID); 
  }

  public void arcadeDrive(double fwd, double rot) {
    //sets arcade drive
    m_drive.arcadeDrive(fwd, rot);
    //fwd - forward movement command
    //rot - rotation command
  }
  
  //get average distance of encoders
  public double getAverageEncoderDistance(){
    return (m_leftEncoder.getDistance() + m_rightEncoder.getDistance() / 2);
  }

  public Encoder getLeftEncoder(){
    return m_leftEncoder;
  }

  public Encoder getRightEncoder(){
    return m_rightEncoder;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    //reset encoders before each run - reads a position of 0
    m_leftEncoder.reset();
    m_rightEncoder.reset();
  }

  public void setMaxOutput(double maxOutput){
    //set max output of the bot - can help drive bot more slowly
    m_drive.setMaxOutput(maxOutput);
  }
}
