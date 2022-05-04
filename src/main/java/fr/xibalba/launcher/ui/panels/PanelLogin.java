package fr.xibalba.launcher.ui.panels;

import fr.xibalba.launcher.account.AccountManager;
import fr.xibalba.launcher.account.LoginResponse;
import fr.xibalba.launcher.config.ConfigManager;
import fr.xibalba.launcher.core.AxiumLauncher;
import fr.xibalba.launcher.lang.Lang;
import fr.xibalba.launcher.theme.ThemeManager;
import fr.xibalba.launcher.ui.panel.Panel;
import fr.xibalba.utils.MdpUtils;
import fr.xibalba.utils.javaFX.Link;
import fr.xibalba.utils.javaFX.ShowablePasswordField;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PanelLogin extends Panel {

    private final GridPane loginPanel = new GridPane();
    private final GridPane mainPanel = new GridPane();
    private final GridPane bottomPanel = new GridPane();
    private Label errorEmail, errorPassword, errorOther;
    private TextField emailField;
    private ShowablePasswordField passwordField;
    private CheckBox rememberPassword;
    private Button connectionButton;

    @Override
    public void init() {

        super.init();

        initLoginPanel();
        initMain();
        initBottom();

        this.layout.getChildren().add(loginPanel);

        if (Boolean.valueOf(ConfigManager.CONFIG.rememberPassword)) {
            if (ConfigManager.CONFIG.email != "" && ConfigManager.CONFIG.mdp != "") {
                login(ConfigManager.CONFIG.email, ConfigManager.CONFIG.mdp);
            }
        }
    }

    private void initLoginPanel() {

        loginPanel.setMinWidth(400);
        loginPanel.setMaxWidth(400);
        loginPanel.setMinHeight(580);
        loginPanel.setMaxHeight(580);

        loginPanel.getStylesheets().clear();
        loginPanel.getStylesheets().add(ThemeManager.getCurrentTheme().getStyle("panel-login"));

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
        mainPanel.setStyle(ThemeManager.getCurrentTheme().getStyle("panel-login"));
        mainPanel.setStyle("-fx-background-color: #181818;");

        initMainTitle();
        initMainEmail();
        initMainPassword();
        initRememberPass();
        initConnectionButton();
        initOtherMods();

        this.mainPanel.getChildren().addAll(rememberPassword, connectionButton, errorOther);
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
        email.setFont(new Font(14));
        email.setTextFill(Color.web("#95bad3"));
        email.setTranslateY(110);
        email.setTranslateX(37.5);

        errorEmail = new Label();
        errorEmail.setVisible(false);
        GridPane.setVgrow(errorEmail, Priority.ALWAYS);
        GridPane.setHgrow(errorEmail, Priority.ALWAYS);
        GridPane.setValignment(errorEmail, VPos.TOP);
        GridPane.setHalignment(errorEmail, HPos.LEFT);
        errorEmail.setFont(new Font(14));
        errorEmail.setTextFill(Color.web("#c70808"));
        errorEmail.setTranslateY(110);
        errorEmail.setTranslateX(email.getTranslateX() + getWidthOfText(email.getText(), email.getFont()) + 20);

        emailField = new TextField(ConfigManager.CONFIG.email);
        GridPane.setVgrow(emailField, Priority.ALWAYS);
        GridPane.setHgrow(emailField, Priority.ALWAYS);
        GridPane.setValignment(emailField, VPos.TOP);
        GridPane.setHalignment(emailField, HPos.LEFT);
        emailField.setStyle("-fx-background-color: #1e1e1e; -fx-font-size: 16px; -fx-text-fill: #e5e5e5");
        emailField.setMaxWidth(325);
        emailField.setMaxHeight(40);
        emailField.setTranslateX(37.5);
        emailField.setTranslateY(140);
        emailField.textProperty().addListener(observable -> {
            ConfigManager.CONFIG.email = emailField.getText();
            this.checkFieldContent();
        });

        Separator emailSeparator = new Separator();
        GridPane.setVgrow(emailSeparator, Priority.ALWAYS);
        GridPane.setHgrow(emailSeparator, Priority.ALWAYS);
        GridPane.setValignment(emailSeparator, VPos.TOP);
        GridPane.setHalignment(emailSeparator, HPos.CENTER);
        emailSeparator.setTranslateY(181);
        emailSeparator.setMinWidth(325);
        emailSeparator.setMaxWidth(325);
        emailSeparator.setStyle("-fx-background-color: #fff; -fx-opacity: 40%;");

        mainPanel.getChildren().addAll(email, errorEmail, emailField, emailSeparator);
    }

    private void initMainPassword() {

        Label password = new Label(Lang.getText(this, "password"));
        GridPane.setVgrow(password, Priority.ALWAYS);
        GridPane.setHgrow(password, Priority.ALWAYS);
        GridPane.setValignment(password, VPos.TOP);
        GridPane.setHalignment(password, HPos.LEFT);
        password.setFont(new Font(14));
        password.setTextFill(Color.web("#95bad3"));
        password.setTranslateY(200);
        password.setTranslateX(37.5);

        errorPassword = new Label();
        errorPassword.setVisible(false);
        GridPane.setVgrow(errorPassword, Priority.ALWAYS);
        GridPane.setHgrow(errorPassword, Priority.ALWAYS);
        GridPane.setValignment(errorPassword, VPos.TOP);
        GridPane.setHalignment(errorPassword, HPos.LEFT);
        errorPassword.setFont(new Font(12));
        errorPassword.setTextFill(Color.web("#c70808"));
        errorPassword.setTranslateY(200);
        errorPassword.setTranslateX(password.getTranslateX() + getWidthOfText(password.getText(), password.getFont()) + 20);

        passwordField = new ShowablePasswordField();
        GridPane.setVgrow(passwordField, Priority.ALWAYS);
        GridPane.setHgrow(passwordField, Priority.ALWAYS);
        GridPane.setValignment(passwordField, VPos.TOP);
        GridPane.setHalignment(passwordField, HPos.LEFT);
        passwordField.passwordField.setText(ConfigManager.CONFIG.rememberPassword ? MdpUtils.decrypt(ConfigManager.CONFIG.mdp) : "");
        passwordField.setStyle("-fx-background-color: #1e1e1e; -fx-font-size: 16px; -fx-text-fill: #e5e5e5");
        passwordField.passwordField.setStyle("-fx-background-color: #1e1e1e; -fx-font-size: 16px; -fx-text-fill: #e5e5e5");
        passwordField.textField.setStyle("-fx-background-color: #1e1e1e; -fx-font-size: 16px; -fx-text-fill: #e5e5e5");
        passwordField.setMaxWidth(325);
        passwordField.setMaxHeight(40);
        passwordField.setTranslateX(37.5);
        passwordField.setTranslateY(230);
        passwordField.passwordField.textProperty().addListener(observable -> {
            if (Boolean.valueOf(ConfigManager.CONFIG.rememberPassword))
                ConfigManager.CONFIG.mdp = MdpUtils.encrypt(passwordField.passwordField.getText());
            else
                ConfigManager.CONFIG.mdp = "";

            ConfigManager.CONFIG.email = emailField.getText();
            this.checkFieldContent();
        });

        Separator passwordSeparator = new Separator();
        GridPane.setVgrow(passwordSeparator, Priority.ALWAYS);
        GridPane.setHgrow(passwordSeparator, Priority.ALWAYS);
        GridPane.setValignment(passwordSeparator, VPos.TOP);
        GridPane.setHalignment(passwordSeparator, HPos.CENTER);
        passwordSeparator.setTranslateY(271);
        passwordSeparator.setMinWidth(325);
        passwordSeparator.setMaxWidth(325);
        passwordSeparator.setStyle("-fx-background-color: #fff; -fx-opacity: 40%;");

        mainPanel.getChildren().addAll(password, errorPassword, passwordField, passwordSeparator);
    }

    private void initRememberPass() {

        rememberPassword = new CheckBox(Lang.getText(this, "rememberPassword"));
        GridPane.setVgrow(rememberPassword, Priority.ALWAYS);
        GridPane.setHgrow(rememberPassword, Priority.ALWAYS);
        GridPane.setValignment(rememberPassword, VPos.TOP);
        GridPane.setHalignment(rememberPassword, HPos.LEFT);
        rememberPassword.setSelected(ConfigManager.CONFIG.rememberPassword);
        rememberPassword.setStyle("-fx-font-size: 16px; -fx-text-fill: #e5e5e5");
        rememberPassword.setTranslateX(37.5);
        rememberPassword.setTranslateY(280);
        rememberPassword.selectedProperty().addListener(observable -> {
            ConfigManager.CONFIG.rememberPassword = rememberPassword.isSelected();

            if (rememberPassword.isSelected()) {
                ConfigManager.CONFIG.mdp = MdpUtils.encrypt(passwordField.passwordField.getText());
            } else {
                ConfigManager.CONFIG.mdp = "";
            }
        });
    }

    private void initConnectionButton() {

        connectionButton = new Button("Se connecter"); //TODO translate
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
        connectionButton.setOnMouseClicked(event -> login(emailField.getText(), passwordField.passwordField.getText()));
        this.checkFieldContent();

        errorOther = new Label();
        errorOther.setVisible(false);
        GridPane.setVgrow(errorOther, Priority.ALWAYS);
        GridPane.setHgrow(errorOther, Priority.ALWAYS);
        GridPane.setValignment(errorOther, VPos.CENTER);
        GridPane.setHalignment(errorOther, HPos.CENTER);
        errorOther.setStyle("-fx-text-fill: #c70808; -fx-font-size: 14px");
        connectionButton.applyCss();
        errorOther.setTranslateY(connectionButton.getTranslateY() + connectionButton.getMinHeight() + 20);
    }

    private void initOtherMods() {

        Separator otherSeparator = new Separator();
        GridPane.setVgrow(otherSeparator, Priority.ALWAYS);
        GridPane.setHgrow(otherSeparator, Priority.ALWAYS);
        GridPane.setValignment(otherSeparator, VPos.BOTTOM);
        GridPane.setHalignment(otherSeparator, HPos.CENTER);
        otherSeparator.setTranslateY(-140);
        otherSeparator.setMinWidth(325);
        otherSeparator.setMaxWidth(325);
        otherSeparator.setStyle("-fx-background-color: #fff; -fx-opacity: 50%;");

        mainPanel.getChildren().add(otherSeparator);
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

    private void checkFieldContent() {

        connectionButton.setDisable(!((emailField.getText() != null && emailField.getText() != "") && (passwordField.passwordField.getText() != null && passwordField.passwordField.getText() != "")));
    }

    private void login(String email, String password) {

        errorEmail.setVisible(false);
        errorPassword.setVisible(false);
        errorOther.setVisible(false);

        LoginResponse loginResponse = AccountManager.tryLogin(email, password);

        if (loginResponse.succeed()) {

            AxiumLauncher.getPanelManager().showPanel(AxiumLauncher.getPanelManager().getHomePanel());
        } else {

            System.out.println(loginResponse.error().getErrorText() + loginResponse.error().getField());
            switch (loginResponse.error().getField()) {

                case 0: {
                    errorEmail.setText(loginResponse.error().getErrorText());
                    errorEmail.setVisible(true);
                    break;
                }
                case 1: {
                    errorPassword.setText(loginResponse.error().getErrorText());
                    errorPassword.setVisible(true);
                    break;
                }
                default: {
                    errorOther.setText(loginResponse.error().getErrorText());
                    errorOther.setVisible(true);
                }
            }
        }

            /*AxiumLauncher.getConfigManager().setProperty(Config.EMAIL, emailField.getText());

            boolean rememberPassword = Boolean.valueOf(AxiumLauncher.getConfigManager().getProperty(Config.REMEMBER_PASSWORD));
            AxiumLauncher.getConfigManager().setProperty(Config.REMEMBER_PASSWORD, String.valueOf(rememberPassword));

            if (rememberPassword) {

                AxiumLauncher.getConfigManager().setProperty(Config.PASSWORD, MdpUtils.encrypt(passwordField.passwordField.getText()));
            }*/

    }

    @Override
    public String getName() {
        return "panellogin";
    }

    public static double getWidthOfText(String text, Font font) {

        Text t = new Text(text);
        t.setFont(font);

        return t.getBoundsInLocal().getWidth();
    }
}