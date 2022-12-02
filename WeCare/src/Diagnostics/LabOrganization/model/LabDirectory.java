/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Diagnostics.LabOrganization.model;

import java.util.ArrayList;

/**
 *
 * @author parvathypillai
 */
public class LabDirectory {
    
    private ArrayList<Lab> labDirectory;
    
    
    public LabDirectory(){
        this.labDirectory = new ArrayList();
    }
    
    public ArrayList<Lab> getLabDirectory(){
        return labDirectory;
    }
    
    public Lab addLab(){
        Lab lab = new Lab();
        labDirectory.add(lab);
        return lab;
    }

    public void deleteLab(Lab selectedLab){
        labDirectory.remove(selectedLab);    
    }
}