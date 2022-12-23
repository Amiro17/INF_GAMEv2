package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

public class Overlay extends JPanel {


    JProgressBar pbar;



    Settings settings = new Settings();

    int width = settings.width;
    int height = settings.height;

    public void main(JPanel current_panel){
        stamina_bar(current_panel);
        inventory(current_panel);

    }

    int pic_w = 50;
    int pic_h = 50;

    public void stamina_bar(JPanel currentpanel){


        pbar = new JProgressBar();


        pbar.setBounds(50,50,200,20);

        pbar.setValue(80);


        currentpanel.add(pbar);

    }

    public void inventory(JPanel currentpanel){

        Image pic_scaled = null;
        try{
            BufferedImage pic = ImageIO.read(new File(new File("/game/files/inventory.png").getPath()));
            pic_scaled = pic.getScaledInstance(pic_w, pic_h, Image.SCALE_DEFAULT);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        JLabel picLabel = new JLabel(new ImageIcon(pic_scaled));
        picLabel.setBounds(40,height - (pic_h*3) , pic_w, pic_h);
        currentpanel.add(picLabel);



    }



    public void right_arrow(JPanel currentpanel, JPanel next_panel){                // right arrow



        Image arrow_pic_scaled = null;
        try{
            BufferedImage arrow_pic = ImageIO.read(new File(new File("/game/files/right_arrow.png").getPath()));
            arrow_pic_scaled = arrow_pic.getScaledInstance(pic_w, pic_h, Image.SCALE_DEFAULT);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        JLabel picLabel = new JLabel(new ImageIcon(arrow_pic_scaled));
        picLabel.setBounds(width - (pic_w*2), height/2 - 60, pic_w, pic_h);

        currentpanel.add(picLabel);


        picLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {

                currentpanel.setVisible(false);
                next_panel.setVisible(true);
                Spieler.main();

            }
        });


    }

    public void left_arrow(JPanel currentpanel, JPanel next_panel){                // left_arrow



        Image arrow_pic_scaled = null;
        try{
            BufferedImage arrow_pic = ImageIO.read(new File(new File("/game/files/left_arrow.png").getPath()));
            arrow_pic_scaled = arrow_pic.getScaledInstance(pic_w, pic_h, Image.SCALE_DEFAULT);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        JLabel picLabel = new JLabel(new ImageIcon(arrow_pic_scaled));
        picLabel.setBounds(pic_w-15, height/2 - 60, pic_w, pic_h);

        currentpanel.add(picLabel);


        picLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                currentpanel.setVisible(false);
                next_panel.setVisible(true);
                Spieler.main();
            }
        });


    }


}
