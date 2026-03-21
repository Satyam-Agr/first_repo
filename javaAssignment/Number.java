package javaAssignment;
import javax.swing.*;
import java.awt.*;

public class Number {//controler
    static NumberGUI gui;
    public static void handleButtonClick(int index, int number){
        switch (index) {
            case 0:
                if(NumberLogic.isArmstrong(number))
                    gui.displayMessage(number + " is an Armstrong number");
                else
                    gui.displayMessage(number + " is not an Armstrong number");
                break;
            case 1:
                if(NumberLogic.isAutomorphic(number))
                    gui.displayMessage(number + " is an Automorphic number");
                else
                    gui.displayMessage(number + " is not an Automorphic number");
                break;
            case 2:
                if(NumberLogic.isHarshad(number))
                    gui.displayMessage(number + " is a Harshad number");
                else
                    gui.displayMessage(number + " is not a Harshad number");
                break;
            case 3:
                if(NumberLogic.isPalindrome(number))
                    gui.displayMessage(number + " is a Palindrome number");
                else
                    gui.displayMessage(number + " is not a Palindrome number");
                break;
            case 4:
                if(NumberLogic.isPerfect(number))
                    gui.displayMessage(number + " is a Perfect number");
                else
                    gui.displayMessage(number + " is not a Perfect number");
                break;
            case 5:
                if(NumberLogic.isStrong(number))
                    gui.displayMessage(number + " is a Strong number");
                else
                    gui.displayMessage(number + " is not a Strong number");
                break;
            default:
                gui.displayMessage("Enter an integer number");
                break;
        }
    }
    public static void main(String[] args) {
        gui = new NumberGUI();
    }
    
}
class NumberLogic {

    // 1. Armstrong Number
    public static boolean isArmstrong(int num) {
        int original = num;
        int sum = 0;
        int digits = String.valueOf(num).length();

        while (num > 0) {
            int d = num % 10;
            sum += Math.pow(d, digits);
            num /= 10;
        }
        return sum == original;
    }

    // 2. Strong Number (factorial sum of digits)
    public static boolean isStrong(int num) {
        int original = num;
        int sum = 0;

        while (num > 0) {
            int d = num % 10;
            sum += factorial(d);
            num /= 10;
        }
        return sum == original;
    }

    private static int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) fact *= i;
        return fact;
    }

    // 3. Perfect Number
    public static boolean isPerfect(int num) {
        int sum = 0;

        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) sum += i;
        }
        return sum == num;
    }

    // 4. Harshad (Niven) Number
    public static boolean isHarshad(int num) {
        int sum = 0, temp = num;

        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        return num % sum == 0;
    }

    // 5. Palindrome Number
    public static boolean isPalindrome(int num) {
        int original = num;
        int rev = 0;

        while (num > 0) {
            rev = rev * 10 + (num % 10);
            num /= 10;
        }
        return rev == original;
    }

    // 6. Automorphic Number (square ends with same number)
    public static boolean isAutomorphic(int num) {
        int square = num * num;
        return String.valueOf(square).endsWith(String.valueOf(num));
    }
}

class NumberGUI {
    private JTextField textField;
    private JLabel messageLabel;
    private JFrame frame;
    private static String[] buttonName = {
        "Armstrong",
        "Automorphic",
        "Harshad",
        "Palindrome",
        "Perfect",
        "Strong"
    };
    public NumberGUI(){
        frame = new JFrame();
        setup();
    }
    private void setup() {
        frame.setTitle("Diagonal GUI");
        frame.setSize(620, 320);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Top Panel (Label | TextField | Clear Button)
        JPanel topPanel = new JPanel(new BorderLayout(10, 10));

        JLabel inputLabel = new JLabel("Input:");
        textField = new JTextField();
        JButton clearButton = new JButton("Clear");

        // Clear button functionality
        clearButton.addActionListener(e -> {
            textField.setText("");
            messageLabel.setText("Enter an integer value");
        });

        topPanel.add(inputLabel, BorderLayout.WEST);
        topPanel.add(textField, BorderLayout.CENTER);
        topPanel.add(clearButton, BorderLayout.EAST);

        frame.add(topPanel, BorderLayout.NORTH);

        // Center Panel (Diagonal Buttons)
        JPanel centerPanel = new JPanel(null); // absolute positioning

        JButton[] buttons = new JButton[6];

        int x = 30, y = 20;
        int buttonWidth = 120;
        int buttonHeight = 35;

        for (int i = 0; i < 6; i++) {
            buttons[i] = new JButton(buttonName[i]);
            buttons[i].setBounds(x, y, buttonWidth, buttonHeight);
            final int idx = i;
            buttons[i].addActionListener(e -> clickEvent(idx));
            centerPanel.add(buttons[i]);

            x += 85;  // move right
            y += 35;  // move down (diagonal)
        }

        frame.add(centerPanel, BorderLayout.CENTER);

        // Bottom Label
        messageLabel = new JLabel("Enter an integer value");
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        frame.add(messageLabel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
    private void clickEvent(int index){
        try{
            int n = Integer.parseInt(textField.getText());
            Number.handleButtonClick(index, n);
        }catch (Exception e){
            textField.setText("");
            displayMessage("Enter an integer value");
        }
    }
    public void displayMessage(String msg){
        messageLabel.setText(msg);
    }

}
