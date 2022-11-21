package game;

public class Settings {



        public boolean bg_music = true;


        final int width = 1000;
        final int height = 800;

        Functions functions = new Functions();

        public void settings(){
            if (bg_music){
                functions.mp3_player("C:\\Users\\amira\\IdeaProjects\\INF_GAME\\src\\game\\files\\bg_music.wav", -40);
            }
            else{
                functions.clip.stop();
            }
        }

}
