import com.sun.prism.Image;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Tic_Tac_ToeWindow extends JFrame {
    private JPanel mainPanel;
    private JLabel messageLabel;
    private JButton newGameButton;
    private JPanel broadPanel;
    Tic_Tac_Toe tic_tac_toe;

    public Tic_Tac_ToeWindow() {
        tic_tac_toe = new Tic_Tac_Toe();
        add(mainPanel);
        broadPanel.setMinimumSize(new Dimension(630, 630));
        setTitle("Aaron Tic Tac Toe Game");
        setSize(730, 800);
        ImageIcon img = new ImageIcon("src/images/tic-tac-toe.png");
        setIconImage(img.getImage());
        messageLabel.setText("Welcome! New game start " + tic_tac_toe.GetWhoseTurnMessage());
        broadPanel.setLayout(new GridLayout(3, 3));
        /*close*/
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        Font lableFont = new Font("Sans-Serif", Font.PLAIN, 20);
        messageLabel.setFont(lableFont);

        ButtonClickListener buttonClickListener = new ButtonClickListener();

        /*NewGameButton*/
        newGameButton.setActionCommand("NewGame");
        newGameButton.setFont(new Font("Sans-Serif", Font.PLAIN, 15));
        newGameButton.addActionListener(buttonClickListener);

        /*Create broadButton*/
        Font buttonFont = new Font("Sans-Serif", Font.PLAIN, 80);
        for (int i = 1; i <= 9; i++) {
            JButton blockButton = new JButton();
            blockButton.addActionListener(buttonClickListener);
            blockButton.setActionCommand(String.valueOf(i));
            blockButton.setFont(buttonFont);
            blockButton.setMinimumSize(new Dimension(200, 200));
            broadPanel.add(blockButton);
        }

       /*Set button action command*/
//        button1.setActionCommand("1");
//        button2.setActionCommand("2");
//        button3.setActionCommand("3");
//        button4.setActionCommand("4");
//        button5.setActionCommand("5");
//        button6.setActionCommand("6");
//        button7.setActionCommand("7");
//        button8.setActionCommand("8");
//        button9.setActionCommand("9");
//
//        button1.setFont(buttonFont);
//        button2.setFont(buttonFont);
//        button3.setFont(buttonFont);
//        button4.setFont(buttonFont);
//        button5.setFont(buttonFont);
//        button6.setFont(buttonFont);
//        button7.setFont(buttonFont);
//        button8.setFont(buttonFont);
//        button9.setFont(buttonFont);
//
//        button1.setMinimumSize(new Dimension(200,200));
//        button2.setMinimumSize(new Dimension(200,200));
//        button3.setMinimumSize(new Dimension(200,200));
//        button4.setMinimumSize(new Dimension(200,200));
//        button5.setMinimumSize(new Dimension(200,200));
//        button6.setMinimumSize(new Dimension(200,200));
//        button7.setMinimumSize(new Dimension(200,200));
//        button8.setMinimumSize(new Dimension(200,200));
//        button9.setMinimumSize(new Dimension(200,200));
//
//        /*Add action listener*/
//        button1.addActionListener(buttonClickListener);
//        button2.addActionListener(buttonClickListener);
//        button3.addActionListener(buttonClickListener);
//        button4.addActionListener(buttonClickListener);
//        button5.addActionListener(buttonClickListener);
//        button6.addActionListener(buttonClickListener);
//        button7.addActionListener(buttonClickListener);
//        button8.addActionListener(buttonClickListener);
//        button9.addActionListener(buttonClickListener);

    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String winner = "";
            String command = e.getActionCommand();
            switch (command) {
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9": {
                    JButton thisbutton = (JButton) e.getSource();
                    thisbutton.setText(tic_tac_toe.GetWhoseTurn());
                    thisbutton.setEnabled(false);
                    winner = tic_tac_toe.PutPice(Integer.valueOf(command));
                    messageLabel.setText(tic_tac_toe.GetWhoseTurnMessage());
                    if (!winner.equals("")) {
                        if (winner.equals("draw")) {
                            messageLabel.setText("This game is draw");
                        } else {
                            messageLabel.setText("Winner is " + winner);
                        }
                    }
                    break;
                }
                case "NewGame": {
                    tic_tac_toe.NewGame();
                    reset();
                    break;
                }
                default: {
                    break;
                }
            }
        }

        private void reset() {
            for (Component b : broadPanel.getComponents()) {
                ((JButton) b).setEnabled(true);
                ((JButton) b).setText("");
            }

            messageLabel.setText("Welcome! This new game " + tic_tac_toe.GetWhoseTurnMessage());
        }
    }
}
