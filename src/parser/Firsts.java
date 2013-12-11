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
public class Firsts implements IFirsts {
    Map<String,Set<Token>> firstsMap;
    
    Firsts(){
        firstsMap = new HashMap<>();
        
        
        List<Token> allTokens =   Arrays.asList(Token.FORWARD,                                  
                                                Token.BACKWARD,
                                                Token.LEFT,
                                                Token.RIGHT,
                                                Token.PENUP,
                                                Token.PENDOWN,
                                                Token.HIDETURTLE,
                                                Token.SHOWTURTLE,
                                                Token.PENCOLOR,
                                                Token.CLEARSCREEN,
                                                Token.REPEAT,
                                                Token.TO,
                                                Token.RIGHT_BRACES,
                                                Token.LEFT_BRACES,
                                                Token.SEMI_COMMA,
                                                Token.ID,
                                                Token.NUM,
                                                Token.EOF,
                                                Token.UNKNOWN);
        
        List<Token> commandTokens = Arrays.asList(Token.FORWARD,                                  
                                                  Token.BACKWARD,
                                                  Token.LEFT,
                                                  Token.RIGHT,
                                                  Token.PENUP,
                                                  Token.PENDOWN,
                                                  Token.HIDETURTLE,
                                                  Token.SHOWTURTLE,
                                                  Token.PENCOLOR,
                                                  Token.CLEARSCREEN,
                                                  Token.REPEAT,
                                                  Token.ID);
        
       HashSet<Token> programFirsts = new HashSet<>(commandTokens);
       programFirsts.add(Token.TO);
       
       HashSet<Token> listRoutineDeclsFirsts = new HashSet<>();
       listRoutineDeclsFirsts.add(Token.TO);
      
       HashSet<Token> routineDeclsFirsts = new HashSet<>();
       routineDeclsFirsts.add(Token.TO);
       
        firstsMap.put("program", new HashSet<>(programFirsts));
        firstsMap.put("listRoutineDecls", new HashSet<>(listRoutineDeclsFirsts));
        firstsMap.put("routineDecls", new HashSet<>(routineDeclsFirsts));
        firstsMap.put("listCommands", new HashSet<>(commandTokens));
        firstsMap.put("listCommandsA", new HashSet<>(commandTokens));
        firstsMap.put("command", new HashSet<>(commandTokens));
    }
    public Set<Token> get(String nonTerminal){
        return firstsMap.get(nonTerminal);
    } 
}
