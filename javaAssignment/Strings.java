package javaAssignment;
import javax.swing.*;
import java.awt.*;

public class Strings {//con
    static GUI gui;
    public static void handleButtonClick(String s1, String s2, int index){
        switch (index) {
            case 0:
                if(s1.equals(s2))
                    gui.displayMessage("Both strings are equal");
                else
                    gui.displayMessage("Both strings are not equal");
                break;
            case 1:
                String newString = s1.concat(s2);
                gui.displayMessage("Concatenated string: " + newString);
                break;
            case 2:
                int value = s1.compareTo(s2);
                if (value == 0)
                    gui.displayMessage("Both strings are equal");
                else if (value > 0)
                    gui.displayMessage("\"" + s1 + "\" is greater than \"" + s2 + "\"");
                else
                    gui.displayMessage("\"" + s2 + "\" is greater than \"" + s1 + "\"");
                break;
            case 3:
                int idx = s1.indexOf(s2);
                if(idx == -1)
                    gui.displayMessage("\"" + s2 + "\" was not found in \"" + s1 + "\"");
                else
                    gui.displayMessage("\"" + s2 + "\" found at index " + idx);
                break;
            case 4:
                gui.displayMessage("Lowercase: " + s1.toLowerCase() + " | " + s2.toLowerCase());
                break;
            case 5:
                gui.displayMessage("Uppercase: " + s1.toUpperCase() + " | " + s2.toUpperCase());
                break;
            default:
                gui.displayMessage("Enter two strings");
                break;
        }
    }
    public static void main(String[] args) {
        gui = new GUI();
    }
    
}

class GUI {
    private JTextField textField1;
    private JTextField textField2;
    private JLabel messageLabel;
    private JFrame frame;
    private static String[] buttonName = {
        "Equals",
        "Concat",
        "Compare",
        "Index Of",
        "Lowercase",
        "Uppercase"
    };
    public GUI(){
        frame = new JFrame();
        setup();
    }
    private void setup() {
        frame.setTitle("Strng Operations");
        frame.setSize(620, 320);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Top Panel (all inputs on one line)
        JPanel topPanel = new JPanel(new GridLayout(1, 5, 10, 10));
        JLabel inputLabel = new JLabel("Input 1:");
        textField1 = new JTextField();
        JLabel inputLabe2 = new JLabel("Input 2:");
        textField2 = new JTextField();
        JButton clearButton = new JButton("Clear");
        // Clear button functionality
        clearButton.addActionListener(e -> {
            textField1.setText("");
            textField2.setText("");
            messageLabel.setText("Enter two strings");
        });

        topPanel.add(inputLabel);
        topPanel.add(textField1);
        topPanel.add(inputLabe2);
        topPanel.add(textField2);
        topPanel.add(clearButton);

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

            x += 160;  // move right
            if(i == 2)
            {
                x = 30;
                y = 60;
            }
        }

        frame.add(centerPanel, BorderLayout.CENTER);

        // Bottom Label
        messageLabel = new JLabel("Enter two Strings");
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        frame.add(messageLabel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
    private void clickEvent(int index){
        String s1 = textField1.getText();
        String s2 = textField2.getText();

        if (s1 == null || s2 == null || s1.trim().isEmpty() || s2.trim().isEmpty()) {
            displayMessage("Enter two strings");
            return;
        }

        Strings.handleButtonClick(s1, s2, index);
    }
    public void displayMessage(String msg){
        messageLabel.setText(msg);
    }

}
