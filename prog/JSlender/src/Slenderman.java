import javax.swing.*;
import java.util.Random;

public class Slenderman extends Character {
    private ImageIcon icon = new ImageIcon("src/img/slender.png");
    private ImageIcon icon2 = new ImageIcon("src/img/slender.png");
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
    int r1 = (int)(Math.random() * 3);
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
        return (ind>0 && 15>ind);

    }

    public void teleport(JLabel grid[][]) {
        int pcount = player.getCounter();
        if(pcount<2){
            teleport1(grid,rxx,ryy);
        }if (pcount>=2 && pcount<4)
        {
            teleport1(grid,r5,r5);
        }if (pcount>=4 && pcount<6){
            teleport1(grid,r3,r3);
        }if (pcount>=6){
            teleport1(grid,r1,r1);
        }
    }

    public void teleport1(JLabel grid[][],int a,int b) {

       int px = player.getLocatex();
       int py = player.getLocatey();
       int kulx = px - locatex;
       int kuly = py - locatey;
           if (kulx > 0 || kuly > 0) {
               if (kulx < kuly && index(locatex + 1)) {

                   setTemp(grid[locatex + 1][locatey].getIcon());
                   grid[locatex + 1][locatey].setIcon(icon);
                   grid[locatex][locatey].setIcon(temp2);
                   setTemp2(getTemp());
                   locatex++;
                   catcs();
                   count++;
               }
               if (kulx > kuly && index(locatey + 1)) {

                   setTemp(grid[locatex][locatey + 1].getIcon());
                   grid[locatex][locatey + 1].setIcon(icon);
                   grid[locatex][locatey ].setIcon(temp2);

                   setTemp2(getTemp());
                   locatey++;
                   catcs();
                   count++;
               }
           }else if (kulx < 0 || kuly < 0) {
               if (kulx < kuly && index(locatex - 1)) {

                   setTemp(grid[locatex - 1][locatey].getIcon());
                   grid[locatex - 1][locatey].setIcon(icon);
                   grid[locatex][locatey].setIcon(temp2);

                   setTemp2(getTemp());
                   locatex--;
                   catcs();
                   count++;
               }
               if (kulx > kuly && index(locatey - 1)) {

                   setTemp(grid[locatex][locatey - 1].getIcon());
                   grid[locatex][locatey - 1].setIcon(icon);
                   grid[locatex][locatey].setIcon(temp2);

                   setTemp2(getTemp());
                   locatey--;
                   catcs();
                   count++;
               }
           }
             System.out.println(count);
               if (count == 5) {
                   current.slender.port(grid, a, b);
                   setCount(0);
               }
       }

    public void port(JLabel grid[][],int a,int b){

        int rx=a;
        int ry=b;
        int px=player.getLocatex();
        int py=player.getLocatey();

            if(index(px-rx)&&index(py-ry)) {
                setTemp(grid[px - rx][py - ry].getIcon());
                grid[px - rx][py - ry].setIcon(icon);
                grid[locatex][locatey].setIcon(temp2);
                setTemp2(getTemp());
                locatex = px - rx;
                locatey = py - ry;
                

            }if(index(px+rx)&&index(py+ry)){
                setTemp(grid[px + rx][py + ry].getIcon());
                grid[px + rx][py + ry].setIcon(icon);
                grid[locatex][locatey].setIcon(temp2);
                setTemp2(getTemp());
                locatex=px+rx;
                locatey=py+ry;

            }if(index(px-rx)&&index(py+ry)){
            setTemp(grid[px - rx][py + ry].getIcon());
            grid[px - rx][py + ry].setIcon(icon);
            grid[locatex][locatey].setIcon(temp2);
            setTemp2(getTemp());
            locatex=px-rx;
            locatey=py+ry;

        }if(index(px+rx)&&index(py-ry)){
            setTemp(grid[px + rx][py - ry].getIcon());
            grid[px + rx][py - ry].setIcon(icon);
            grid[locatex][locatey].setIcon(temp2);
            setTemp2(getTemp());
            locatex=px+rx;
            locatey=py-ry;

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
        int px=player.getLocatex();
        int py=player.getLocatey();
        int kulx= Math.abs((px - locatex));
        int kuly =Math.abs((py-locatey));
        int sum= kulx+kuly;
        if (sum<4){
            setIcon(icon2);
        }if(sum>=4){
            setIcon(icon);
        }

    }
    public void catcs(){
        int px = player.getLocatex();
        int py = player.getLocatey();
        if (locatey==py&&locatex==px  ) {
            current.lose();
        }

    }
}
