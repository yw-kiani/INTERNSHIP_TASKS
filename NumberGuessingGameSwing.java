package Tasks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGuessingGameSwing extends JFrame {

    private JTextField guessField;
    private JButton guessButton;
    private JLabel resultLabel;

    private Random random = new Random();
    private int secretNumber;
    private int attemptsLeft = 5;

    public NumberGuessingGameSwing() {
        setTitle("Number Guessing Game");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        guessField = new JTextField();
        guessButton = new JButton("submit");
        resultLabel = new JLabel("");

        panel.add(guessField);
        panel.add(guessButton);
        panel.add(resultLabel);

        add(panel);

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!guessField.getText().isEmpty()) {
                    int userGuess = Integer.parseInt(guessField.getText());
                    checkGuess(userGuess);
                    guessField.setText("");
                }
            }
        });

        startNewGame();
    }

    private void startNewGame() {
        secretNumber = random.nextInt(100) + 1;
        attemptsLeft = 5;
        resultLabel.setText("");
    }

    private void checkGuess(int userGuess) {
        attemptsLeft--;

        if (userGuess == secretNumber) {
            showResult("Congratulations! You guessed the correct number.");
        } else if (attemptsLeft == 0) {
            showResult("Sorry, you're out of attempts. The correct number was: " + secretNumber);
        } else if (userGuess < secretNumber) {
            showResult("Too low. Try again.");
        } else {
            showResult("Too high. Try again.");
        }
    }

    private void showResult(String message) {
        resultLabel.setText(message);
        if (!message.contains("Try again")) {
            int option = JOptionPane.showConfirmDialog(this, message + "\nDo you want to play again?", "Game Over", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                startNewGame();
            } else {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NumberGuessingGameSwing().setVisible(true);
            }
        });
    }
}

