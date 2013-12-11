/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

/**
 *
 * @author Anselmo
 */
public class LexicalAnalyzerTest {
    public LexicalAnalyzerTest(){
        
    }
    
    public void run(String fileName){
        ISource source = new FileSource(fileName);
        IReservedWords rws = new ReservedWords();
        ISymbolTable st = new SymbolTable();
        IConstList<Integer> nums = new ConstList();
        
        ILexicalAnalyzer la = new LexicalAnalyzer(source,rws,nums,st);
        
        Token token = la.nextToken();
        
        do{
          token = la.nextToken();
        }while (token!=Token.EOF);          
    }
}
