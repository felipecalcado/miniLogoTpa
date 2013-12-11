/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.Scanner;

/**
 *
 * @author Anselmo
 */
public class StringSource implements ISource{
    String[] strings;
    private int charPosition;
    private String line;
    private int lineNumber;
    
    public StringSource(String[] lineStrings){
        strings = lineStrings;
        line = strings[0];
        lineNumber = 0;
        charPosition = 0;
    }
    
    
    @Override
    public String getCurrentLineString() {
        return line;
    }

    @Override
    public char nextChar() {
       char ch = ' ';
       if (charPosition>=line.length()){
           if (lineNumber<strings.length-1){
               lineNumber++;
               line = strings[lineNumber];
               charPosition = 0;
               ch = '\n';
           }
           else 
               ch = '$';
       }else
            ch = line.charAt(charPosition++);
       
       return ch;
    }

    @Override
    public void unGetChar() {
        charPosition--;
    }

    @Override
    public int getLineNumber() {
        return lineNumber;
    }

    @Override
    public int getCharPosition() {
        return charPosition;
    }
    
    
    
}
