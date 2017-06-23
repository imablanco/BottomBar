package com.example.bottombar.sample;

/**
 * Created by Álvaro Blanco Cabrero on 24/06/2017.
 * BottomBar.
 */

public class ProgrammaticallyTabMessage {

    public static final int FAVORITES = 0;
    public static final int NEARBY = 1;
    public static final int FRIENDS = 2;

    public static String get(int menuItemId, boolean isReselection) {
        String message = "Content for ";

        switch (menuItemId) {
            case FAVORITES:
                message += "favorites";
                break;
            case NEARBY:
                message += "nearby";
                break;
            case FRIENDS:
                message += "friends";
                break;
        }

        if (isReselection) {
            message += " WAS RESELECTED! YAY!";
        }

        return message;
    }
}
