package abstractinterfacejava.com.Groupe14.project.abstractclasssusage;
import abstractinterfacejava.com.Groupe14.projects.connectionsample.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Student extends Person {
    private String rollNumber;

    public Student() {
    }

    public Student(int id, String firstName, String lastName, String rollNumber) {
        super(id, firstName, lastName);
        this.rollNumber = rollNumber;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    @Override
    public void showIdentity() {
        System.out.println(String.format(
            "Student with ID [%s], FirstName [%s], LastName [%s], Roll Number [%s]", 
            id, firstName, lastName, rollNumber));
    }

    @Override
    public int add(Person p) {
        String sqlQuery = "INSERT INTO student(id, firstName, lastName, rollNumber) VALUES(?, ?, ?, ?)";
        Connection con = null;

        try {
            con = ConnectionFactory.getConnection(ConnectionFactory.MYSQL_CONNECTION);
            try (PreparedStatement ps = con.prepareStatement(sqlQuery)) {
                ps.setInt(1, p.getId());
                ps.setString(2, p.getFirstName());
                ps.setString(3, p.getLastName());
                ps.setString(4, ((Student) p).getRollNumber());

                return ps.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(" Error while inserting Student: " + e.getMessage());
            e.printStackTrace();
            return 0;
        } 
    }

    @Override
    public void showDynamicIdentity(int id) {
        String sqlQuery = "SELECT id, firstName, lastName, rollNumber FROM student WHERE id=?";
        Connection con = null;

        try {
            con = ConnectionFactory.getConnection(ConnectionFactory.MYSQL_CONNECTION);
            try (PreparedStatement ps = con.prepareStatement(sqlQuery)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        System.out.println(String.format(
                            "Student with ID [%s], FirstName [%s], LastName [%s], Roll Number [%s]", 
                            rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"), 
                            rs.getString("rollNumber")));
                    } else {
                        System.out.println(" No Student found with ID: " + id);
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error while fetching Student: " + e.getMessage());
            e.printStackTrace();
        } 
    }
}
