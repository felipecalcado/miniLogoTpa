/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

/**
 *
 * @author Anselmo
 */
public class RecursiveDescentSyntaticAnalyzerTest {
        
        
    
    
    public RecursiveDescentSyntaticAnalyzerTest(){
    
    }
    
    public void run(String fileName){
    
        ISource context = new FileSource(fileName);        
        IReservedWords rws = new ReservedWords();
        ISymbolTable st = new SymbolTable();
        IConstList<Integer> nums = new ConstList();
        ILexicalAnalyzer la = new LexicalAnalyzer(context,rws,nums,st);
        ISyntaticAnalyzer rdsa = new RecursiveDescentSyntaticAnalyzer(context, rws, nums, st, la);
        rdsa.parse();
        
    }
}
