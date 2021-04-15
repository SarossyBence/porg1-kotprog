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


        public Map() {
            JPanel Panel = new JPanel(new GridLayout(15, 15, GAP, GAP));
            Panel.setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
            Panel.setBackground(Color.BLACK);
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[row].length; col++) {
                    grid[row][col] = new JLabel("     ", SwingConstants.CENTER);
                    grid[row][col].setFont(LABEL_FONT); // make it big
                    grid[row][col].setOpaque(true);
                    grid[row][col].setBackground(Color.WHITE);
                    Panel.add(grid[row][col]);


                    }

                }


            JPanel bottomPanel = new JPanel();
            bottomPanel.add(new JButton("res"));

            setLayout(new BorderLayout());
            add(Panel, BorderLayout.CENTER);
            add(bottomPanel, BorderLayout.PAGE_END);

        }
}

