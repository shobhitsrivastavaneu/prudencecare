
package Business.Patient;

import Business.Organization.Organization;
import java.util.ArrayList;

/**
 *
 * @author rishabagarwal
 */
public class PatientDirectory {
    private ArrayList<Patient> patientlist;

    public PatientDirectory() {
        patientlist = new ArrayList<Patient>();
    }

    public ArrayList<Patient> getpatientlist() {
        return patientlist;
    }
    
    public Patient addPatient(Patient p)
    {
        //Patient p=new Patient();
        patientlist.add(p);
        return p;
    }
   
      public void deletePatient(Patient patient){
        patientlist.remove(patient); 
    }
    
        public Patient searchPatient(String patientName){
        for (Patient patient: patientlist) {
            if (patient.getName().equals(patientName)) {
                return patient;
            }
        }
        return null;
    }
            public void updatePatient(Patient v){
        for(Patient vac : patientlist){
            if(vac.getId() == v.getId()){
               vac = v;
                
            }
        }
    }
}

