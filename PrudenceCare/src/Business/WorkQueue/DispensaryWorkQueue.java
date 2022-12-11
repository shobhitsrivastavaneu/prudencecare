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
public class DispensaryWorkQueue {
    
    private ArrayList<DispensaryWorkRequest> dispensaryList;

    public DispensaryWorkQueue() {
        dispensaryList = new ArrayList<DispensaryWorkRequest>();
    }

    public ArrayList<DispensaryWorkRequest> getDispensaryList() {
        for(DispensaryWorkRequest w: dispensaryList){
        }
        return dispensaryList;
    }
    public void addDispensaryRequest(DispensaryWorkRequest dispensaryReq) {
        this.dispensaryList.add(dispensaryReq);
             for(DispensaryWorkRequest w: dispensaryList){
        }
    }
            public void removeDispensaryRequest(DispensaryWorkRequest dispensaryReq) {
        dispensaryList.remove(dispensaryReq);
    }
    
        public void updateDispensaryRequest(DispensaryWorkRequest dispensaryReq,List<DispensaryWorkRequest> dispensaryList){
            for(DispensaryWorkRequest work: dispensaryList){
                if(work.getId().equals(dispensaryReq.getId())){
                   work = dispensaryReq;
                }
            }
        }
        public DispensaryWorkRequest getDispensaryRequest(DispensaryWorkRequest w){
            for(DispensaryWorkRequest work: dispensaryList){
                if(work.getId().equals(w.getId())){
                    return work;
                }
            }
            return null;
        }
    
}