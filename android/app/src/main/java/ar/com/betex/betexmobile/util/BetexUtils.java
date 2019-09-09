package ar.com.betex.betexmobile.util;

/**
 * Utilties para utilizar en Betex Mobile
 * @autor Diego Mernies
 */
public class BetexUtils {
    public static final String CURRENT_FRAGMENT_SELECTED_BY_USER = "current_fragment_selected_by_user";

    /**
     * Obtiene el valor del String. En caso de ser nulo o vacío pone un valor por default
     * @param input
     * @param defaultValue
     * @return string
     */
    public static String getString(String input, String defaultValue) {
        if (input != null && !input.trim().isEmpty()){
            return input;
        }
        return defaultValue;
    }

    public static String formatUserNameOrAddress(String userName) {
        if (userName == null)
            return "";
        if (userName.startsWith("0x") && userName.length() > 25) {
            return userName.substring(0, 24) + "...";
        }

        return userName;
    }
}

