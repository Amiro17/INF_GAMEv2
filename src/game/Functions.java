package game;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Functions {
    private int charIndex = 0;
    String labelText = "";

    public static JLabel text;
    Clip clip;

    public void text_animation(String anim_string, JPanel panel, int x, int y, int n){

        if (n == 0){
            text = new JLabel();
        }

        text.setForeground(Color.BLUE);
        text.setFont(new Font("MONOSPACED", Font.PLAIN, 30));
        text.setBounds(x,y,300,50);
        panel.add(text);



        labelText = "";
        charIndex = 0;
        mp3_player("C:\\Users\\amira\\IdeaProjects\\INF_GAME\\src\\game\\files\\typing.wav", -20);
        Timer timer = new Timer(100, e -> {

            labelText += anim_string.charAt(charIndex);
            text.setText(labelText);
            charIndex++;
            if (charIndex >= anim_string.length()) {
                ((Timer)e.getSource()).stop();
                clip.stop();
            }

            if (panel.isVisible() == false){
                ((Timer)e.getSource()).stop();
                clip.stop();
            }
        });
        timer.start();

    }

    public void setlabelfree(){
        if (text != null){
            text.setText("");
        }

    }

    public void mp3_player(String sound_path, int db_volume) {                // play mp3

        try{
            String soundName = sound_path;
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
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
