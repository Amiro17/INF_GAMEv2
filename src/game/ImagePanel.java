package game;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {

    private final Image imgscaled;

    Gui gui = new Gui();

    int h = gui.get_h() - 30;
    int w = gui.get_w() - 15;

    public ImagePanel(Image img) {

        imgscaled = img.getScaledInstance(w,h, Image.SCALE_DEFAULT);

        Dimension size = new Dimension(w, h);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    public void paintComponent(Graphics g) {

        g.drawImage(imgscaled, 0, 0, null);
    }
}
