/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.DiagnosticsOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import UserInterface.DiagnosticsAdmin.DiagnosticsAdminJPanel;

/**
 *
 * @author rishabagarwal
 */
public class DiagnosticsAdmin extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new DiagnosticsAdminJPanel(userProcessContainer, account,(DiagnosticsOrganization)organization,enterprise,business);
    }

    public String toString(){
        return "DiagnosticsAdmin";
    }   
    
}
