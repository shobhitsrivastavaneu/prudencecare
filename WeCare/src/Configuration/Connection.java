/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Configuration;

/**
 *
 * @author rishabagarwal
 */
public class Connection {
    
    
    public static DatabaseConfiguration configure(){
        DatabaseConfiguration dc = DatabaseConfiguration.getInstance();
        return dc;
    }
    
}
