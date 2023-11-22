package org.jabref.gui.chatty;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import org.jabref.gui.ClipBoardManager;
import org.jabref.gui.DialogService;
import org.jabref.gui.util.BaseDialog;
import org.jabref.logic.chatgpt.GPTinterface;
import org.jabref.logic.cleanup.EprintCleanup;
import org.jabref.logic.l10n.Localization;

import com.airhacks.afterburner.views.ViewLoader;
import jakarta.inject.Inject;

public class ChattyDialogView extends BaseDialog<Void> {

    @FXML
    private TextField chatField;
    @Inject private DialogService dialogService;
    @Inject private ClipBoardManager clipBoardManager;

    private ChattyDialogViewModel viewModel;

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
    }

    @FXML
    private void send() {
        String message = chatField.getText();
        chatField.clear();
        String response = GPTinterface.sendChatAndGetResponse(message);
        System.out.println("Response: " + response);
        // TODO: Add message to context
    }

    @FXML
    private void copyToClipboard() {
        System.out.println("copy button pressed");
    }
}
