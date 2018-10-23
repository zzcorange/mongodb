package com.chengzi.mongodb.other;


import org.springframework.data.mongodb.core.aggregation.Fields;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.lang.reflect.Field;
@Document(collection = "UserEntity")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 8602883392112475289L;
    private Long id;
    private String username;
    private String password;
    private String userName;
    private String passWord;

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Field[] fields = this.getClass().getDeclaredFields();
        for(Field f:fields){

            try{
                sb.append(f.getName()+":");
                sb.append(this.getClass().getMethod("get"+toHigh(f.getName())).invoke(this).toString());

            }catch (Exception e){}
            finally {
                    sb.append(";");
            }
        }
        return sb.toString();
    }
    private String toHigh(String str) {
        char[] chars = str.toCharArray();
        if (chars[0] >= 'a' && chars[0] <= 'z') {
            chars[0] = (char) (chars[0] - 32);
        }
        return new String(chars);
    }
}
