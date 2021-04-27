import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Slenderman extends Character {
    static ImageIcon icon = new ImageIcon("src/img/slender.png");

    private Map current;
    private Player player;
    Random random = new Random();

   int rx = (int)(Math.random() * 3)+5;
    int ry = (int)(Math.random() * 3)+5;
    int rmd = random.nextInt(100);
    int r5 = (int)(Math.random() * 5);
    int r3 = (int)(Math.random() * 1)+3;
    int r1 = (int)(Math.random() * 3);
    public Slenderman(int x, int y, boolean vis,Map current,Player player) {
        super(x, y, vis);
        setVisible(false);
        this.current=current;
        this.player=player;

    }
    public boolean index(int a){
        return (a>0 && 15>a);

    }
    public static ImageIcon getIcon() {
        return icon;
    }

    public void teleport(JLabel grid[][]) {
        int pcount = player.getCounter();
        System.out.println(pcount);
        if(pcount<2){
            teleport1(grid);
        }if (pcount>=2 && pcount<4)
        {
            teleport2(grid);
        }if (pcount>=4 && pcount<6){
            teleport3(grid);
        }if (pcount>=6){
            teleport4(grid);
        }
    }

   public void teleport1(JLabel grid[][]) {
       int count = 0;
       int px = player.getLocatex();
       int py = player.getLocatey();
       int kulx = px - locatex;
       int kuly = py - locatey;

       if ((kulx > 0 && kuly > 0) || (kulx < 0 && kuly > 0) || (kulx > 0 && kuly < 0)) {
           if (kulx < kuly && index(locatex + 1)) {
               // ImageIcon csere = new ImageIcon((Image) grid[locatex][locatey].getIcon());
               grid[locatex + 1][locatey].setIcon(icon);
               grid[locatex][locatey].setIcon(null);
               locatex++;
               count++;
           }
           if (kulx > kuly && index(locatey + 1)) {
               grid[locatex][locatey + 1].setIcon(icon);
               grid[locatex][locatey].setIcon(null);
               locatey++;
               count++;
           }
           if (kulx == kuly) {
               grid[locatex][locatey + 1].setIcon(icon);
               grid[locatex][locatey].setIcon(null);
               locatey++;
               count++;
           }
       }
       if ((kulx < 0 && kuly < 0) || (kulx > 0 && kuly < 0) || (kulx < 0 && kuly > 0)) {
           if (kulx <= kuly && index(locatex - 1)) {
               grid[locatex - 1][locatey].setIcon(icon);
               grid[locatex][locatey].setIcon(null);
               locatex--;
               count++;
           }
           if (kulx >= kuly && index(locatey - 1)) {
               grid[locatex][locatey - 1].setIcon(icon);
               grid[locatex][locatey].setIcon(null);
               locatey--;
               count++;
           }
           if (kulx == kuly) {
               grid[locatex][locatey - 1].setIcon(icon);
               grid[locatex][locatey].setIcon(null);
               locatey--;
               count++;
           }
       }
       if (count == 5) {
           current.slender.come(grid,rx,ry);
           count = 0;
       }
   }
       public void teleport2(JLabel grid[][]){
           int count=0;
           int px=player.getLocatex();
           int py=player.getLocatey();
           int kulx=px-locatex;
           int kuly=py-locatey;
           if ((kulx>0 && kuly>0)||(kulx<0 && kuly>0)||(kulx>0 && kuly<0)){
               if (kulx<kuly&& index(locatex+1)){
                   // ImageIcon csere = new ImageIcon((Image) grid[locatex][locatey].getIcon());
                   grid[locatex+1][locatey].setIcon(icon);
                   grid[locatex][locatey].setIcon(null);
                   locatex++;
                   count++;
               }if (kulx>kuly && index(locatey+1)){
                   grid[locatex][locatey+1].setIcon(icon);
                   grid[locatex][locatey].setIcon(null);
                   locatey++;
                   count++;
               }
               if (kulx==kuly){
                   grid[locatex][locatey+1].setIcon(icon);
                   grid[locatex][locatey].setIcon(null);
                   locatey++;
                   count++;
               }
           }
           if ((kulx<0 && kuly<0)||(kulx>0 && kuly<0)||(kulx<0 && kuly>0)){
               if (kulx<=kuly&& index(locatex-1)){
                   grid[locatex-1][locatey].setIcon(icon);
                   grid[locatex][locatey].setIcon(null);
                   locatex--;
                   count++;
               }if (kulx>=kuly&& index(locatey-1)){
                   grid[locatex][locatey-1].setIcon(icon);
                   grid[locatex][locatey].setIcon(null);
                   locatey--;
                   count++;
               }if (kulx==kuly){
                   grid[locatex][locatey-1].setIcon(icon);
                   grid[locatex][locatey].setIcon(null);
                   locatey--;
                   count++;
               }
           }
           if(count == 5){
               current.slender.come(grid,r5,r1);
               count=0;
           }

    }
    public void teleport3(JLabel grid[][]){
        int count=0;
        int px=player.getLocatex();
        int py=player.getLocatey();
        int kulx=px-locatex;
        int kuly=py-locatey;
        if ((kulx>0 && kuly>0)||(kulx<0 && kuly>0)||(kulx>0 && kuly<0)){
            if (kulx<kuly&& index(locatex+1)){
                // ImageIcon csere = new ImageIcon((Image) grid[locatex][locatey].getIcon());
                grid[locatex+1][locatey].setIcon(icon);
                grid[locatex][locatey].setIcon(null);
                locatex++;
                count++;
            }if (kulx>kuly && index(locatey+1)){
                grid[locatex][locatey+1].setIcon(icon);
                grid[locatex][locatey].setIcon(null);
                locatey++;
                count++;
            }
            if (kulx==kuly){
                grid[locatex][locatey+1].setIcon(icon);
                grid[locatex][locatey].setIcon(null);
                locatey++;
                count++;
            }
        }
        if ((kulx<0 && kuly<0)||(kulx>0 && kuly<0)||(kulx<0 && kuly>0)){
            if (kulx<=kuly&& index(locatex-1)){
                grid[locatex-1][locatey].setIcon(icon);
                grid[locatex][locatey].setIcon(null);
                locatex--;
                count++;
            }if (kulx>=kuly&& index(locatey-1)){
                grid[locatex][locatey-1].setIcon(icon);
                grid[locatex][locatey].setIcon(null);
                locatey--;
                count++;
            }if (kulx==kuly){
                grid[locatex][locatey-1].setIcon(icon);
                grid[locatex][locatey].setIcon(null);
                locatey--;
                count++;
            }
        }
        if(count == 5){
            current.slender.come(grid,r3,r1);
            count=0;
        }
    }
    public void teleport4(JLabel grid[][]){
        int count=0;
        int px=player.getLocatex();
        int py=player.getLocatey();
        int kulx=px-locatex;
        int kuly=py-locatey;
        if ((kulx>0 && kuly>0)||(kulx<0 && kuly>0)||(kulx>0 && kuly<0)){
            if (kulx<kuly&& index(locatex+1)){
                // ImageIcon csere = new ImageIcon((Image) grid[locatex][locatey].getIcon());
                grid[locatex+1][locatey].setIcon(icon);
                grid[locatex][locatey].setIcon(null);
                locatex++;
                count++;
            }if (kulx>kuly && index(locatey+1)){
                grid[locatex][locatey+1].setIcon(icon);
                grid[locatex][locatey].setIcon(null);
                locatey++;
                count++;
            }
            if (kulx==kuly){
                grid[locatex][locatey+1].setIcon(icon);
                grid[locatex][locatey].setIcon(null);
                locatey++;
                count++;
            }
        }
        if ((kulx<0 && kuly<0)||(kulx>0 && kuly<0)||(kulx<0 && kuly>0)){
            if (kulx<=kuly&& index(locatex-1)){
                grid[locatex-1][locatey].setIcon(icon);
                grid[locatex][locatey].setIcon(null);
                locatex--;
                count++;
            }if (kulx>=kuly&& index(locatey-1)){
                grid[locatex][locatey-1].setIcon(icon);
                grid[locatex][locatey].setIcon(null);
                locatey--;
                count++;
            }if (kulx==kuly){
                grid[locatex][locatey-1].setIcon(icon);
                grid[locatex][locatey].setIcon(null);
                locatey--;
                count++;
            }
        }
        if(count == 5){
            current.slender.come(grid,r1,r1);
            count=0;
        }
    }
    public void come(JLabel grid[][],int a,int b){

        int rx=a;
        int ry=b;
        int px=player.getLocatex();
        int py=player.getLocatey();
        if (rmd<50) {
            if(index(px-rx)&&index(py-ry)){
            grid[px - rx][py - ry].setIcon(icon);
            locatex=px-rx;
            locatey=py-ry;
            }else{ grid[px + rx][py + ry].setIcon(icon);
                locatex=px+rx;
                locatey=py+ry;}
        }if (rmd>50) {
            if(index(px+rx)&&index(py+ry)){
            grid[px + rx][py + ry].setIcon(icon);
                locatex=px+rx;
                locatey=py+ry;
        }else{
                grid[px - rx][py - ry].setIcon(icon);
                locatex=px-rx;
                locatey=py-ry;
            }
        }

    }
    public void catcs(){}
}
