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
public class ReservedWords implements IReservedWords{
    private Map<String,Token> rws;
    
    public ReservedWords(){
        rws = new HashMap<>();
        rws.put("forward",Token.FORWARD);
        rws.put("backward",Token.BACKWARD);
        rws.put("right",Token.RIGHT);
        rws.put("left",Token.LEFT);
        rws.put("pendown",Token.PENDOWN);
        rws.put("penup",Token.PENUP);
        rws.put("hideturtle",Token.HIDETURTLE);
        rws.put("showturtle",Token.SHOWTURTLE);
        rws.put("pencolor",Token.PENCOLOR);
        rws.put("clearscreen",Token.CLEARSCREEN);
        rws.put("repeat",Token.REPEAT);
        rws.put("to",Token.TO);
    }

    @Override
    public Token searchKeyWord(String s) {
        if (rws.containsKey(s))
            return rws.get(s);
        else 
            return Token.ID;
    }
    
    
    
}
