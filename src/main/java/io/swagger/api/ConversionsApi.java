package io.swagger.api;

import io.swagger.model.*;

import io.swagger.model.Conversion;
import java.math.BigDecimal;

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
@RequestMapping(value = "/conversions", produces = {APPLICATION_JSON_VALUE})
@Api(value = "/conversions", description = "the conversions API")
public class ConversionsApi {
  

  @ApiOperation(value = "Get a list of the valid conversions.", notes = "Gets a list of the valid conversions that can be made with the API. For each conversion is also shown the available options for that specific type of conversion.\n\nThis conversions can be added to a Job through the specific endpoint or in the information given to create the new Job.\n", response = Conversion.class, responseContainer = "List")
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "List of conversions") })
  @RequestMapping(value = "", 
    
    
    method = RequestMethod.GET)
  public ResponseEntity<Conversion> conversionsGet(@ApiParam(value = "Category for the conversion.") @RequestParam(value = "category", required = false) String category

,
    @ApiParam(value = "Target for for the conversion.") @RequestParam(value = "target", required = false) String target

,
    @ApiParam(value = "Pagination for list of elements.", defaultValue = "1") @RequestParam(value = "page", required = false, defaultValue="1") BigDecimal page

)
      throws NotFoundException {
      // do some magic!
      return new ResponseEntity<Conversion>(HttpStatus.OK);
  }

  
}
