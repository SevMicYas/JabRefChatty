package org.jabref.logic.chatgpt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class APIKeyHandlerTests {

    private static final String API_KEY_FILE_PATH = "api-key.txt";

    private static Path getFilePath() {
        return Paths.get(API_KEY_FILE_PATH);
    }
    @BeforeEach
    void setup(){
        setApiKey();
    }
    @Test
    void getApiKeyNotNull(){
        String testResult = APIKeyHandler.getApiKey();
        assertNotNull(testResult);
    }

    @Test
    void isEqualApiKey(){
        String testResult = APIKeyHandler.getApiKey();
        assertEquals("FirstTestApiKey", testResult);
    }

    @Test
    void isUpdated(){
        String firstKey = APIKeyHandler.getApiKey();
        setApiKey("SecondApiKey");
        String secondKey = APIKeyHandler.getApiKey();
        assertNotEquals(firstKey, secondKey);

    }

    void setApiKey(String key){
        try {
            Files.write(getFilePath(), Collections.singletonList(key));
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    void setApiKey(){
        try {
            Files.write(getFilePath(), Collections.singletonList("FirstTestApiKey"));
        } catch(IOException e){
            e.printStackTrace();
        }
    }

}
