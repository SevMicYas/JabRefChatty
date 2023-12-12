package org.jabref.gui.chatty;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;

import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import org.jabref.gui.ClipBoardManager;
import org.jabref.gui.DialogService;
import org.jabref.gui.util.BaseDialog;
import org.jabref.logic.chatgpt.GPTinterface;
import org.jabref.logic.l10n.Localization;

import com.airhacks.afterburner.views.ViewLoader;
import jakarta.inject.Inject;

public class ChattyDialogView extends BaseDialog<Void> {

    @FXML
    private TextField chatField;
    @FXML
    private VBox chat = new VBox();
    @FXML
    private ScrollPane scrollPane;
    @Inject private DialogService dialogService;
    @Inject private ClipBoardManager clipBoardManager;

    private ChattyDialogViewModel viewModel;
    private String lastMessage;

    private String systemRole = "{\"role\": \"system\", \"content\": \"You are a helpful sarcastic assistant called Chatty.\"}";

    private StringBuilder resultBuilder = new StringBuilder();

    public ChattyDialogView() {
        this.setTitle(Localization.lang("Chatty"));
        this.setOnCloseRequest(dialogEvent -> {
            resultBuilder.setLength(0);
            resultBuilder.append(systemRole);
            chat.getChildren().clear();
        });

        ViewLoader.view(this)
                  .load()
                  .setAsDialogPane(this);
    }

    public ChattyDialogViewModel getViewModel() {
        return viewModel;
    }

    @FXML
    private void initialize() {
        viewModel = new ChattyDialogViewModel(dialogService, clipBoardManager);
        this.setResizable(true);
        resultBuilder.append(systemRole);

        // To scroll auotomatically to the bottom if new Chat messages come...
        chat.heightProperty().addListener(
                (observable, oldValue, newValue) -> scrollPane.setVvalue((Double) newValue));
    }

    @FXML
    private void send() {
        String message = chatField.getText();
        displayQuestion(message);
        chatField.clear();
        String outMessage = replaceSpecialChars(message);
        outMessage = userMsgFormater(outMessage);
        String finalOutMessage = outMessage;
        new Thread(() -> {
            String response = sendToBackend(finalOutMessage);
            chattyMsgFormater(response);
            // displayResponse("This is a message with a newline.\nAnother line.");
            displayResponse(response);
            System.out.println("Response: " + response);
        }).start();
    }

    private void displayQuestion(String msg) {
        Text text = new Text("You: " + msg);
        text.setFont(Font.font("Arial", 20));
        TextFlow textFlow = new TextFlow(text);
        textFlow.setStyle("-fx-background-color: #99ccff; -fx-padding: 5px; -fx-background-radius: 10px;");
        HBox hbox = new HBox(textFlow);
        hbox.setAlignment(Pos.CENTER_RIGHT);
        hbox.setPadding(new Insets(10, 10, 10, 30));
        Platform.runLater(() -> chat.getChildren().add(hbox));
    }

    private void displayResponse(String msg) {
        Text text = new Text("Chatty: " + msg);
        text.setFont(Font.font("Arial", 20));
        TextFlow textFlow = new TextFlow(text);
        textFlow.setStyle("-fx-background-color: #ccffcc; -fx-padding: 5px; -fx-background-radius: 10px;");
        HBox hbox = new HBox(textFlow);
        hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.setPadding(new Insets(10, 30, 10, 10));
        Platform.runLater(() -> chat.getChildren().add(hbox));
    }

    private String sendToBackend(String input) {
        String response = GPTinterface.sendChatAndGetResponse(input);
        lastMessage = response;
        return response;
    }

    private static String replaceSpecialChars(String input) {
        System.out.println("Before replacing special chars: " + input);
        input = input.replace("\\", "\\\\");
        input = input.replace("\"", "\\\"");
        input = input.replace("\n", "\\n");

        System.out.println("After replacing special chars: " + input);
        return input;
    }

    @FXML
    private void copyToClipboard() {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent clipboardContent = new ClipboardContent();
        clipboardContent.putString(lastMessage);
        clipboard.setContent(clipboardContent);
    }

    private String userMsgFormater(String input) {
        resultBuilder.append(",\n{\"role\": \"user\", \"content\": \"" + input + "\"}");
        return resultBuilder.toString();
    }

    private String chattyMsgFormater(String input) {
        input = replaceSpecialChars(input);
        System.out.println("String being appended to context: " + input);
        resultBuilder.append(",\n{\"role\": \"assistant\", \"content\": \"" + input + "\"}");
        return resultBuilder.toString();
    }
}

