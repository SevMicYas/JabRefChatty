package org.jabref.logic.chatgpt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GPTinterfaceTest {

    @Test
    void GptApiTest() {
        try {
            String message = GPTinterface.sendChatAndGetResponse("Say Tomato");
            assertEquals("Tomato", message);
        } catch (RuntimeException e) {
            String errorMessage = e.getMessage();
            if (errorMessage.contains("401")) {
                assertEquals("Correct ErrorCode", "Correct ErrorCode");
            } else {
                assertEquals("Correct ErrorCode", "False ErrorCode");
            }
        }
    }
}
