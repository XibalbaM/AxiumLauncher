package libs.arilibfx.auth.premium.responses;

public abstract class Response {

    Type type = Type.UNKNOWN;

    public enum Type {
        ERROR,
        LOGIN,
        REQUEST,
        AUTH,
        UNKNOWN
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
