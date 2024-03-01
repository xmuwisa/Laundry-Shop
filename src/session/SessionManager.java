package session;
import database.DatabaseUtils;

/**
 *
 * @author Luisa Eustaquio
 */
public class SessionManager {
    private static String loggedInUser;

    public static String getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(String username) {
        loggedInUser = username;
    }
    
    public static void clearLoggedInUser() {
        loggedInUser = null;
    }
}
