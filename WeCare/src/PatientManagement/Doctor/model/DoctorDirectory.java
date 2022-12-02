/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PatientManagement.Doctor.model;

import java.util.ArrayList;

/**
 *
 * @author shobhitsrivastava
 */
public class DoctorDirectory {

    private ArrayList<Doctor> doctorDirectory;

    public DoctorDirectory() {
        this.doctorDirectory = new ArrayList();
    }

    public ArrayList<Doctor> getDoctorDirectory() {
        return doctorDirectory;
    }

    public Doctor addDoctor() {
        Doctor doctor = new Doctor();
        doctorDirectory.add(doctor);
        return doctor;

    }

    public void deleteDoctor(Doctor selectedDoctor) {
        doctorDirectory.remove(selectedDoctor);
    }

}
