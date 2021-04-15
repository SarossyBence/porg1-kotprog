import java.awt.*;

public abstract class things { //entity
    protected int locatex;
    protected int locatey;
    protected boolean paper;
    protected boolean obstacle;
    public things(int locatex,int locatey,boolean paper,boolean obstacle){
        this.locatex=locatex;
        this.locatey=locatey;
        this.paper=paper;
        this.obstacle=obstacle;
    }

   public void bigrock(Component[][] grid) {

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (i >= locatex && j >= locatey && i <= locatex + 2 && j <= locatey + 2) {
                   grid[i][j].setBackground(Color.gray);
                }
            }
        }
    }

    
    
    
    
    
    
    
}