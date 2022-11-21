package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;


public class Gui{

    public static JFrame main_frame;
    public static JPanel Mpanel;
    public static JLabel start_game, music_setting;


    Settings settings = new Settings();

    Rooms rooms = new Rooms();

    Spieler spieler = new Spieler();



    int width = settings.width;
    int height = settings.height;


    public int get_w(){
        return width;
    }

    public int get_h(){
        return height;
    }



    public void main() {

        settings.settings();
        main_frame = new JFrame("Game");
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_frame.setLayout(null);
        main_frame.setVisible(true);
        main_frame.setResizable(false);
        main_panel();
        rooms.main(main_frame);

    }

    int Lx = width / 2 - 120;
    int Ly = height / 2 - 50;

    public void main_panel() {                       // main panle game start with

        try {
            Mpanel = new ImagePanel(new ImageIcon(ImageIO.read(new File("C:\\Users\\amira\\IdeaProjects\\INF_GAME\\src\\game\\files\\MPanel_bg.jpg"))).getImage());

        } catch (IOException e) {
            e.printStackTrace();
        }

        main_frame.getContentPane().add(Mpanel);
        main_frame.pack();
        main_frame.setSize(width, height);

        int Lwidth = 250;
        int Lheight = 50;

        start_game = new JLabel("START GAME");
        start_game.setFont(new Font("MONOSPACED", Font.PLAIN, 40));
        start_game.setBounds(Lx, Ly, Lwidth, Lheight);

        start_game.setCursor(new Cursor(Cursor.HAND_CURSOR));
        start_game.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {


                Mpanel.setVisible(false);
                rooms.GPanel.setVisible(true);
                spieler.main();


            }
        });
        Mpanel.add(start_game);



        music_setting = new JLabel("Music on/off");
        music_setting.setFont(new Font("MONOSPACED", Font.PLAIN, 40));
        music_setting.setBounds(Lx, Ly+60, Lwidth+50, Lheight);

        music_setting.setCursor(new Cursor(Cursor.HAND_CURSOR));
        music_setting.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {

                if (settings.bg_music){


                    settings.bg_music = false;
                    settings.settings();


                } else {

                    settings.bg_music = true;
                    settings.settings();
                }


            }
        });
        Mpanel.add(music_setting);

    }





}


