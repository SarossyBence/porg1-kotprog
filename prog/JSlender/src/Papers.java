import javax.swing.*;

public class Papers extends Character{
    static ImageIcon icon = new ImageIcon("src/img/paper.png");
    public Papers(int x, int y, boolean vis, String view) {
        super(x, y, vis, view);
    }

    public static ImageIcon getIcon() {
        return icon;
    }
}
