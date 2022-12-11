
package Business.Enterprise;

import Business.Essentials.MedicineCatalog;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author rishabagarwal
 */
public class MedicineManufacturingEnterprise extends Enterprise {
    private MedicineCatalog medicineCatalog;
    public MedicineManufacturingEnterprise(String name){
        
        super(name,Enterprise.EnterpriseType.DrugManufacturer);
        medicineCatalog=new MedicineCatalog();
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

    public MedicineCatalog getMedicineCatalog() {
        return medicineCatalog;
    }

    public void setMedicineCatalog(MedicineCatalog medicineCatalog) {
        this.medicineCatalog = medicineCatalog;
    }


}
