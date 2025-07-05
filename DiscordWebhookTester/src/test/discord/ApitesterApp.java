package test.discord;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ApitesterApp extends Application{
    /**
     * Starts the JavaFX application by loading the server GUI from FXML
     * and setting the window properties including title, icon, and size.
     *
     * @param primaryStage the main application window
     */
    @Override
    public void start(Stage primaryStage) {
        try {
            URL fxmlPath = getClass().getResource("DiscordApiTester.fxml");
            if (fxmlPath == null) {
                throw new RuntimeException("❌ FXML not found");
            }

            Parent root = FXMLLoader.load(fxmlPath);
            primaryStage.setTitle("Discord Api Tester");

            // ✅ Add CSS manually for runnable JAR compatibility
            URL cssPath = getClass().getResource("style.css");
            if (cssPath != null) {
                root.getStylesheets().add(cssPath.toExternalForm());
            } else {
                System.err.println("❌ style.css not found!");
            }

            primaryStage.getIcons().add(new Image("https://i.imgur.com/xf9Etn2.png"));
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();

        } catch (Exception e) {
            System.err.println("❌ Failed to start application");
            e.printStackTrace();
        }
    }


    /**
     * Main method to launch the JavaFX application.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        launch(args); // Triggers the start method
    }
}
