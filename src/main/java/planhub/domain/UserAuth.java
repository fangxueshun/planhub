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

    /*
    *transform UserAuth object in to json object.
    * */
    public String toJson(UserAuth userAuth){
        Gson gson = new Gson();
        return gson.toJson(userAuth);
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
