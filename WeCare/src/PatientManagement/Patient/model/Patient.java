/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PatientManagement.Patient.model;

import java.util.Date;

/**
 *
 * @author rishabagarwal
 */
public class Patient extends User{
    
    
    
    
    
    public Patient(String userName, String password, String userId, String PersonName, String address, String gender, String phoneNumber, Date dateOfBirth) {
        super(userName, password, userId, PersonName, address, gender, phoneNumber, dateOfBirth);
    }
    
    
    
    
    private String patientDiagnosis;
    private String hospitalName;

    public String getPatientDiagnosis() {
        return patientDiagnosis;
    }

    public void setPatientDiagnosis(String patientDiagnosis) {
        this.patientDiagnosis = patientDiagnosis;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }
    
    
    
    
    
}
