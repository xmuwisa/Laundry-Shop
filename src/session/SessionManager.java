package session;
import database.DatabaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    
    public static int getUserIdByUsername(String username) {
        int userId = -1;
        
        try (Connection conn = DatabaseUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT u_id FROM tbl_users WHERE u_username = ?")) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    userId = rs.getInt("u_id");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return userId;
    }
    
    public static String getRoleByUsername(String username) {
        String role = null;

        try (Connection conn = DatabaseUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT u_role FROM tbl_users WHERE u_username = ?")) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    role = rs.getString("u_role");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return role;
    }
}
