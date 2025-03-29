package abstractinterfacejava.com.Groupe14.project.interfaceusage;
import abstractinterfacejava.com.Groupe14.projects.connectionsample.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Student implements IPerson {
    private int id;
    private String firstName;
    private String lastName;
    private String rollNumber;
    private static Connection connection; // Connexion partagée

    public Student() throws SQLException, ClassNotFoundException {
        if (connection == null || connection.isClosed()) {
            connection = ConnectionFactory.getConnection(ConnectionFactory.MYSQL_CONNECTION);
        }
    }

    public Student(int id, String firstName, String lastName, String rollNumber) throws SQLException, ClassNotFoundException {
        this();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rollNumber = rollNumber;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getRollNumber() { return rollNumber; }
    public void setRollNumber(String rollNumber) { this.rollNumber = rollNumber; }

    @Override
    public void showIdentity() {
        System.out.println(String.format(
            "Student with ID [%s], FirstName [%s], LastName [%s], Roll Number [%s]",
            id, firstName, lastName, rollNumber
        ));
    }

    @Override
    public int add() throws SQLException {
        String sqlQuery = "INSERT INTO student(id, firstName, lastName, rollNumber) VALUES(?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sqlQuery)) {
            ps.setInt(1, id);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.setString(4, rollNumber);

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(" Error while inserting student data: " + e.getMessage());
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public void showDynamicIdentity(int id) throws SQLException {
        String sqlQuery = "SELECT student.id, student.firstName, student.lastName, student.rollNumber FROM student WHERE student.id=?";

        try (PreparedStatement ps = connection.prepareStatement(sqlQuery)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println(String.format(
                        "Student with ID [%s], FirstName [%s], LastName [%s], Roll Number [%s]",
                        rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("rollNumber")
                    ));
                } else {
                    System.out.println("No student found with ID: " + id);
                }
            }
        } catch (SQLException e) {
            System.err.println(" Error while fetching student data: " + e.getMessage());
            e.printStackTrace();
        }
    }
 }

