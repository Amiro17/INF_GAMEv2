package game;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class Functions {
    private int charIndex = 0, n;
    String labelText = "";

    public static JLabel text;
    Clip clip;

    static boolean nextTextThisPage;

    static boolean timerON;


    public void text_animation(String anim_string, JPanel panel, Color color, int font, int x, int y, int w, int h, int text_size, boolean pressAble, boolean nextTextThisPage1, int n){         // set animation on text

        if (n == 0){
            text = new JLabel("<html> </html>");

        }

        panel.add(text);
        nextTextThisPage = nextTextThisPage1;

        text.setVisible(false);

        text.setForeground(color);
        text.setFont(new Font("MONOSPACED", font, text_size));
        text.setBounds(x,y,w,h);

        String anim_string1 = "<html>" + anim_string + "</html>";

        labelText = "";
        charIndex = 0;

        Timer timer = new Timer(40, e -> {

            labelText += anim_string1.charAt(charIndex);
            text.setText(labelText);
            charIndex++;
            timerON = true;

            if (charIndex == 6){
                text.setVisible(true);

                mp3_player("/game/files/typing.wav", -20);
            }

//            if (charIndex > 15){
//                if (anim_string.charAt(charIndex) == ' '){
//                    labelText += anim_string.charAt(charIndex) + System.lineSeparator();
//                }
//            }

            if (Gui_actionlistener.space_pressed){
                text.setText(anim_string1);
                ((Timer)e.getSource()).stop();
                clip.stop();
                timerON = false;
                Gui_actionlistener.space_pressed = false;
                if (pressAble){
                    labelPress(text);
                }

            }

            if (charIndex-7 >= anim_string.length()) {
                ((Timer)e.getSource()).stop();
                clip.stop();
                if (pressAble){
                    labelPress(text);
                }
                timerON = false;
            }

            if (!panel.isVisible()){
                ((Timer)e.getSource()).stop();
                clip.stop();
                timerON = false;
            }
        });
        timer.start();


    }

    public void setlabelfree(){
        if (text != null){
            text.setText("");
        }

    }


    public void labelPress(JLabel label){                     // Set Label pressable

        n =0;


        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {

                if (n == 0 ){
                    ++Spieler.game_Progress;
                    label.setVisible(false);
                    n++;
                    if (nextTextThisPage){

                        Spieler.main();
                    }

                }


            }

        });


    }

    public void mp3_player(String sound_path, int db_volume) {                // play mp3

        try{
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(new File(sound_path).getPath()));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            FloatControl gainControl =
                    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(db_volume);


            clip.start();

        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e){
            e.printStackTrace();
        }
    }






}
