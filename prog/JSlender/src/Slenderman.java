import javax.swing.*;

public class Slenderman extends Character {
    static ImageIcon sicon = new ImageIcon("src/img/slender.png");


    public Slenderman(int x, int y, boolean vis) {
        super(x, y, vis);
        setVisible(false);
    }

    public static ImageIcon getIcon() {
        return sicon;
    }

    public void teleport(){}
    public void come(){}
    public void catcs(){}
}
