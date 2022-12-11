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
//Dispensary sends demand requests to manufacturing unit using this queue.
public class MedicineDemandQueue {
    
    private ArrayList<MedicineDemandWorkRequest> demandRequest;

    public MedicineDemandQueue() {
        demandRequest = new ArrayList<MedicineDemandWorkRequest>();
    }

    public ArrayList<MedicineDemandWorkRequest> getDemandList() {
        return demandRequest;
    }
    public void addDemandRequest(MedicineDemandWorkRequest demandReq) {
        this.demandRequest.add(demandReq);
    }
            public void removeDemandRequest(MedicineDemandWorkRequest req) {
        demandRequest.remove(req);
    }
    
        public void updateDemandRequest(MedicineDemandWorkRequest req,List<MedicineDemandWorkRequest> demandRequest){
            for(MedicineDemandWorkRequest work: demandRequest){
                if(work.getId().equals(req.getId())){
                   work=req;
                }
            }
        }
        public MedicineDemandWorkRequest getDemandRequest(MedicineDemandWorkRequest w){
            for(MedicineDemandWorkRequest work: demandRequest){
                if(work.getId().equals(w.getId())){
                    return work;
                }
            }
            return null;
        }
    
}