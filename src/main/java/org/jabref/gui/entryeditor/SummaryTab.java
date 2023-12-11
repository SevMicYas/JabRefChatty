package org.jabref.gui.entryeditor;

import com.tobiasdiez.easybind.EasyBind;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
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
    private final CitationsDisplay citationsDisplay;

    public SummaryTab(BibDatabaseContext databaseContext, PreferencesService preferencesService,
                             TaskExecutor taskExecutor, DialogService dialogService) {
        this.viewModel = new LatexCitationsTabViewModel(databaseContext, preferencesService, taskExecutor, dialogService);
        this.searchPane = new GridPane();
        this.progressIndicator = new ProgressIndicator();
        this.citationsDisplay = new CitationsDisplay();

        setText(Localization.lang("Abstract summary"));
        setTooltip(new Tooltip(Localization.lang("Random gibberish")));
        setGraphic(IconTheme.JabRefIcons.LATEX_CITATIONS.getGraphicNode());
        setSearchPane();
    }

    public void setSearchPane() {
        progressIndicator.setMaxSize(100, 100);
        citationsDisplay.basePathProperty().bindBidirectional(viewModel.directoryProperty());
        citationsDisplay.setItems(viewModel.getCitationList());

        RowConstraints mainRow = new RowConstraints();
        mainRow.setVgrow(Priority.ALWAYS);

        RowConstraints bottomRow = new RowConstraints(40);
        bottomRow.setVgrow(Priority.NEVER);

        ColumnConstraints column = new ColumnConstraints();
        column.setPercentWidth(100);
        column.setHalignment(HPos.CENTER);

        searchPane.getColumnConstraints().setAll(column);
        searchPane.getRowConstraints().setAll(mainRow, bottomRow);
        searchPane.setId("citationsPane");
        setContent(searchPane);
            EasyBind.subscribe(viewModel.statusProperty(), status -> {
                searchPane.getChildren().clear();
                switch (status) {
                    case ERROR:
                        searchPane.add(getErrorPane(EntryEditor.getSummarizedAbstract()), 0, 0);
                        break;
                }
            });
    }

    public void updateSearchPane() {
        Platform.runLater(() -> {
            searchPane.getChildren().clear();
            searchPane.add(getErrorPane(EntryEditor.getSummarizedAbstract()), 0, 0);
        });
    }

    public static VBox getErrorPane(String newAbstract) {
        Label titleLabel = new Label(Localization.lang("Summary"));
        titleLabel.setStyle("-fx-font-size: 1.5em;-fx-font-weight: bold;-fx-text-fill: darkgrey;");
        Text errorMessageText = new Text(newAbstract);
        TextFlow textFlow = new TextFlow(errorMessageText);
        VBox errorMessageBox = new VBox(30, titleLabel, textFlow);
        errorMessageBox.setStyle("-fx-padding: 30 0 0 30;");
        return errorMessageBox;
    }

    @Override
    protected void bindToEntry(BibEntry entry) {
        viewModel.init(entry);
    }

    @Override
    public boolean shouldShow(BibEntry entry) {
        return viewModel.shouldShow();
    }
}
