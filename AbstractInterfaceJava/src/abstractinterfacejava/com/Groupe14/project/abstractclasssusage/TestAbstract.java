package abstractinterfacejava.com.Groupe14.project.abstractclasssusage;
import abstractinterfacejava.com.Groupe14.projects.connectionsample.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;


public class TestAbstract {
    public static void main(String[] args) {
        Connection connection = null;
        
        try {
            // Récupération d'une connexion SQL
            connection = ConnectionFactory.getConnection(ConnectionFactory.MYSQL_CONNECTION);
            
            // Création et insertion des employés
            Person e1 = new Employee(1, "MRIMO", "SAMUEL", "23LIAGELJ1070455");
            e1.add(e1);
            System.out.println("Employee 1 inserted successfully!");

            Person e2 = new Employee(2, "MUGANZA", "GABRIEL", "23LIAGELJ1070843");
            e2.add(e2);
            System.out.println("Employee 2 inserted successfully!");
            
            Person e3 = new Employee(3, "MUBUTO", "FIRMIN", "22LSILJ1010278");
            e1.add(e3);
            System.out.println("Employee 3 inserted successfully!");

            Person e4 = new Employee(4, "MOMBERO", "DANIEL", "23LIAGELJ10594");
            e2.add(e4);
            System.out.println("Employee 4 inserted successfully!");
            
            Person e5 = new Employee(5, "MOISE", "MATOFALI", "22LSILJ1040277");
            e1.add(e5);
            System.out.println("Employee 5 inserted successfully!");                    
            

            // Création et insertion des étudiants
                      
            Person s1 = new Student(1, "MRIMO", "SAMUEL", "23LIAGELJ1070455");
            s1.add(s1);
            System.out.println("Student 1 inserted successfully!");

            Person s2 = new Student(2, "MUGANZA", "GABRIEL", "23LIAGELJ1070843");
            s2.add(s2);
            System.out.println("Student 2 inserted successfully!");
            
            Person s3 = new Student(3, "MUBUTO", "FIRMIN", "22LSILJ1010278");
            s1.add(s3);
            System.out.println("Student 3 inserted successfully!");

            Person s4 = new Student(4, "MOMBERO", "DANIEL", "23LIAGELJ10594");
            s2.add(s4);
            System.out.println("Student 4 inserted successfully!");
            
            Person s5 = new Student(5, "MOISE", "MATOFALI", "22LSILJ1040277");
            s1.add(s5);
            System.out.println("Student 5 inserted successfully!");

           

            // Affichage des employés insérés
            System.out.println("----- Employee Records -----");
            e1.showDynamicIdentity(e1.getId());
            e2.showDynamicIdentity(e2.getId());
            e3.showDynamicIdentity(e3.getId());
            e4.showDynamicIdentity(e4.getId());
            e5.showDynamicIdentity(e5.getId());
           

            // Affichage des étudiants insérés
            System.out.println("----- Student Records -----");
            s1.showDynamicIdentity(s1.getId());
            s2.showDynamicIdentity(s2.getId());
            s3.showDynamicIdentity(s3.getId());
            s4.showDynamicIdentity(s4.getId());
            s5.showDynamicIdentity(s5.getId());
            

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Failed to insert records into the Database");
            e.printStackTrace();
        } finally {
            closeConnection(connection, "MySQL");
        }
    }

    private static void closeConnection(Connection con, String dbType) {
        if (con != null) {
            try {
                con.close();
                System.out.println("Connection to " + dbType + " closed.");
            } catch (SQLException e) {
                System.err.println("Error while closing the " + dbType + " connection: " + e.getMessage());
            }
        }
    }
}
