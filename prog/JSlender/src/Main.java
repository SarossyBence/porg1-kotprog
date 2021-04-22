import java.awt.*;
import javax.swing.*;
public class Main{

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::createAndShowGui);
    }

    private static void createAndShowGui() {
        Map mainPanel = new Map();
        JFrame frame = new JFrame("Slender");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setMinimumSize(new Dimension(800,800));
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setFocusable(true);
        frame.requestFocusInWindow();

    }
}