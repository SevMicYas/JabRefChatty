package org.jabref.gui.chatty;

import org.jabref.gui.AbstractViewModel;
import org.jabref.gui.ClipBoardManager;
import org.jabref.gui.DialogService;

public class ChattyDialogViewModel extends AbstractViewModel {

    private final DialogService dialogService;
    private final ClipBoardManager clipBoardManager;

    public ChattyDialogViewModel(DialogService dialogService, ClipBoardManager clipBoardManager) {
        this.dialogService = dialogService;
        this.clipBoardManager = clipBoardManager;
    }
}
