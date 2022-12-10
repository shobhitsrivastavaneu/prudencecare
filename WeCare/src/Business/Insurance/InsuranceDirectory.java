/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Insurance;

import java.util.ArrayList;

/**
 *
 * @author Shobhit
 */
public class InsuranceDirectory {
     private ArrayList<Insurance> insurancePolicyList;

    public InsuranceDirectory() {
        insurancePolicyList = new ArrayList();
    }

    public ArrayList<Insurance> getInsurancePolicyList() {
        return insurancePolicyList;
    }

    public void setInsurancePolicyList(ArrayList<Insurance> insurancePolicyList) {
        this.insurancePolicyList = insurancePolicyList;
    }
       public Insurance addInsurancePolicy(){
        Insurance c = new Insurance();
        insurancePolicyList.add(c);
        return c;
    }
    
    public void deleteInsurancePolicy(Insurance c){
        insurancePolicyList.remove(c);
    }
    
    public Insurance searchzipCode(String code){
           
        for(Insurance zip: insurancePolicyList){
            if(zip.getZipCode().equals(code))
                    {
                return zip;
            }
        }
        return null;
            }
    public Insurance searchAge(String age){
           
        for(Insurance zip: insurancePolicyList){
           if(zip.getAgeGroup().equals(age))          
                    {
                return zip;
            }
        }
        return null;
            }
    public Insurance searchMax(Double max){
           
        for(Insurance zip: insurancePolicyList){
            if(zip.getMonthlyPremium()<=max)
                    {
                return zip;
            }
        }
        return null;
            }
    public Insurance searchpolicy(String type){
           
        for(Insurance zip: insurancePolicyList){
            if(zip.getPolicyType().equals(type))
                    {
                return zip;
            }
        }
        return null;
            }
}
