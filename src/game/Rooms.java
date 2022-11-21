package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class Rooms{

    Overlay overlay = new Overlay();
    Functions functions = new Functions();


    public static JPanel  RoomP, GPanel, GymP;

    public Rooms(){

        String house, gym, arena, shop;

    }

    int width = 1000;
    int height = 800;

    int Lx = width / 2 - 120;
    int Ly = height / 2 - 50;



    public void main(JFrame main_frame){


        try {

            GPanel = new ImagePanel(new ImageIcon(ImageIO.read(new File("C:\\Users\\amira\\IdeaProjects\\INF_GAME\\src\\game\\files\\bg2.png"))).getImage());
            GPanel.setVisible(false);

            RoomP = new ImagePanel(new ImageIcon(ImageIO.read(new File("C:\\Users\\amira\\IdeaProjects\\INF_GAME\\src\\game\\files\\roombg.jpg"))).getImage());
            RoomP.setVisible(false);

            GymP = new ImagePanel(new ImageIcon(ImageIO.read(new File("C:\\Users\\amira\\IdeaProjects\\INF_GAME\\src\\game\\files\\gym_bg.png"))).getImage());
            GymP.setVisible(false);


        } catch (IOException e) {
            e.printStackTrace();
        }

        house(main_frame);
        GPanel(main_frame);
        gym(main_frame);


    }

    public void GPanel(JFrame main_frame) {

        main_frame.getContentPane().add(GPanel);
        main_frame.pack();
        main_frame.setSize(width, height);



        overlay.main(GPanel);
        overlay.right_arrow(GPanel, RoomP);
        overlay.left_arrow(GPanel, GymP);

    }

    public void house(JFrame main_frame){

        main_frame.getContentPane().add(RoomP);
        main_frame.pack();
        main_frame.setSize(width, height);

        JLabel text = new JLabel();
        text.setForeground(Color.BLUE);
        text.setFont(new Font("MONOSPACED", Font.PLAIN, 30));
        text.setBounds(Lx,Ly,300,50);
        RoomP.add(text);

        overlay.main(RoomP);
        overlay.left_arrow(RoomP, GPanel);


    }


    public void gym(JFrame main_frame){

        main_frame.getContentPane().add(GymP);
        main_frame.pack();
        main_frame.setSize(width, height);

        JLabel text = new JLabel();
        text.setForeground(Color.BLUE);
        text.setFont(new Font("MONOSPACED", Font.PLAIN, 30));
        text.setBounds(Lx,Ly,300,50);
        GymP.add(text);

        overlay.main(GymP);
        overlay.right_arrow(GymP, GPanel);


    }





}
