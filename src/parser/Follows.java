/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Anselmo
 */
public class Follows {
    Map<String,Set<Token>> followsMap;
    
    Follows(){
        followsMap = new HashMap<>();
        
        
        
        List<Token> followTokens = Arrays.asList(Token.RIGHT_BRACES,Token.EOF);
        
       
        followsMap.put("listCommandsA", new HashSet<>(followTokens));
    }
    
    public Set<Token> get(String nonTerminal){
        return followsMap.get(nonTerminal);
    }     
}
