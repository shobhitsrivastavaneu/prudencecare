package Business.Enterprise;

import Business.Organization.OrganizationDirectory;
import java.util.ArrayList;

/**
 *
 * @author rishabagarwal
 */
public class EnterpriseDirectory {
    private ArrayList<Enterprise> enterpriseList;
   

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    
    public EnterpriseDirectory(){
        enterpriseList=new ArrayList<Enterprise>();
    }
    
    //Create enterprise
    public Enterprise createAndAddEnterprise(String name,Enterprise.EnterpriseType type){
        Enterprise enterprise=null;
        if(type==Enterprise.EnterpriseType.Hospital){
            enterprise=new HospitalEnterprise(name);
            enterpriseList.add(enterprise);
        }
         if(type==Enterprise.EnterpriseType.VaccineCompany){
            enterprise=new VaccineEnterprise(name);
            enterpriseList.add(enterprise);
        }
        if(type==Enterprise.EnterpriseType.Diagnostics){
            enterprise=new DiagnosticsEnterprise(name);
            enterpriseList.add(enterprise);
        }
        if(type==Enterprise.EnterpriseType.Dispensary){
            enterprise=new DispensaryEnterprise(name);
            enterpriseList.add(enterprise);
        }
          if(type==Enterprise.EnterpriseType.Insurance){
            enterprise=new InsuranceEnterprise(name);
            enterpriseList.add(enterprise);
        }
        if(type==Enterprise.EnterpriseType.FDA){
            enterprise=new FDAEnterprise(name);
            enterpriseList.add(enterprise);
        }
        if(type==Enterprise.EnterpriseType.DrugManufacturer){
            enterprise=new MedicineManufacturingEnterprise(name);
            enterpriseList.add(enterprise);
        }        
        return enterprise;
    }

   //Remove enterprise
    public void removeEnterprise(Enterprise enterprise){
        enterpriseList.remove(enterprise);
                }
}