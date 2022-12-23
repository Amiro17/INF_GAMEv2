package game;

import javax.swing.*;
import java.awt.*;

public class    Spieler {

    int min_stamina, stamina, max_stamina;


    Rooms rooms = new Rooms();
    static Functions functions = new Functions();
    static Overlay overlay = new Overlay();

    public Spieler() {

        int stamina = 50;

        int gewicht = 50;

        int money = 0;

        int strength = 0;

        int player_level = 0;

        String[] tasche = {""};


        String current_room = "house";

    }


    static int game_Progress = 0;
    static int n = 0;

    public static void main(){


        System.out.println(game_Progress);

        if(n == 0){ Rooms.GPanel.setVisible(true); }

        if(game_Progress == 0 && Rooms.GPanel.isVisible()){
            //functions.text_animation("LOLOLOLO", Rooms.GPanel, 500, 300, game_Progress);
            functions.text_animation("Alsalam aleikum, <br/> in this game u start as laith and u have to get A CBUM", Rooms.GPanel, Color.GREEN , Font.ITALIC, 150, 420,800, 200, 37, true, true, n);
            n++;
        }

        if (game_Progress == 1 && Rooms.GPanel.isVisible()){
            functions.text_animation("HUGO IST EIN NETTER MENSCH HMHM", Rooms.GPanel, Color.blue ,Font.PLAIN, 205, 570,700, 200, 30, true, false, n);

        }




        if (game_Progress == 2 && Rooms.GymP.isVisible()){
            functions.text_animation(" game_Progress is 3", Rooms.GymP, Color.RED ,Font.PLAIN, 205, 570,700, 200, 30, true, true, n);

        }

        if (game_Progress == 3 && Rooms.RoomP.isVisible()){
            functions.text_animation(" game_Progress is 6", Rooms.RoomP, Color.RED ,Font.PLAIN, 205, 570,700, 200, 30, true,false , n);
            overlay.left_arrow(Rooms.RoomP, Rooms.GymP);
        }

        else{
            functions.setlabelfree();
        }


    }


    /// cheatcode: stroiden -> cbum
    ///











}
