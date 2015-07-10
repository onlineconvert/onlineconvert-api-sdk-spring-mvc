package io.swagger.api;

import io.swagger.model.*;

import io.swagger.model.Status;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.springframework.http.MediaType.*;

@Controller
@RequestMapping(value = "/statuses", produces = {APPLICATION_JSON_VALUE})
@Api(value = "/statuses", description = "the statuses API")
public class StatusesApi {
  

  @ApiOperation(value = "Get a list of the valid statuses.", notes = "The endpoint provide a list of all available status that the Job may have during the process as a description of the status.", response = Status.class, responseContainer = "List")
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "List of statuses") })
  @RequestMapping(value = "", 
    
    
    method = RequestMethod.GET)
  public ResponseEntity<Status> statusesGet()
      throws NotFoundException {
      // do some magic!
      return new ResponseEntity<Status>(HttpStatus.OK);
  }

  
}
