
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.AdminOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.AmbulanceDriver.AmbulanceDriverJPanel;
import javax.management.relation.Role;
import javax.swing.JPanel;
import UserInterface.AmbulanceDriverJPanel.AmbulanceDriverWorkAreaJPanel;

/**
 *
 * @author rishabagarwal
 */
public class AmbulanceDriver extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new AmbulanceDriverJPanel(userProcessContainer, account,business,enterprise);
    }
    public String toString(){
        return "AmbulanceDriver";
    } 
    
}
