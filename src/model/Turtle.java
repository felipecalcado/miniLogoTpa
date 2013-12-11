package model;

import java.awt.Color;
import java.awt.Graphics;
import view.Window;


/**
 *
 * @author Anselmo
 */
public class Turtle implements ITurtle{
	
    private Vector2D<Integer> pos;
    private double angle;
    private boolean isVisible;
    private boolean isPenUp;
	
	Graphics g;
	private final Color COR = Color.BLUE;
	

    public Turtle () {
        pos = new Vector2D(0,0);
        angle = 0.0;
        isVisible = true;
		// Desenha no canvas
		g = Window.getMyGraphics();
		g.setColor(COR);
    }

	@Override
    public void forward(int n) {
		System.out.println("Param: "+n+"\nXINICIAL: "+pos.getX()+"\nYINICIAL: "+pos.getY());
		g.drawLine(pos.getX(), pos.getY(), n, n);
    }

	@Override
    public void backward(int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	@Override
    public void left(double n) {
        angle += n;
        angle = angle; 
                
    }

	@Override
    public void right(double n) {
        angle -= n;
        angle = angle; 
    }

	@Override
    public void show() {
        isVisible = true;
    }

	@Override
    public void hide() {
        isVisible = false;
    }

	@Override
    public void penUp() {
        isPenUp = true;
    }

	@Override
    public void penDown() {
        isPenUp = false;
    }

	@Override
    public void penColor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	@Override
    public void clearScreen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

