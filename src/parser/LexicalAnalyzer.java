/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

/**
 *
 * @author Anselmo
 */
public class LexicalAnalyzer implements ILexicalAnalyzer{
    private char nextChar;
    private ISource source;
    private IReservedWords rws;
    private IConstList<Integer> nums;
    private ISymbolTable st;
    private Token token;
    private int secondaryToken;
    private boolean verbose;
    private int lineNumber;
    
    public LexicalAnalyzer(ISource source, IReservedWords rws, IConstList<Integer> nums, ISymbolTable st){
        setContext(source,' ',Token.UNKNOWN,-1);
        this.rws = rws;
        this.nums = nums;
        this.st = st;
        verbose = false;
        lineNumber = -1;
        
        if (verbose){
            printLineInfo();
        }
    }
    
    private void printTokenInfo(){
        if (token!=Token.UNKNOWN){
            System.out.print("Token:" + token + " ");
            if (token == Token.NUM || token == Token.ID){
                System.out.print("SecondaryToken:" + getSecondaryToken());
            }
            System.out.println();
        }
    }
    
    private void printError(){
        if (token == Token.UNKNOWN){
           System.out.println("Lexical Error:"+ "'" + nextChar + "'" +
                              "is not a valid symbol");
        }
    }
    
    private void printLineInfo(){
        if (lineNumber!=source.getLineNumber()){
           lineNumber = source.getLineNumber();
           System.out.println("\n"+source.getLineNumber() + ":" + source.getCurrentLineString());
       }
    }
    
    private void skipSpace(){
        while(Character.isWhitespace(nextChar)){
          nextChar = source.nextChar();
        }
    }
    
    private void skipComment(){
        do{
         if (nextChar == '/'){
            nextChar = source.nextChar();
            if (nextChar == '/'){
               do{
                  nextChar = source.nextChar();
               }while (nextChar!='\n' && nextChar!='$' );
            }
            skipSpace();
         } 
        }while(nextChar == '/');
    }
    
    @Override
    public Token nextToken() {
    // loop do estado inicial para pular os separadores
        skipSpace();
        skipComment();
       

        secondaryToken = -1;
        
        if(Character.isLetter(nextChar)){
          String text = "";
          do
          {
            text = text + nextChar;
            nextChar = source.nextChar();
          }
          while( Character.isLetterOrDigit(nextChar) || nextChar == '_' );
          
          token = rws.searchKeyWord( text );
          if (token == Token.ID){
              secondaryToken = st.searchSymbol(text);
          }
        }
        else{
            if( Character.isDigit(nextChar)){
                String numeral="";
                do {
                    numeral = numeral + nextChar;
                    nextChar = source.nextChar();
                }       
                while( Character.isDigit(nextChar) );
                
                token = Token.NUM;
                secondaryToken = nums.addConst(Integer.parseInt(numeral));
            }
            else{
                switch(nextChar){
                    
                    case '{':
                    nextChar = source.nextChar();
                    token = Token.LEFT_BRACES;
                    break;
                        
                    case '}':
                    nextChar = source.nextChar();
                    token = Token.RIGHT_BRACES;
                    break;
                        
                    case ';':
                    nextChar = source.nextChar();
                    token = Token.SEMI_COMMA;
                    break;       
                                                                        
                    case '$':
                    token = Token.EOF;
                    break;
                        
                    default:
                    token = Token.UNKNOWN;
                }
            }
        }
        
    if (verbose){
       printTokenInfo();
       printLineInfo();
       printError();
    }    
        
    return token;
   }

    @Override
    public int getSecondaryToken() {
        return secondaryToken;
    }

    @Override
    public void setContext(ISource source ,char nextChar, Token token, int secondaryToken) {
        this.nextChar = nextChar;
        this.token = token;
        this.secondaryToken = secondaryToken;
        this.source = source;
    }

    @Override
    public char getCurrentChar() {
        return nextChar;            
    }
}
