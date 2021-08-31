package libs.arilibfx.auth.premium.responses;

import libs.arilibfx.auth.premium.Profile;

/**
 * Created by Arinonia on 10/04/2020 inside the package - libs.arilibfx.auth.premium.responses
 */
public class AuthenticationResponse extends LoginResponse {

    private Profile[] availableProfiles;

    public AuthenticationResponse(String accessToken, String clientToke, Profile selectedProfile, Profile[] availableProfiles) {
        super(accessToken, clientToke, selectedProfile);
        this.availableProfiles = availableProfiles;
    }

    public Profile[] getAvailableProfiles() {
        return availableProfiles;
    }
}