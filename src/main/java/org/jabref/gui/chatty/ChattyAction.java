package org.jabref.gui.chatty;

import org.jabref.gui.DialogService;
import org.jabref.gui.actions.SimpleCommand;

import com.airhacks.afterburner.injection.Injector;

public class ChattyAction extends SimpleCommand {
    private final ChattyDialogView chattyDialogView;

    public ChattyAction() {
        this.chattyDialogView = new ChattyDialogView();
    }

    @Override
    public void execute() {
        DialogService dialogService = Injector.instantiateModelOrService(DialogService.class);
        dialogService.showCustomDialog(chattyDialogView);
    }
}
