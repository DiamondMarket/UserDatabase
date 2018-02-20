package com.diamondmarket.users.api;

import com.diamondmarket.users.model.Response;
import com.diamondmarket.users.model.TransactionContext;
import com.diamondmarket.users.model.User;
import com.diamondmarket.users.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.diamondmarket.users.model.Error;
import javax.validation.constraints.*;
import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-02-17T15:10:28.385Z")

@Controller
public class UserApiController implements UserApi {

	@Autowired
	private UserService userService;

	private TransactionContext createTransactionContext(HttpHeaders httpHeaders) {

		TransactionContext context = new TransactionContext();
		if (httpHeaders.get("correlationId") != null) {
			context.setCorrelationId(httpHeaders.get("correlationId").toString());
		} else {
			context.setCorrelationId("demo");
		}
		if (httpHeaders.get("ApplicationLabel") != null) {
			context.setApplicationLabel(httpHeaders.get("ApplicationLabel").toString());
		} else {
			context.setApplicationLabel("demo");
		}

		return context;
	}

	private HttpHeaders setHeaders(TransactionContext context) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("correlationId", context.getCorrelationId());
		headers.add("ApplicationLabel", context.getApplicationLabel());
		headers.add("Content-Type", "application/json");
		return headers;
	}

	private ResponseEntity<Response> successResponse(TransactionContext context, Object object, HttpStatus httpStatus) {
		HttpHeaders headers = setHeaders(context);
		Response response = new Response();
		response.setData(object);
		response.setTimeStamp(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
		ResponseEntity<Response> responseEntity = new ResponseEntity<Response>(response, headers, httpStatus);
		return responseEntity;
	}

	private ResponseEntity<Response> errorResponse(TransactionContext context, Exception exception,
			HttpStatus httpStatus) {
		HttpHeaders headers = setHeaders(context);
		Error error = new Error();
		error.setCode(httpStatus.toString() + "0001");
		error.setReason(exception.getMessage());
		Response response = new Response();
		response.setError(error);
		response.setTimeStamp(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
		ResponseEntity<Response> responseEntity = new ResponseEntity<Response>(response, headers, httpStatus);
		return responseEntity;
	}

	public ResponseEntity<Response> createUser(@RequestHeader HttpHeaders httpHeaders,
			@ApiParam(value = "Created user object", required = true) @Valid @RequestBody User body) {
		ResponseEntity<Response> response = null;
		TransactionContext context = createTransactionContext(httpHeaders);
		if (httpHeaders.get("correlationId") != null) {
			context.setCorrelationId(httpHeaders.get("correlationId").toString());
		} else {
			context.setCorrelationId("demo");
		}
		if (httpHeaders.get("ApplicationLabel") != null) {
			context.setApplicationLabel(httpHeaders.get("ApplicationLabel").toString());
		} else {
			context.setApplicationLabel("demo");
		}
		try {
			response = successResponse(context, userService.createUser(body), HttpStatus.CREATED);

		} catch (Exception e) {
			response = errorResponse(context, e, HttpStatus.BAD_REQUEST);
		}

		return response;
	}

	public ResponseEntity<Response> deleteUser(@RequestHeader HttpHeaders httpHeaders,
			@ApiParam(value = "The user that needs to be deleted", required = true) @RequestParam(value="userId",required=true) String userId) {
		ResponseEntity<Response> response = null;
		TransactionContext context = new TransactionContext();
		if (httpHeaders.get("correlationId") != null) {
			context.setCorrelationId(httpHeaders.get("correlationId").toString());
		} else {
			context.setCorrelationId("demo");
		}
		if (httpHeaders.get("ApplicationLabel") != null) {
			context.setApplicationLabel(httpHeaders.get("ApplicationLabel").toString());
		} else {
			context.setApplicationLabel("demo");
		}

		try {
			String deleteUser = userService.deleteUser(userId);

			response = successResponse(context, deleteUser, HttpStatus.OK);

		} catch (Exception e) {
			response = errorResponse(context, e, HttpStatus.BAD_REQUEST);
		}

		return response;
	}

	public ResponseEntity<Response> getUserById(@RequestHeader HttpHeaders httpHeaders,
			@ApiParam(value = "", required = true) @PathVariable("userId") String userId) {

		ResponseEntity<Response> response = null;
		TransactionContext context = createTransactionContext(httpHeaders);
		if (httpHeaders.get("correlationId") != null) {
			context.setCorrelationId(httpHeaders.get("correlationId").toString());
		} else {
			context.setCorrelationId("demo");
		}
		if (httpHeaders.get("ApplicationLabel") != null) {
			context.setApplicationLabel(httpHeaders.get("ApplicationLabel").toString());
		} else {
			context.setApplicationLabel("demo");
		}
		try {

			User user = userService.getUser(userId);
			response = successResponse(context, user, HttpStatus.OK);

		} catch (Exception e) {
			response = errorResponse(context, e, HttpStatus.BAD_REQUEST);
		}

		return response;

	}

	public ResponseEntity<Response> loginUser(@RequestHeader HttpHeaders httpHeaders,
			@NotNull @ApiParam(value = "The user name for login", required = true) @RequestParam(value = "username", required = true) String username,
			@NotNull @ApiParam(value = "The password for login in clear text", required = true) @RequestParam(value = "password", required = true) String password) {
		ResponseEntity<Response> response = null;
		TransactionContext context = createTransactionContext(httpHeaders);
		if (httpHeaders.get("correlationId") != null) {
			context.setCorrelationId(httpHeaders.get("correlationId").toString());
		} else {
			context.setCorrelationId("demo");
		}
		if (httpHeaders.get("ApplicationLabel") != null) {
			context.setApplicationLabel(httpHeaders.get("ApplicationLabel").toString());
		} else {
			context.setApplicationLabel("demo");
		}
		try {

			User loginUser = userService.loginUser(username, password);

			response = successResponse(context, loginUser, HttpStatus.OK);

		} catch (Exception e) {
			response = errorResponse(context, e, HttpStatus.BAD_REQUEST);
		}

		return response;

	}

	public ResponseEntity<Response> updateUser(@RequestHeader HttpHeaders httpHeaders,
			@ApiParam(value = "Updated user object", required = true) @Valid @RequestBody User body) {
		ResponseEntity<Response> response = null;
		TransactionContext context = createTransactionContext(httpHeaders);
		if (httpHeaders.get("correlationId") != null) {
			context.setCorrelationId(httpHeaders.get("correlationId").toString());
		} else {
			context.setCorrelationId("demo");
		}
		if (httpHeaders.get("ApplicationLabel") != null) {
			context.setApplicationLabel(httpHeaders.get("ApplicationLabel").toString());
		} else {
			context.setApplicationLabel("demo");
		}
		try {

			User updateUser = userService.updateUser(body);
			response = successResponse(context, updateUser, HttpStatus.OK);

		} catch (Exception e) {
			response = errorResponse(context, e, HttpStatus.BAD_REQUEST);
		}

		return response;

	}

}
