package gui;
import database.DatabaseUtils;
import utils.PasswordUtils;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Luisa Eustaquio
 */
public class RegisterAdmin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = "";
        String password = "";
        String confirmPassword = "";

        do {
            System.out.print("Enter the username: ");
            username = scanner.nextLine();
            if (!validateUsername(username)) {
                System.out.println("Username already exists. Please choose another username.");
            }
        } while (!validateUsername(username));

        do {
            System.out.print("Enter the password: ");
            password = scanner.nextLine();
            System.out.print("Confirm the password: ");
            confirmPassword = scanner.nextLine();

            if (!validatePassword(password)) {
                System.out.println("Password must be at least 8 characters long, contain at least one numeric character, one special character, and one uppercase letter.");
            } else if (!password.equals(confirmPassword)) {
                System.out.println("Passwords do not match.");
            }
        } while (!validatePassword(password) || !password.equals(confirmPassword));

        String hashedPassword = PasswordUtils.hashPassword(password);

        try {
            Connection conn = DatabaseUtils.getConnection();
            String sql = "INSERT INTO tbl_users (u_username, u_password, u_role) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, hashedPassword);
            stmt.setString(3, "admin");
            stmt.executeUpdate();

            stmt.close();
            conn.close();

            System.out.println("Admin user created successfully!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private static boolean validatePassword(String password) {
        String regex = "^(?=.*[0-9])(?=.*[!@#$%^&*()\\-_=+\\\\|\\[{\\]};:'\",<.>/?])(?=.{8,}).*[A-Z].*[a-z].*$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(password).matches();
    }

    private static boolean validateUsername(String username) {
        String sql = "SELECT * FROM tbl_users WHERE u_username = ?";
        try (Connection conn = DatabaseUtils.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            return !rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
