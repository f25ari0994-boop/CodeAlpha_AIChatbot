import javax.swing.*;
import java.awt.*;

public class ChatBotGUI extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    public ChatBotGUI() {

        setTitle("AI Chatbot");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Chat area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);

        // Input panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        inputField = new JTextField();
        sendButton = new JButton("Send");

        panel.add(inputField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);

        add(panel, BorderLayout.SOUTH);

        // Send action
        sendButton.addActionListener(e -> respond());

        inputField.addActionListener(e -> respond());

        setVisible(true);
    }

    // Simple NLP / Rule-based logic
    private void respond() {
        String userText = inputField.getText().toLowerCase();
        chatArea.append("You: " + userText + "\n");

        String response = getResponse(userText);

        chatArea.append("Bot: " + response + "\n\n");
        inputField.setText("");
    }

    private String getResponse(String input) {

        if (input.contains("hello") || input.contains("hi")) {
            return "Hello! How can I help you?";
        } 
        else if (input.contains("name")) {
            return "I am a Java AI Chatbot.";
        } 
        else if (input.contains("how are you")) {
            return "I am just a program, but I am working fine!";
        } 
        else if (input.contains("help")) {
            return "You can ask me about name, greetings, or basic questions.";
        } 
        else {
            return "Sorry, I don't understand that yet.";
        }
    }

    public static void main(String[] args) {
        new ChatBotGUI();
    }
}