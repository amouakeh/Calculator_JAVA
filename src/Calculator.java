import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator implements ActionListener{
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10]; // 0-9 buttons
    JButton[] functionButtons = new JButton[9]; // 9 function buttons
    JButton addButton, subButton, mulButton, divButton; // 4 arithmetic buttons
    JButton decButton, equButton, delButton, clrButton; // 4 other buttons
    JPanel panel;

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
        // set bounds for number buttons 
        for(int i = 0; i < 10; i++){
            numberButtons[i] = new JButton(String.valueOf(i)); // set text for buttons
            numberButtons[i].addActionListener(this); 
            numberButtons[i].setFont(myfont); 
            numberButtons[i].setFocusable(false); 
        }
        // set bounds for other buttons
        delButton.setBounds(50, 430, 145, 50);
        clrButton.setBounds(205, 430, 145, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10)); // 4 rows, 4 columns, 10px horizontal gap, 10px vertical gap
        

        
        // add buttons to panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);


        // add components to frame
        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField); 
        frame.setVisible(true);

    }
    public static void main(String[] args){
        Calculator calc = new Calculator();
    }
    
    public void actionPerformed(ActionEvent e){
        // loop through number buttons
        for(int i = 0; i < 10; i++){
            if(e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        // loop through function buttons
        if(e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }
        // addition button
        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        // subtraction button
        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        // multiplication button
        if(e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        // division button
        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        // equal button
        if(e.getSource() == equButton){
            num2 = Double.parseDouble(textField.getText());
            switch(operator){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        // clear button
        if(e.getSource() == clrButton){
            textField.setText("");
        }
        // delete button
        if(e.getSource() == delButton){
            String string = textField.getText();
            textField.setText("");
            for(int i = 0; i < string.length() - 1; i++){
                textField.setText(textField.getText() + string.charAt(i));
            }
        }

    }
}
