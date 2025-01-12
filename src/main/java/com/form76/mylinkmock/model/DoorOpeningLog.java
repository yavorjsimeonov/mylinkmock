package com.form76.mylinkmock.model;
import lombok.ToString;

import java.util.List;

@ToString
public class DoorOpeningLog {

  public int totalCount;
  public int totalPage;
  public List<DoorEvent> list;

  public DoorOpeningLog(int totalCount, int totalPage, List<DoorEvent> list) {
    this.totalCount = totalCount;
    this.totalPage = totalPage;
    this.list = list;
  }

}
