package game;

import java.io.File;

public class Settings {



        public boolean bg_music = true;


        final int width = 1000;
        final int height = 800;

        Functions functions = new Functions();

        public void settings(){
            if (bg_music){
                File file = new File("src\\game\\files\\bg_music.wav");
                String path = file.getPath();
                functions.mp3_player(path, -20);
            }
            else{
                functions.clip.stop();
            }
        }

}
