package com.form76.mylinkmock.model;

import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


@ToString
public class DoorEvent implements Serializable {

  public String doorName;
  public String devSn;
  public String devName;
  public String empName;
  public Integer empId;
  public String empUUID;
  public Integer eventType;
  public String eventTypeName;
  public String captureImage;
  public Integer faceMatchScore;
  public Double bodyTemperature;
  public String eventTime;
  public String pushRtEventResult;
  public Integer openStatus;
  public boolean isInEvent;


  public DoorEvent(String eventTime, String doorName, String devName) {
    this.eventTime = eventTime;
    this.doorName = doorName;
    this.devName = devName;
    this.isInEvent = devName.endsWith("-IN") || devName.endsWith("-in");
  }

  public DoorEvent(String doorName, String devSn, String devName, String empName, Integer empId, String empUUID,
                   Integer eventType, String eventTypeName, String captureImage, Integer faceMatchScore,
                   Double bodyTemperature, String eventTime, String pushRtEventResult, Integer openStatus) {
    this.doorName = doorName;
    this.devSn = devSn;
    this.devName = devName;
    this.empName = empName;
    this.empId = empId;
    this.empUUID = empUUID;
    this.eventType = eventType;
    this.eventTypeName = eventTypeName;
    this.captureImage = captureImage;
    this.faceMatchScore = faceMatchScore;
    this.bodyTemperature = bodyTemperature;
    this.eventTime = eventTime;
    this.pushRtEventResult = pushRtEventResult;
    this.openStatus = openStatus;
  }
}

