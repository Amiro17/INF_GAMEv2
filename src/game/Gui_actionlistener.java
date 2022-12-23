package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static game.Gui.Mpanel;
import static game.Gui.main_frame;


public class Gui_actionlistener extends Rooms implements ActionListener, KeyListener {

    static Boolean space_pressed = false;


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

        if (e.getKeyCode() == KeyEvent.VK_ENTER){
                space_pressed = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            if(Spieler.game_Progress > 0 && !Functions.timerON){
                Spieler.game_Progress = Spieler.game_Progress - 1;
                Spieler.main();
            }

        }

        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            if(!Functions.timerON){
                Spieler.game_Progress++;
                Spieler.main();
            }
        }



    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
