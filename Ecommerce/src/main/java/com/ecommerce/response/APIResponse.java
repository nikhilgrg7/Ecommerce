package com.ecommerce.response;

public class APIResponse {
		private String status ;
		private String message;
		private Object data;
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public Object getData() {
			return data;
		}
		public void setData(Object data) {
			this.data = data;
		}
		public APIResponse(String status, String message, Object data) {
			super();
			this.status = status;
			this.message = message;
			this.data = data;
		}
		public APIResponse() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "APIResponse [status=" + status + ", message=" + message + ", data=" + data + ", getStatus()="
					+ getStatus() + ", getMessage()=" + getMessage() + ", getData()=" + getData() + ", getClass()="
					+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
		}
		


}
