package Tasks;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame {

    private JLabel questionLabel;
    private JTextField answerField;
    private JButton nextButton;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private String[] questions = {
            "How many countries in the world?\nA: 195\nB: 200\nC: 165\nD: 175 ",
            "How many continents in the world?\nA: 5\nB: 7\nC: 6\nD: 15 ",
            "What is the capital of France?\nA: London\nB: Berlin\nC: Paris\nD: Madrid ",
            "Who wrote 'Romeo and Juliet'?\nA: Charles Dickens\nB: William Shakespeare\nC: Jane Austen\nD: Mark Twain ",
            "What is the largest mammal on Earth?\nA: Elephant\nB: Giraffe\nC: Blue Whale\nD: Polar Bear ",
            "In which year did Christopher Columbus reach the Americas?\nA: 1492\nB: 1607\nC: 1776\nD: 1812 ",
            "What is the capital of Japan?\nA: Seoul\nB: Tokyo\nC: Beijing\nD: Bangkok ",
            "Which planet is known as the 'Red Planet'?\nA: Mars\nB: Venus\nC: Jupiter\nD: Saturn ",
            "Who is the author of 'To Kill a Mockingbird'?\nA: J.K. Rowling\nB: Harper Lee\nC: George Orwell\nD: Ernest Hemingway ",
            "What is the chemical symbol for gold?\nA: Au\nB: Ag\nC: Fe\nD: Cu "
    };

    private String[] answers = {
            "195", "7", "Paris", "William Shakespeare", "Blue Whale",
            "1492", "Tokyo", "Mars", "Harper Lee", "Au"
    };

    public Quiz() {
        setTitle("Quiz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 200);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel questionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        questionLabel = new JLabel(questions[currentQuestionIndex]);
        questionPanel.add(questionLabel);
        add(questionPanel, BorderLayout.NORTH);

        JPanel answerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        answerField = new JTextField(10);
        answerPanel.add(answerField);
        add(answerPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
            }
        });
        buttonPanel.add(nextButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void checkAnswer() {
        String userAnswer = answerField.getText().trim();
        if (userAnswer.equalsIgnoreCase(answers[currentQuestionIndex])) {
            score++;
        }
        currentQuestionIndex++;
        if (currentQuestionIndex < questions.length) {
            questionLabel.setText(questions[currentQuestionIndex]);
            answerField.setText("");
        } else {
            displayResult();
        }
    }

    private void displayResult() {
        JOptionPane.showMessageDialog(this, "Your total score is " + score + " out of " + questions.length);
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Quiz().setVisible(true);
            }
        });
    }
}
