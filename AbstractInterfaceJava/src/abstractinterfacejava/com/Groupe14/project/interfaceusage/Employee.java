package abstractinterfacejava.com.Groupe14.project.interfaceusage;
import abstractinterfacejava.com.Groupe14.projects.connectionsample.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee implements IPerson {
    private int id;
    private String firstName;
    private String lastName;
    private String cnss;
    private static Connection connection; // Connexion statique partagée

    public Employee() throws SQLException, ClassNotFoundException {
        if (connection == null || connection.isClosed()) {
            connection = ConnectionFactory.getConnection(ConnectionFactory.MYSQL_CONNECTION);
        }
    }

    public Employee(int id, String firstName, String lastName, String cnss) throws SQLException, ClassNotFoundException {
        this();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnss = cnss;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getCnss() { return cnss; }
    public void setCnss(String cnss) { this.cnss = cnss; }

    @Override
    public void showIdentity() {
        System.out.println(String.format("Employee with ID [%s], FirstName [%s], LastName [%s], Social Security [%s]",
                id, firstName, lastName, cnss));
    }

    @Override
    public void showDynamicIdentity(int id) throws SQLException {
        String sqlQuery = "SELECT employee.id, employee.firstname, employee.lastname, employee.cnss FROM employee WHERE employee.id=?";
        try (PreparedStatement ps = connection.prepareStatement(sqlQuery)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println(
                        String.format("Employee with ID [%s], FirstName [%s], LastName [%s], Social Security [%s]",
                                rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"),
                                rs.getString("cnss")));
                } else {
                    System.out.println("No employee found with ID: " + id);
                }
            }
        }
    }

    @Override
    public int add() throws SQLException {
        String sqlQuery = "INSERT INTO employee(id, firstName, lastName, cnss) VALUES(?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sqlQuery)) {
            ps.setInt(1, id);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.setString(4, cnss);
            return ps.executeUpdate();
        }
    }
}
