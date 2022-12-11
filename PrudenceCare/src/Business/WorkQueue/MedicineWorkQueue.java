/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author parvathypillai
 */
public class MedicineWorkQueue {
    
    private ArrayList<MedicineWorkRequest> dispensaryList;

    public MedicineWorkQueue() {
        dispensaryList = new ArrayList<MedicineWorkRequest>();
    }

    public ArrayList<MedicineWorkRequest> getDispensaryList() {
        for(MedicineWorkRequest w: dispensaryList){
        }
        return dispensaryList;
    }
    public void addDispensaryRequest(MedicineWorkRequest dispensaryReq) {
        this.dispensaryList.add(dispensaryReq);
             for(MedicineWorkRequest w: dispensaryList){
        }
    }
            public void removeDispensaryRequest(MedicineWorkRequest dispensaryReq) {
        dispensaryList.remove(dispensaryReq);
    }
    
        public void updateDispensaryRequest(MedicineWorkRequest dispensaryReq,List<MedicineWorkRequest> dispensaryList){
            for(MedicineWorkRequest work: dispensaryList){
                if(work.getId().equals(dispensaryReq.getId())){
                   work = dispensaryReq;
                }
            }
        }
        public MedicineWorkRequest getDispensaryRequest(MedicineWorkRequest w){
            for(MedicineWorkRequest work: dispensaryList){
                if(work.getId().equals(w.getId())){
                    return work;
                }
            }
            return null;
        }
    
}