import javax.swing.*;

public class  Player extends Character{
    private ImageIcon icon = new ImageIcon("src/img/player.png");
    private Map current;
    public JLabel[][] grid;
   public Player(int x,int y, boolean vis,Map current){
        super(x, y,vis);
        this.grid=current.getGrid();
        this.current= current;
    }

    public  ImageIcon getIcon() {
        return icon;
    }

/*public boolean index(int a){
       if (a>0 || a<15){
           return true;
       }else {return false;}
}
*/
public void start(){
        grid[14][14].setIcon(icon);
}
    public void up(){


                    if(current.getGridhow()[locatex-1][locatey]==0 || current.getGridhow()[locatex][locatey-1]==2 || current.getGridhow()[locatex][locatey-1]==5  ) {
                        System.out.println(current.getGridhow()[locatex-1][locatey]);
                        System.out.println(locatex);
                        System.out.println(locatey);
                        grid[locatex-1][locatey].setIcon(icon);
                        grid[locatex][locatey].setIcon(null);
                        locatex--;
                    }

    }
    public void down(){

        if(current.getGridhow()[locatex+1][locatey]==0 || current.getGridhow()[locatex][locatey+1]==2 || current.getGridhow()[locatex][locatey+1]==5  ) {
            grid[locatex + 1][locatey].setIcon(icon);
            grid[locatex][locatey].setIcon(null);
            locatex++;

        }

    }
    public void left(){

        if(current.getGridhow()[locatex][locatey-1]==0 || current.getGridhow()[locatex][locatey-1]==2 || current.getGridhow()[locatex][locatey-1]==5  ) {
            grid[locatex][locatey-1].setIcon(icon);
            grid[locatex][locatey].setIcon(null);
            locatey--;

        }

    }
    public void right(){

        if(current.getGridhow()[locatex][locatey+1]==0 || current.getGridhow()[locatex][locatey+1]==2 || current.getGridhow()[locatex][locatey+1]==5  ) {
            grid[locatex][locatey+1].setIcon(icon);
            grid[locatex][locatey].setIcon(null);
            locatex++;

        }

    }

    public void gather(){
    int counter=0;
    if(grid[locatex][locatey+1].getIcon()==Papers.getIcon()){
        counter++;
        grid[locatex][locatey+1].setIcon(null);

    }
    if(grid[locatex+1][locatey].getIcon()==Papers.getIcon()){
        counter++;
        grid[locatex+1][locatey].setIcon(null);
    }
    if(grid[locatex-1][locatey].getIcon()==Papers.getIcon()){
        counter++;
        grid[locatex-1][locatey].setIcon(null);
    }
    if(grid[locatex][locatey-1].getIcon()==Papers.getIcon()){
        counter++;
        grid[locatex][locatey-1].setIcon(null);
    }

    }
}
