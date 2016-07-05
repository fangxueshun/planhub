package planhub.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Created by little_sheep on 2016/5/24.
 * @version v0.1 use for user register and login.
 */
public class User {
    private long uid;
    @Length(min=6,max=12,message="密码长度要在6-12位之间")
    @NotEmpty
    private String password;
    @Email(message = "邮箱格式不正确")
    @NotEmpty
    private String email;
    private String userName;
    private long registerTime;

    /*
    *transform User object in to json object.
    * */
    @Override
    public String toString(){
        return "User [id=" + uid + ", email=" + email + ", userName=" + userName + "]";
    }

    public long getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(long registerTime) {
        this.registerTime = registerTime;
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
