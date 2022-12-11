/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Rider;
import Business.Role.Doctor;
import Business.Role.DispensaryAdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author parvathypillai
 */
public class DispensaryOrganization extends Organization{
    private String organizationType;
    public DispensaryOrganization(String organizationType) {
        super(Organization.Type.PharmacyAdmin.getValue());
        this.organizationType = organizationType;
    }
    
    public String getOrganizationType(){
        return organizationType; 
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new DispensaryAdminRole());
        roles.add(new Rider());
        return roles;
    }
     
}