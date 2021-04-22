import javax.swing.*;
import java.util.Random;

public class Slenderman extends Character {
    static ImageIcon icon = new ImageIcon("src/img/slender.png");
    private Map current;
    Random random = new Random();
    int rx = random.nextInt(4);
    int ry = random.nextInt(4);

    public Slenderman(int x, int y, boolean vis,Map current) {
        super(x, y, vis);
        setVisible(false);
        this.current=current;

    }

    public static ImageIcon getIcon() {
        return icon;
    }

    public static void setIcon(ImageIcon icon) {
        Slenderman.icon = icon;
    }

    public void teleport(JLabel grid[][]){

    }
    public void come(JLabel grid[][]){
        grid[rx][ry].setIcon(icon);



    }
    public void catcs(){}
}
