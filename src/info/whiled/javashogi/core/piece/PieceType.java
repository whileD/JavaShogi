package info.whiled.javashogi.core.piece;

import com.sun.istack.internal.NotNull;
import info.whiled.javashogi.core.UserType;

/**
 * Created by whiled on 17/07/20.
 */
public enum PieceType {
    KING("king"),
    ROOK("rook"),
    BISHOP("bishop"),
    GOLD_GENERAL("goldg"),
    SILVER_GENERAL("silverg"),
    KNIGHT("knight"),
    LANCE("lance"),
    PAWN("pawn"),

    PROMOTION_ROOK("p_rook"),
    PROMOTION_BISHOP("p_bishop"),
    PROMOTION_SILVER_GENERAL("p_silverg"),
    PROMOTION_KNIGHT("p_knight"),
    PROMOTION_LANCE("p_lance"),
    PROMOTION_PAWN("p_pawn");

    private final String PATH;

    private final String PIECE_ROOT_PATH = "info/whiled/javashogi/piece";
    private final String USER = "/user/";
    private final String RIVAL = "/rival/";
    private final String EXTENSION = ".png";

    PieceType(String s) {
        PATH = s;
    }

    @NotNull
    public String getImagePath(UserType userType){
        switch (userType){
            case USER:
                return PIECE_ROOT_PATH + USER + getPATH() + EXTENSION;
            case RIVAL:
                return PIECE_ROOT_PATH + RIVAL + getPATH() + EXTENSION;
            default:
                return null;
        }
    }

    private String getPATH(){
        return PATH;
    }
}

