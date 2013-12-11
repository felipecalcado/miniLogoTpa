package model;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Anselmo
 */
public class Turtle {
	
    private Vector2D pos;
    private double angle;
    private boolean isVisible;
    private boolean isPenUp;

    public Turtle() {
        pos = new Vector2D(0,0);
        angle = 0.0;
        isVisible = true;
    }

    public void forward(int n) {
        
    }

    public void backward(int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void left(double n) {
        angle += n;
        angle = angle; 
                
    }

    public void right(double n) {
        angle -= n;
        angle = angle; 
    }

    public void show() {
        isVisible = true;
    }

    public void hide() {
        isVisible = false;
    }

    public void penUp() {
        isPenUp = true;
    }

    public void penDown() {
        isPenUp = false;
    }

    public void penColor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void clearScreen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

