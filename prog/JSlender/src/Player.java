import javax.swing.*;

public class  Player extends Character{
    static ImageIcon icon = new ImageIcon("src/img/player.png");

    Player(int x,int y, boolean vis,String view){
        super(x, y,vis,view);
    }
    public static ImageIcon getIcon() {
        return icon;
    }



    public JLabel[][] grid= Map.getGrid();




    public void up(){
        for(int row = 0; row<grid.length;row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if(grid[row][col].equals(icon)){
                    if(Map.getGridhow()[row+1][col]!=1 || Map.getGridhow()[row+1][col]!=3||Map.getGridhow()[row+1][col]!=4||Map.getGridhow()[row+1][col]!=6||Map.getGridhow()[row+1][col]!=7) {
                        grid[row + 1][col].setText("  p  ");
                        grid[row][col].setText("  p  ");
                    }
                }
            }
        }
    }
    public void walkDown(){

    }
    public void walkLLeft(){}
    public void walkRight(){}
    public void gather(){}
}
