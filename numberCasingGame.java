import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class numberCasingGame extends JFrame {

    private final Random random = new Random();
    private final JLabel promptLabel;
    private final JTextField userInputField;
    private final JButton submitButton;
    private final JTextArea feedbackArea;
    private int secretNumber;
    private int score;

    public numberCasingGame() {
        setTitle("Number Casing Game");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        promptLabel = new JLabel("Guess the number (between 1 and 100):");
        add(promptLabel);

        userInputField = new JTextField(10);
        add(userInputField);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitButtonListener());
        add(submitButton);

        feedbackArea = new JTextArea(10, 30);
        feedbackArea.setEditable(false);
        add(new JScrollPane(feedbackArea));

        score = 0;
        playGame();
    }

    private void playGame() {
        secretNumber = random.nextInt(100) + 1;
        feedbackArea.setText("");
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int userGuess = Integer.parseInt(userInputField.getText());
                if (userGuess == secretNumber) {
                    feedbackArea.append("Congratulations! You guessed the correct number " + secretNumber + ".\n");
                    score++;
                    playGame();
                } else if (userGuess < secretNumber) {
                    feedbackArea.append("Too low. Try again.\n");
                } else {
                    feedbackArea.append("Too high. Try again.\n");
                }
            } catch (NumberFormatException ex) {
                feedbackArea.append("Please enter a valid number.\n");
            }
            userInputField.setText("");
            userInputField.requestFocus();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new numberCasingGame().setVisible(true);
        });
    }
}





