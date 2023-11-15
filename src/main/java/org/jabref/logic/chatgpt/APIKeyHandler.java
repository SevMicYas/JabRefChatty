package org.jabref.logic.chatgpt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javafx.scene.control.TextInputDialog;

import org.jabref.gui.actions.SimpleCommand;

public class APIKeyHandler extends SimpleCommand {
    private static final String API_KEY_FILE_PATH = "api-key.txt";


    // Method to get the API key from the file
    public static String getApiKey() {
        try {
            // Read all lines from the file
            List<String> lines = Files.readAllLines(getFilePath());

            // If there are lines in the file, return the first one (assuming one API key per file)
            if (!lines.isEmpty()) {
                return lines.get(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // Return null if there was an error or the file is empty
    }


    // Private helper method to get the file path
    private static Path getFilePath() {
        return Paths.get(API_KEY_FILE_PATH);
    }

    @Override
    public void execute() {
        //Used to be setApiKey() was changed in order to work with @Override
        TextInputDialog dialog = new TextInputDialog("xx-xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        dialog.setTitle("API-key");
        dialog.setHeaderText("Please enter your ChatGPT API-key");
        dialog.setContentText("API-key:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
           try{
               System.out.println(getFilePath());
               Files.write(getFilePath(), Collections.singletonList(result.get()));
           }catch (IOException e){
               e.printStackTrace();
           }
        }


    }
}
