
package game;

public class Main{


    public static void main(String[] args) {

        Settings settings = new Settings();
        Gui gui = new Gui();
        Gui_actionlistener act = new Gui_actionlistener();
        gui.main();
        act.actionlistner();

    }
}