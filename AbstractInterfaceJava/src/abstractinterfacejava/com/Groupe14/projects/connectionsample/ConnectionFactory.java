package abstractinterfacejava.com.Groupe14.projects.connectionsample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    private static Connection connection = null;
    public static final int MYSQL_CONNECTION = 1;
    public static final int SQL_SERVER_CONNECTION = 2;

    private ConnectionFactory() {
    }

    /**
     * Instantiate a Database (MySQL, SQL Server, etc.) connection string and return
     * it (Using Singleton Pattern by returning only one instance of the class)
     * 
     * @return Connection
     * @throws SQLException
     */
    public static Connection getConnection(int connectionType) throws SQLException, ClassNotFoundException {
        if (connection == null) {
            switch (connectionType) {
                case MYSQL_CONNECTION:
                    connection = createMySQLConnection();
                    break;
                case SQL_SERVER_CONNECTION:
                    connection = createSQLServerConnection();
                    break;
                default:
                    throw new SQLException("No Database type specified!");
            }
        }
        return connection;
    }

    private static String formatSQLServerConnectionString(Connect connect) {
        return String.format("jdbc:sqlserver://%s;databaseName=%s;encrypt=false", 
                connect.getHost(), connect.getDatabase());
    }

    private static Connection createSQLServerConnection() throws SQLException, ClassNotFoundException {
        // Charger le driver JDBC pour SQL Server
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        String strCon = formatSQLServerConnectionString(
                new Connect("DESKTOP-1PQ7N3N", "db_person", "sa", "20032020@"));
        
        return DriverManager.getConnection(strCon, "sa", "20032020@");
    }

    private static String formatMySQLConnectionString(Connect connect) {
        return String.format("jdbc:mysql://%s:%s/%s?serverTimezone=UTC", 
                connect.getHost(), connect.getPort(), connect.getDatabase());
    }

    private static Connection createMySQLConnection() throws SQLException, ClassNotFoundException {
        // Charger le driver JDBC pour MySQL
        Class.forName("com.mysql.cj.jdbc.Driver");

        String strCon = formatMySQLConnectionString(new Connect("localhost", 3306, "db_person", "root", ""));
        return DriverManager.getConnection(strCon, "root", "");
    }
}
