/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.Set;
import java.util.Stack;
import controller.Controller;
import interfaces.IController;

/**
 *
 * @author Anselmo
 */
public class RecursiveDescentSyntaticAnalyzer implements ISyntaticAnalyzer{
    private  ISource source;
    private  IReservedWords rws;
    private  ISymbolTable st;
    private  IRoutineTable rt;
    private  Stack<IContext> contextStack;
    private  IConstList<Integer> nums;
    ILexicalAnalyzer la;
    Firsts allFirsts;
    Token currentToken;
    int secondaryToken;
	
	RecursiveDescentSyntaticAnalyzer(ISource source, IReservedWords rws, 
                                     IConstList<Integer> nums, ISymbolTable st, ILexicalAnalyzer la){
        
        this.rws = rws;
        this.nums = nums;
        this.st = st;        
        this.la = la;
        allFirsts = new Firsts();
        rt = new RoutineTable();
        contextStack = new Stack<IContext>();
        setContext(' ',source);
		
        
    }
    
    
    private void setContext(char nextChar, ISource source){
       this.source = source;
       la.setContext(this.source,nextChar,Token.UNKNOWN,-1);
       currentToken = la.nextToken();
       secondaryToken = la.getSecondaryToken();
    }    
   
    
    private void restoreContext(IContext context){
       this.source = context.getSource();
       this.currentToken = context.getCurrentToken();
       this.secondaryToken = context.getSecondaryToken();
       la.setContext(this.source,context.getNextChar(),currentToken,secondaryToken);
    }    
    
    private void sintaxeError(Token t){
        System.out.println("Error: sintaxe error");
    }
    
    private int expect(Token token){
        int previousSecondaryToken = la.getSecondaryToken();
        if (currentToken == token){
            previousSecondaryToken = la.getSecondaryToken();
            // Update Tokens
            currentToken = la.nextToken();
            secondaryToken = la.getSecondaryToken();
        }
        else
            sintaxeError(token);
        
        return previousSecondaryToken;
    }
    
    @Override
    public void parse(){
        parseProgram();
    }
    
    private void parseProgram(){
        Set<Token> firstsSet = allFirsts.get("program");
        if (firstsSet.contains(currentToken)){
            parseListRoutineDecls();
            parseListCommands();
        }
            
        expect(Token.EOF);
    }
    
    private void parseListRoutineDecls(){
        Set<Token> firstsSet = allFirsts.get("listRoutineDecls");
        if (firstsSet.contains(currentToken)){
            parseRoutineDecls();
        } 
    }
        
    private void parseRoutineDecls(){
        Set<Token> firstsSet = allFirsts.get("listRoutineDecls");
        if (firstsSet.contains(currentToken)){
            parseTo();
            parseListRoutineDecls();
        }
    }
    
    private void parseListCommands(){
        Set<Token> firstsSet = allFirsts.get("command");
        if (firstsSet.contains(currentToken)){
            parseCommand();
            parseListCommandsA();
        } 
    }
    
    private String learnListCommands(){
        String s = "";
        Set<Token> firstsSet = allFirsts.get("command");
        if (firstsSet.contains(currentToken)){
            s = s + learnCommand();
            s = s + learnListCommandsA();
        } 
        return s;
    }
    
    private void parseListCommandsA(){
        Set<Token> firstsSet = allFirsts.get("listCommandsA");
        if (firstsSet.contains(currentToken)){
            parseListCommands();
        }
    }
    
    private String learnListCommandsA(){
        String s = "";
        Set<Token> firstsSet = allFirsts.get("listCommandsA");
        if (firstsSet.contains(currentToken)){
            s = s + learnListCommands();
        }
        return s;
    }
    
    private String learnCommand(){
        String s="";
        Set<Token> firstsSet = allFirsts.get("listCommandsA");
        if (firstsSet.contains(currentToken)){
            switch(currentToken){
                case FORWARD:
                    s = s + learnForward();
                break;
                case BACKWARD:
                    s = s + learnBackward();
                break;
                case LEFT:
                    s = s + learnLeft();
                break;
                case RIGHT:
                    s = s + learnRight();
                break;
                case PENUP:
                    s = s + learnPenUp();
                break;
                case PENDOWN:
                    s = s + learnPenDown();
                break;
                case PENCOLOR:
                    s = s + learnPenColor();
                break;
                case SHOWTURTLE:
                    s = s + learnShowTurtle();
                break;
                case HIDETURTLE:
                    s = s + learnHideTurtle();
                break;        
                case CLEARSCREEN:
                    s = s + learnClearScreen();
                break;    
                case REPEAT:
                    s = s + learnRepeat();
                break;
                case ID:
                    s = s + st.searchSymbol(secondaryToken)+";";
                break;
                    
            }   
        }
        return s;
    }
    
    private void parseCommand(){
        Set<Token> firstsSet = allFirsts.get("listCommandsA");
        if (firstsSet.contains(currentToken)){
            switch(currentToken){
                case FORWARD:
                    parseForward();
                break;
                case BACKWARD:
                    parseBackward();
                break;
                case LEFT:
                    parseLeft();
                break;
                case RIGHT:
                    parseRight();
                break;
                case PENUP:
                    parsePenUp();
                break;
                case PENDOWN:
                    parsePenDown();
                break;
                case PENCOLOR:
                    parsePenColor();
                break;
                case SHOWTURTLE:
                    parseShowTurtle();
                break;
                case HIDETURTLE:
                    parseHideTurtle();
                break;        
                case CLEARSCREEN:
                    parseClearScreen();
                break;    
                case REPEAT:
                    parseRepeat();
                break;  
                case ID:
                    parseID();
                break;   
            }   
        }
    }
    
    private String learnForward(){
        expect(Token.FORWARD);
        int numSecondaryToken = expect(Token.NUM);
        int num = nums.getConst(numSecondaryToken);
        expect(Token.SEMI_COMMA);
        return "forward "+num+";";
    }
    
    private void parseForward(){
        expect(Token.FORWARD);
        int numSecondaryToken = expect(Token.NUM);
        int num = nums.getConst(numSecondaryToken);
        expect(Token.SEMI_COMMA);
        System.out.println("Command:" + "forward " +num);
		Controller.addCmdLista("forward " + num);
    }

    private String learnBackward(){
        expect(Token.BACKWARD);
        int numSecondaryToken = expect(Token.NUM);
        int num = nums.getConst(numSecondaryToken);
        expect(Token.SEMI_COMMA);
        return "backward " +num + ";";
    }

    private void parseBackward(){
        expect(Token.BACKWARD);
        int numSecondaryToken = expect(Token.NUM);
        int num = nums.getConst(numSecondaryToken);
        expect(Token.SEMI_COMMA);
        System.out.println("Command:" + "backward " +num);
		Controller.addCmdLista("backward " + num);
    }

    private String learnLeft(){
        expect(Token.LEFT);
        int numSecondaryToken = expect(Token.NUM);
        int num = nums.getConst(numSecondaryToken);
        expect(Token.SEMI_COMMA);
        return "left " +num+";";
    }

    private void parseLeft(){
        expect(Token.LEFT);
        int numSecondaryToken = expect(Token.NUM);
        int num = nums.getConst(numSecondaryToken);
        expect(Token.SEMI_COMMA);
        System.out.println("Command:" + "left " +num);
		Controller.addCmdLista("left " + num);
    }

    
    private String learnRight(){
        expect(Token.RIGHT);
        int numSecondaryToken = expect(Token.NUM);
        int num = nums.getConst(numSecondaryToken);
        expect(Token.SEMI_COMMA);
        return "right " + num + ";";
    }

    private void parseRight(){
        expect(Token.RIGHT);
        int numSecondaryToken = expect(Token.NUM);
        int num = nums.getConst(numSecondaryToken);
        expect(Token.SEMI_COMMA);
        System.out.println("Command:" + "right " +num);
		Controller.addCmdLista("right " + num);
    }

    
    private String learnPenUp(){
        expect(Token.PENUP);
        expect(Token.SEMI_COMMA);        
        return "penup " + ";";
    }
    
    private void parsePenUp(){
        expect(Token.PENUP);
        expect(Token.SEMI_COMMA);        
        System.out.println("Command:" + "penup ");
		Controller.addCmdLista("penup " + 0);
    }
    
    private String learnPenDown(){
        expect(Token.PENDOWN);
        expect(Token.SEMI_COMMA);        
        return "pendown " + ";";
    }
    
    private void parsePenDown(){
        expect(Token.PENDOWN);
        expect(Token.SEMI_COMMA);
        System.out.println("Command:" + "pendown ");
		Controller.addCmdLista("pendown " + 0);
    }
    
    private String learnPenColor(){
        expect(Token.PENCOLOR);
        int numSecondaryToken = expect(Token.NUM);
        int num = nums.getConst(numSecondaryToken);
        expect(Token.SEMI_COMMA);
        return "pencolor " + num+";";
    }
    
    private void parsePenColor(){
        expect(Token.PENCOLOR);
        int numSecondaryToken = expect(Token.NUM);
        int num = nums.getConst(numSecondaryToken);
        expect(Token.SEMI_COMMA);
        System.out.println("Command:" + "pencolor " + num);
		Controller.addCmdLista("pencolor " + num);
    }
   
    private String learnShowTurtle(){
        expect(Token.SHOWTURTLE);
        expect(Token.SEMI_COMMA);
        return "showturtle" + ";";
    }    
    
    private void parseShowTurtle(){
        expect(Token.SHOWTURTLE);
        expect(Token.SEMI_COMMA);
        System.out.println("Command:" + "showturtle ");
		Controller.addCmdLista("showturtle " + 0);
    }    
    
    private String learnHideTurtle(){
        expect(Token.HIDETURTLE);
        expect(Token.SEMI_COMMA);
        return "hideturtle"+";";
    }    
    
    
    private void parseHideTurtle(){
        expect(Token.HIDETURTLE);
        expect(Token.SEMI_COMMA);
        System.out.println("Command:" + "hideturtle");
		Controller.addCmdLista("hideturtle " + 0);
    }    

    
    private String learnClearScreen(){
        expect(Token.CLEARSCREEN);
        expect(Token.SEMI_COMMA);
        return "clearscreen "+";";
    }

    private void parseClearScreen(){
        expect(Token.CLEARSCREEN);
        expect(Token.SEMI_COMMA);
        System.out.println("Command:" + "clearscreen ");
		Controller.addCmdLista("clearscreen " + 0);
    }
    
    private String learnRepeat(){
        expect(Token.REPEAT);
        int numSecondaryToken = expect(Token.NUM);
        int num = nums.getConst(numSecondaryToken);
        expect(Token.LEFT_BRACES);
        String s = learnListCommands();
        expect(Token.RIGHT_BRACES);
        expect(Token.SEMI_COMMA);
 
        return "repeat " + num + "{" + s + "}"+";";        
    }
    
    private void parseRepeat(){
        expect(Token.REPEAT);
        int numSecondaryToken = expect(Token.NUM);
        int num = nums.getConst(numSecondaryToken);
        expect(Token.LEFT_BRACES);
        String s = learnListCommands();
        expect(Token.RIGHT_BRACES);
        expect(Token.SEMI_COMMA);
        
        String[] commandLines = s.split("\n");
        IContext context = new Context(source,la.getCurrentChar(),currentToken,la.getSecondaryToken());
        contextStack.push(context);
        
        for(int i=0;i<num;i++){
            source = new StringSource(commandLines);
            setContext(' ',source);
            parseListCommands();
        }
        
        context = contextStack.pop();
        restoreContext(context);
    }

    private void parseTo(){
        expect(Token.TO);
        int idSecondaryToken = expect(Token.ID);
        String routineName = st.searchSymbol(idSecondaryToken);
        expect(Token.LEFT_BRACES);
        String s = learnListCommands();
        rt.addRoutine(routineName,s);
        expect(Token.RIGHT_BRACES);
        expect(Token.SEMI_COMMA);
         
    }
    
    private void parseID(){
        int idSecondaryToken = expect(Token.ID);
        // Do jeito que esta assume que os IDs sao rotina, mas para um gramática
        // mais completa isso não é verdade
        String routineName = st.searchSymbol(idSecondaryToken);
        expect(Token.SEMI_COMMA);
        
        String s = rt.getCode(routineName);
        String[] code = s.split("\n");

        IContext context = new Context(source,la.getCurrentChar(),currentToken,
                secondaryToken);

        contextStack.push(context);

        source = new StringSource(code);
        setContext(' ',source);
        parseListCommands();
        context = contextStack.pop();
        restoreContext(context);
    }

}
