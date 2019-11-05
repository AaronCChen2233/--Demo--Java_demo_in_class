import AaronSwingPalette.AaronJCheckBox;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

public class PasswordGeneratorWindow extends JFrame {
    private AaronJCheckBox uppercaseCheckBox;
    private AaronJCheckBox lowercaseCheckBox;
    private AaronJCheckBox numbersCheckBox;
    private JSpinner minimumSizeSpinner;
    private JSpinner maximumSizeSpinner;
    private JSpinner generateCountSpinner;
    private JList list1;
    private JPanel mainPanel;
    private JButton generatorButton;

    public PasswordGeneratorWindow() {
        add(mainPanel);
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Aaron Passwords Generator");

        generatorButton.setEnabled(false);

        /*Set bound*/
        minimumSizeSpinner.setModel(new SpinnerNumberModel(1, 1, 1, 1));
        maximumSizeSpinner.setModel(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
        generateCountSpinner.setModel(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));

        minimumSizeSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int minimumSize = Integer.parseInt(minimumSizeSpinner.getValue().toString());
                int maximumSize = Integer.parseInt(maximumSizeSpinner.getValue().toString());
                minimumSizeSpinner.setModel(new SpinnerNumberModel(minimumSize, 1, maximumSize, 1));
                maximumSizeSpinner.setModel(new SpinnerNumberModel(maximumSize, minimumSize, Integer.MAX_VALUE, 1));
            }
        });

        maximumSizeSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int minimumSize = Integer.parseInt(minimumSizeSpinner.getValue().toString());
                int maximumSize = Integer.parseInt(maximumSizeSpinner.getValue().toString());
                minimumSizeSpinner.setModel(new SpinnerNumberModel(minimumSize, 1, maximumSize, 1));
                maximumSizeSpinner.setModel(new SpinnerNumberModel(maximumSize, minimumSize, Integer.MAX_VALUE, 1));
            }
        });

        lowercaseCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckCheckBoxChecked();
            }
        });
        uppercaseCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckCheckBoxChecked();
            }
        });
        numbersCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckCheckBoxChecked();
            }
        });

        generatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isUseLowerLetter = lowercaseCheckBox.isSelected();
                boolean isUseUpperLetter = uppercaseCheckBox.isSelected();
                boolean isUseNumberLetter = numbersCheckBox.isSelected();
                int minimumSize = Integer.parseInt(minimumSizeSpinner.getValue().toString());
                int maximumSize = Integer.parseInt(maximumSizeSpinner.getValue().toString());
                int count = Integer.parseInt(generateCountSpinner.getValue().toString());

                String[] passwords = PasswordGenerator.GenerateRandomPasswords(minimumSize, maximumSize, isUseLowerLetter, isUseUpperLetter, isUseNumberLetter, count);

                list1.setListData(passwords);
            }
        });
    }

    private void CheckCheckBoxChecked() {
        boolean isUseLowerLetter = lowercaseCheckBox.isSelected();
        boolean isUseUpperLetter = uppercaseCheckBox.isSelected();
        boolean isUseNumberLetter = numbersCheckBox.isSelected();
        boolean isgeneratorButtonEnable = isUseLowerLetter || isUseUpperLetter || isUseNumberLetter;
        generatorButton.setEnabled(isgeneratorButtonEnable);
    }

}
