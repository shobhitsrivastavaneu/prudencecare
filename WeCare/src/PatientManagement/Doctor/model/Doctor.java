/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PatientManagement.Doctor.model;

import PatientManagement.Patient.model.User;
import java.util.Date;

/**
 *
 * @author shobhitsrivastava
 */
public class Doctor extends User {

  public Doctor(){}
    
    
    public Doctor(String userName, String password, String userId, String PersonName, String address, String gender, String phoneNumber, Date dateOfBirth) {
        super(userName, password, userId, PersonName, address, gender, phoneNumber, dateOfBirth);
    }

    private String doctorSpeciality;
    private String hospitalName;

    public String getDoctorSpeciality() {
        return doctorSpeciality;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setDoctorSpeciality(String doctorSpeciality) {
        this.doctorSpeciality = doctorSpeciality;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }
    
    

}
