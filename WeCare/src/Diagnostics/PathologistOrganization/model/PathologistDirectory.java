/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Diagnostics.PathologistOrganization.model;

import Diagnostics.LabOrganization.model.Lab;
import java.util.ArrayList;

/**
 *
 * @author rishabagarwal
 */
public class PathologistDirectory {
    
     private ArrayList<Pathologist> pathalogyDirectory;
    
    
    public PathologistDirectory(){
        this.pathalogyDirectory = new ArrayList();
    }
    
    public ArrayList<Pathologist> getPathologistDirectory(){
        return pathalogyDirectory;
    }
    
    public Pathologist addPathologist(){
        Pathologist pathologist = new Pathologist();
        pathalogyDirectory.add(pathologist);
        return pathologist;
    }

    public void deletePathologist(Pathologist selectedLab){
        pathalogyDirectory.remove(selectedLab);    
    }
    
    
    
    
}
