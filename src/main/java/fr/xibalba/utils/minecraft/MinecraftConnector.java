package fr.xibalba.utils.minecraft;

import fr.xibalba.launcher.main.Main;
import libs.arilibfx.auth.premium.Auth;
import libs.arilibfx.auth.premium.exceptions.AuthenticationUnavailableException;
import libs.arilibfx.auth.premium.exceptions.RequestException;
import libs.arilibfx.auth.premium.responses.AuthenticationResponse;

public class MinecraftConnector {

    public AuthenticationResponse connect(String username, String mdp) {
        try {
            AuthenticationResponse response = Auth.authenticate(username, mdp);
            Main.logger.log("-----------------[Auth]-----------------");
            Main.logger.log("Access token: " + response.getAccessToken());
            Main.logger.log("Account name: " + response.getSelectedProfile().getName());
            Main.logger.log("Account id: " + response.getSelectedProfile().getUUID());
            Main.logger.log("----------------------------------------");
            return response;
        } catch (RequestException | AuthenticationUnavailableException e) {
            e.printStackTrace();
            return null;
        }
    }
}
