package controllers.responsedto;

import java.io.Serializable;

/**
 * Created by pkonwar on 6/25/2016.
 */
public class GenericResponseContainer implements Serializable{

    public GenericResponseContainer(){}

    public GenericResponseContainer(String status, Object data) {
        this.status = status;
        this.data = data;
    }

    public GenericResponseContainer(String token, String code, String status, Object data) {
        this.token = token;
        this.code = code;
        this.status = status;
        this.data = data;
    }

    public GenericResponseContainer(String token, String code, String status, ErrorResponse errorResponse) {
        this.token = token;
        this.code = code;
        this.status = status;
        this.errorResponse = errorResponse;
    }

    private String token;
    private String code;
    private String status;
    private Object data;
    private ErrorResponse errorResponse;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }
}
