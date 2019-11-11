import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.Group;


public class mainMenu extends Application{
Scene mainMenuScene, loginScene, registerScene = null;



	@Override
    public void start(Stage primaryStage) throws Exception
     {
        primaryStage.setTitle("Welcome to CinEMACS");
        GridPane menuPane = createRegistrationFormPane();
        GridPane loginPane = createRegistrationFormPane();
        GridPane regPane = createRegistrationFormPane();
        addLoginControls(loginPane);
        addRegisterControls(regPane);
        addUIControls(menuPane, primaryStage);
        mainMenuScene = new Scene(menuPane, 800, 500);
        loginScene = new Scene(loginPane, 800, 500);
        registerScene = new Scene(regPane, 800, 500);	
        primaryStage.setScene(mainMenuScene);
        primaryStage.show();
    }
    
    
    private GridPane createRegistrationFormPane() 
    {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(40, 40, 40, 40));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        ColumnConstraints columnOneConstraints = new ColumnConstraints(150, 150, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }
		//Controls for Main Menu
 	    private void addUIControls(GridPane menuPane, Stage window) {
        Label headerLabel = new Label("Welcome to CINEMACS");
        headerLabel.setFont(Font.font("Dekko", FontWeight.BOLD, 32));
        menuPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));
        
		//Login Button
        Button loginButton = new Button("Login");
        loginButton.setPrefHeight(60);
        loginButton.setDefaultButton(true);
        loginButton.setPrefWidth(400);
        menuPane.add(loginButton, 0, 4, 2, 1);
        GridPane.setHalignment(loginButton, HPos.CENTER);
        GridPane.setMargin(loginButton, new Insets(20, 0,20,0));
        
        //Register Button
        Button regButton = new Button("Register");
        regButton.setPrefHeight(60);
        regButton.setDefaultButton(true);
        regButton.setPrefWidth(400);
        menuPane.add(regButton, 0, 5, 2, 1);
        GridPane.setHalignment(regButton, HPos.CENTER);
        GridPane.setMargin(regButton, new Insets(20, 0,20,0));
        
        //Switching to another scene!
        loginButton.setOnAction(e -> window.setScene(loginScene));
        regButton.setOnAction(e -> window.setScene(registerScene));
    }
    	    private void addRegisterControls(GridPane regPane) {
        // Add Header
        Label headerLabel = new Label("Sign Up");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        regPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        // Add Name Label
        Label nameLabel = new Label("Full Name : ");
        regPane.add(nameLabel, 0,1);

        // Add Name Text Field
        TextField nameField = new TextField();
        nameField.setPrefHeight(40);
        regPane.add(nameField, 1,1);


        // Add Email Label
        Label emailLabel = new Label("Email ID : ");
        regPane.add(emailLabel, 0, 2);

        // Add Email Text Field
        TextField emailField = new TextField();
        emailField.setPrefHeight(40);
        regPane.add(emailField, 1, 2);

        // Add Password Label
        Label passwordLabel = new Label("Password : ");
        regPane.add(passwordLabel, 0, 3);

        // Add Password Field
        PasswordField passwordField = new PasswordField();
        passwordField.setPrefHeight(40);
        regPane.add(passwordField, 1, 3);
        
        Label confirmPasswordLabel = new Label("Confirm Password : ");
        regPane.add(confirmPasswordLabel, 0, 4);
        
        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setPrefHeight(40);
        regPane.add(confirmPasswordField, 1,4);
        

        // Add Submit Button
        Button submitButton = new Button("Submit");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        regPane.add(submitButton, 0, 8, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));
        
        //Add Return
        Button returnButton = new Button("Return");
        returnButton.setPrefHeight(40);
        returnButton.setDefaultButton(true);
        returnButton.setPrefWidth(100);
        regPane.add(returnButton, 1, 8, 7, 1);
        GridPane.setHalignment(returnButton, HPos.CENTER);
        GridPane.setMargin(returnButton, new Insets(20, 0,20,0));
		Stage window = new Stage();
//Validating the input to the Registration Page
		//returnButton.setOnAction();
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	String pattern = "[a-z]{1,15} [a-z]{1,15}";
            	String emailPattern = "[A-Za-z0-9]{1,}@[A-Za-z]{1,15}.com";
            	String passwordPattern = "[A-Za-z0-9]{5,20}";
                if(nameField.getText().isEmpty() || emailField.getText().isEmpty() || passwordField.getText().isEmpty() || confirmPasswordField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, regPane.getScene().getWindow(), "Form Error!", "One of the required fields is empty");
                    return;
                }
                else if (!(nameField.getText().toLowerCase().matches(pattern)))
                {
                	showAlert(Alert.AlertType.ERROR, regPane.getScene().getWindow(), "Form Error!", "Full name doesn't match the expected input (No Numbers and A Full Name i.e John Doe");
                	return;
                }
                else if (!(emailField.getText().matches(emailPattern)))
                {
                	showAlert(Alert.AlertType.ERROR, regPane.getScene().getWindow(), "Form Error!", "Email doesn't match the expected input ([A-Za-z0-9]{1,}@[A-Za-z]{1,15}.com)");
                	return;
                }
                else if (!(passwordField.getText().matches(passwordPattern)))
                {
                	showAlert(Alert.AlertType.ERROR, regPane.getScene().getWindow(), "Form Error!", "Password doesn't match the expected input (Between 5 and 20 characters)");
                	return;
                }
                else if (!(confirmPasswordField.getText().matches(passwordField.getText())))
                {
                	showAlert(Alert.AlertType.ERROR, regPane.getScene().getWindow(), "Form Error!", "Confirm Password doesn't match the original password");
                	return;
                }
                //showAlert(Alert.AlertType.CONFIRMATION, regPane.getScene().getWindow(), "Registration Successful!", "Welcome " + nameField.getText() + "\nYour information is being authenticated by the server");
                Account newAccount = new accountBuilder().setAccountName(nameField.getText().toUpperCase()).setAccountPassword(passwordField.getText()).setAccountEmail(emailField.getText()).getAccount();
                showAlert(Alert.AlertType.CONFIRMATION, regPane.getScene().getWindow(), "Working", newAccount.toString());
            }
        });
    }
    	private void addLoginControls(GridPane loginPane)
    	{
    		// Add Header
            Label headerLabel = new Label("Log In");
            headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
            loginPane.add(headerLabel, 0,0,2,1);
            GridPane.setHalignment(headerLabel, HPos.CENTER);
            GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

            // Add Name Label
            Label nameLabel = new Label("Username: ");
            loginPane.add(nameLabel, 0,1);

            // Add Name Text Field
            TextField nameField = new TextField();
            nameField.setPrefHeight(40);
            loginPane.add(nameField, 1,1);

            // Add Password Label
            Label passwordLabel = new Label("Password : ");
            loginPane.add(passwordLabel, 0, 3);

            // Add Password Field
            PasswordField passwordField = new PasswordField();
            passwordField.setPrefHeight(40);
            loginPane.add(passwordField, 1, 3);

            // Add Submit Button
            Button submitButton = new Button("Submit");
            submitButton.setPrefHeight(40);
            submitButton.setDefaultButton(true);
            submitButton.setPrefWidth(100);
            GridPane.setHalignment(submitButton, HPos.CENTER);
            loginPane.add(submitButton, 0, 4, 2, 1);
            GridPane.setMargin(submitButton, new Insets(20, 20, 20, 0));
            submitButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if(nameField.getText().isEmpty()) {
                        showAlert(Alert.AlertType.ERROR, loginPane.getScene().getWindow(), "Form Error!", "Please enter your name");
                        return;
                    }
                    if(passwordField.getText().isEmpty()) {
                        showAlert(Alert.AlertType.ERROR, loginPane.getScene().getWindow(), "Form Error!", "Please enter a password");
                        return;
                    }

                    showAlert(Alert.AlertType.CONFIRMATION, loginPane.getScene().getWindow(), "Sign in successful!", "Welcome Back " + nameField.getText());

                }
            });


        }
            private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) 
            {
           		Alert alert = new Alert(alertType);
            	alert.setTitle(title);
            	alert.setHeaderText(null);
            	alert.setContentText(message);
            	alert.initOwner(owner);
            	alert.show();
        	}
			public static void main (String [] args)
			{
				launch(args);
			}
}
	
		