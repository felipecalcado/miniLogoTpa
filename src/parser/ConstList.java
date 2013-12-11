/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Anselmo
 */
public class ConstList<T> implements IConstList<T> {
    private List<T> list; 
            
    public ConstList(){
        list = new ArrayList<>();
    }
    
    @Override
    public int addConst(T c) {
        for (int i=0;i<list.size();i++){
            if (list.get(i).equals(c)){
                return i;
            }
        }
        list.add(c);        
        return list.size()-1;
    }

    @Override
    public T getConst(int index) {
        return list.get(index);
        /* for (int i=0;i<list.size();i++){
            if (list.get(i).equals(c)){
                return i;
            }
        }*/
    }
    
}
