package nju.swi.common;


public class GenericResult<T> {
	private int code;
	private String message;
	private T data;
	
	public GenericResult() {
		this.code = ResultCode.OK;
	}
	
	public GenericResult(int code) {
		this.code = code;
	}
	
	public GenericResult(int code, T data) {
		this.code = code;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public GenericResult<T> setCode(int code) {
		this.code = code;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public GenericResult<T> setMessage(String message) {
		this.message = message;
		return this;
	}

	public T getData() {
		return data;
	}

	public GenericResult<T> setData(T data) {
		this.data = data;
		return this;
	}
}
