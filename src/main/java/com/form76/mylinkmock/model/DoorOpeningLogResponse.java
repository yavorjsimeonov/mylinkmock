package com.form76.mylinkmock.model;

import lombok.ToString;

@ToString
public class DoorOpeningLogResponse {
  public Integer code;
  public String msg;
  public String time;

  public DoorOpeningLog data;

  public DoorOpeningLogResponse(Integer code, String msg, String time, DoorOpeningLog data) {
    this.code = code;
    this.msg = msg;
    this.time = time;
    this.data = data;
  }
}
