package fr.xibalba.launcher.account;

import fr.xibalba.launcher.exceptions.LoginException;
import javafx.scene.image.Image;

public class AccountManager {

    private static Account account;

    public static LoginResponse tryLogin(String email, String password) {

        account = Account.Builder.of().withUsername("Abdoul").withIcon(new Image("https://www.dropbox.com/s/k8kba15p514uopq/W.png?dl=1")).build();

        return new LoginResponse(false, new LoginException(1, "mot de passe incorrect"));
    }

    public static void logOut() {

    }

    public static Account getAccount() {

        return account;
    }
}