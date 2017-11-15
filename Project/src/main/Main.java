package main;


import sys.CIS;

import javax.swing.*;
import java.awt.event.*;
import java.util.Enumeration;

public class Main {
    //the elements of the GUI
    private JButton useItAsapButton;
    private JButton deleteCouponButton;
    private JButton searchCouponsButton;
    private JButton listCouponsButton;
    private JButton insertCouponButton;
    private JTextField textField1;
    private JTextField textField2;
    private JPanel jp;
    private JTextArea textArea1;
    private JRadioButton providerRadioButton;
    private JRadioButton nameRadioButton;
    private JRadioButton priceRadioButton;
    private JRadioButton discountRadioButton;
    private JRadioButton expirationRadioButton;
    private JRadioButton useRadioButton;
    private JScrollPane js;
    private ButtonGroup buttonGroup1;

    public Main() {
//initiate the Swing
        textField2.setText(CIS.asap());
        textField1.setText("String String int double(0<?<1) int boolean");
        //add listener to the button
        listCouponsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
                String s = "provider";
                String restult;
                Enumeration<AbstractButton> en = buttonGroup1.getElements();
                while (en.hasMoreElements()) {
                    AbstractButton ab = en.nextElement();
                    if (ab.isSelected()) {
                        s = ab.getText();
                        break;
                    }
                }
                restult = CIS.list(s);
                textArea1.setText(restult);
            }
        });
        //add listener to the button
        insertCouponButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = textField1.getText();
                if (verify(temp)) {
                    CIS.add(temp);
                    textField1.setText("you have successfully added " + temp);
                } else {
                    textField1.setText("your input format is wrong");
                }
            }
        });
        //add listener to the button
        searchCouponsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = textField1.getText();
                if (verify(temp)) {
                    String s = CIS.search(temp);
                    textField1.setText("the result is down below");
                    textArea1.setText(s);
                } else {
                    textField1.setText("your input format is wrong");
                }

            }
        });
        //add listener to the button
        deleteCouponButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = textField1.getText();
                if (verify(temp)) {
                    String s = CIS.delete(temp);
                    textField1.setText(s);
                } else {
                    textField1.setText("your input format is wrong");
                }
            }
        });
//add listener to the button
        useItAsapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField2.setText("");
                String s = CIS.asap();
                textField2.setText(s);
            }
        });
        //add listener to the button
        textField1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                textField1.setText("");
            }
        });

    }

    // private method which used to find out that whether the format of the String is correct or not
    private boolean verify(String s) {
        String[] s1 = s.split(" ");
        if (s1.length < 6) {
            return false;
        }
        if (s1[0] instanceof String && s1[1] instanceof String) {
            try {
                Integer.parseInt(s1[2]);
                double d = Double.parseDouble(s1[3]);
                Integer.parseInt(s1[4]);
                Boolean.parseBoolean(s1[5]);
                if (d < 1 && d > 0) {
                    return true;
                } else {
                    return false;
                }

            } catch (Exception e) {
                return false;
            }

        }
        return false;
    }

    // the main approach to start the GUI and in the meantime, start the system
    public static void main(String[] args) {
        JFrame frame = new JFrame("Coupon Inventory System");
        frame.setContentPane(new Main().jp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
