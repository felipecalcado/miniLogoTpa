package interfaces;

// A CLASSE TURTLE VAI RECEBER A REQUISIÇÃO E VAI MUDAR DE ESTADO, ASSIM, GRAPHICS TURTLE TEM QUE SER NOTIFICADA E DESENHAR!

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
