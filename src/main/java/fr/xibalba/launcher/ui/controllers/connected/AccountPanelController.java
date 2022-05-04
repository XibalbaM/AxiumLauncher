package fr.xibalba.launcher.ui.controllers.connected;

import fr.xibalba.launcher.account.AccountManager;
import fr.xibalba.launcher.lang.Lang;
import fr.xibalba.launcher.ui.panels.LauncherPanel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class AccountPanelController implements Initializable {

    @FXML
    private Circle accountIcon;

    @FXML
    private Text accountNameField;

    @FXML
    private Text accountLevel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        accountIcon.setFill(new ImagePattern(AccountManager.getAccount().icon()));
        accountNameField.setText(AccountManager.getAccount().username());
        accountLevel.setText(Lang.getText(new LauncherPanel(), "global.level") + " " + AccountManager.getAccount().level());
    }
}
