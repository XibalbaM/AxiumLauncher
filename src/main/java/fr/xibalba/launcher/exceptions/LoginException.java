package fr.xibalba.launcher.exceptions;

public class LoginException extends LauncherException {

    private int field;
    private String errorText;

    public LoginException(int field, String errorText) {

        this.field = field;
        this.errorText = errorText;
    }

    public int getField() {

        return field;
    }

    public void setField(int field) {

        this.field = field;
    }

    public String getErrorText() {

        return errorText;
    }

    public void setErrorText(String errorText) {

        this.errorText = errorText;
    }
}