package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static game.Gui.Mpanel;
import static game.Gui.main_frame;


public class Gui_actionlistener extends Rooms implements ActionListener, KeyListener {


    public void actionlistner(){

        main_frame.addKeyListener(this);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE){

            if (GPanel != null){
                Mpanel.setVisible(true);
                GPanel.setVisible(false);
            }

        };

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
