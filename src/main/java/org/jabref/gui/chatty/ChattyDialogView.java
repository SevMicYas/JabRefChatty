package org.jabref.gui.chatty;

import javafx.fxml.FXML;

import org.jabref.gui.ClipBoardManager;
import org.jabref.gui.DialogService;
import org.jabref.gui.help.AboutDialogViewModel;
import org.jabref.gui.util.BaseDialog;
import org.jabref.logic.l10n.Localization;

import com.airhacks.afterburner.views.ViewLoader;
import jakarta.inject.Inject;

public class ChattyDialogView extends BaseDialog<Void> {

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
}
