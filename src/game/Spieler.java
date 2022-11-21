package game;

import javax.swing.*;

public class Spieler {

    int min_stamina, stamina, max_stamina;


    Rooms rooms = new Rooms();
    static Functions functions = new Functions();

    public Spieler() {

        int stamina = 50;

        int gewicht = 50;

        int money = 0;

        int strength = 0;

        int player_level = 0;

        String[] tasche = {""};


        String current_room = "house";

    }

    static int n1 = 0;
    public static void main(){

        if (Rooms.GPanel.isVisible()) {
            functions.text_animation("LOLOLOLO", Rooms.GPanel, 500, 300, n1);
            n1 = n1 + 1;
        }
        else{
            functions.setlabelfree();
        }


    }











}
