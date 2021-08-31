package fr.xibalba.launcher.ui.panels;

import fr.xibalba.launcher.main.AxiumLauncher;
import fr.xibalba.launcher.lang.Lang;
import fr.xibalba.launcher.ui.PanelManager;
import fr.xibalba.launcher.ui.panel.Panel;
import fr.xibalba.utils.javaFX.Link;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class PanelLogin extends Panel {

    private final GridPane loginPanel = new GridPane();
    private final GridPane mainPanel = new GridPane();
    private final GridPane bottomPanel = new GridPane();

    @Override
    public void init(PanelManager panelManager) {

        super.init(panelManager);

        initLoginPanel();
        initMain();
        initBottom();

        this.layout.getChildren().add(loginPanel);
    }

    private void initLoginPanel() {

        loginPanel.setMinWidth(400);
        loginPanel.setMaxWidth(400);
        loginPanel.setMinHeight(580);
        loginPanel.setMaxHeight(580);

        loginPanel.getStylesheets().clear();
        loginPanel.getStylesheets().add(getClass().getClassLoader().getResource("style/panellogin.css").toString());

        GridPane.setVgrow(loginPanel, Priority.ALWAYS);
        GridPane.setHgrow(loginPanel, Priority.ALWAYS);
        GridPane.setValignment(loginPanel, VPos.CENTER);
        GridPane.setHalignment(loginPanel, HPos.CENTER);

        RowConstraints bottomConstraints = new RowConstraints();
        bottomConstraints.setValignment(VPos.BOTTOM);
        bottomConstraints.setMaxHeight(55);
        loginPanel.getRowConstraints().addAll(new RowConstraints(), bottomConstraints);
        loginPanel.add(mainPanel, 0, 0);
        loginPanel.add(bottomPanel, 0, 1);
    }

    private void initMain() {

        GridPane.setVgrow(mainPanel, Priority.ALWAYS);
        GridPane.setHgrow(mainPanel, Priority.ALWAYS);
        mainPanel.setStyle(getClass().getClassLoader().getResource("style/panellogin.css").toString());
        mainPanel.setStyle("-fx-background-color: #181818;");

        initMainTitle();
        initMainEmail();
        initMainPassword();


    }

    private void initMainTitle() {

        Label title = new Label(Lang.getText(this, "title"));
        GridPane.setVgrow(title, Priority.ALWAYS);
        GridPane.setHgrow(title, Priority.ALWAYS);
        GridPane.setValignment(title, VPos.TOP);
        title.setTranslateY(27);
        title.setTranslateX(37.5);
        title.setStyle("-fx-text-fill: #bcc6e7; -fx-font-size: 18px;");

        Separator titleSeparator = new Separator();
        GridPane.setVgrow(titleSeparator, Priority.ALWAYS);
        GridPane.setHgrow(titleSeparator, Priority.ALWAYS);
        GridPane.setValignment(titleSeparator, VPos.TOP);
        GridPane.setHalignment(titleSeparator, HPos.CENTER);
        titleSeparator.setTranslateY(60);
        titleSeparator.setMinWidth(325);
        titleSeparator.setMaxWidth(325);
        titleSeparator.setStyle("-fx-background-color: #fff; -fx-opacity: 50%;");

        mainPanel.getChildren().addAll(title, titleSeparator);
    }

    private void initMainEmail() {

        Label email = new Label(Lang.getText(this, "email"));
        GridPane.setVgrow(email, Priority.ALWAYS);
        GridPane.setHgrow(email, Priority.ALWAYS);
        GridPane.setValignment(email, VPos.TOP);
        GridPane.setHalignment(email, HPos.LEFT);
        email.setStyle("-fx-text-fill: #95bad3; -fx-font-size: 14px");
        email.setTranslateY(110);
        email.setTranslateX(37.5);

        TextField emailField = new TextField();
        GridPane.setVgrow(emailField, Priority.ALWAYS);
        GridPane.setHgrow(emailField, Priority.ALWAYS);
        GridPane.setValignment(emailField, VPos.TOP);
        GridPane.setHalignment(emailField, HPos.LEFT);
        emailField.setStyle("-fx-background-color: #1e1e1e; -fx-font-size: 16px; -fx-text-fill: #e5e5e5");
        emailField.setMaxWidth(325);
        emailField.setMaxHeight(40);
        emailField.setTranslateX(37.5);
        emailField.setTranslateY(140);

        Separator emailSeparator = new Separator();
        GridPane.setVgrow(emailSeparator, Priority.ALWAYS);
        GridPane.setHgrow(emailSeparator, Priority.ALWAYS);
        GridPane.setValignment(emailSeparator, VPos.TOP);
        GridPane.setHalignment(emailSeparator, HPos.CENTER);
        emailSeparator.setTranslateY(181);
        emailSeparator.setMinWidth(325);
        emailSeparator.setMaxWidth(325);
        emailSeparator.setStyle("-fx-background-color: #fff; -fx-opacity: 40%;");

        mainPanel.getChildren().addAll(email, emailField, emailSeparator);
    }

    private void initMainPassword() {

        Label password = new Label(Lang.getText(this, "password"));
        GridPane.setVgrow(password, Priority.ALWAYS);
        GridPane.setHgrow(password, Priority.ALWAYS);
        GridPane.setValignment(password, VPos.TOP);
        GridPane.setHalignment(password, HPos.LEFT);
        password.setStyle("-fx-text-fill: #95bad3; -fx-font-size: 14px");
        password.setTranslateY(200);
        password.setTranslateX(37.5);

        PasswordField passwordField = new PasswordField();
        GridPane.setVgrow(passwordField, Priority.ALWAYS);
        GridPane.setHgrow(passwordField, Priority.ALWAYS);
        GridPane.setValignment(passwordField, VPos.TOP);
        GridPane.setHalignment(passwordField, HPos.LEFT);
        passwordField.setStyle("-fx-background-color: #1e1e1e; -fx-font-size: 16px; -fx-text-fill: #e5e5e5");
        passwordField.setMaxWidth(325);
        passwordField.setMaxHeight(40);
        passwordField.setTranslateX(37.5);
        passwordField.setTranslateY(230);

        Separator passwordSeparator = new Separator();
        GridPane.setVgrow(passwordSeparator, Priority.ALWAYS);
        GridPane.setHgrow(passwordSeparator, Priority.ALWAYS);
        GridPane.setValignment(passwordSeparator, VPos.TOP);
        GridPane.setHalignment(passwordSeparator, HPos.CENTER);
        passwordSeparator.setTranslateY(271);
        passwordSeparator.setMinWidth(325);
        passwordSeparator.setMaxWidth(325);
        passwordSeparator.setStyle("-fx-background-color: #fff; -fx-opacity: 40%;");

        CheckBox rememberPassword = new CheckBox(Lang.getText(this, "rememberPassword"));
        GridPane.setVgrow(rememberPassword, Priority.ALWAYS);
        GridPane.setHgrow(rememberPassword, Priority.ALWAYS);
        GridPane.setValignment(rememberPassword, VPos.TOP);
        GridPane.setHalignment(rememberPassword, HPos.LEFT);
        rememberPassword.setStyle("-fx-font-size: 16px; -fx-text-fill: #e5e5e5");
        rememberPassword.setTranslateX(37.5);
        rememberPassword.setTranslateY(280);

        Button connectionButton = new Button("Se connecter"); //TODO translate
        GridPane.setVgrow(connectionButton, Priority.ALWAYS);
        GridPane.setHgrow(connectionButton, Priority.ALWAYS);
        GridPane.setValignment(connectionButton, VPos.CENTER);
        GridPane.setHalignment(connectionButton, HPos.LEFT);
        connectionButton.setTranslateX(37.5);
        connectionButton.setTranslateY(80);
        connectionButton.setMinWidth(325);
        connectionButton.setMinHeight(50);
        connectionButton.setStyle("-fx-background-color: #007dbe; -fx-border-radius: 0px; -fx-background-insets: 0; -fx-font-size: 14px; -fx-text-fill: #fff;");
        connectionButton.setCursor(Cursor.HAND);
        connectionButton.setOnMouseEntered(e -> connectionButton.setStyle("-fx-background-color: #0079b7; -fx-border-radius: 0px; -fx-background-insets: 0; -fx-font-size: 14px; -fx-text-fill: #fff;"));
        connectionButton.setOnMouseExited(e -> connectionButton.setStyle("-fx-background-color: #007dbe; -fx-border-radius: 0px; -fx-background-insets: 0; -fx-font-size: 14px; -fx-text-fill: #fff;"));

        connectionButton.setOnMouseClicked(e -> AxiumLauncher.getPanelManager().showPanel(new MinecraftPanel()));

        mainPanel.getChildren().addAll(password, passwordField, passwordSeparator, rememberPassword, connectionButton);
    }

    private void initBottom() {

        GridPane.setVgrow(bottomPanel, Priority.ALWAYS);
        GridPane.setHgrow(bottomPanel, Priority.ALWAYS);
        bottomPanel.setStyle("-fx-background-color: #181818; -fx-opacity: 50%;");

        Label noAccount = new Label(Lang.getText(this, "noAccount"));
        GridPane.setVgrow(noAccount, Priority.ALWAYS);
        GridPane.setHgrow(noAccount, Priority.ALWAYS);
        GridPane.setValignment(noAccount, VPos.TOP);
        GridPane.setHalignment(noAccount, HPos.CENTER);
        noAccount.setStyle("-fx-text-fill: #bcc6e7; -fx-font-size: 14px;");

        String registerHereText = Lang.getText(this, "registerHere");
        Label registerHere = new Link(registerHereText, "www.google.com"); //TODO change to register link
        GridPane.setValignment(registerHere, VPos.CENTER);
        GridPane.setHalignment(registerHere, HPos.CENTER);

        String forgotPasswordText = Lang.getText(this, "forgotPassword");
        Label forgotPassword = new Link(forgotPasswordText, "www.google.com"); //TODO change to forgot link
        GridPane.setValignment(forgotPassword, VPos.BOTTOM);
        GridPane.setHalignment(forgotPassword, HPos.CENTER);

        bottomPanel.getChildren().addAll(noAccount, registerHere, forgotPassword);
    }

    @Override
    public String getName() {
        return "panellogin";
    }
}