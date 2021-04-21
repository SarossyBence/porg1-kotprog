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

public boolean index(int a){
       if (a>0 || a<14){
           return true;
       }else {return false;}
}

    public boolean up(){
        if (index(locatex-1)){
                    if(current.getGridhow()[locatex-1][locatey]==0 || current.getGridhow()[locatex][locatey-1]==2 || current.getGridhow()[locatex][locatey-1]==5  ) {
                        grid[locatex - 1][locatey].setIcon(icon);
                    }}else{return false;}
        return true;

    }
    public boolean down(){
        if (index(locatex+1)){
        if(current.getGridhow()[locatex+1][locatey]==0 || current.getGridhow()[locatex][locatey+1]==2 || current.getGridhow()[locatex][locatey+1]==5  ) {
            grid[locatex + 1][locatey].setIcon(icon);
        }}else{return false;}
        return true;

    }
    public boolean left() {
        if (index(locatey - 1)) {
            if (current.getGridhow()[locatex][locatey - 1] == 0 || current.getGridhow()[locatex][locatey - 1] == 2 || current.getGridhow()[locatex][locatey - 1] == 5) {
                grid[locatex][locatey - 1].setIcon(icon);

            }
        } else {
            return false;
        }
        return true;
    }
    public boolean right(){
        if (index(locatey+1)){
        if(current.getGridhow()[locatex][locatey+1]==0 || current.getGridhow()[locatex][locatey+1]==2 || current.getGridhow()[locatex][locatey+1]==5  ) {
            grid[locatex][locatey+1].setIcon(icon);

        }}else{return false;}
        return true;

    }

    public void gather(){}
}
