package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
//import userinterface.FDAWorkAreaJPanel.FDAWorkAreaJPanel; ////
import userinterface.ManufacturerRole.ManufacturerMainAreaJPanel;

/**
 *
 * @author parvathypillai
 */
public class ManufactureAdmin extends Role{
     @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new ManufacturerMainAreaJPanel(userProcessContainer, account,organization,enterprise,business);
    }
     public String toString(){
        return "ManufactureAdmin";
    }
}
