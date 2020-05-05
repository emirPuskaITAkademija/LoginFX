package login;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * Entry point -> Login extends Application
 *
 * <li> start(Stage primaryStage)
 * <li> main -> launch(args)
 *
 * @author emir
 */
public class Login extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Login aplikacija");
        //kontejner i layout manager -> JPanel i GridLayout
        GridPane gridPanel = new GridPane();
        gridPanel.setAlignment(Pos.CENTER);
        gridPanel.setHgap(10);
        gridPanel.setVgap(10);
        Insets paddingInsets = new Insets(25, 25, 25, 25);
        gridPanel.setPadding(paddingInsets);
        //gridPanel.setGridLinesVisible(true);

        Text loginTitleText = new Text("Dobro došli");
       
        Font logintTitleFont = Font.font("Tahoma", FontWeight.BOLD, 20);
        loginTitleText.setFont(logintTitleFont);
        loginTitleText.setId("welcome-text");
        gridPanel.add(loginTitleText, 0, 0, 2, 1);

        Label usernameLabel = new Label("Korisnički nalog:");
        gridPanel.add(usernameLabel, 0, 1);
        TextField usernameTextField = new TextField();
        gridPanel.add(usernameTextField, 1, 1);

        Label passwordLabel = new Label("Lozinka:");
        gridPanel.add(passwordLabel, 0, 2);
        PasswordField passwordField = new PasswordField();
        gridPanel.add(passwordField, 1, 2);

        Button button = new Button("Login");
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        hBox.getChildren().add(button);
        gridPanel.add(hBox, 1, 4);

        Text badLoginText = new Text();
        gridPanel.add(badLoginText, 1, 6);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                badLoginText.setFill(Color.RED);
                badLoginText.setText("Malko morgen ćeš se ulogovat");
            }
        });
        badLoginText.setId("loginStatusLabel");

        Scene scene = new Scene(gridPanel, 400, 350);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(Login.class.getResource("Login.css").toExternalForm());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
