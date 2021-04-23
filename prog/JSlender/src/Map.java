import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


class Map extends JPanel implements KeyListener {

    public Player person = new Player(14,14,true,this);
    public Slenderman slender = new Slenderman(1,1,true,this);
    public Papers pap0=new Papers(11,10,true,this);
    public Papers pap1=new Papers(9,7,true,this);
    public Papers pap2=new Papers(5,10,true,this);
    public Papers pap3=new Papers(2,2,true,this);
    public Papers pap4=new Papers(4,6,true,this);
    public Papers pap5=new Papers(6,2,true,this);
    public Papers pap6=new Papers(8,13,true,this);
    public Papers pap7=new Papers(1,6,true,this);
    public int counter=0;
    public int hiv=0;
    private static final int GAP = 1;
    private final Font lab = new Font(Font.DIALOG, Font.PLAIN, 40);






    public  JLabel[][] grid = new JLabel[15][15];

    public JLabel[][] getGrid()
    {
        return grid;
    }


    public int[][] gridhow = {
            {1, 1, 1, 0, 0, 0, 3, 3, 3, 0, 2, 0, 0, 0, 0},
            {1, 1, 1, 2, 0, 0, 3, 3, 3, 0, 0, 0, 2, 0, 0},
            {1, 1, 1, 0, 0, 0, 0, 0, 4, 4, 4, 4, 4, 4, 0},
            {0, 0, 0, 7, 7, 7, 7, 0, 5, 5, 4, 5, 5, 4, 0},
            {2, 0, 0, 7, 7, 7, 7, 0, 4, 5, 5, 5, 5, 4, 0},
            {0, 0, 0, 0, 0, 0, 0, 2, 4, 4, 4, 4, 5, 4, 2},
            {1, 1, 1, 0, 0, 0, 0, 0, 4, 5, 4, 5, 5, 4, 0},
            {1, 1, 1, 0, 0, 0, 3, 3, 4, 5, 5, 5, 5, 4, 0},
            {1, 1, 1, 0, 0, 0, 3, 3, 4, 4, 4, 4, 5, 4, 0},
            {0, 0, 2, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 2, 2},
            {0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 2, 2},
            {0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 3, 3, 0, 0, 0},
            {0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 6, 6, 2, 0, 0},
            {2, 2, 0, 0, 2, 2, 0, 0, 0, 0, 6, 6, 2, 0, 0},
            {2, 2, 0, 0, 2, 2, 0, 0, 0, 0, 6, 6, 0, 0, 0},
    };

    public int[][] getGridhow() {
        return gridhow;
    }






    public Map() {
        JFrame frame = new JFrame("Slender");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(this);
        frame.pack();
        frame.setMinimumSize(new Dimension(800,800));
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setFocusable(true);
        frame.requestFocusInWindow();
        JPanel Panel = new JPanel(new GridLayout(15, 15, GAP, GAP));
        Panel.setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        Panel.setBackground(Color.BLACK);
            for(int row = 0; row<grid.length;row++) {
                 for (int col = 0; col < grid[row].length; col++) {
                     grid[row][col] = new JLabel("", SwingConstants.CENTER);
                     grid[row][col].setFont(lab);
                     grid[row][col].setOpaque(true);
                     switch (gridhow[row][col]) {
                         case 0:
                             grid[row][col].setBackground(Color.white);
                             Panel.add(grid[row][col]);
                             break;
                         case 1:
                             grid[row][col].setBackground(Color.gray);
                             Panel.add(grid[row][col]);
                             break;
                         case 2:
                             grid[row][col].setBackground(Color.green);
                             Panel.add(grid[row][col]);
                             break;
                         case 3:
                             grid[row][col].setBackground(Color.blue);
                             Panel.add(grid[row][col]);
                             break;
                         case 4:
                             grid[row][col].setBackground(Color.orange);
                             Panel.add(grid[row][col]);
                             break;
                         case 5:
                             grid[row][col].setBackground(Color.yellow);
                             Panel.add(grid[row][col]);
                             break;
                         case 6:
                             grid[row][col].setBackground(Color.cyan);
                             Panel.add(grid[row][col]);
                             break;
                         case 7:
                             grid[row][col].setBackground(Color.DARK_GRAY);
                             Panel.add(grid[row][col]);
                             break;
                     }
                 }}
        pap0.place(grid);
        pap1.place(grid);
        pap2.place(grid);
        pap3.place(grid);
        pap4.place(grid);
        pap5.place(grid);
        pap6.place(grid);
        pap7.place(grid);
        person.start(grid);
            JPanel bot = new JPanel();
            bot.add(new JLabel( "counter: "+person.getCounter()));

            frame.addKeyListener(this);
            setLayout(new BorderLayout());
            add(Panel, BorderLayout.CENTER);
            add(bot, BorderLayout.PAGE_END);
        }
        public void hiv(){
        if(hiv<1){
        slender.come(grid);
        hiv++;
        }
        }
    @Override
    public void keyTyped(KeyEvent keyEvent) { }
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                person.up(grid);
                if(counter>0){slender.teleport(grid);}
                break;
            case KeyEvent.VK_DOWN:
                person.down(grid);
                if(counter>0){slender.teleport(grid);}
                break;
                case KeyEvent.VK_LEFT:
                person.left(grid);
                if(counter>0){slender.teleport(grid);}
                break;
            case KeyEvent.VK_RIGHT:
                person.right(grid);
                if(counter>0){slender.teleport(grid);}
                break;
            case KeyEvent.VK_SPACE:
                person.gather(grid);
                System.out.println(counter);
                break;
            case KeyEvent.VK_ESCAPE :
                System.exit(0);
        }
    }
    @Override
    public void keyReleased(KeyEvent e) { }



}

