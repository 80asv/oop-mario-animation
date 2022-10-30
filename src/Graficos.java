import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class Graficos extends JComponent{
    static JPanel panel;

    public Graficos(JPanel panel){
        Graficos.panel = panel;
        setVisible(true);
    }

    @Override
    public void paint(Graphics g){
        ImageIcon floor = new ImageIcon(getClass().getResource("images/resources/floor.png"));
        // nubes
        g.setColor(Color.decode("#ebeff8"));
        g.fillRoundRect(10, 10, 200, 35, 50, 50);
        g.fillRoundRect(300, 50, 100, 25, 50, 50);
        g.fillRoundRect(20, 120, 100, 25, 50, 50);
        // cactus 01
        g.setColor(Color.decode("#039205"));
        g.fillRoundRect(300, 320, 50, 200, 50, 50);
            g.setColor(Color.decode("#0c0c0c"));
            g.fillRoundRect(315, 335, 6, 10, 50, 50);
            g.fillRoundRect(330, 335, 6, 10, 50, 50);
            
        // cactus 02
        g.setColor(Color.decode("#0fb711"));
        g.fillRoundRect(270, 350, 50, 150, 50, 50);
            g.setColor(Color.decode("#0c0c0c"));
            g.fillRoundRect(285, 365, 6, 10, 50, 50);
            g.fillRoundRect(300, 365, 6, 10, 50, 50);
        // cactus 03
        g.setColor(Color.decode("#5ab95b"));
        g.fillRoundRect(340, 360, 50, 150, 50, 50);
            g.setColor(Color.decode("#0c0c0c"));
            g.fillRoundRect(355, 375, 6, 10, 50, 50);
            g.fillRoundRect(370, 375, 6, 10, 50, 50);
        // suelo
        g.drawImage(floor.getImage(), 0, 462, 600, 115, null);
    }
}
