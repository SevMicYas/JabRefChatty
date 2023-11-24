package org.jabref.gui.chatty;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
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
    @Inject private DialogService dialogService;
    @Inject private ClipBoardManager clipBoardManager;

    private ChattyDialogViewModel viewModel;
    private String lastMessage;

    private String systemRole = "{\"role\": \"system\", \"content\": \"You are a helpful assistant.\"}";

    StringBuilder resultBuilder = new StringBuilder();


    public ChattyDialogView() {
        this.setTitle(Localization.lang("Chatty"));

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
    }

    @FXML
    private void send() {
        String message = chatField.getText();
        chatField.clear();
        String outMessage = replaceSpecialChars(message);
        outMessage = userMsgFormater(outMessage);
        // TODO: Add message to context
        String finalOutMessage = outMessage;
        new Thread(() -> {
            String response = sendToBackend(finalOutMessage);
            chattyMsgFormater(response);
            System.out.println(response);
        }).start();
        // TODO: Display messages in GUI!!
    }

    private String sendToBackend(String input) {
        String response = GPTinterface.sendChatAndGetResponse(input);
        lastMessage = response;
        return response;
    }

    private static String replaceSpecialChars(String input) {
        input = input.replace("\\", "\\\\");
        input = input.replace("\"", "\\\"");
        return input;
    }

    @FXML
    private void copyToClipboard() {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent clipboardContent = new ClipboardContent();
        clipboardContent.putString(lastMessage);
        clipboard.setContent(clipboardContent);
    }

    private String userMsgFormater(String input){
        resultBuilder.append(",\n{\"role\": \"user\", \"content\": \"" + input + "\"}");
        return resultBuilder.toString();
    }

    private String chattyMsgFormater(String input){
        resultBuilder.append(",\n{\"role\": \"assistant\", \"content\": \"" + input + "\"}");
        return resultBuilder.toString();
    }
}

