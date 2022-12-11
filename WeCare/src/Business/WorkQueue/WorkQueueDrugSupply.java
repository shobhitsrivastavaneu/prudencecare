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
//Manufacturing Unit fulfills pharmacy demands using this queue.
public class WorkQueueDrugSupply {
    
    private ArrayList<WorkRequestDrugSupply> supplyRequest;

    public WorkQueueDrugSupply() {
        supplyRequest = new ArrayList<WorkRequestDrugSupply>();
    }

    public ArrayList<WorkRequestDrugSupply> getSupplyList() {
        return supplyRequest;
    }
    public void addSupplyRequest(WorkRequestDrugSupply demandReq) {
        this.supplyRequest.add(demandReq);
    }
            public void removeSupplyRequest(WorkRequestDrugSupply req) {
        supplyRequest.remove(req);
    }
    
        public void updateSupplyRequest(WorkRequestDrugSupply req,List<WorkRequestDrugSupply> supplyRequest){
            for(WorkRequestDrugSupply work: supplyRequest){
                if(work.getId().equals(req.getId())){
                   work=req;
                }
            }
        }
        public WorkRequestDrugSupply getSupplyRequest(WorkRequestDrugSupply w){
            for(WorkRequestDrugSupply work: supplyRequest){
                if(work.getId().equals(w.getId())){
                    return work;
                }
            }
            return null;
        }
    
}