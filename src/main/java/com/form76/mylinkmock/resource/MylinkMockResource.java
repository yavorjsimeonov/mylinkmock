package com.form76.mylinkmock.resource;

//import com.form76.generator.Form76ReportGenerator;
import com.form76.mylinkmock.TestDataGeneratorService;
import com.form76.mylinkmock.model.DoorOpeningLog;
import com.form76.mylinkmock.model.DoorOpeningLogResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


import java.nio.file.FileSystems;

@Controller
@RequestMapping("/")
public class MylinkMockResource {

  @Autowired
  TestDataGeneratorService testDataGeneratorService;

  private static String TMP_DIR = System.getProperty("java.io.tmpdir");
  private static String FILE_SEPARATOR = FileSystems.getDefault().getSeparator();

  @GetMapping("/ping")
  @ResponseBody
  public String ping() {
    return "Ping successful...";
  }


  @GetMapping(path = "/normalOpenDoorlog/extapi/list", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<DoorOpeningLogResponse> generateTestSrcFile(
      @RequestParam(value = "accessToken") String accessToken,
      @RequestParam(value = "extCommunityId") int extCommunityId,
      @RequestParam(value = "extCommunityUuid") String extCommunityUuid,
      @RequestParam(value = "openStatus") Integer openStatus,
      @RequestParam(value = "startDateTime") String startDateTime,
      @RequestParam(value = "endDateTime") String endDateTime,
      @RequestParam(value = "currentPage") Integer currentPage,
      @RequestParam(value = "pageSize") Integer pageSize
  ) {
    try {
      // Validate input parameters
      if (accessToken == null || accessToken.isEmpty()) {
        throw new IllegalArgumentException("Access token is required.");
      }
      if ((extCommunityId <= 0 && (extCommunityUuid == null || extCommunityUuid.isEmpty()))) {
        throw new IllegalArgumentException("Either extCommunityId or extCommunityUuid must be provided.");
      }
      if (startDateTime == null || startDateTime.isEmpty()) {
        throw new IllegalArgumentException("startDateTime is required.");
      }
      if (endDateTime == null || endDateTime.isEmpty()) {
        throw new IllegalArgumentException("endDateTime is required.");
      }


      DoorOpeningLog data = testDataGeneratorService.generateDoorOpeningLog(startDateTime, endDateTime);

      // Create DoorOpeningLogResponse
      DoorOpeningLogResponse response = new DoorOpeningLogResponse(
          200,
          "Success",
          LocalDateTime.now().toString(),
          data
      );

      return ResponseEntity.ok(response);

    } catch (Exception e) {
      e.printStackTrace();
      DoorOpeningLogResponse errorResponse = new DoorOpeningLogResponse(
          500,
          "Failed to generate test data: " + e.getMessage(),
          LocalDateTime.now().toString(),
          null
      );
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
  }


}
