
package Business.WorkQueue;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rishabagarwal
 */
public class DiagnosticsTestWorkQueue {
    
    private ArrayList<DiagnosticsTestWorkRequest> labRequestList;

    public DiagnosticsTestWorkQueue() {
        labRequestList = new ArrayList();
    }

    public ArrayList<DiagnosticsTestWorkRequest> getLabRequestList() {
        return labRequestList;
    }
    public void addLabRequest(DiagnosticsTestWorkRequest w) {
        labRequestList.add(w);
    }
        public void removeLabRequest(DiagnosticsTestWorkRequest w) {
        labRequestList.remove(w);
    }
    
        public void updateLabRequest(DiagnosticsTestWorkRequest w,List<DiagnosticsTestWorkRequest> labRequestList){
            for(DiagnosticsTestWorkRequest work: labRequestList){
                if(work.getId().equals(w.getId())){
                   work=w;
                }
            }
        }
        public DiagnosticsTestWorkRequest getLabRequest(DiagnosticsTestWorkRequest w){
            for(DiagnosticsTestWorkRequest work: labRequestList){
                if(work.getId().equals(w.getId())){
                    return work;
                }
            }
            return null;
        }
    
}