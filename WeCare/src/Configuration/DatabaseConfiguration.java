/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Configuration;

/**
 *
 * @author rishabagarwal
 */
public class DatabaseConfiguration {
 
       private static DatabaseConfiguration dConfig;

    
    public static DatabaseConfiguration getInstance() {
        if (dConfig == null) {
            dConfig = new DatabaseConfiguration();
        }
        return dConfig;
    }
    
}
