package org.jabref.logic.chatgpt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

public class GPTinterface {

    public static String model = "gpt-3.5-turbo";
    private static String apiKey;

    public static String summarizeAbstract(String prompt) {
        String url = "https://api.openai.com/v1/chat/completions";
        String task = "Summarize me the following text in one sentence: ";
        apiKey = APIKeyHandler.getApiKey();
        prompt = task + prompt;

        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + apiKey);
            connection.setRequestProperty("Content-Type", "application/json");

            // The request body
            String body = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + prompt + "\"}]}";
            connection.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(body);
            writer.flush();
            writer.close();

            // Response from ChatGPT
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;

            StringBuilder response = new StringBuilder();

            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();

            // calls the method to extract the message.
            return extractMessageFromJSONResponse(response.toString());
        } catch (IOException e) {
            if (e instanceof java.net.SocketException) {
                // Check if it's a socket exception (likely no internet connection)
                throw new RuntimeException("Uh-oh: Please check your internet connection.\n" +
                        " " + e);
            } else {
                if (e.getMessage().contains("401")) {
                    throw new RuntimeException("Uh-oh: Please check your API-key.\n" +
                            "Set your API-key under 'tools'->'set API-key'.\n" +
                            " " + e);
                }
            }
            throw new RuntimeException("Uh-oh: Something unexpected happened.\n" +
                    " " + e);
        }
    }

    public static String sendChatAndGetResponse(String prompt) {
        String url = "https://api.openai.com/v1/chat/completions";
        apiKey = APIKeyHandler.getApiKey();
        String model = "gpt-3.5-turbo";

        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + apiKey);
            connection.setRequestProperty("Content-Type", "application/json");

            // The request body
            String body = "{\"model\": \"" + model + "\", \"messages\": [" + prompt + "]}";
            connection.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            System.out.println("String being sent to ChatGPT: " + body);
            writer.write(body);
            writer.flush();
            writer.close();

            // Response from ChatGPT
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;

            StringBuilder response = new StringBuilder();

            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();

            System.out.println("String coming back from ChatGPT: " + response);

            // calls the method to extract the message.
            return extractMessageFromJSONResponse(response.toString());
        } catch (IOException e) {
            if (e instanceof java.net.SocketException) {
                throw new RuntimeException("Uh-oh: Please check your internet connection.\n" +
                        " " + e);
            } else {
                if (e.getMessage().contains("401")) {
                    throw new RuntimeException("Uh-oh: Please check your API-key.\n" +
                            "Set your API-key under 'tools'->'set API-key'.\n" +
                            " " + e);
                }
            }
            throw new RuntimeException("Uh-oh: Something unexpected happened.\n" +
                    " " + e);
        }
    }

    public static String extractMessageFromJSONResponse(String response) {
        int start = response.indexOf("content") + 11;

        int end = response.indexOf("finish_reason", start) - 16;

        return responseFormatter(response.substring(start, end));
    }

    private static String responseFormatter(String response) {
        System.out.println("Response before formatting: " + response);
        // response = response.replace("\\\\n", "\\n");
        // response = response.replace("\n", " ");
        // response = response.replace("\\n\\n", "\\n");
        response = response.replace("\\\\", "\\");
        response = response.replace("\\\"", "\"");
        response = response.replace("\\n", "\n");
        System.out.println("Response after formatting: " + response);
        return response;
    }
}
