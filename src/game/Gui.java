package game;

import javax.swing.*;
import java.awt.*;


public class Gui {

    final int width = 900;
    final int height = 800;

    public void main(){
        JFrame main_frame = new JFrame( "Game");
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_frame.setSize(width,height);
        main_frame.setLayout(null);
        main_frame.setVisible(true);
        main_panel(main_frame);
    }


    public void main_panel(JFrame frame){
        JPanel Mpanel = new JPanel();
        Mpanel.setLayout(null);
        Mpanel.setBackground(Color.cyan);
        Mpanel.setSize(width, height);
        Mpanel.setVisible(false);
        frame.add(Mpanel);



    }


}
