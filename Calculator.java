import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textfield;
    JButton[] numberButton = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton;
    JPanel panel;
    Font myFont = new Font("Monospaced", Font.BOLD, 20); 

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator() {
        // Frame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        // TextField
        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setBackground(Color.WHITE);
        textfield.setEditable(false);

        // Initialize buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for (int i = 0; i < 8; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].setFocusable(false);
            numberButton[i].setFont(myFont);
            numberButton[i].addActionListener(this);
        }

        delButton.setBounds(50, 420, 148, 50);
        clrButton.setBounds(202, 420, 148, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(addButton);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(subButton);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButton[0]);
        panel.add(equButton);
        panel.add(divButton);

        // Style the buttons with a professional theme
        Color buttonColor = new Color(235, 235, 235); // Light gray
        Color textColor = Color.BLACK;
        Font buttonFont = new Font("Monospaced", Font.BOLD, 24);

        for (int i = 0; i < 10; i++) {
            numberButton[i].setBackground(buttonColor);
            numberButton[i].setForeground(textColor);
            numberButton[i].setFont(buttonFont);
        }

        Color operatorColor = new Color(255, 128, 0); // Blue
        addButton.setBackground(operatorColor);
        subButton.setBackground(operatorColor);
        mulButton.setBackground(operatorColor);
        divButton.setBackground(operatorColor); 
        decButton.setBackground(buttonColor);
        equButton.setBackground(new Color(21, 185, 37)); // Green
        delButton.setBackground(Color.RED);
        delButton.setForeground(Color.WHITE);
        clrButton.setBackground(new Color(64, 123, 240)); //light blue
        clrButton.setForeground(Color.WHITE);

        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	for(int i=0;i<10;i++) {
    		if(e.getSource() == numberButton[i]) {
    			textfield.setText(textfield.getText().concat(String.valueOf(i)));
    		}
    	}
    	if(e.getSource()==decButton) {
    		textfield.setText(textfield.getText().concat("."));
    	}
    	if(e.getSource()==addButton) {
    		num1 = Double.parseDouble(textfield.getText());
    		operator ='+';
    		textfield.setText("");
    	}
    	if(e.getSource()==subButton) {
    		num1 = Double.parseDouble(textfield.getText());
    		operator ='-';
    		textfield.setText("");
    	}
    	if(e.getSource()==mulButton) {
    		num1 = Double.parseDouble(textfield.getText());
    		operator ='*';
    		textfield.setText("");
    	}
    	if(e.getSource()==divButton) {
    		num1 = Double.parseDouble(textfield.getText());
    		operator ='/';
    		textfield.setText("");
    	}
    	if(e.getSource()==equButton) {
    		num2 = Double.parseDouble(textfield.getText());
    		
    		switch(operator) {
    		case'+':
    			result=num1+num2;
    			break;
    		case'-':
    			result=num1-num2;
    			break;
    		case'*':
    			result=num1*num2;
    			break;
    		case'/':
    			result=num1/num2;
    			break;
    		}
    		textfield.setText(String.valueOf(result));
    		num1=result;
    	}
    	if(e.getSource()==clrButton) {
    		textfield.setText("");
    	}
    	if(e.getSource()==delButton) {
    		String string = textfield.getText();
    		textfield.setText("");
    		for(int i=0; i<string.length()-1; i++) {
    			textfield.setText(textfield.getText()+string.charAt(i));
    		}
    	}
    }
}