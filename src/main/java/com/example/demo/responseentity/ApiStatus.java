package com.example.demo.responseentity;

import org.springframework.http.HttpStatus;

public class ApiStatus<T> {

private HttpStatus status;
	private String requestStatus;
	private String statusMessage;
	private T data;
	private String statusCode;

	public ApiStatus() {
	}
	
	public ApiStatus(HttpStatus status, String requestStatus, T response) {
		super();
		this.setStatus(status);
		this.setRequestStatus(requestStatus);
		this.setData(response);
	}

	public ApiStatus(HttpStatus status, String requestStatus, String statusMessage, T response) {
		super();
		this.setStatus(status);
		this.setStatusCode(Integer.toString(status.value()));
		this.setRequestStatus(requestStatus);
		this.setData(response);
		this.setStatusMessage(statusMessage);
	}

	@Deprecated
	public ApiStatus(HttpStatus status, String statusCode, String requestStatus, String statusMessage,
			T response) {
		super();
		this.setStatus(status);
		this.setRequestStatus(requestStatus);
		this.setData(response);
		this.setStatusMessage(statusMessage);
		this.setStatusCode(statusCode);
	}

	public T getData() {
		return data;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

}
