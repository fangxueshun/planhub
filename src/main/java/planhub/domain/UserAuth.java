package planhub.domain;

import com.google.gson.Gson;

/**
 * @author Created by little_sheep on 2016/5/24.
 * @version v0.1 use for user register and login.
 */
public class UserAuth {
    private long uid;
    private String password;
    private String email;
    private String userName;

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    private long timeStamp;




    /*
    *transform UserAuth object in to json object.
    * */
    @Override
    public String toString(){
        return "User [id=" + uid + ", email=" + email + ", userName=" + userName + "]";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
