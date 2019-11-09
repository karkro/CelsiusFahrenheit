package main;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CelsiusFahrenheit extends JFrame implements ActionListener {

    private JLabel lCelsius, lFahrenheit;
    private JTextField tCelsius, tFahrenheit;
    private JButton bKonwertuj, bResetuj, bUseSlider;
    private JCheckBox chWielkie;
    private ButtonGroup bgRozmiar, bgZmiana;
    private JRadioButton rbMaly, rbSredni, rbDuzy, rbCtoF, rbFtoC;
    private double tempCelsius, tempFahrenheit;
    private UseSlider useSlider;

    public CelsiusFahrenheit() {

        setSize(400, 310);
        setTitle("Celsius <=> Fahrenheit");
        setLayout(null);

        lCelsius = new JLabel("Celsius grades:");
        lCelsius.setBounds(20, 20 , 120, 20);
        add(lCelsius);

        tCelsius = new JTextField("");
        tCelsius.setBounds(170, 20, 150, 20);
        tCelsius.setToolTipText("Celsius");
        tCelsius.addActionListener(this);
        add(tCelsius);


        lFahrenheit = new JLabel("Fahrenheit grades");
        lFahrenheit.setBounds(20, 70, 150, 20);
        add(lFahrenheit);

        tFahrenheit = new JTextField("");
        tFahrenheit.setBounds(170, 70, 150, 20);
        tFahrenheit.setToolTipText("Fahrenheit");
        tFahrenheit.addActionListener(this);
        add(tFahrenheit);

        bgZmiana = new ButtonGroup();
        rbCtoF = new JRadioButton("Celsius to Fahrenheit", false);
        rbCtoF.setBounds(10, 120, 180, 20);
        rbCtoF.addActionListener(this);
        rbFtoC = new JRadioButton("Fahrenheit to Celsius", false);
        rbFtoC.setBounds(220, 120, 180, 20);
        rbFtoC.addActionListener(this);
        bgZmiana.add(rbCtoF);
        bgZmiana.add(rbFtoC);
        add(rbCtoF);
        add(rbFtoC);

        bgRozmiar = new ButtonGroup();
        rbMaly = new JRadioButton("Small", false);
        rbMaly.setBounds(10, 170, 80, 20);
        rbMaly.setToolTipText("Font size: 10");
        rbMaly.addActionListener(this);
        rbSredni = new JRadioButton("Normal", false);
        rbSredni.setBounds(90, 170, 80, 20);
        rbSredni.setToolTipText("Font size: 14");
        rbSredni.addActionListener(this);
        rbDuzy = new JRadioButton("Big", false);
        rbDuzy.setBounds(170, 170, 80, 20);
        rbDuzy.setToolTipText("Font size: 16");
        rbDuzy.addActionListener(this);
        bgRozmiar.add(rbMaly);
        bgRozmiar.add(rbSredni);
        bgRozmiar.add(rbDuzy);
        add(rbMaly);
        add(rbSredni);
        add(rbDuzy);

        chWielkie = new JCheckBox("Big letters");
        chWielkie.setBounds(280, 170, 100, 20);
        chWielkie.setToolTipText("Font size: 18");
        // chWielkie.addActionListener(this);
        add(chWielkie);

        bKonwertuj = new JButton("Convert");
        bKonwertuj.setBounds(20, 220, 110, 20);
        bKonwertuj.setToolTipText("Convert");
        bKonwertuj.addActionListener(this);
        add(bKonwertuj);

        bResetuj = new JButton("Clear");
        bResetuj.setBounds(140, 220, 110, 20);
        bResetuj.setToolTipText("Clear text");
        bResetuj.addActionListener(this);
        add(bResetuj);

        bUseSlider = new JButton("Use slider");
        bUseSlider.setBounds(260, 220, 120, 20);
        bUseSlider.setToolTipText("Use slider");
        bUseSlider.addActionListener(this);
        add(bUseSlider);

    }

    public static void main(String[] args) {

        CelsiusFahrenheit application = new CelsiusFahrenheit();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        if (source == bKonwertuj || source == tCelsius) {
            if (rbCtoF.isSelected()) {
                tempCelsius = Double.parseDouble(tCelsius.getText());
                tempFahrenheit = 32.0 + (9.0 / 5.0) * tempCelsius;
                tFahrenheit.setText(String.valueOf(tempFahrenheit));
                if (chWielkie.isSelected() == true) {
                    tFahrenheit.setFont(new Font("SansSerif", Font.BOLD, 18));
                    // rbMaly.setSelected(false);
                    // rbSredni.setSelected(false);
                    // rbDuzy.setSelected(false);
                } else if (rbMaly.isSelected()) {
                    tFahrenheit.setFont(new Font("SansSerif", Font.PLAIN, 10));
                    // chWielkie.setSelected(false);
                } else if (rbSredni.isSelected()) {
                    tFahrenheit.setFont(new Font("SansSerif", Font.PLAIN, 14));
                    // chWielkie.setSelected(false);
                } else if (rbDuzy.isSelected()) {
                    tFahrenheit.setFont(new Font("SansSerif", Font.BOLD, 16));
                    // chWielkie.setSelected(false);
                }
            }
        }

        if (source == bKonwertuj || source == tFahrenheit) {
            if (rbFtoC.isSelected()) {
                tempFahrenheit = Double.parseDouble(tFahrenheit.getText());
                tempCelsius = (tempFahrenheit - 32.0) * (5.0 / 9.0);
                tCelsius.setText(String.valueOf(tempCelsius));
                if (chWielkie.isSelected() == true) {
                    tCelsius.setFont(new Font("SansSerif", Font.BOLD, 18));
                    // rbMaly.setSelected(false);
                    // rbSredni.setSelected(false);
                    // rbDuzy.setSelected(false);
                } else if (rbMaly.isSelected()) {
                    tCelsius.setFont(new Font("SansSerif", Font.PLAIN, 10));
                    // chWielkie.setSelected(false);
                } else if (rbSredni.isSelected()) {
                    tCelsius.setFont(new Font("SansSerif", Font.PLAIN, 14));
                    // chWielkie.setSelected(false);
                } else if (rbDuzy.isSelected()) {
                    tCelsius.setFont(new Font("SansSerif", Font.BOLD, 16));
                    // chWielkie.setSelected(false);
                }
            }
        }

        if (source == bUseSlider) {
            if (useSlider == null) {
                useSlider = new UseSlider(null);
            }
            useSlider.setVisible(true);

        }

        if (source == bResetuj) {
            tCelsius.setText("");
            tFahrenheit.setText("");
        }
    }
}

class UseSlider extends JDialog implements ChangeListener {

    private JLabel lCelsius, lFahrenheit;
    private JSlider sCelsius, sFahrenheit;
    private int tempCelsius, tempFahrenheit;

    public UseSlider(JFrame owner) {
        super(owner, "Celsius to Fahrenheit", true);
        setSize(300, 200);
        setTitle("Celsius to Fahrenheit");
        setLayout(null);
        setResizable(false);

        lCelsius = new JLabel("Celsius: 0");
        lCelsius.setBounds(20, 20, 100, 20);
        add(lCelsius);

        sCelsius = new JSlider(0, 100, 0);
        sCelsius.setBounds(20, 45, 200, 40);
        sCelsius.setMajorTickSpacing(20);
        sCelsius.setMinorTickSpacing(5);
        sCelsius.setPaintTicks(true);
        sCelsius.setPaintLabels(true);
        sCelsius.addChangeListener(this);
        add(sCelsius);

        lFahrenheit = new JLabel("Fahrenheit: 32");
        lFahrenheit.setBounds(20, 100, 150, 20);
        add(lFahrenheit);

        sFahrenheit = new JSlider(20, 220, 32);
        sFahrenheit.setBounds(20, 125, 200, 40);
        sFahrenheit.setMajorTickSpacing(40);
        sFahrenheit.setMinorTickSpacing(10);
        sFahrenheit.setPaintTicks(true);
        sFahrenheit.setPaintLabels(true);
        sFahrenheit.setEnabled(false);
        add(sFahrenheit);


    }

    @Override
    public void stateChanged(ChangeEvent e) {
        tempCelsius = sCelsius.getValue();
        lCelsius.setText("Celsius: " + tempCelsius);
        tempFahrenheit = (int) Math.round(32 + (9.0/5.0) * tempCelsius);
        sFahrenheit.setValue(tempFahrenheit);
        lFahrenheit.setText("Fahrenheit: " + tempFahrenheit);
    }
}