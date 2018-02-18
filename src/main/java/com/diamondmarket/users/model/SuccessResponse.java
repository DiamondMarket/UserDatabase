package com.diamondmarket.users.model;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-02-14T17:51:56.837Z")


public class SuccessResponse {

	@JsonProperty("message")
	private String message;
	
	@JsonProperty("timestamp")
	private Date timestamp;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		SuccessResponse successResponse = (SuccessResponse) o;
		return Objects.equals(this.message, successResponse.message) &&
				Objects.equals(this.timestamp, successResponse.timestamp); 
	}

	@Override
	public int hashCode() {
		return Objects.hash(message,timestamp);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Order {\n");
	    sb.append("    message: ").append(toIndentedString(message)).append("\n");
	    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
	    sb.append("}");
	    return sb.toString();
	  }
	 
	private String toIndentedString(java.lang.Object o) {
		 if (o == null) {
			 return "null";
		 }
		 return o.toString().replace("\n", "\n    ");
	  }
	
}
