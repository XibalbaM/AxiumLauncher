package libs.arilibfx.auth.premium.responses;

import libs.arilibfx.auth.premium.Profile;

/**
 * Created by Arinonia on 10/04/2020 inside the package - libs.arilibfx.auth.premium.responses
 */
public class LoginResponse extends Response {

    private String accessToken;
    private String clientToken;
    private Profile selectedProfile;

    public LoginResponse(String accessToken, String clientToken, Profile selectedProfile) {
        this.accessToken = accessToken;
        this.clientToken = clientToken;
        this.selectedProfile = selectedProfile;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getClientToken() {
        return clientToken;
    }

    public Profile getSelectedProfile() {
        return selectedProfile;
    }
}
