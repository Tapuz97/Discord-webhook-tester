package test.discord;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class DiscordApiTesterController {

	
	@FXML TextField webhookUrl;
	@FXML Button sendBtn;
	@FXML TextField resultText;
	@FXML CheckBox withMsgChkBx;
    @FXML private void openLinkedin() {openLink("https://www.linkedin.com/in/galmitrani1/");}
    @FXML private void openGit() {openLink("https://github.com/Tapuz97");}
	private Gson gson = new GsonBuilder().create();

    
    
    @FXML
    private void initialize() {
    	resultText.setDisable(true);
    }
    
    
    @FXML
    private boolean sendMsg() {
        String url = webhookUrl.getText().trim();
        System.out.println("Webhook URL: " + url);
        boolean withMsg = withMsgChkBx.isSelected();

        if (url == null || url.isEmpty() || !url.matches("^https://discord(?:app)?\\.com/api/webhooks/\\d+/[\\w-]+$")) {
            resultText.setText("URL is null, empty or invalid. Aborting.");
			resultText.getStyleClass().add("error-box");
            return false;
        }

        int responseCode = verifyKey(url);
        resultText.getStyleClass().removeAll("success-box", "error-box");
        if (responseCode==204) {
            resultText.setText("204: Key verified successfully.");
            resultText.getStyleClass().add("success-box");

            return true;
        }
        else {
			resultText.setText("Key verification failed. Please check the webhook URL.");
			resultText.getStyleClass().add("error-box");
			return false;
        }
        
    }
    
    public int verifyKey(String webhookUrl) {
        boolean withMsg = withMsgChkBx.isSelected(); // read checkbox state here
        String payload = createTestPayLoad(!withMsg); // send blank if not withMsg
        return postToDiscord(payload, webhookUrl);
    }
    
    private int postToDiscord(String jsonPayload,String webhookUrl){
        URL url;
		try {
			url = new URL(webhookUrl);
		} catch (MalformedURLException e) {
			return -1;
		}
        HttpURLConnection connection = null;
		try {
			connection = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			return -1;
		}
        try {
			connection.setRequestMethod("POST");
		} catch (ProtocolException e) {
			return -1;
		}
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        try (OutputStream os = connection.getOutputStream()) {
            os.write(jsonPayload.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e1) {
        	return -1;
		}
        int responseCode = -1;
		try {
			responseCode = connection.getResponseCode();
		} catch (IOException e) {
			return -1;
		}
        try {
			connection.getInputStream().close();
		} catch (IOException e) {
			return -1;
		}
        return responseCode;
    }
    
    private String createTestPayLoad(boolean isBlank) {
    	
        if (isBlank) {
        	String blank = "󠀠󠀠";//"Tag Space Emoji"
            Map<String, Object> payload = new HashMap<>();
            payload.put("content", blank);
            payload.put("embeds", null);
            return gson.toJson(payload);
        }
        
        String keyIcon = "https://i.imgur.com/xf9Etn2.png"; // Key icon
        String checkmarkIcon = "https://i.imgur.com/Q3pHQaA.png"; // Checkmark icon
        Map<String, Object> embed = new HashMap<>();
        embed.put("title", "API Key Verification");
        embed.put("color", 5785327);
        embed.put("timestamp", Instant.now().toString());

        List<Map<String, String>> fields = new ArrayList<>();
        
        fields.add(createField("Verified 🟢", ""));
        fields.add(createField("Status", "204"));
        embed.put("fields", fields);
        embed.put("thumbnail", Map.of(
            "url", checkmarkIcon // 
        ));

        Map<String, Object> payload = new HashMap<>();
        payload.put("username", "API Tester");	
        payload.put("avatar_url", keyIcon);//user icon
        payload.put("content", null);
        payload.put("embeds", List.of(embed));
        return gson.toJson(payload);
    }
    
    private void openLink(String url) {
        try {
            java.awt.Desktop.getDesktop().browse(new java.net.URI(url));
        } catch (Exception e) {}
    }
    
    private Map<String, String> createField(String name, String value) {
    	
        return Map.of("name", name, "value", value);
    }
    
}
