package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Gui{

    public static JFrame main_frame;
    public static JPanel Mpanel, GPanel;
    public static JLabel l;

    final int width = 900;
    final int height = 800;


    public int get_w(){
        return width;
    }

    public int get_h(){
        return height;
    }

    public void main() {

        main_frame = new JFrame("Game");
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_frame.setLayout(null);
        main_frame.setVisible(true);
        main_frame.setResizable(false);
        main_panel();


    }


    public void main_panel() {

        try {
            Mpanel = new ImagePanel(new ImageIcon(ImageIO.read(new File("C:\\Users\\amira\\IdeaProjects\\inf_game\\src\\game\\MPanel_bg.jpg"))).getImage());

        } catch (IOException e) {
            e.printStackTrace();
        }

        main_frame.getContentPane().add(Mpanel);
        main_frame.pack();
        main_frame.setSize(width, height);



        int Lx = width / 2 - 120;
        int Ly = height / 2 - 50;
        int Lwidth = 250;
        int Lheight = 50;

        l = new JLabel("START GAME");
        l.setFont(new Font("MONOSPACED", Font.PLAIN, 40));
        l.setBounds(Lx, Ly, Lwidth, Lheight);

        l.setCursor(new Cursor(Cursor.HAND_CURSOR));
        l.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {

                Mpanel.setVisible(false);
                game_panel();


            }
        });
        Mpanel.add(l);

    }


    public void game_panel() {


        int pic_w = 50;
        int pic_h = 50;
        int pic_x = 50;
        int pic_y = 50;


        Image pic_scaled = null;
        try {
            GPanel = new ImagePanel(new ImageIcon(ImageIO.read(new File("C:\\Users\\amira\\IdeaProjects\\inf_game\\src\\game\\bg2.png"))).getImage());


            BufferedImage pic = ImageIO.read(new File("C:\\Users\\amira\\IdeaProjects\\inf_game\\src\\game\\inventory.png"));
            pic_scaled = pic.getScaledInstance(pic_w, pic_h, Image.SCALE_DEFAULT);

        } catch (IOException e) {
            e.printStackTrace();
        }


        JLabel picLabel = new JLabel(new ImageIcon(pic_scaled));
        picLabel.setBounds(50, 50, pic_w, pic_h);
        GPanel.add(picLabel);


        main_frame.getContentPane().add(GPanel);
        main_frame.pack();
        main_frame.setSize(width, height);


    }

}


