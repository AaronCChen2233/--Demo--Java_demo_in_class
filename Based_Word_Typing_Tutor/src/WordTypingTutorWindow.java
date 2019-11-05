import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class WordTypingTutorWindow extends JFrame {

    private JPanel mainPanel;
    private JCheckBox ignoreCaseCheckBox;
    private JButton startButton;
    private JCheckBox autoCheckCheckBox;
    private JSpinner testTimeSpinner;
    private JLabel help;
    private JTextField typeTextField;
    private JLabel questionLabel;
    private JLabel leftTime;
    private JLabel testTimeMinuteLabel;
    private JPanel scorePanel;
    private JLabel correct;
    private JLabel wrong;
    private JLabel perSecondCharacter;
    private JLabel perSecondCorrectWord;
    private JLabel perMinuteCorrectWord;
    private JButton stopButton;
    private final String dataString = "English Dictionary Get clear definitions and audio pronunciations of words phrases and idioms in British and American English from the three most popular Cambridge dictionaries of English with just one search the Cambridge Advanced Dictionary the Cambridge Academic Content Dictionary and the Cambridge Business English Dictionary a medical examination of part of your body in order to find out how healthy it is or what is happening with it a way of discovering by questions or practical activities what someone knows or what someone or something can do or is like We're revising algebra for the test tomorrow. She scored 18 out of 20 in the spelling test. She's been trying to pass her driving test for six years and she's finally succeeded. The medical tests showed some variation in the baby's heart rate. Candidates who are successful in the written test will be invited for an interview. Did you see that? Joe said to his friend Bill. You're a great shooter! Bill caught the basketball and bounced it before throwing it again. The ball flew into the net. Bill, you never miss! Joe said admiringly. Unless I'm in a real game, Bill complained. Then I miss all the time. Joe knew that Bill was right. Bill performed much better when he was having fun with Joe in the school yard than he did when he was playing for the school team in front of a large crowd. Maybe you just need to practice more, Joe suggested. But I practice all the time with you! Bill objected. He shook his head. I just can't play well when people are watching me. You play well when I'm watching, Joe pointed out. That's because I've known you since we were five years old, Bill said with a smile. I'm just not comfortable playing when other people are around. Joe nodded and understood, but he also had an idea. The next day Joe and Bill met in the school yard again to practice. After a few minutes, Joe excused himself. Practice without me, Joe said to his friend. I'll be back in a minute. Joe hurried through the school building, gathering together whomever he could find—two students, a math";
    private boolean isIgnoreCase = false;
    private boolean isAutoCheck = false;
    private List<String> questionList;
    private Date leftTimeDate;
    private SimpleDateFormat formatter = new SimpleDateFormat("mm:ss");
    private int index = 0;
    private float passSeconds = 0;
    private float correctCount = 0;
    private float wrongCount = 0;
    private float correctLettersCount = 0;
    private boolean isStarted = false;

    /**
     * 1) word count
     * 2) error count
     * 3) characters per second
     * 4) words per second
     * 5) time left
     * *
     */

    public WordTypingTutorWindow() {
        add(mainPanel);
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Aaron Word Typing Tutor");

        help.setForeground(Color.BLUE.darker());
        help.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        testTimeSpinner.setModel(new SpinnerNumberModel(1, 1, 60, 1));
        questionLabel.setEnabled(false);
        typeTextField.setEnabled(false);
        scorePanel.setEnabled(false);
        stopButton.setEnabled(false);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                questionLabel.setEnabled(true);
                typeTextField.setEnabled(true);
                scorePanel.setEnabled(true);
                stopButton.setEnabled(true);
                ignoreCaseCheckBox.setEnabled(false);
                autoCheckCheckBox.setEnabled(false);
                testTimeMinuteLabel.setEnabled(false);
                testTimeSpinner.setEnabled(false);
                startButton.setEnabled(false);
                help.setEnabled(false);

                questionList = Arrays.asList(dataString.split(" "));
                Collections.shuffle(questionList);

                isIgnoreCase = ignoreCaseCheckBox.isSelected();
                isAutoCheck = autoCheckCheckBox.isSelected();

                typeTextField.setText("");
                index = 0;
                passSeconds = 0;
                correctCount = 0;
                wrongCount = 0;
                correctLettersCount = 0;
                questionLabel.setText(questionList.get(index));
                CheckScore();

                leftTimeDate = new Date(0, 0, 0, 0, Integer.parseInt(testTimeSpinner.getValue().toString()));
                TimeSetter timeSetter = new TimeSetter();
                Thread t = new Thread(timeSetter);
                t.start();
                isStarted = true;
                typeTextField.requestFocus();
            }
        });

        help.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(mainPanel, "<html><h1 style='font-family: Droid Sans Mono; font-size: 20pt;'>If \"Auto check\" are checked. Here will check your typing automatic When your type letters count equal question letters count<br> If not you should press \"Space\" after you type finish");
            }
        });

        typeTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if ((isAutoCheck && typeTextField.getText().length() == questionLabel.getText().length() || e.getKeyChar() == (char) 32)) {
                    /*type finish*/

                    if (isIgnoreCase) {
                        if (typeTextField.getText().toLowerCase().equals(questionLabel.getText().toLowerCase())) {
                            /*correct*/
                            correctCount++;
                            correctLettersCount += questionLabel.getText().length();
                        } else {
                            /*wrong*/
                            wrongCount++;
                        }
                    } else {
                        if (typeTextField.getText().replaceAll("\\s+","").equals(questionLabel.getText())) {
                            /*correct*/
                            correctCount++;
                            correctLettersCount += questionLabel.getText().length();
                        } else {
                            /*wrong*/
                            wrongCount++;
                        }
                    }
                    CheckScore();
                    index++;
                    /*loop*/
                    if(index ==questionList.size()){
                        index = 0;
                    }
                    questionLabel.setText(questionList.get(index));
                    typeTextField.setText("");
                }
            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isStarted = false;
                ResetPalettesIsEnable();
            }
        });
    }

    private static Date addSeconds(Date date, Integer seconds) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND, seconds);
        return cal.getTime();
    }

    class TimeSetter implements Runnable {
        @Override
        public void run() {
            try {
                while (isStarted) {
                    Thread.sleep(1000);
                    leftTimeDate = addSeconds(leftTimeDate, -1);
                    String formattedDate = formatter.format(leftTimeDate);
                    leftTime.setText(formattedDate);
                    passSeconds++;
                    CheckScore();

                    if (formattedDate.equals("00:00")) {
                        /**/
                        JOptionPane.showMessageDialog(mainPanel, "<html><h1 style='font-family: Droid Sans Mono; font-size: 20pt;'>Times up!");
                        ResetPalettesIsEnable();
                        break;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void ResetPalettesIsEnable() {
        questionLabel.setEnabled(false);
        typeTextField.setEnabled(false);
        scorePanel.setEnabled(false);
        stopButton.setEnabled(false);
        ignoreCaseCheckBox.setEnabled(true);
        autoCheckCheckBox.setEnabled(true);
        testTimeMinuteLabel.setEnabled(true);
        testTimeSpinner.setEnabled(true);
        startButton.setEnabled(true);
        help.setEnabled(true);
    }

    private void CheckScore() {
        /*if passSeconds is 0 mean just start*/
        if(passSeconds!=0){
            correct.setText(String.valueOf(correctCount));
            wrong.setText(String.valueOf(wrongCount));
            perSecondCharacter.setText(String.valueOf(correctLettersCount / passSeconds));
            perSecondCorrectWord.setText(String.valueOf(correctCount / passSeconds));
            perMinuteCorrectWord.setText(String.valueOf(correctCount / (passSeconds / 60)));
        }
        else {
            correct.setText("0.0");
            wrong.setText("0.0");
            perSecondCharacter.setText("0.0");
            perSecondCorrectWord.setText("0.0");
            perMinuteCorrectWord.setText("0.0");
        }
    }
}
