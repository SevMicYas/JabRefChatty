package org.jabref.gui.entryeditor;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import org.jabref.gui.AbstractViewModel;
import org.jabref.gui.DialogService;
import org.jabref.gui.util.TaskExecutor;
import org.jabref.logic.util.io.FileUtil;
import org.jabref.model.database.BibDatabaseContext;
import org.jabref.preferences.PreferencesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;

public class SummaryTabViewModel extends AbstractViewModel {

    private static final Logger LOGGER = LoggerFactory.getLogger(LatexCitationsTabViewModel.class);
    private final TaskExecutor taskExecutor;
    private final DialogService dialogService;
    private final BibDatabaseContext databaseContext;
    private final PreferencesService preferencesService;

    public String Abstract;
    public SummaryTabViewModel (DialogService dialogService, TaskExecutor taskExecutor, BibDatabaseContext databaseContext, PreferencesService preferencesService, String Abstract) {
        this.databaseContext = databaseContext;
        this.preferencesService = preferencesService;
        this.taskExecutor = taskExecutor;
        this.dialogService = dialogService;
        this.Abstract = Abstract;
    }


}
