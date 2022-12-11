package Business.Organization;

import Business.Role.DiagnosticsAdmin;
import Business.Role.DiagnosticsCrew;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author rishabagarwal
 */

public class DiagnosticsOrganization extends Organization{

    private String organizationType;

    public DiagnosticsOrganization(String organizationType) {
        super(Organization.Type.DiagnosticsAdmin.getValue());
        this.organizationType = organizationType;
    }
    
    public String getOrganizationType(){
        return organizationType; 
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new DiagnosticsAdmin());
        roles.add(new DiagnosticsCrew());
        return roles;
    }
     
}