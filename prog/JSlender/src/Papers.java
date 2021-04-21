import javax.swing.*;

public class Papers extends Character{
    static ImageIcon icon = new ImageIcon("src/img/paper.png");
    public Papers(int x, int y, boolean vis) {
        super(x, y, vis);
    }

    public ImageIcon getIcon() {
        return icon;
    }
}
