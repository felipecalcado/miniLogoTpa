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
public class SymbolTable implements ISymbolTable{
    private Map<String,Integer> symbols;
    private Map<Integer,String> invSymbols;
    private static int secondaryToken;
    
    public SymbolTable(){
        symbols = new HashMap<>();
        invSymbols = new HashMap<>();
        secondaryToken = -1;
    }

    @Override
    public int searchSymbol(String name) {
        if (symbols.containsKey(name)){
            return symbols.get(name);
        }
        else{
            secondaryToken++;
            symbols.put(name,secondaryToken);
            invSymbols.put(secondaryToken, name);
            
            return secondaryToken;         
        }
    }
    
    public String searchSymbol(int secondaryToken) {
       return invSymbols.get(secondaryToken);
    }
}
