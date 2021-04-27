import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.Scanner;

class Map extends JPanel implements KeyListener,ActionListener {

    public Player person = new Player(14,14,true,this);
    public Slenderman slender ;//= new Slenderman(0,0,true,this,person);
    public Papers pap0=new Papers(11,10,false,this);
    public Papers pap1=new Papers(9,7,false,this);
    public Papers pap2=new Papers(5,10,false,this);
    public Papers pap3=new Papers(2,2,false,this);
    public Papers pap4=new Papers(4,6,false,this);
    public Papers pap5=new Papers(6,2,false,this);
    public Papers pap6=new Papers(8,13,false,this);
    public Papers pap7=new Papers(1,6,false,this);
    public int counter=0;
    public int hiv=0;
    private static final int GAP = 1;
    private final Font lab = new Font(Font.DIALOG, Font.PLAIN, 40);
    public void reader(int[][] a){
        try {
            File myObj = new File("C:\\Users\\Nev\\Documents\\GitHub\\porg1-k-tprog\\prog\\JSlender\\src\\map.txt");
            Scanner myReader = new Scanner(myObj);
            String[][] data = new String[15][15];
            int counter =0;
            while (myReader.hasNextLine()) {
                data[counter] = myReader.nextLine().split(",");
            counter++;
            }
            for(int i=0; i<15; i++) {
                for(int j=0; j<15; j++) {

                    System.out.println(data[i][j]);
                    a[i][j]=Integer.parseInt(data[i][j].trim());
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public  JLabel[][] grid = new JLabel[15][15];
    public JLabel[][] getGrid()
    {
        return grid;
    }
    public int[][] gridhow=new int[15][15];
    public int[][] getGridhow() {
        return gridhow;
    }

public void win(){
    JFrame win= new JFrame("WIN");
    win.setMinimumSize(new Dimension(400,400));
    win.setLocationByPlatform(true);
    win.setVisible(true);
    win.setFocusable(true);
    win.requestFocusInWindow();
    JPanel bot = new JPanel();
    JPanel bot1 = new JPanel();
    JButton button= new JButton("exit");
    button.setMnemonic(KeyEvent.VK_ESCAPE);
    button.addActionListener(this);
    JLabel label=new JLabel( "WINNING");
    bot1.add(button);
    bot.add(label);
    bot.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
    win.add(bot,BorderLayout.CENTER);
    win.add(bot1,BorderLayout.PAGE_END);
}
    public void lose(){
        JFrame win= new JFrame("YOU DIED");
        win.setMinimumSize(new Dimension(400,400));
        win.setLocationByPlatform(true);
        win.setVisible(true);
        win.setFocusable(true);
        win.requestFocusInWindow();
        JPanel bot = new JPanel();
        JPanel bot1 = new JPanel();
        JButton button= new JButton("exit");
        button.setMnemonic(KeyEvent.VK_ESCAPE);
        button.addActionListener(this);
        JLabel label=new JLabel( "YOU DIED");
        bot1.add(button);
        bot.add(label);
        bot.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        win.add(bot,BorderLayout.CENTER);
        win.add(bot1,BorderLayout.PAGE_END);
    }
    public Map() {
        reader(gridhow);
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
            bot.add(new JLabel( "counter: "+counter));

            frame.addKeyListener(this);
            setLayout(new BorderLayout());
            add(Panel, BorderLayout.CENTER);
            add(bot, BorderLayout.PAGE_END);
        }
       public void hiv(){
        if(hiv<1){
        slender=new Slenderman(1,1,true,this,person);
        slender.come(grid,5,5);
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
                counter=person.getCounter();
                if (counter==1){hiv();}
                if (counter==8){win();}
                break;
            case KeyEvent.VK_ESCAPE :
                System.exit(0);
               break;

        }
    }
    @Override
    public void keyReleased(KeyEvent e) { }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.exit(0);
    }
}

