/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Admin;
import Business.Role.AmbulanceDriverRole;
import Business.Role.Doctor;
import Business.Role.HospitalStaffRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author parvathypillai
 */
public class AdminOrganization extends Organization{

     private String organizationType;
     
    public AdminOrganization(String organizationType) {
        super(Organization.Type.HospitalAdmin.getValue());
        this.organizationType = organizationType;
    }
     public String getOrganizationType(){
        return organizationType; 
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new Admin());
        roles.add(new Doctor());
        roles.add(new HospitalStaffRole());
        roles.add(new AmbulanceDriverRole());
        return roles;
    }
     
}
