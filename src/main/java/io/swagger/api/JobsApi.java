package io.swagger.api;

import io.swagger.model.*;

import io.swagger.model.Job;
import java.math.BigDecimal;
import io.swagger.model.Error;
import io.swagger.model.Conversion;
import io.swagger.model.InputFile;
import io.swagger.model.OutputFile;
import io.swagger.model.Thread;

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
@RequestMapping(value = "/jobs", produces = {APPLICATION_JSON_VALUE})
@Api(value = "/jobs", description = "the jobs API")
public class JobsApi {
  

  @ApiOperation(value = "List of jobs active for the current user identified by the key.", notes = "It will return the list of jobs for the given user. In order to get the jobs a key or token must be provided:\n  - If the user key is provided all jobs for the current will be return.\n  - If one token is provided it will return the job assigned to that token if any.\n  \nThe request is paginated with an amount of 50 elements per page in any case.\n", response = Job.class, responseContainer = "List")
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "Gets the newly created job info"),
    @ApiResponse(code = 401, message = "No API key or invalid API key given."),
    @ApiResponse(code = 400, message = "Invalid input.") })
  @RequestMapping(value = "", 
    
    
    method = RequestMethod.GET)
  public ResponseEntity<Job> jobsGet(@ApiParam(value = "Filter the status of the job.") @RequestParam(value = "status", required = false) String status

,
    
@ApiParam(value = "Token for authentication for the current job"  ) @RequestHeader(value="xOcToken", required=false) String xOcToken
,
    
@ApiParam(value = "Api key for the user to filter."  ) @RequestHeader(value="xOcApiKey", required=false) String xOcApiKey
,
    @ApiParam(value = "Pagination for list of elements.", defaultValue = "1") @RequestParam(value = "page", required = false, defaultValue="1") BigDecimal page

)
      throws NotFoundException {
      // do some magic!
      return new ResponseEntity<Job>(HttpStatus.OK);
  }

  

  @ApiOperation(value = "Creates a new Job with the user key.", notes = "", response = Job.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 201, message = "Gets the newly created job info"),
    @ApiResponse(code = 204, message = "The JSON body is empty."),
    @ApiResponse(code = 400, message = "Invalid input."),
    @ApiResponse(code = 429, message = "Too many concurrent requests."),
    @ApiResponse(code = 500, message = "Server not available.") })
  @RequestMapping(value = "", 
    
    
    method = RequestMethod.POST)
  public ResponseEntity<Job> jobsPost(
@ApiParam(value = "Api key for the user to filter." ,required=true ) @RequestHeader(value="xOcApiKey", required=true) String xOcApiKey
,
    

@ApiParam(value = "Content of the job." ,required=true ) Job body)
      throws NotFoundException {
      // do some magic!
      return new ResponseEntity<Job>(HttpStatus.OK);
  }

  

  @ApiOperation(value = "Get information about a Job", notes = "", response = Job.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "Get information about a Job"),
    @ApiResponse(code = 401, message = "No API key or invalid API key given."),
    @ApiResponse(code = 404, message = "The specified job does not exists.") })
  @RequestMapping(value = "/{job_id}", 
    
    
    method = RequestMethod.GET)
  public ResponseEntity<Job> jobsJobIdGet(
@ApiParam(value = "Token for authentication for the current job"  ) @RequestHeader(value="xOcToken", required=false) String xOcToken
,
    
@ApiParam(value = "Api key for the user to filter."  ) @RequestHeader(value="xOcApiKey", required=false) String xOcApiKey
,
    
@ApiParam(value = "ID of job that needs to be fetched",required=true ) @PathVariable("jobId") String jobId
)
      throws NotFoundException {
      // do some magic!
      return new ResponseEntity<Job>(HttpStatus.OK);
  }

  

  @ApiOperation(value = "Cancels a job created that haven't been started. (Allow to cancel jobs in process.)", notes = "", response = Job.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "Get information about the removed Job."),
    @ApiResponse(code = 401, message = "No API key or invalid API key given."),
    @ApiResponse(code = 404, message = "The specified job does not exists.") })
  @RequestMapping(value = "/{job_id}", 
    
    
    method = RequestMethod.DELETE)
  public ResponseEntity<Job> jobsJobIdDelete(
@ApiParam(value = "Token for authentication for the current job"  ) @RequestHeader(value="xOcToken", required=false) String xOcToken
,
    
@ApiParam(value = "Api key for the user to filter."  ) @RequestHeader(value="xOcApiKey", required=false) String xOcApiKey
,
    
@ApiParam(value = "ID of job that needs to be fetched",required=true ) @PathVariable("jobId") String jobId
)
      throws NotFoundException {
      // do some magic!
      return new ResponseEntity<Job>(HttpStatus.OK);
  }

  

  @ApiOperation(value = "Modifies the job identified by the id, allows to start a created job.", notes = "", response = Job.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "Get information about the removed Job"),
    @ApiResponse(code = 409, message = "The status of the job could not be changed since it is in a invalid status."),
    @ApiResponse(code = 401, message = "No API key or invalid API key given."),
    @ApiResponse(code = 404, message = "The specified job does not exists.") })
  @RequestMapping(value = "/{job_id}", 
    
    
    method = RequestMethod.PATCH)
  public ResponseEntity<Job> jobsJobIdPatch(

@ApiParam(value = "Content of the job." ,required=true ) Job body,
    
@ApiParam(value = "Token for authentication for the current job"  ) @RequestHeader(value="xOcToken", required=false) String xOcToken
,
    
@ApiParam(value = "Api key for the user to filter."  ) @RequestHeader(value="xOcApiKey", required=false) String xOcApiKey
,
    
@ApiParam(value = "ID of job that needs to be fetched",required=true ) @PathVariable("jobId") String jobId
)
      throws NotFoundException {
      // do some magic!
      return new ResponseEntity<Job>(HttpStatus.OK);
  }

  

  @ApiOperation(value = "Get list of conversions defined for the current job.", notes = "", response = Conversion.class, responseContainer = "List")
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "Get a list of all available conversions."),
    @ApiResponse(code = 401, message = "No API key or invalid API key given."),
    @ApiResponse(code = 404, message = "The specified job does not exists.") })
  @RequestMapping(value = "/{job_id}/conversions", 
    
    
    method = RequestMethod.GET)
  public ResponseEntity<Conversion> jobsJobIdConversionsGet(
@ApiParam(value = "Token for authentication for the current job"  ) @RequestHeader(value="xOcToken", required=false) String xOcToken
,
    
@ApiParam(value = "Api key for the user to filter."  ) @RequestHeader(value="xOcApiKey", required=false) String xOcApiKey
,
    
@ApiParam(value = "ID of job that needs to be fetched",required=true ) @PathVariable("jobId") String jobId
)
      throws NotFoundException {
      // do some magic!
      return new ResponseEntity<Conversion>(HttpStatus.OK);
  }

  

  @ApiOperation(value = "Adds a new conversion to the given job.", notes = "", response = Conversion.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 201, message = "The created conversion."),
    @ApiResponse(code = 401, message = "No API key or invalid API key given."),
    @ApiResponse(code = 404, message = "The specified job does not exists.") })
  @RequestMapping(value = "/{job_id}/conversions", 
    
    
    method = RequestMethod.POST)
  public ResponseEntity<Conversion> jobsJobIdConversionsPost(

@ApiParam(value = "information for the conversion." ,required=true ) Conversion body,
    
@ApiParam(value = "Token for authentication for the current job"  ) @RequestHeader(value="xOcToken", required=false) String xOcToken
,
    
@ApiParam(value = "Api key for the user to filter."  ) @RequestHeader(value="xOcApiKey", required=false) String xOcApiKey
,
    
@ApiParam(value = "ID of job that needs to be fetched",required=true ) @PathVariable("jobId") String jobId
)
      throws NotFoundException {
      // do some magic!
      return new ResponseEntity<Conversion>(HttpStatus.OK);
  }

  

  @ApiOperation(value = "Get list of conversions defined for the current job.", notes = "", response = Conversion.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "Get a conversion for the current job"),
    @ApiResponse(code = 401, message = "No API key or invalid API key given."),
    @ApiResponse(code = 404, message = "The specified job does not exists.") })
  @RequestMapping(value = "/{job_id}/conversions/{conversion_id}", 
    
    
    method = RequestMethod.GET)
  public ResponseEntity<Conversion> jobsJobIdConversionsConversionIdGet(
@ApiParam(value = "Token for authentication for the current job"  ) @RequestHeader(value="xOcToken", required=false) String xOcToken
,
    
@ApiParam(value = "Api key for the user to filter."  ) @RequestHeader(value="xOcApiKey", required=false) String xOcApiKey
,
    
@ApiParam(value = "ID of job that needs to be fetched",required=true ) @PathVariable("jobId") String jobId
,
    
@ApiParam(value = "Identifier for the job conversion.",required=true ) @PathVariable("conversionId") String conversionId
)
      throws NotFoundException {
      // do some magic!
      return new ResponseEntity<Conversion>(HttpStatus.OK);
  }

  

  @ApiOperation(value = "Removes the conversion for a job.", notes = "", response = Conversion.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "Get the removed conversion for the current job."),
    @ApiResponse(code = 401, message = "No API key or invalid API key given."),
    @ApiResponse(code = 404, message = "The specified job does not exists.") })
  @RequestMapping(value = "/{job_id}/conversions/{conversion_id}", 
    
    
    method = RequestMethod.DELETE)
  public ResponseEntity<Conversion> jobsJobIdConversionsConversionIdDelete(
@ApiParam(value = "Token for authentication for the current job"  ) @RequestHeader(value="xOcToken", required=false) String xOcToken
,
    
@ApiParam(value = "Api key for the user to filter."  ) @RequestHeader(value="xOcApiKey", required=false) String xOcApiKey
,
    
@ApiParam(value = "ID of job that needs to be fetched",required=true ) @PathVariable("jobId") String jobId
,
    
@ApiParam(value = "Identifier for the job conversion.",required=true ) @PathVariable("conversionId") String conversionId
)
      throws NotFoundException {
      // do some magic!
      return new ResponseEntity<Conversion>(HttpStatus.OK);
  }

  

  @ApiOperation(value = "Get list of binary source files for the conversion.hhh", notes = "Description of the get for the inputs of a specific job.", response = InputFile.class, responseContainer = "List")
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "Downloads the binary for the file."),
    @ApiResponse(code = 401, message = "No API key or invalid API key given."),
    @ApiResponse(code = 404, message = "The specified job does not exists.") })
  @RequestMapping(value = "/{job_id}/input", 
    
    
    method = RequestMethod.GET)
  public ResponseEntity<InputFile> jobsJobIdInputGet(
@ApiParam(value = "Token for authentication for the current job"  ) @RequestHeader(value="xOcToken", required=false) String xOcToken
,
    
@ApiParam(value = "Api key for the user to filter."  ) @RequestHeader(value="xOcApiKey", required=false) String xOcApiKey
,
    
@ApiParam(value = "ID of job that needs to be fetched",required=true ) @PathVariable("jobId") String jobId
)
      throws NotFoundException {
      // do some magic!
      return new ResponseEntity<InputFile>(HttpStatus.OK);
  }

  

  @ApiOperation(value = "Cretes a new input for the current job.", notes = "", response = InputFile.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 201, message = "The created conversion."),
    @ApiResponse(code = 401, message = "No API key or invalid API key given."),
    @ApiResponse(code = 404, message = "The specified job does not exists.") })
  @RequestMapping(value = "/{job_id}/input", 
    
    
    method = RequestMethod.POST)
  public ResponseEntity<InputFile> jobsJobIdInputPost(

@ApiParam(value = ""  ) InputFile body,
    
@ApiParam(value = "Token for authentication for the current job"  ) @RequestHeader(value="xOcToken", required=false) String xOcToken
,
    
@ApiParam(value = "Api key for the user to filter."  ) @RequestHeader(value="xOcApiKey", required=false) String xOcApiKey
,
    
@ApiParam(value = "ID of job that needs to be fetched",required=true ) @PathVariable("jobId") String jobId
)
      throws NotFoundException {
      // do some magic!
      return new ResponseEntity<InputFile>(HttpStatus.OK);
  }

  

  @ApiOperation(value = "Get list of conversions defined for the current job.", notes = "", response = InputFile.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "Get a file for the current job"),
    @ApiResponse(code = 401, message = "No API key or invalid API key given."),
    @ApiResponse(code = 404, message = "The specified job does not exists.") })
  @RequestMapping(value = "/{job_id}/input/{file_id}", 
    
    
    method = RequestMethod.GET)
  public ResponseEntity<InputFile> jobsJobIdInputFileIdGet(
@ApiParam(value = "Token for authentication for the current job"  ) @RequestHeader(value="xOcToken", required=false) String xOcToken
,
    
@ApiParam(value = "Api key for the user to filter."  ) @RequestHeader(value="xOcApiKey", required=false) String xOcApiKey
,
    
@ApiParam(value = "ID of job that needs to be fetched",required=true ) @PathVariable("jobId") String jobId
,
    
@ApiParam(value = "Id of the file to download",required=true ) @PathVariable("fileId") String fileId
)
      throws NotFoundException {
      // do some magic!
      return new ResponseEntity<InputFile>(HttpStatus.OK);
  }

  

  @ApiOperation(value = "Removes the input for a job.", notes = "", response = InputFile.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "Get the removed file for the current job."),
    @ApiResponse(code = 401, message = "No API key or invalid API key given."),
    @ApiResponse(code = 404, message = "The specified job does not exists.") })
  @RequestMapping(value = "/{job_id}/input/{file_id}", 
    
    
    method = RequestMethod.DELETE)
  public ResponseEntity<InputFile> jobsJobIdInputFileIdDelete(
@ApiParam(value = "Token for authentication for the current job"  ) @RequestHeader(value="xOcToken", required=false) String xOcToken
,
    
@ApiParam(value = "Api key for the user to filter."  ) @RequestHeader(value="xOcApiKey", required=false) String xOcApiKey
,
    
@ApiParam(value = "ID of job that needs to be fetched",required=true ) @PathVariable("jobId") String jobId
,
    
@ApiParam(value = "Id of the file to download",required=true ) @PathVariable("fileId") String fileId
)
      throws NotFoundException {
      // do some magic!
      return new ResponseEntity<InputFile>(HttpStatus.OK);
  }

  

  @ApiOperation(value = "Get list of converted.", notes = "", response = OutputFile.class, responseContainer = "List")
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "Downloads the binary for the file"),
    @ApiResponse(code = 401, message = "No API key or invalid API key given."),
    @ApiResponse(code = 404, message = "The specified job does not exists.") })
  @RequestMapping(value = "/{job_id}/output", 
    
    
    method = RequestMethod.GET)
  public ResponseEntity<OutputFile> jobsJobIdOutputGet(@ApiParam(value = "") @RequestParam(value = "conversionId", required = false) String conversionId

,
    @ApiParam(value = "") @RequestParam(value = "inputId", required = false) String inputId

,
    
@ApiParam(value = "Token for authentication for the current job"  ) @RequestHeader(value="xOcToken", required=false) String xOcToken
,
    
@ApiParam(value = "Api key for the user to filter."  ) @RequestHeader(value="xOcApiKey", required=false) String xOcApiKey
,
    
@ApiParam(value = "ID of job that needs to be fetched",required=true ) @PathVariable("jobId") String jobId
)
      throws NotFoundException {
      // do some magic!
      return new ResponseEntity<OutputFile>(HttpStatus.OK);
  }

  

  @ApiOperation(value = "Get information about an output file source.", notes = "", response = OutputFile.class, responseContainer = "List")
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "Gets the information for the file."),
    @ApiResponse(code = 401, message = "No API key or invalid API key given."),
    @ApiResponse(code = 404, message = "The specified job does not exists.") })
  @RequestMapping(value = "/{job_id}/output/{file_id}", 
    
    
    method = RequestMethod.GET)
  public ResponseEntity<OutputFile> jobsJobIdOutputFileIdGet(
@ApiParam(value = "Token for authentication for the current job"  ) @RequestHeader(value="xOcToken", required=false) String xOcToken
,
    
@ApiParam(value = "Api key for the user to filter."  ) @RequestHeader(value="xOcApiKey", required=false) String xOcApiKey
,
    
@ApiParam(value = "ID of job that needs to be fetched",required=true ) @PathVariable("jobId") String jobId
,
    
@ApiParam(value = "Id of the file to download",required=true ) @PathVariable("fileId") String fileId
)
      throws NotFoundException {
      // do some magic!
      return new ResponseEntity<OutputFile>(HttpStatus.OK);
  }

  

  @ApiOperation(value = "Deletes a file from the output.", notes = "", response = OutputFile.class, responseContainer = "List")
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "Gets the information for the deleted file."),
    @ApiResponse(code = 401, message = "No API key or invalid API key given."),
    @ApiResponse(code = 404, message = "The specified job does not exists.") })
  @RequestMapping(value = "/{job_id}/output/{file_id}", 
    
    
    method = RequestMethod.DELETE)
  public ResponseEntity<OutputFile> jobsJobIdOutputFileIdDelete(
@ApiParam(value = "Token for authentication for the current job"  ) @RequestHeader(value="xOcToken", required=false) String xOcToken
,
    
@ApiParam(value = "Api key for the user to filter."  ) @RequestHeader(value="xOcApiKey", required=false) String xOcApiKey
,
    
@ApiParam(value = "ID of job that needs to be fetched",required=true ) @PathVariable("jobId") String jobId
,
    
@ApiParam(value = "Id of the file to download",required=true ) @PathVariable("fileId") String fileId
)
      throws NotFoundException {
      // do some magic!
      return new ResponseEntity<OutputFile>(HttpStatus.OK);
  }

  

  @ApiOperation(value = "Get list of threads defined for the current job.", notes = "", response = Thread.class, responseContainer = "List")
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "Get a list of all threads currently being processed."),
    @ApiResponse(code = 401, message = "No API key or invalid API key given."),
    @ApiResponse(code = 404, message = "The specified job does not exists.") })
  @RequestMapping(value = "/{job_id}/threads", 
    
    
    method = RequestMethod.GET)
  public ResponseEntity<Thread> jobsJobIdThreadsGet(
@ApiParam(value = "Token for authentication for the current job"  ) @RequestHeader(value="xOcToken", required=false) String xOcToken
,
    
@ApiParam(value = "Api key for the user to filter."  ) @RequestHeader(value="xOcApiKey", required=false) String xOcApiKey
,
    
@ApiParam(value = "ID of job that needs to be fetched",required=true ) @PathVariable("jobId") String jobId
)
      throws NotFoundException {
      // do some magic!
      return new ResponseEntity<Thread>(HttpStatus.OK);
  }

  
}
