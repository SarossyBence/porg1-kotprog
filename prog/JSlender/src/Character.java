import javax.swing.*;

public abstract class Character extends JPanel {
    public int locatex;
    public int locatey;
    public boolean visible;


    public void setLocatex(int locatex) {
        this.locatex = locatex;
    }

    public void setLocatey(int locatey) {
        this.locatey = locatey;
    }

    @Override
    public void setVisible(boolean visible) {
        this.visible = visible;
    }



    public int getLocatex() {
        return locatex;
    }

    public int getLocatey() {
        return locatey;
    }

    @Override
    public boolean isVisible() {
        return visible;
    }



    public Character(int x, int y, boolean vis){
        this.locatex=x;
        this.locatey=y;
        this.visible=vis;





        }

    }


