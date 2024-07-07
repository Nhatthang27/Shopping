/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.model.account;

import java.io.Serializable;

/**
 *
 * @author Nhatthang
 */
public class CreateUserError implements Serializable{
    private String usernameLenErr;
    private String passwordLenErr;
    private String confirmNotMatch;
    private String firstNameLenErr;
    private String usernameExist;

    public CreateUserError() {
    }

    public CreateUserError(String usernameLenErr, String passwordLenErr, String confirmNotMatch, String firstNameLenErr, String usernameExist) {
        this.usernameLenErr = usernameLenErr;
        this.passwordLenErr = passwordLenErr;
        this.confirmNotMatch = confirmNotMatch;
        this.firstNameLenErr = firstNameLenErr;
        this.usernameExist = usernameExist;
    }

    
    public String getUsernameLenErr() {
        return usernameLenErr;
    }

    public void setUsernameLenErr(String usernameLenErr) {
        this.usernameLenErr = usernameLenErr;
    }

    public String getPasswordLenErr() {
        return passwordLenErr;
    }

    public void setPasswordLenErr(String passwordLenErr) {
        this.passwordLenErr = passwordLenErr;
    }

    public String getConfirmNotMatch() {
        return confirmNotMatch;
    }

    public void setConfirmNotMatch(String confirmNotMatch) {
        this.confirmNotMatch = confirmNotMatch;
    }

    public String getFirstNameLenErr() {
        return firstNameLenErr;
    }

    public void setFirstNameLenErr(String firstNameLenErr) {
        this.firstNameLenErr = firstNameLenErr;
    }

    public String getUsernameExist() {
        return usernameExist;
    }

    public void setUsernameExist(String usernameExist) {
        this.usernameExist = usernameExist;
    }

    @Override
    public String toString() {
        return "CreateUserError{" + "usernameLenErr=" + usernameLenErr + ", passwordLenErr=" + passwordLenErr + ", confirmNotMatch=" + confirmNotMatch + ", firstNameLenErr=" + firstNameLenErr + ", usernameExist=" + usernameExist + '}';
    }
    
    
    
    
}
