package controllers.responsedto;

import java.io.Serializable;

public class BaseResponseDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer code;
	private String status;
	private String token;
	private ErrorResponse errorResponse;
	
	public BaseResponseDto() {}
	
	
	public BaseResponseDto(String token, String status) {
		this.status = status;
		this.token = token;
	}

	public BaseResponseDto(String token, String status, Integer code) {
		this.status = status;
		this.token = token;
		this.code = code;
	}
	
	public BaseResponseDto(String token, String status, ErrorResponse errorResponse) {
		this.status = status;
		this.token = token;
		this.errorResponse = errorResponse;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}