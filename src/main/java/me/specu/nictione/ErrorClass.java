package me.specu.nictione;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ErrorClass extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel label;

    public ErrorClass(String name) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        label.setText(name);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
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
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public ErrorClass(String name, int i){
        ErrorClass errorClass = new ErrorClass(name);
        errorClass.pack();
        errorClass.setVisible(true);
    }

    public static void main(String[] args) {
        ErrorClass errorClass = new ErrorClass(args[0]);
        errorClass.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        errorClass.setLocation(dim.width/2-errorClass.getSize().width/2, dim.height/2-errorClass.getSize().height/2);
        errorClass.setVisible(true);

    }

}
