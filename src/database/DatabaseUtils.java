package database;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;

/**
 *
 * @author Luisa Eustaquio
 */
public class DatabaseUtils {
    private static final String SCRIPT = "C:/Users/Maary/Documents/NetBeansProjects/Laundry-Shop/database_schema.sql";
    private static final String ADDRESS = "jdbc:mysql://localhost:3306/";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String DB_NAME = "db_laundry_shop";
    
    public static Connection getConnection() throws SQLException {
        boolean db_exist = databaseExists(); 
        if(!db_exist){
            setupDatabase();
        }
        return DriverManager.getConnection(ADDRESS + DB_NAME, USERNAME, PASSWORD);
    }

    private static boolean databaseExists() {
        boolean databaseExists = false;
        try (Connection connection = DriverManager.getConnection(ADDRESS, USERNAME, PASSWORD)) {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet resultSet = metaData.getCatalogs();
            while (resultSet.next()) {
                String catalogName = resultSet.getString(1);
                if (catalogName != null && catalogName.equals(DB_NAME)) {
                    databaseExists = true;
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return databaseExists;
    }
    
    private static void setupDatabase() {
        try (Connection connection = DriverManager.getConnection(ADDRESS, USERNAME, PASSWORD)) {
            executeScript(connection, SCRIPT);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
 
    private static void executeScript(Connection connection, String scriptFilePath) throws IOException, SQLException {
        try (BufferedReader reader = new BufferedReader(new FileReader(scriptFilePath))) {

            String line;
            StringBuilder statementBuilder = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                if (!line.trim().startsWith("--") && !line.trim().isEmpty()) {
                    statementBuilder.append(line);
                    if (line.trim().endsWith(";")) {
                        try (PreparedStatement statement = connection.prepareStatement(statementBuilder.toString())) {
                            statement.executeUpdate();
                        }
                        statementBuilder.setLength(0);
                    }
                }
            }

            System.out.println("Database schema created successfully! ^^");
        } catch (SQLException | IOException e) {
            System.err.println("Error setting up database: " + e.getMessage());
        }
    }
}