
package Business.Doctor;


import java.util.ArrayList;

/**
 *
 * @author rishabagarwal
 */
public class DoctorDirectory {
    private ArrayList<Doctor> doctorList;

    public DoctorDirectory() {
        System.out.println("DoctorDirectory.<init>()");
        doctorList = new ArrayList<Doctor>();
    }

    public ArrayList<Doctor> getdoctorList() {
        return doctorList;
    }
    
    public Doctor addDoctor(Doctor p)
    {
        doctorList.add(p);
        return p;
    }
   
      public void deleteDoctor(Doctor doctor){
        doctorList.remove(doctor); 
    }
       public void updateDoctor(Doctor d){
        for(Doctor doc : doctorList){
            if(doc.getId() == d.getId()){
               doc = d;
                
            }
        }
    }
    
        public Doctor searchDoctor(String doctorName){
        for (Doctor doctor: doctorList) {
            if (doctor.getName().equals(doctorName)) {
                return doctor;
            }
        }
        return null;
    }
}


    

