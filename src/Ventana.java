import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JToggleButton;

public class Ventana extends JFrame {
    JPanel panel;
    Animacion animacion;
    Semaforo semaforo;

    public Ventana(){
        setSize(450, 580);
        setTitle("Ventana de animacion");
        setLocationRelativeTo(null);
        setResizable(false);
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void iniciarComponentes(){
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        panel.setBackground(Color.decode("#acd4f8"));
        panel.add(iniciarBoton());
        panel.add(iniciarAnimacion());
        panel.add(iniciarSemaforo());
        panel.add(iniciarGraficos());
    }

    public JToggleButton iniciarBoton(){
        JToggleButton btnCorrer = new JToggleButton("Correr");
        ActionListener escuchador = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(btnCorrer.isSelected()){
                    animacion.start();
                    btnCorrer.setText("Parar");
                } else {
                    animacion.stop();
                    btnCorrer.setText("Correr");
                }
            }
        };
        btnCorrer.addActionListener(escuchador);
        btnCorrer.setBounds(310, 400, 100, 40);
        return btnCorrer;
    }

    public Semaforo iniciarSemaforo(){
        semaforo = new Semaforo(panel);
        semaforo.setBounds(176, 100, 344, 363);
        return semaforo;
    }

    public Animacion iniciarAnimacion(){
        animacion = new Animacion(panel);        
        animacion.setBounds(20, 300, 250, 250);
        return animacion;
    }

    public Graficos iniciarGraficos(){
        Graficos g = new Graficos(panel);
        g.setBounds(0, 0, 450, 580);
        return g;
    }
    
    public static void main(String[] args) {
        new Ventana().setVisible(true);
    }
}
