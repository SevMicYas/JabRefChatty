package org.jabref.gui.collab.entrySummaryAbstract;

import org.jabref.gui.collab.DatabaseChange;
import org.jabref.gui.collab.DatabaseChangeResolverFactory;
import org.jabref.gui.undo.NamedCompound;
import org.jabref.gui.undo.UndoableRemoveEntries;
import org.jabref.logic.importer.fileformat.medline.Abstract;
import org.jabref.logic.l10n.Localization;
import org.jabref.model.database.BibDatabaseContext;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.Field;

public final class AbstractSummaryButton extends DatabaseChange{

    private final BibEntry abstractEntry;

    public AbstractSummaryButton(BibEntry abstractEntry, BibDatabaseContext databaseContext, DatabaseChangeResolverFactory databaseChangeResolverFactory) {
        super(databaseContext, databaseChangeResolverFactory);
        this.abstractEntry = abstractEntry;
        setChangeName(abstractEntry.getCitationKey()
                .map(key -> Localization.lang("abstract entry '%0'", key))
                .orElse(Localization.lang("Deleted entry")));
        //abstractEntry.getField("Abstract");
    }

    @Override
    public void applyChange(NamedCompound undoEdit) {

    }

    public String getAbstractEntry() {
        return abstractEntry.toString();
    }
}
