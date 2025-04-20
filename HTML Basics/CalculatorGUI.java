import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI  extends JFrame implements ActionListener {
    JTextField textField;
    char operator;
    double result, num1, num2;

    public CalculatorGUI(){
        setTitle("Caluclator");
        setSize(400, 400);
        setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setEditable(false);
        add(textField, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,4));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };
        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        String input = e.getActionCommand();

        if (input.charAt(0) >= '0' && input.charAt(0) <= '9') {
            textField.setText(textField.getText() + input);
        } else if (input.equals("C")) {
            textField.setText("");
        } else if (input.equals("=")) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/':
                    if (num2 == 0) {
                        textField.setText("Error");
                        return;
                    } else {
                        result = num1 / num2;
                    }
                    break;
            }
            textField.setText(String.valueOf(result));
        } else {
            num1 = Double.parseDouble(textField.getText());
            operator = input.charAt(0);
            textField.setText("");
        }
    }

    public static void main(String[] args) {
        new CalculatorGUI();


    }
}
