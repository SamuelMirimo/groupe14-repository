package abstractinterfacejava.com.Groupe14.project.abstractclasssusage;
import abstractinterfacejava.com.Groupe14.projects.connectionsample.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Employee extends Person {
    private String cnss;

    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, String cnss) {
        super(id, firstName, lastName);
        this.cnss = cnss;
    }

    public String getCnss() {
        return cnss;
    }

    public void setCnss(String cnss) {
        this.cnss = cnss;
    }

    @Override
    public void showIdentity() {
        System.out.println(String.format(
            "Employee with ID [%s], FirstName [%s], LastName [%s], Social Security [%s]",
            id, firstName, lastName, cnss));
    }

    @Override
    public int add(Person p) {
        String sqlQuery = "INSERT INTO employee(id, firstName, lastName, cnss) VALUES (?, ?, ?, ?)";
        Connection con = null;

        try {
            con = ConnectionFactory.getConnection(ConnectionFactory.MYSQL_CONNECTION);
            try (PreparedStatement ps = con.prepareStatement(sqlQuery)) {
                ps.setInt(1, p.getId());
                ps.setString(2, p.getFirstName());
                ps.setString(3, p.getLastName());
                ps.setString(4, ((Employee) p).getCnss());

                return ps.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(" Error while inserting Employee: " + e.getMessage());
            e.printStackTrace();
            return 0;
        } 
    }

    @Override
    public void showDynamicIdentity(int id) {
        String sqlQuery = "SELECT id, firstName, lastName, cnss FROM employee WHERE id=?";
        Connection con = null;

        try {
            con = ConnectionFactory.getConnection(ConnectionFactory.MYSQL_CONNECTION);
            try (PreparedStatement ps = con.prepareStatement(sqlQuery)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        System.out.println(String.format(
                            "Employee with ID [%s], FirstName [%s], LastName [%s], Social Security [%s]",
                            rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"),
                            rs.getString("cnss")));
                    } else {
                        System.out.println(" No Employee found with ID: " + id);
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(" Error while fetching Employee: " + e.getMessage());
            e.printStackTrace();
        } 
    }

}
