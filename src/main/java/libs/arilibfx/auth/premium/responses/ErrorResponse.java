package libs.arilibfx.auth.premium.responses;

/**
 * Created by Arinonia on 10/04/2020 inside the package - libs.arilibfx.auth.premium.responses
 */
public class ErrorResponse extends Response {
    private String error;
    private String errorMessage;
    private String cause;

    public String getError() {
        return error;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public String getCause() {
        return cause;
    }
}
