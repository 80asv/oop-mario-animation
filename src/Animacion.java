import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Graphics;


public class Animacion extends JComponent implements Runnable{
    static JPanel panel;
    static Thread hilo;
    boolean ejecutar = false;
    int numero = 0;

    public Animacion(JPanel panel){
        Animacion.panel = panel;
        hilo = new Thread(this);
        hilo.start();
        setVisible(true);
    }

    public void paint(Graphics g){
        ImageIcon imagen = new ImageIcon(getClass().getResource("images/mario/"+numero+".png"));
        g.drawImage(imagen.getImage(), 0, 0, 164, 164, null);
    }


    @Override
    public void run() {
        try {
            while (ejecutar){
                numero++;

                if(numero == 11){
                    numero = 0;
                }

                repaint();

                Thread.sleep(90);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }

    public void start(){
        ejecutar = true;
        new Thread(this).start();
    }

    public void stop(){
        numero = 0;
        ejecutar = false;
        panel.repaint();
    }

    public int getNumero() {
        return numero;
    }

    public static Thread getHilo() {
        return hilo;
    }
}
