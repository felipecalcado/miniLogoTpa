package model;

import java.util.ArrayList;

/**
 *  PADRÃO OBSERVER: ESSA CLASSE É O SUJEITO
 *
 * @author Anselmo
 */
public class Turtle extends Observado{
	
    private Vector2D<Integer> pos;
    private double angle;
    private boolean isVisible;
    private boolean isPenUp;
	
	private String comando;
	private int n;
	
	public final int X_INICIAL = 0;
	public final int Y_INICIAL = 0;
	
	
    public Turtle () {
        pos = new Vector2D(X_INICIAL,Y_INICIAL);
        angle = 0.0;
        isVisible = true;
		observadores = new ArrayList<>();
    }

    public void forward(int n) {
		setParams("forward", n);
		notifica();
		// atualiza posicao da tartaruga
		pos.setX(pos.getX() + n);
		pos.setY(pos.getY() + n);
    }

    public void backward(int n) {

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
	
	public int getPosX() {
		return pos.getX();
	}
	
	public int getPosY() {
		return pos.getY();
	}

	private void setParams(String comando, int n) {
		this.comando = comando;
		this.n = n;
	}
	
	public String getCmd(){
		return comando;
	}
	
	public int getN(){
		return n;
	}

	
}

