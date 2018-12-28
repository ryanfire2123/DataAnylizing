import javax.swing.*;
import java.awt.event.*;

public class DisplayStatistics extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextField fieldAmountWords;
    private JTextField fieldAmountWordsAnwser;
    private JTextField fieldAmountSent;
    private JTextField fieldAmountSentAnwser;
    private JTextField fieldMostUsedWord;
    private JTextField fieldMostUsedWordAnwser;

    public void setFieldAmountWordsAnwser(int anwser) {
        fieldAmountWordsAnwser.setText(Integer.toString(anwser));
    }
    public void setFieldAmountSentAnwser(int anwser) {
        fieldAmountSentAnwser.setText(Integer.toString(anwser));
    }
    public void setFieldMostUsedWordAnwser(String awnser, int amount) {
        fieldMostUsedWordAnwser.setText(awnser + "(" +amount + " times)");
    }

    public DisplayStatistics() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

    }

    private void onOK() {
       System.exit(2);
        dispose();
    }


    public void showDialog() {
       this.pack();
       this.setVisible(true);
    }
}
