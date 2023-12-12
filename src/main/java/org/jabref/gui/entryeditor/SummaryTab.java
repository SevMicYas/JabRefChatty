package org.jabref.gui.entryeditor;

import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import org.jabref.gui.DialogService;
import org.jabref.gui.icon.IconTheme;
import org.jabref.gui.texparser.CitationsDisplay;
import org.jabref.gui.util.TaskExecutor;
import org.jabref.logic.l10n.Localization;
import org.jabref.model.database.BibDatabaseContext;
import org.jabref.model.entry.BibEntry;
import org.jabref.preferences.PreferencesService;

public class SummaryTab extends EntryEditorTab {

    private final LatexCitationsTabViewModel viewModel;
    private final GridPane searchPane;
    private final ProgressIndicator progressIndicator;


    public SummaryTab(BibDatabaseContext databaseContext, PreferencesService preferencesService,
                             TaskExecutor taskExecutor, DialogService dialogService) {
        this.viewModel = new LatexCitationsTabViewModel(databaseContext, preferencesService, taskExecutor, dialogService);
        this.searchPane = new GridPane();
        this.progressIndicator = new ProgressIndicator();

        setText(Localization.lang("Summmary Abstract"));
        setTooltip(new Tooltip(Localization.lang("Search citations for this entry in LaTeX files")));
        setGraphic(IconTheme.JabRefIcons.LATEX_CITATIONS.getGraphicNode());
        //setSearchPane();
    }

    /**
     * Decide whether to show this tab for the given entry.
     *
     * @param entry
     */
    @Override
    public boolean shouldShow(BibEntry entry) {
        return true;
    }

    /**
     * Updates the view with the contents of the given entry.
     *
     * @param entry
     */
    @Override
    protected void bindToEntry(BibEntry entry) {
        viewModel.init(entry);
    }
}
