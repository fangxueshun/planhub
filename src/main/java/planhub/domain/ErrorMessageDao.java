package planhub.domain;

/**
 * Created by little_sheep on 2016/7/11.
 */
public class ErrorMessageDao {
    private String code;
    private String message;
    private String detail;
    private ResponseErrorMessage cause;


    public ErrorMessageDao() {
    }

    public ErrorMessageDao(String code, String message) {
        this(code,message,(String)null);
    }

    public ErrorMessageDao(String code, String message, String detail,ResponseErrorMessage cause){
        this.message = message;
        this.code = code;
        this.detail = detail;
        this.cause = cause;
    }

    public ErrorMessageDao(String code, String message, String detail) {
        this(code,message,detail,(ResponseErrorMessage)null);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
// private ResponseErrorM
}
