import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator implements ActionListener{
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10]; // 0-9 buttons
    JButton[] functionButtons = new JButton[8]; // 8 function buttons
    JButton addButton, subButton, mulButton, divButton; // 4 arithmetic buttons
    JButton decButton, equButton, delButton, clrButton; // 4 other buttons

    Font myfont = new Font("Ink Free", Font.BOLD, 30); // font for buttons

    double num1 = 0, num2 = 0, result = 0; // numbers and result
    char operator;

    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50); // x, y, width, height
        textField.setFont(myfont);
        textField.setEditable(false); // user can't type in text field

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        
        // set bounds for function buttons
        for(int i = 0; i < 8; i++){
            functionButtons[i].addActionListener(this); // add action listener
            functionButtons[i].setFont(myfont); 
            functionButtons[i].setFocusable(false); // remove focus
        }


        frame.add(textField); 
        frame.setVisible(true);

    }
    public static void main(String[] args){
        Calculator calc = new Calculator();
    }
    
    public void actionPerformed(ActionEvent e){

    }
}
