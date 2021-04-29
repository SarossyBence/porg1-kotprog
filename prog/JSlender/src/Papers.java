import javax.swing.*;


public class Papers extends Character{
    /**
     * a Papers osztály a papirok leherakását végző osztály
     * meg adja hogyan nézzenek ki a papírok
     * **/
    public JLabel[][] grid;
    public static ImageIcon icon = new ImageIcon("src/img/paperv2.png");
    public Papers(int x, int y, boolean vis,Map current) {
        super(x, y, vis);
        this.grid=current.getGrid();


    }


public void place(JLabel grid[][]){
        /**
         * adott helyre lehelyezi a papírt a pályán
         * **/
        grid[locatex][locatey].setIcon(icon);


}
    public static ImageIcon getIcon() {
        return icon;

    }
}
