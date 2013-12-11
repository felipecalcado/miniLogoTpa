/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anselmo
 */
public class FileSource implements ISource{
    private Scanner lineScanner;
    private int charPosition;
    private String line;
    private int lineNumber;
            
    public FileSource(String fileName){
        try {
            File file = new File(fileName);
            lineScanner = new Scanner(file);
            line = lineScanner.nextLine(); 
            lineNumber = 1;
            charPosition = 0;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileSource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public char nextChar() {
        char ch = ' ';
        if (charPosition>=line.length()){
           if (lineScanner.hasNext()){
               line = lineScanner.nextLine();
               lineNumber++;
               charPosition = 0;
               ch = '\n';
           }
           else
               ch = '$';
        }
        else
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

    @Override
    public String getCurrentLineString() {
        return line;
    }
    
}
