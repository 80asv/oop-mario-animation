import java.util.concurrent.ThreadLocalRandom;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;


public class Semaforo extends JComponent implements Runnable{
    static JPanel panel;
    static Thread hilo;

    private int numero = 0;
    boolean ejecutar = false;
    int[] tiempos = {1000, 1500, 2000, 8000, 2300, 3000, 4000, 500};

    public Semaforo(JPanel panel){
        Semaforo.panel = panel;
        hilo = new Thread(this);
        hilo.start();
        setVisible(true);
    }

    public void paint(Graphics g){
        ImageIcon imagen = new ImageIcon(getClass().getResource("images/semaforo/"+numero+".png"));
        g.drawImage(imagen.getImage(), 0, 0, 84, 94, null);
        g.setColor(Color.BLACK);
        g.fillRect(38, 92, 12, 400);
    }

    @Override
    public void run() {
        try {
            while (true){
                numero++;
                if(numero == 3){
                    numero = 0;
                }
                repaint();
                Thread.sleep(tiempos[numeroAleatorioEnRango(0, tiempos.length - 1)]);
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

    public static int numeroAleatorioEnRango(int minimo, int maximo) {
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }
}
