package org.jabref.gui.chatty;

import java.awt.Button;

import javafx.fxml.FXML;

public class ChattyController {

    @FXML
    private Button sendButton;
    @FXML
    private Button copyToClipboard;

    public void send() {
        System.out.println("Sends Chat to Chatty");
    }

    public void copyToClipboard() {
        System.out.println("Copies last message to Clipboard");
    }
}
