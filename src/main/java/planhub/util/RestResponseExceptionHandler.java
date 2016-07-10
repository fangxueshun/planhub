package planhub.util;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.annotation.Resource;
import javax.xml.bind.ValidationException;

/**
 * Created by little_sheep on 2016/7/10.
 */
public class RestResponseExceptionHandler extends
        ResponseEntityExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private Gson gson;

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleExceptions(Exception ex,
                                                      WebRequest request) {

        HttpStatus status = HttpStatus.OK;
        HttpHeaders headers = new HttpHeaders();
        String bodyOfResponse = "";

        ServiceResult result = new ServiceResult();
        if(ex instanceof ValidationException){
            result.setCode(999);
            result.setMsg(ex.getMessage());
        } else {
            logger.error(ex.getMessage(), ex);

            result.setCode(500);
            result.setMsg(ex.getMessage());
        }

        try {
            bodyOfResponse = mapper.writeValueAsString(result);
        } catch (IOException e) {
        }

        headers.add("Content-Type", "application/json;charset=UTF-8");

        return handleExceptionInternal(ex, bodyOfResponse, headers, status,request);
    }

    @Resource(name = "jsonMapper")
    public void setMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }
}
