import javax.swing.*;

public abstract class Character extends JPanel {
    public int locatex;
    public int locatey;
    public boolean visible;
    public String view;

    public Character(int x, int y,boolean vis,String view){
        this.locatex=x;
        this.locatey=y;
        this.visible=vis;
        this.view=view;




        }

    }


