/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.DispensaryEnterprise;
import Business.Organization.LaboratoryOrganization;
import Business.Organization.Organization;
import Business.Organization.DispensaryOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import UserInterface.LabStaffRole.LabStaffWorkAreaJPanel;
import UserInterface.PharmaAdmin.PharmacyAdminPageJPanel;

/**
 *
 * @author parvathypillai
 */
public class DispensaryAdmin extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new DispensaryAdminPageJPanel(userProcessContainer, account,(DispensaryOrganization)organization,(DispensaryEnterprise) enterprise,business);
    }

    public String toString(){
        return "DispensaryAdmin";
    }  
    
}
