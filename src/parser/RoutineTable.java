/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Anselmo
 */
public class RoutineTable implements IRoutineTable {
    Map<String,String> rt;
    
    RoutineTable(){
        rt = new HashMap<>();
    }
    
    public void addRoutine(String name, String code){
        rt.put(name,code);
    }

    @Override
    public String getCode(String name) {
        return rt.get(name);
    }

}
