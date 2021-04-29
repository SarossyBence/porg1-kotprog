import javax.swing.*;
import java.util.Random;

public class Slenderman extends Character {
    /**
     * a Slenderman osztály feladata a Slenderman cselkvéseinek elvégzése
     * **/
    private ImageIcon icon = new ImageIcon("src/img/slender2.png");
    private static ImageIcon icon2 = new ImageIcon("src/img/slender.png");
    private static ImageIcon icon3 = new ImageIcon("src/img/slender2.png");
    public Icon temp = new ImageIcon();
    public Icon temp2 = new ImageIcon();

    public void setTemp2(Icon temp2) {
        this.temp2 = temp2;
    }

    public void setTemp(Icon temp) {
        this.temp =  temp;
    }

    public Icon getTemp() {
        return temp;
    }

    private Map current;
    private Player player;
    Random random = new Random();

   int rxx = (int)(Math.random() * 3)+5;
    int ryy = (int)(Math.random() * 3)+5;
    int rmd = random.nextInt(100);
    int r5 = (int)(Math.random() * 5)+3;
    int r3 = (int)(Math.random() * 1)+3;
    int r1 = (int)(Math.random() * 4);
    int count=0;


    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Slenderman(int x, int y, boolean vis, Map current, Player player) {
        super(x, y, vis);
        setVisible(false);
        this.current=current;
        this.player=player;

    }

    public boolean index(int ind){
        /**
         * meg nézi hogy a tömb indexein belüli e a szám
         * **/
        return (ind>0 && 15>ind);

    }

    public void teleport(JLabel grid[][]) {
        /**
         * a Slenderman teleportálást végző függvény ha nem 5. lépés akkor csak simán meghívja a lépés fügvényt
         * **/
        int pcount = player.getCounter();
        if(pcount<2){

            stepper(grid,rxx,ryy);
        }if (pcount>=2 && pcount<4)
        {
            stepper(grid,r5,r5);
        }if (pcount>=4 && pcount<6){
            stepper(grid,r3,3);
        }if (pcount>=6){
            stepper(grid,r1,4);
        }
    }

    public void stepper(JLabel grid[][],int a,int b) {
/**
 * a slendermen lépésért felelős függvény
 *meg nézi merre van a player és eldönti hogy merre kell felé lépni
 * **/
        int px = player.getLocatex();
        int py = player.getLocatey();
        int kulx = px - locatex;
        int kuly = py - locatey;
        if(kulx>0){
            right(grid);
        }else if(kulx<0){
            left(grid);
        }else if(kuly<0){
            up(grid);
        }else if(kuly>0){
            down(grid);
        }


                System.out.println(count);
                if (count == 5) {
                    current.slender.port(grid, a, b);
                    setCount(0);


                }
    }
       public void up(JLabel grid[][]){
        /**
         * a slenderman felfele lépéset intéző függvény
         * **/
           visible(grid);
           setTemp(grid[locatex][locatey - 1].getIcon());
           grid[locatex][locatey - 1].setIcon(icon);
           grid[locatex][locatey].setIcon(temp2);

           setTemp2(getTemp());
           locatey--;

           catcs();
           count++;
       }
       public void down(JLabel grid[][]){
           /**
            * a slenderman lefele lépéset intéző függvény
            * **/
           visible(grid);
    setTemp(grid[locatex][locatey - 1].getIcon());
    grid[locatex][locatey - 1].setIcon(icon);
    grid[locatex][locatey].setIcon(temp2);

    setTemp2(getTemp());
    locatey--;

    catcs();
    count++;
    }
    public void left(JLabel grid[][]){
        /**
         * a slenderman balrafele lépéset intéző függvény
         * **/
        visible(grid);
    setTemp(grid[locatex - 1][locatey].getIcon());
    grid[locatex - 1][locatey].setIcon(icon);
    grid[locatex][locatey].setIcon(temp2);
    setTemp2(getTemp());
    locatex--;

    catcs();
    count++;


    }
    public void right(JLabel grid[][]){
        /**
         * a slenderman jobrafele lépéset intéző függvény
         * **/
        visible(grid);
    setTemp(grid[locatex + 1][locatey].getIcon());
    grid[locatex + 1][locatey].setIcon(icon);
    grid[locatex][locatey].setIcon(temp2);
    setTemp2(getTemp());
    locatex++;

    catcs();
    count++;

    }

    public void port(JLabel grid[][],int a,int b){
        /**
         * a slenderman 5. lépésénél való teleporttálást meg valósító függvény
         * a teleportálás mindig a playerhez képest történik
         * **/
        int rx=a;
        int ry=b;
        int px=player.getLocatex();
        int py=player.getLocatey();
        if(index(px-rx)&& index(py-ry)) {
            setTemp(grid[px - rx][py - ry ].getIcon());
            grid[px - rx][py - ry].setIcon(icon3);
            grid[locatex][locatey].setIcon(temp2);
            setTemp2(getTemp());
            locatex = px - rx;
            locatey = py - ry;
        }else if(index(px+rx)&&index(py+ry)) {
            setTemp(grid[px + rx][py + ry ].getIcon());
            grid[px + rx][py + ry].setIcon(icon3);
            grid[locatex][locatey].setIcon(temp2);
            setTemp2(getTemp());
            locatex = px + rx;
            locatey = py + ry;
        }else if(index(px+rx)&& index(py-ry)) {
            setTemp(grid[px + rx][py - ry ].getIcon());
            grid[px + rx][py - ry].setIcon(icon3);
            grid[locatex][locatey].setIcon(temp2);
            setTemp2(getTemp());
            locatex = px + rx;
            locatey = py - ry;
        }else if(index(px-rx)&&index(py+ry)) {
            setTemp(grid[px - rx][py + ry ].getIcon());
            grid[px - rx][py + ry].setIcon(icon3);
            grid[locatex][locatey].setIcon(temp2);
            setTemp2(getTemp());
            locatex = px - rx;
            locatey = py + ry;
        }
    }
    public void come(JLabel grid[][],int a,int b){
/**
 * a slenderman ezzel a függvényem megy be a pályára
 * a player töl a megadott távolsságra
 * **/
        int rx=a;
        int ry=b;
        int px=player.getLocatex();
        int py=player.getLocatey();
        if (rmd<50) {
            if(index(px-rx)&&index(py-ry)){
            grid[px - rx][py - ry].setIcon(icon);
            locatex=px-rx;
            locatey=py-ry;
            rmd=random.nextInt(100);
            }else{ grid[px + rx][py + ry].setIcon(icon);
                locatex=px+rx;
                locatey=py+ry;
                rmd=random.nextInt(100);
            }
        }if (rmd>50) {
            if(index(px+rx)&&index(py+ry)){
            grid[px + rx][py + ry].setIcon(icon);
                locatex=px+rx;
                locatey=py+ry;
                rmd=random.nextInt(100);
        }else{
                grid[px - rx][py - ry].setIcon(icon);
                locatex=px-rx;
                locatey=py-ry;
                rmd=random.nextInt(100);
            }
        }

    }
   public void visible(JLabel grid[][]){
    /**
     * ez a fügvény adja meg mikor látható vagy nem a slenderman
     * az alapján mmilyen távolsában van a playerünk
     * **/
        int px=player.getLocatex();
        int py=player.getLocatey();
        int locx=getLocatex();
        int locy=getLocatey();
        int kulx= Math.abs(px - locx);
        int kuly =Math.abs(py - locy);
        int sum= kulx+kuly;
        if (sum>4){
            grid[locx][locy].setIcon(icon3);
            setIcon(icon3);
        }else{
           grid[locx][locy].setIcon(icon2);
            setIcon(icon2);
        }

    }
    public void catcs(){
    /**
     * a player elkapását meg valósító függvény
     * **/
        int px = player.getLocatex();
        int py = player.getLocatey();
        if (locatey==py&&locatex==px  ) {
            current.lose();
        }

    }
}
