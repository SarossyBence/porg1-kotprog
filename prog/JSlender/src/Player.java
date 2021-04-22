import javax.swing.*;

public class  Player extends Character{
    private ImageIcon icon = new ImageIcon("src/img/player.png");
    private Map current;
    public int counter;
  //  public JLabel[][] grid;
   public Player(int x,int y, boolean vis,Map current){
        super(x, y,vis);
      //  this.grid=current.getGrid();
       this.counter=0;
        this.current= current;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public String toString() {
        return "Player{" +
                "icon=" + icon +
                '}';
    }

    public  ImageIcon getIcon() {
        return icon;
    }

    public boolean index(int a){
        return (a>0 && 15>a);

    }
public boolean isIndex(int x,int y){
        if(!index(x) || !index(y)){
            return false;
        }
        if(current.getGridhow()[x][y]==0 || current.getGridhow()[x][y]==2 || current.getGridhow()[x][y]==5  ){
            return true;
        }
        return false;

    }

public void start(JLabel grid[][]){
        grid[14][14].setIcon(icon);



}
    public void up(JLabel grid[][]){
                    if(isIndex(locatex-1,locatey)) {
                        grid[locatex-1][locatey].setIcon(icon);
                        grid[locatex][locatey].setIcon(null);
                        locatex--;
                    }

    }
    public void down(JLabel grid[][]){

        if(isIndex(locatex+1,locatey)) {
            grid[locatex+1][locatey].setIcon(icon);
            grid[locatex][locatey].setIcon(null);
            locatex++;
        }

    }
    public void left(JLabel grid[][]){

        if(isIndex(locatex,locatey-1)) {
            grid[locatex][locatey-1].setIcon(icon);
            grid[locatex][locatey].setIcon(null);
            locatey--;
        }

    }
    public void right(JLabel grid[][]){

        if(isIndex(locatex,locatey+1)) {
            grid[locatex][locatey+1].setIcon(icon);
            grid[locatex][locatey].setIcon(null);
            locatey++;
        }

    }

   public void gather(JLabel grid[][]){

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
    //System.out.println(counter);

    }
}
