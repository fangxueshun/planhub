package planhub.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import java.util.Date;

/**
 * Created by little_sheep on 2016/7/12.
 */
public class ResponseErrorMessage extends ErrorMessageDao {
    private String hostId;
    private String requestId;
    private Date serverTime;
    @Expose
    private Throwable throwable;
    Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    public ResponseErrorMessage() {
    }

    public ResponseErrorMessage(Throwable throwable) {
        this.throwable = throwable;
    }

    public String getHostId() {
        return hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Date getServerTime() {
        return (Date) serverTime.clone();
    }

    public void setServerTime(Date serverTime) {
        if(serverTime!=null){
            this.serverTime = new Date(serverTime.getTime());
        }else {
            this.serverTime = new Date();
        }

    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public String toString(){
        return gson.toJson(this);
    }
}
