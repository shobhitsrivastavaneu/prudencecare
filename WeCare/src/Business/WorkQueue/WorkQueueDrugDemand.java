/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manasa
 */
//Pharmacy sends demand requests to manufacturing unit using this queue.
public class WorkQueueDrugDemand {
    
    private ArrayList<WorkRequestDrugDemand> demandRequest;

    public WorkQueueDrugDemand() {
        demandRequest = new ArrayList<WorkRequestDrugDemand>();
    }

    public ArrayList<WorkRequestDrugDemand> getDemandList() {
        return demandRequest;
    }
    public void addDemandRequest(WorkRequestDrugDemand demandReq) {
        this.demandRequest.add(demandReq);
    }
            public void removeDemandRequest(WorkRequestDrugDemand req) {
        demandRequest.remove(req);
    }
    
        public void updateDemandRequest(WorkRequestDrugDemand req,List<WorkRequestDrugDemand> demandRequest){
            for(WorkRequestDrugDemand work: demandRequest){
                if(work.getId().equals(req.getId())){
                   work=req;
                }
            }
        }
        public WorkRequestDrugDemand getDemandRequest(WorkRequestDrugDemand w){
            for(WorkRequestDrugDemand work: demandRequest){
                if(work.getId().equals(w.getId())){
                    return work;
                }
            }
            return null;
        }
    
}