/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * PROV. MODEL
 * 
 */
package mainApp;

/**
 *
 * @author Anselmo
 */
public class Vector2D<T> {
    private T x;
    private T y;

    public Vector2D(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }
   
}