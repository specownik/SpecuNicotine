package me.specu.nictione;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGui {

    private JPanel panel;
    private JLabel b1;
    private JTextField x1;
    private JLabel b2;
    private JTextField x2;
    private JLabel b3;
    private JTextField x3;
    private JButton oblicz;
    private JLabel tw;

    public MainGui(){
        oblicz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(x1.getText().isEmpty() || x2.getText().isEmpty() || x3.getText().isEmpty()){
                    ErrorClass.main(new String[] {"Blad: Zadne pole nie moze byc puste!"});
                    return;
                }
                double b = Double.parseDouble(x1.getText());
                double o = Double.parseDouble(x2.getText());
                double p = Double.parseDouble(x3.getText());
                if(b <= 0 || o <= 0 || p <= 0){
                    ErrorClass.main(new String[] {"Blad: Zadne pole nie moze wynosic mniej niz 0!"});
                    return;
                }
                double m1 = round(((b * 0) - o * b)/(o-p), 2);
                if((m1 <= 0)) {
                    return;
                }else{
                    tw.setText("Potrzebujesz ok. "+m1+" ml bazy nikotynowej o mocy: "+p+" [mg/ml]");
                }
            }
        });
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel( new FlatDarkLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        JFrame jFrame = new JFrame("SpecuNicotine");
        jFrame.setResizable(false);
        jFrame.setContentPane(new MainGui().panel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        jFrame.setLocation(dim.width/2-jFrame.getSize().width/2, dim.height/2-jFrame.getSize().height/2);
        jFrame.setVisible(true);
    }

    public static double round(double num, double dec){
        return  (Math.round(num*Math.pow(10,dec))/Math.pow(10,dec));
    }
}
