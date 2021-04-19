import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
class Map extends JPanel {


    public JLabel[][] getGrid() {
        return grid;
    }

    public void setGrid(JLabel[][] grid) {
        this.grid = grid;
    }

    private static final int GAP = 1;
    private final Font LABEL_FONT = new Font(Font.DIALOG, Font.PLAIN, 40);
    public JLabel[][] grid = new JLabel[15][15];
    public int[][] gridhow = {
            {1, 1, 1, 0, 0, 0, 3, 3, 3, 0, 2, 0, 0, 0, 0},
            {1, 1, 1, 2, 0, 0, 3, 3, 3, 0, 0, 0, 2, 0, 0},
            {1, 1, 1, 0, 0, 0, 0, 0, 4, 4, 4, 4, 4, 4, 0},
            {0, 0, 0, 7, 7, 7, 0, 0, 5, 5, 4, 5, 5, 4, 0},
            {2, 0, 0, 7, 7, 7, 0, 0, 4, 5, 5, 5, 5, 4, 0},
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


    public Map() {
        JPanel Panel = new JPanel(new GridLayout(15, 15, GAP, GAP));
        Panel.setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        Panel.setBackground(Color.BLACK);
            for(int row = 0; row<grid.length;row++) {
                 for (int col = 0; col < grid[row].length; col++) {
                     //System.out.print(gridhow[row][col]);
                     grid[row][col] = new JLabel("      ", SwingConstants.CENTER);
                     grid[row][col].setFont(LABEL_FONT); // make it big
                     grid[row][col].setOpaque(true);
                     if(gridhow[row][col]==0){
                         grid[row][col].setBackground(Color.WHITE);
                         Panel.add(grid[row][col]);}
                     if (gridhow[row][col]==1){
                         grid[row][col].setBackground(Color.gray);
                         Panel.add(grid[row][col]);}
                     if (gridhow[row][col]==2){
                         grid[row][col].setBackground(Color.green);
                         Panel.add(grid[row][col]);}
                     if (gridhow[row][col]==3){
                         grid[row][col].setBackground(Color.blue);
                         Panel.add(grid[row][col]);}
                     if (gridhow[row][col]==4){
                         grid[row][col].setBackground(Color.orange);
                         Panel.add(grid[row][col]);}
                     if (gridhow[row][col]==5){
                         grid[row][col].setBackground(Color.yellow);
                         Panel.add(grid[row][col]);}
                     if (gridhow[row][col]==6){
                         grid[row][col].setBackground(Color.cyan);
                         Panel.add(grid[row][col]);}
                     if (gridhow[row][col]==7){
                         grid[row][col].setBackground(Color.black);
                         Panel.add(grid[row][col]);}
                 } }
            JPanel bottomPanel = new JPanel();
            bottomPanel.add(new JButton("res"));
            setLayout(new BorderLayout());
            add(Panel, BorderLayout.CENTER);
            add(bottomPanel, BorderLayout.PAGE_END);
        }}

