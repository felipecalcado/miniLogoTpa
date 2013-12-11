package model;

/**
 *
 * @author Muta
 */
public interface ITurtle {
    public void forward(int n);
    public void backward(int n);
    public void left(double n);
    public void right(double n);
    public void show();
    public void hide();
    public void penUp();
    public void penDown();
    public void penColor();
    public void clearScreen();
}
