import javax.swing.*;

public class Slenderman extends Character {
    static ImageIcon icon = new ImageIcon("src/img/slender.png");


    public Slenderman(int x, int y, boolean vis, String view) {
        super(x, y, vis, view);
    }

    public static ImageIcon getIcon() {
        return icon;
    }

    public void teleport(){}
    public void come(){}
    public void catcs(){}
}
