import javax.swing.*;

public class Papers extends Character{
    public JLabel[][] grid;

    public static ImageIcon icon = new ImageIcon("src/img/paper.png");
    public Papers(int x, int y, boolean vis,Map current) {
        super(x, y, vis);
        this.grid=current.getGrid();


    }
public void place(JLabel grid[][]){
        grid[locatex][locatey].setIcon(icon);
}




    public static ImageIcon getIcon() {
        return icon;
    }
}
