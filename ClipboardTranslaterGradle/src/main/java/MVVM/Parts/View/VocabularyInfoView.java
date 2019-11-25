package MVVM.Parts.View;

import Bootstrap.Tools.ImageTools;
import Bootstrap.Tools.ReaderWriter;
import MVVM.Parts.ViewModel.VocabularyInfoViewModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class VocabularyInfoView extends JFrame {
    private VocabularyInfoViewModel vocabularyInfoViewModel;
    private JPanel infoPanel;
    private JLabel vocabularyLabel;
    private JTextArea definitionInEnglishLabel;
    private JTextArea definitionInChineseLabel;
    private JTextArea exampleLabel;
    private JPanel imgPanel;
    private JPanel mainPanel;
    private JScrollPane definitionInEnglishScrollPane;
    private JScrollPane definitionInChineseScrollPane;
    private JScrollPane exampleScrollPane;
    private JScrollPane imgScrollPane;
    private JButton saveButton;


    public VocabularyInfoView() {
        super();
        setSize(450, 600);
        infoPanel = new JPanel(new GridLayout(3, 1));
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        infoPanel.setMinimumSize(new Dimension(450, 300));
        infoPanel.setMaximumSize(new Dimension(450, 300));
        setAlwaysOnTop(true);
        vocabularyLabel = new JLabel();
        vocabularyLabel.setFont(new Font("Microsoft JhengHei", Font.BOLD, 28));
        vocabularyLabel.setHorizontalAlignment(SwingConstants.LEFT);

        definitionInEnglishLabel = new JTextArea();
        setTextAreaStyle(definitionInEnglishLabel);
        definitionInEnglishScrollPane = new JScrollPane(definitionInEnglishLabel);
        setJScrollPaneStyle(definitionInEnglishScrollPane);

        definitionInChineseLabel = new JTextArea();
        setTextAreaStyle(definitionInChineseLabel);
        definitionInChineseScrollPane = new JScrollPane(definitionInChineseLabel);
        setJScrollPaneStyle(definitionInChineseScrollPane);

        exampleLabel = new JTextArea();
        setTextAreaStyle(exampleLabel);
        exampleScrollPane = new JScrollPane(exampleLabel);
        setJScrollPaneStyle(exampleScrollPane);

        imgPanel = new JPanel(new GridLayout(10, 3));
        imgScrollPane = new JScrollPane(imgPanel);
        setJScrollPaneStyle(imgScrollPane);
        imgScrollPane.setMinimumSize(new Dimension(450, 200));
        imgScrollPane.setMaximumSize(new Dimension(450, 200));

        saveButton = new JButton("Save");

        mainPanel.add(infoPanel);
        infoPanel.add(definitionInEnglishScrollPane);
        infoPanel.add(definitionInChineseScrollPane);
        infoPanel.add(exampleScrollPane);
        mainPanel.add(imgScrollPane);
        mainPanel.add(saveButton);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        add(mainPanel);

        Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
        Insets toolHeight = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
        setLocation(scrSize.width - getWidth(), scrSize.height - toolHeight.bottom - getHeight());

        addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowLostFocus(WindowEvent e) {
                setState(Frame.ICONIFIED);
            }

            @Override
            public void windowGainedFocus(WindowEvent e) {

            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vocabularyInfoViewModel.save();
            }
        });
    }

    private static void setJScrollPaneStyle(JScrollPane scrollPane) {
        JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL) {
            @Override
            public boolean isVisible() {
                return true;
            }
        };
        scrollBar.setUnitIncrement(3);
        scrollPane.setVerticalScrollBar(scrollBar);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 2));
    }

    private static void setTextAreaStyle(JTextArea label) {
        Font infoFont = new Font("Microsoft JhengHei", Font.LAYOUT_NO_LIMIT_CONTEXT, 16);
        label.setFont(infoFont);
        label.setLineWrap(true);
        label.setWrapStyleWord(true);
        label.setEditable(false);
    }

    public void windowPopUp(VocabularyInfoViewModel vocabularyInfoViewModel) {
        this.vocabularyInfoViewModel = vocabularyInfoViewModel;
        setVisible(true);
        if (vocabularyInfoViewModel.isNotFound()) {
            setTitle(vocabularyInfoViewModel.getVocabulary());
            imgPanel.removeAll();
            definitionInEnglishLabel.setText("");
            definitionInChineseLabel.setText("");
            exampleLabel.setText("");
            saveButton.setEnabled(false);
            setState(Frame.NORMAL);
        } else {
            saveButton.setEnabled(true);
            setState(Frame.NORMAL);
            setTitle(vocabularyInfoViewModel.getVocabulary());
            definitionInEnglishLabel.setText(String.join("\n", vocabularyInfoViewModel.getDefinitionInEnglish()));
            definitionInChineseLabel.setText(String.join("\n", vocabularyInfoViewModel.getDefinitionInChinese()));
            exampleLabel.setText(String.join("\n", vocabularyInfoViewModel.getExample()));
            imgPanel.removeAll();
            for (String imgs : vocabularyInfoViewModel.getImgSrcList()) {
                BufferedImage suiteImage = null;
                try {
                    suiteImage = ImageIO.read(new URL(imgs));
                    suiteImage = ImageTools.resize(suiteImage, 140, 140);

                    JLabel pic = new JLabel();
                    pic.setIcon(new ImageIcon(suiteImage));
                    imgPanel.add(pic);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            imgPanel.updateUI();
            mainPanel.updateUI();
        }
    }
}
