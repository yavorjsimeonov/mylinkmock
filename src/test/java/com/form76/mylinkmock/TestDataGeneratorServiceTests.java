package com.form76.mylinkmock;

import com.form76.mylinkmock.model.DoorOpeningLog;
import org.apache.poi.ss.formula.functions.T;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;

public class TestDataGeneratorServiceTests {

  @Test
  public void testGenerateEmployees() throws ParseException {
    TestDataGeneratorService testDataGeneratorService = new TestDataGeneratorService();
    DoorOpeningLog doorOpeningLog = testDataGeneratorService.generateDoorOpeningLog("2024-12-01 00:00:00", "2024-12-31 23:59:59");
    System.out.println(doorOpeningLog);
  }


}
