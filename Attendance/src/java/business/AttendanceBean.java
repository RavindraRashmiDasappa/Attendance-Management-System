/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author rahmi
 */
public class AttendanceBean {
    private String rate3;
    private String email;
    private String password;
    private String name;
    private String lastName;
    public boolean valid;

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String newLastName) {
        lastName = newLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String newEmail) {
        email = newEmail;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean newValid) {
        valid = newValid;
    }
    
    public String getRate3() {
        return rate3;
    }

    public void setRate3(String newRate3) {
        rate3 = newRate3;
    }
}
