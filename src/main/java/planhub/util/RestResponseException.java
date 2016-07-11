package planhub.util;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import planhub.domain.ErrorMessageDao;

/**
 * Created by little_sheep on 2016/7/10.
 */
public class RestResponseException extends
        RuntimeException {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private Gson gson;
    private ResponseEntity<ErrorMessageDao> responseEntity;

    public RestResponseException(ResponseEntity<ErrorMessageDao> responseEntity,Throwable cause){
        super(((ErrorMessageDao)responseEntity.getBody()).getMessage(),cause);
        this.responseEntity=responseEntity;
    }
    public RestResponseException(ErrorMessageDao errorMessageDao,HttpStatus httpStatus,Throwable cause){
        this(new ResponseEntity(errorMessageDao,httpStatus),cause);
    }
    public RestResponseException(String code,String message,Throwable cause){
        this(new ErrorMessageDao(code,message),HttpStatus.INTERNAL_SERVER_ERROR,cause);
    }
    public RestResponseException(String code,String message){
        this(code,message,(Throwable)null);
    }

}
