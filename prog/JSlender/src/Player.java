import javax.swing.*;

public class  Player extends Character{
    private ImageIcon icon = new ImageIcon("src/img/player.png");
    private Map current;
    public int counter;
/**
 * a Player osztály a játékos karakterének a csselekvéseit végzi ilyen a mozgás és a papír felvétel
 **/


   public Player(int x,int y, boolean vis,Map current){
        super(x, y,vis);
       this.counter=0;
        this.current= current;

    }

    public int getCounter() {
        return counter;
    }



    @Override
    public String toString() {
        return "Player{" +
                "icon=" + icon +
                '}';
    }



    public boolean index(int a){
        /**
         * meg nézi hogy a szám benne van e az intervvallumban ez
         * késöbb lesz hasznos mikor ellenőrizni kell hogy ne mennyünk ki a pályáról
         * **/
        return (a>=0 && 15>a);

    }

public boolean isIndex(int x,int y){
       /**
        * azt nézhetjük meg vele hogy az adott pálya részre léphet e a Playerünk
         **/
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
/**
 * karakter pályára állítása
 * **/


}


    public void up(JLabel grid[][]){
/**
 * karakter felfele léptetése ha lehetséges
 * **/
                    if(isIndex(locatex-1,locatey)) {
                        grid[locatex-1][locatey].setIcon(icon);
                        grid[locatex][locatey].setIcon(null);
                        locatex--;
                        if(counter>0){current.slender.teleport(grid);

                        }
                    }

    }
    public void down(JLabel grid[][]){
/**
 * karakter lefele léptetése ha lehetséges
 * **/
        if(isIndex(locatex+1,locatey)) {
            grid[locatex+1][locatey].setIcon(icon);
            grid[locatex][locatey].setIcon(null);
            locatex++;
            if(counter>0){current.slender.teleport(grid);

            }
        }

    }
    public void left(JLabel grid[][]){
/**
 * karakter balrafele léptetése ha lehetséges
 * **/
        if(isIndex(locatex,locatey-1)) {
            grid[locatex][locatey-1].setIcon(icon);
            grid[locatex][locatey].setIcon(null);
            locatey--;
            if(counter>0){current.slender.teleport(grid);

            }
        }

    }
    public void right(JLabel grid[][]){
/**
 * karakter jobra léptetése ha lehetséges
 * **/
        if(isIndex(locatex,locatey+1)) {
            grid[locatex][locatey+1].setIcon(icon);
            grid[locatex][locatey].setIcon(null);
            locatey++;
            if(counter>0){current.slender.teleport(grid);

            }
        }

    }


   public void gather(JLabel grid[][]){
       /**
        * a karakter papír be gyüjtését megoldó fügvény
        * **/
        if(index(locatex+1) &&index(locatex-1)&&index(locatey+1) && index(locatey-1)) {
            if (grid[locatex][locatey + 1].getIcon() == Papers.getIcon()) {

                counter++;
                grid[locatex][locatey + 1].setIcon(null);

            }
            if (grid[locatex + 1][locatey].getIcon() == Papers.getIcon()) {

                counter++;
                grid[locatex + 1][locatey].setIcon(null);
            }
            if (grid[locatex - 1][locatey].getIcon() == Papers.getIcon()) {

                counter++;
                grid[locatex - 1][locatey].setIcon(null);
            }
            if (grid[locatex][locatey - 1].getIcon() == Papers.getIcon()) {

                counter++;
                grid[locatex][locatey - 1].setIcon(null);
            }


        }
    }
}
