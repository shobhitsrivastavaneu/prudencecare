/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enterprise;

/**
 *
 * @author rishabagarwal
 */
public class Enterprise {
    private String address;

    public Enterprise() {
    }
    private String userName;
    private String pwd;
    private String enterpriseName;
    private String registrationNumber;

    public String getAddress() {
        return address;
    }

    public Enterprise(String address, String userName, String pwd, String enterpriseName, String registrationNumber) {
        this.address = address;
        this.userName = userName;
        this.pwd = pwd;
        this.enterpriseName = enterpriseName;
        this.registrationNumber = registrationNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    
}
