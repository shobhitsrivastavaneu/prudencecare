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
import userinterface.AdministrativeRole.AdminWorkAreaJPanel;
import javax.swing.JPanel;
import userinterface.DiagnosticsCrew.DiagnosticsCrewJPanel;

/**
 *
 * @author rishabagarwal
 */
public class DiagnosticsCrew extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new DiagnosticsCrewJPanel(userProcessContainer, business,account,(DiagnosticsOrganization)organization,enterprise);
    
    }
    
    public String toString(){
        return "DiagnosticsCrew";
    }
    
    
}
