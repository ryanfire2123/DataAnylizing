import javax.swing.*;
import java.awt.event.*;

public class ChoosingMethod extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JRadioButton radioButtonAmountChars;
    private JRadioButton radioButtonAmountStrings;
    private ButtonGroup allButtons;
    private int whatChoice = 0;

    public ChoosingMethod() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        //---------------------------------addingAllButtons-------------------------------------------------------------
        allButtons.add(radioButtonAmountChars);
        allButtons.add(radioButtonAmountStrings);


        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {

        if (radioButtonAmountChars.isSelected()) {
            whatChoice = 1;
        } else if (radioButtonAmountStrings.isSelected()) {
            whatChoice = 2;
        }


        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
    public int getWhatChoice() {
        return whatChoice;
    }

    public void showDialog() {
        this.pack();
        this.setVisible(true);
    }
}
