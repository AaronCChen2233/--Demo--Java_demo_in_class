import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameOfLifeWindows extends JFrame{
    private JButton createButton;
    private JTextField gridWidth;
    private JTextField gridHeight;
    private JPanel mainPanel;
    private JPanel cellPlayGrid;
    private JButton stopButton;

    public GameOfLifeWindows() {
//        cellPlayGrid.add(new JLabel("test"));
        add(mainPanel);
        setTitle("GameOfLifeWindows");
        setSize(1000,800);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

    public static void main(String[] args) {

          GameOfLifeWindows gameOfLifeWindows = new GameOfLifeWindows();
          gameOfLifeWindows.setVisible(true);

//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                GameOfLifeWindows gameOfLifeWindows = new GameOfLifeWindows();
//                gameOfLifeWindows.setVisible(true);
//            }
//        });

    }
}
