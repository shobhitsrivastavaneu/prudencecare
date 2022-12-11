/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rishabagarwal
 */
public class DiagnosticsPatientWorkQueue {
    
    private ArrayList<DiagnosticsPatientWorkRequest> labPatientList;

    public DiagnosticsPatientWorkQueue() {
        labPatientList = new ArrayList();
    }

    public ArrayList<DiagnosticsPatientWorkRequest> getLabPatientRequestList() {
        return labPatientList;
    }
    public void addLabPatientRequest(DiagnosticsPatientWorkRequest w) {
        labPatientList.add(w);
    }
        public void removeLabPatientRequest(DiagnosticsPatientWorkRequest w) {
        labPatientList.remove(w);
    }
    
        public void updateLabPatientRequest(DiagnosticsPatientWorkRequest w,List<DiagnosticsPatientWorkRequest> labPatientList){
            for(DiagnosticsPatientWorkRequest work: labPatientList){
                if(work.getId().equals(w.getId())){
                   work=w;
                }
            }
        }
        public DiagnosticsPatientWorkRequest getLabPatientRequest(DiagnosticsPatientWorkRequest w){
            for(DiagnosticsPatientWorkRequest work: labPatientList){
                if(work.getId().equals(w.getId())){
                    return work;
                }
            }
            return null;
        }
    
}