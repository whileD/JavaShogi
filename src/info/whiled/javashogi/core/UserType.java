package info.whiled.javashogi.core;

public enum UserType {
    USER("先手"),
    RIVAL("後手");

    private final String type;
    UserType(String s) {
        type = s;
    }

    public String getType() {
        return type;
    }
}
