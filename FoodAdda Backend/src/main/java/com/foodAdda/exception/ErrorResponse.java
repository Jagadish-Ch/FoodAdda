package com.foodAdda.exception;


import java.time.LocalDateTime;
import java.util.Objects;

public class ErrorResponse {
	private LocalDateTime timeStamp;
	private int status; //httpStatus code
	private String error;
	private String message;
	private String path;
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	@Override
	public String toString() {
		return "ErrorResponse [timeStamp=" + timeStamp + ", status=" + status + ", error=" + error + ", message="
				+ message + ", path=" + path + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(error, message, path, status, timeStamp);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ErrorResponse other = (ErrorResponse) obj;
		return Objects.equals(error, other.error) && Objects.equals(message, other.message)
				&& Objects.equals(path, other.path) && status == other.status
				&& Objects.equals(timeStamp, other.timeStamp);
	}
	
	
}
