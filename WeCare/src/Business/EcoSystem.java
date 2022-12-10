
package Business;

import Business.Doctor.DoctorDirectory;
import Business.Essentials.ProductCatalog;
import Business.Insurance.InsuranceDirectory;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Patient.Patient;
import Business.Patient.PatientDirectory;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author rishabagarwal
 */
public class EcoSystem extends Organization{
    
    private static EcoSystem business;
    private ArrayList<Network> networkList;
    private PatientDirectory patientDirectory;
    private InsuranceDirectory InsuranceDirectory;
    private ProductCatalog productcatalog;
    private DoctorDirectory doctorDirectory;
    public static EcoSystem getInstance(){
        if(business==null){
            business=new EcoSystem();
        }
        return business;
    }
    
    public Network createAndAddNetwork(){
        Network network=new Network();
        networkList.add(network);
        return network;
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList=new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
    private EcoSystem(){
        super(null);
        patientDirectory=new PatientDirectory();
        InsuranceDirectory= new InsuranceDirectory();
        productcatalog=new ProductCatalog();
        doctorDirectory= new DoctorDirectory();
        networkList=new ArrayList<Network>();
    }

    public DoctorDirectory getDoctorDirectory() {
        System.out.println("Business.EcoSystem.getDoctorDirectory()"+ doctorDirectory);
        return doctorDirectory;
    }

    public void setDoctorDirectory(DoctorDirectory doctorDirectory) {
        this.doctorDirectory = doctorDirectory;
    }

    public static EcoSystem getBusiness() {
        return business;
    }

    public static void setBusiness(EcoSystem business) {
        EcoSystem.business = business;
    }

    public InsuranceDirectory getInsuranceDirectory() {
        return InsuranceDirectory;
    }

    public void setInsuranceDirectory(InsuranceDirectory InsuranceDirectory) {
        this.InsuranceDirectory = InsuranceDirectory;
    }

    public PatientDirectory getPatientDirectory() {
        return patientDirectory;
    }

    public void setPatientDirectory(PatientDirectory patientDirectory) {
        this.patientDirectory = patientDirectory;
    }
    

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    
    public ProductCatalog getProductCatalog() {
        return productcatalog;
    }

    public void setProductCatalog(ProductCatalog vaccineDirectory) {
        this.productcatalog = vaccineDirectory;
    }


 
    
    public boolean checkIfUserIsUnique(String userName){
        if(!this.getUserAccountDirectory().checkIfUsernameIsUnique(userName)){
            return false;
        }
        for(Network network:networkList){
            
        }
        return true;
    }
}
