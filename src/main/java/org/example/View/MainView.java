package org.example.View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MainView extends JFrame{


    private JPanel mainPanel;
    private JPanel inputPolPanel;
    private JPanel operationsPanel;
    private JPanel integrationPanel;
    private JPanel derivativePanel;
    private JPanel invalidInputPanel;

    private JButton addButton;
    private JButton substractButton;
    private JButton multiplyByButton;
    private JButton divideByButton;
    private JButton integrateButton;
    private JButton derivateButton;

    private JButton integrateFrameButton;
    private JButton derivateFrameButton;

    private JFrame integrationFrame;
    private JFrame derivativeFrame;
    private JFrame allFrame;
    private JFrame invalidInputFrame;

    private JTextField firstPolinom;
    private JTextField secondPolinom;
    private JTextField integrationTF;
    private JTextField integrationResTF;
    private JTextField derivativeTF;
    private JTextField derivativeResTF;
    private JTextField resultPolinom;

    private JLabel resultLable;
    private JLabel firstLable;
    private JLabel secondLable;
    private JLabel integratePol;
    private JLabel resultAfInte;
    private JLabel derivatePol;
    private JLabel resultAfDer;
    private JLabel invalidInputLabel;


    protected void beautifyButton(JButton button, Color color)
    {
        button.setFocusPainted(false);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFont(button.getFont().deriveFont(Font.ITALIC,12));
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Change the button background color when mouse enters
                button.setBackground(new Color(9, 22, 51, 255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Reset the button background color when mouse exits
                button.setBackground(new Color(39, 99, 160));
            }
        });

    }


    public MainView (){

        mainPanel = new JPanel();
        inputPolPanel = new JPanel();
        operationsPanel = new JPanel();
        integrationPanel = new JPanel();
        derivativePanel = new JPanel();
        invalidInputPanel = new JPanel();
        invalidInputFrame = new JFrame();


        integrationFrame = new JFrame("Integration of a Polynom");
        derivativeFrame = new JFrame("Derivative of a Polynom");
        allFrame = new JFrame("Polynomial Calculator");
        invalidInputFrame = new JFrame("Error!");

        addButton = new JButton("Add");
        substractButton = new JButton("Substract");
        divideByButton = new JButton("Divide");
        multiplyByButton = new JButton("Multiply");
        integrateButton = new JButton("Integrate");
        derivateButton = new JButton("Derivate");
        integrateFrameButton = new JButton("Result");
        derivateFrameButton = new JButton("Result");

        addButton.setMaximumSize(new Dimension(100,70));
        substractButton.setMaximumSize(new Dimension(100,70));
        divideByButton.setMaximumSize(new Dimension(100,70));
        multiplyByButton.setMaximumSize(new Dimension(100,70));
        integrateButton.setMaximumSize(new Dimension(100,70));
        derivateButton.setMaximumSize(new Dimension(100,70));
        integrateFrameButton.setMaximumSize(new Dimension(100,50));
        derivateFrameButton.setMaximumSize(new Dimension(100,50));

        beautifyButton(addButton,new Color(39, 99, 160));
        beautifyButton(substractButton,new Color(39, 99, 160));
        beautifyButton(divideByButton,new Color(39, 99, 160));
        beautifyButton(multiplyByButton,new Color(39, 99, 160));
        beautifyButton(integrateButton,new Color(39, 99, 160));
        beautifyButton(derivateButton,new Color(39, 99, 160));
        beautifyButton(integrateFrameButton,new Color(39, 99, 160));
        beautifyButton(derivateFrameButton,new Color(39, 99, 160));

        firstPolinom  = new JTextField();
        secondPolinom = new JTextField();
        resultPolinom = new JTextField();
        integrationResTF = new JTextField();
        integrationTF = new JTextField();
        derivativeTF = new JTextField();
        derivativeResTF = new JTextField();
        integrationResTF.setPreferredSize(new Dimension(100, 15));
        integrationTF.setPreferredSize(new Dimension(100, 15));
        derivativeTF.setPreferredSize(new Dimension(100, 15));
        derivativeResTF.setPreferredSize(new Dimension(100, 15));
        firstPolinom.setPreferredSize(new Dimension(200, 40));
        secondPolinom.setPreferredSize(new Dimension(200,40));
        resultPolinom.setPreferredSize(new Dimension(200,40));
        firstPolinom.setBackground(Color .GRAY);
        secondPolinom.setBackground(Color .GRAY);
        resultPolinom.setBackground(Color .GRAY);
        integrationTF.setBackground(Color .GRAY);
        integrationResTF.setBackground(Color .GRAY);
        derivativeResTF.setBackground(Color .GRAY);
        derivativeTF.setBackground(Color .GRAY);
        firstPolinom.setBorder(new LineBorder(Color.GRAY));
        secondPolinom.setBorder(new LineBorder(Color.GRAY));
        resultPolinom.setBorder(new LineBorder(Color.GRAY));
        integrationTF.setBorder(new LineBorder(Color.GRAY));
        integrationResTF.setBorder(new LineBorder(Color.GRAY));
        derivativeResTF.setBorder(new LineBorder(Color.GRAY));
        derivativeTF.setBorder(new LineBorder(Color.GRAY));
        firstPolinom.setEditable(true);
        secondPolinom.setEditable(true);
        resultPolinom.setEditable(false);
        integrationTF.setEditable(true);
        derivativeTF.setEditable(true);
        integrationResTF.setEditable(false);
        derivativeResTF.setEditable(false);
        integrationResTF.setCaretColor(Color .GRAY);
        derivativeResTF.setCaretColor(Color .GRAY);
        resultPolinom.setCaretColor(Color .GRAY);


        firstLable = new JLabel("First Polynom");
        firstLable.setPreferredSize(new Dimension(100,20));
        firstLable.setBackground(new Color(0, 0, 0));
        firstLable.setForeground(Color .WHITE);
        firstLable.setOpaque(true);
        secondLable = new JLabel("Second Polynom");
        secondLable.setPreferredSize(new Dimension(100,20));
        secondLable.setBackground(new Color(0, 0, 0));
        secondLable.setForeground(Color .WHITE);
        secondLable.setOpaque(true);
        resultLable = new JLabel("Resulted Polynom");
        resultLable.setPreferredSize(new Dimension(100,20));
        resultLable.setBackground(new Color(0, 0, 0));
        resultLable.setForeground(Color .WHITE);
        resultLable.setOpaque(true);
        integratePol = new JLabel("Polynom to Integrate");
        integratePol.setPreferredSize(new Dimension(100,20));
        integratePol.setBackground(new Color(0, 0, 0));
        integratePol.setForeground(Color .WHITE);
        integratePol.setOpaque(true);
        resultAfInte = new JLabel("Resulted Polynom");
        resultAfInte.setPreferredSize(new Dimension(100,20));
        resultAfInte.setBackground(new Color(0, 0, 0));
        resultAfInte.setForeground(Color .WHITE);
        resultAfInte.setOpaque(true);
        derivatePol = new JLabel("Polynom to Derivate");
        derivatePol.setPreferredSize(new Dimension(100,20));
        derivatePol.setBackground(new Color(0, 0, 0));
        derivatePol.setForeground(Color .WHITE);
        derivatePol.setOpaque(true);
        resultAfDer = new JLabel("Resulted Polynom");
        resultAfDer.setPreferredSize(new Dimension(100,20));
        resultAfDer.setBackground(new Color(0, 0, 0));
        resultAfDer.setForeground(Color .WHITE);
        resultAfDer.setOpaque(true);
        invalidInputLabel = new JLabel("INVALID INPUT ERROR!");
        invalidInputLabel.setPreferredSize(new Dimension(200,20));
        invalidInputLabel.setBackground(new Color(5, 68, 110));
        invalidInputLabel.setForeground(Color .WHITE);
        invalidInputLabel.setOpaque(true);

        inputPolPanel.add(firstLable);
        inputPolPanel.add(firstPolinom);
        inputPolPanel.add(Box.createVerticalStrut(5));
        inputPolPanel.add(secondLable);
        inputPolPanel.add(secondPolinom);
        inputPolPanel.add(Box.createVerticalStrut(5));
        inputPolPanel.add(resultLable);
        inputPolPanel.add(resultPolinom);

        inputPolPanel.add(Box.createVerticalStrut(5));
        inputPolPanel.setPreferredSize(new Dimension(200,130));
        inputPolPanel.setLayout(new BoxLayout(inputPolPanel, BoxLayout.Y_AXIS));
        inputPolPanel.setBackground(new Color(5, 68, 110));
        inputPolPanel.setBorder(new EmptyBorder(5,0,0,0));

        operationsPanel.add(addButton);
        operationsPanel.add(divideByButton);
        operationsPanel.add(substractButton);
        operationsPanel.add(integrateButton);
        operationsPanel.add(multiplyByButton);
        operationsPanel.add(derivateButton);

        operationsPanel.setBackground(new Color(5, 68, 110));
        operationsPanel.setPreferredSize(new Dimension(200, 150));
        operationsPanel.setLayout(new GridLayout(3,2,0,0));
        operationsPanel.setBorder(new EmptyBorder(15,0,0,0));

        mainPanel.add(inputPolPanel);
        mainPanel.add(operationsPanel);
        mainPanel.setLayout(new FlowLayout());
        mainPanel.setPreferredSize(new Dimension(450,180));
        mainPanel.setBackground(new Color(5, 68, 110));

        integrationPanel.add(integratePol);
        integrationPanel.add(integrationTF);
        integrationPanel.add(Box.createVerticalStrut(5));
        integrationPanel.add(resultAfInte);
        integrationPanel.add(integrationResTF);
        integrationPanel.add(Box.createVerticalStrut(5));
        integrationPanel.add(integrateFrameButton);
        integrationPanel.setLayout(new BoxLayout(integrationPanel, BoxLayout.Y_AXIS));
        integrationPanel.setBorder(new EmptyBorder(10,50,10,50));
        integrationPanel.setPreferredSize(new Dimension(300,120));
        integrationPanel.setBackground(new Color(5, 68, 110));


        integrationFrame.add(integrationPanel);
        integrationFrame.pack();
        integrationFrame.setResizable(false);
        integrationFrame.setVisible(false);
        integrationFrame.setLocationRelativeTo(null);

        derivativePanel.add(derivatePol);
        derivativePanel.add(derivativeTF);
        derivativePanel.add(Box.createVerticalStrut(5));
        derivativePanel.add(resultAfDer);
        derivativePanel.add(derivativeResTF);
        derivativePanel.add(Box.createVerticalStrut(5));
        derivativePanel.add(derivateFrameButton);
        derivativePanel.setLayout(new BoxLayout(derivativePanel, BoxLayout.Y_AXIS));
        derivativePanel.setBorder(new EmptyBorder(10,50,10,50));
        derivativePanel.setPreferredSize(new Dimension(300,120));
        derivativePanel.setBackground(new Color(5, 68, 110));

        invalidInputPanel.setLayout(new BoxLayout(invalidInputPanel, BoxLayout.Y_AXIS));
        invalidInputPanel.setBorder(new EmptyBorder(20,50,10,50));
        invalidInputPanel.setPreferredSize(new Dimension(240,70));
        invalidInputPanel.setBackground(new Color(5, 68, 110));
        invalidInputPanel.add(invalidInputLabel);

        derivativeFrame.add(derivativePanel);
        derivativeFrame.pack();
        derivativeFrame.setResizable(false);
        derivativeFrame.setVisible(false);
        derivativeFrame.setLocationRelativeTo(null);

        allFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Point posOfFrame = new Point(550,300);
        allFrame.add(mainPanel);
        allFrame.pack();
        allFrame.setLocation(posOfFrame);
        allFrame.setResizable(false);
        allFrame.setVisible(true);

        invalidInputFrame.add(invalidInputPanel);
        invalidInputFrame.pack();
        invalidInputFrame.setPreferredSize(new Dimension(200, 120));
        invalidInputFrame.setLocation(posOfFrame);
        invalidInputFrame.setLocationRelativeTo(invalidInputPanel);
        invalidInputFrame.setVisible(false);
        invalidInputFrame.setResizable(false);


        integrationFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                allFrame.setEnabled(true);
                integrationResTF.setText("");
                integrationTF.setText("");
            }
        });

        derivativeFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                allFrame.setEnabled(true);
                derivativeResTF.setText("");
                derivativeTF.setText("");
            }
        });
        invalidInputFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                allFrame.setEnabled(true);
            }
        });
        secondPolinom.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                resultPolinom.setText("");
            }
        });
        firstPolinom.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                resultPolinom.setText("");
            }
        });
        derivativeTF.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                derivativeResTF.setText("");
            }
        });
        integrationTF.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                integrationResTF.setText("");
            }
        });
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getSubstractButton() {
        return substractButton;
    }

    public JButton getMultiplyByButton() {
        return multiplyByButton;
    }

    public JButton getDivideByButton() {
        return divideByButton;
    }

    public JFrame getInvalidInputFrame() {
        return invalidInputFrame;
    }

    public JButton getIntegrateButton() {
        return integrateButton;
    }

    public JButton getEqualButton() {
        return derivateButton;
    }

    public JButton getIntegrateFrameButton() {
        return integrateFrameButton;
    }

    public JFrame getIntegrationFrame() {
        return integrationFrame;
    }

    public JFrame getAllFrame() {
        return allFrame;
    }

    public JTextField getFirstPolinom() {
        return firstPolinom;
    }

    public JTextField getSecondPolinom() {
        return secondPolinom;
    }

    public JTextField getIntegrationTF() {
        return integrationTF;
    }

    public JTextField getIntegrationResTF() {
        return integrationResTF;
    }

    public JTextField getResultPolinom() {
        return resultPolinom;
    }

    public JButton getDerivateFrameButton() {
        return derivateFrameButton;
    }

    public JFrame getDerivativeFrame() {
        return derivativeFrame;
    }

    public JTextField getDerivativeTF() {
        return derivativeTF;
    }

    public JTextField getDerivativeResTF() {
        return derivativeResTF;
    }
}
