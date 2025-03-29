package abstractinterfacejava.com.Groupe14.project.interfaceusage;

import java.sql.SQLException;

public class TestInterface {
    public static void main(String[] args) {
        try {
            IPerson e6 = new Employee();
            ((Employee) e6).setId(6);
            ((Employee) e6).setFirstName("MIRIAM");
            ((Employee) e6).setLastName("DORCAS");
            ((Employee) e6).setCnss("22LIAGELJ10364");

            e6.add();
            System.out.println("Employee inserted successfully!");

            IPerson e7 = new Employee();
            ((Employee) e7).setId(7);
            ((Employee) e7).setFirstName("MILKA");
            ((Employee) e7).setLastName("BERNICE");
            ((Employee) e7).setCnss("23LIAGELJ1070648");

            e7.add();
            System.out.println("Employee inserted successfully!");
            
            IPerson e8 = new Employee();
            ((Employee) e8).setId(8);
            ((Employee) e8).setFirstName("MIGISHA");
            ((Employee) e8).setLastName("DANIEL");
            ((Employee) e8).setCnss("23LIAGELJ1070858");

            e8.add();
            System.out.println("Employee inserted successfully!");
            
            IPerson e9 = new Employee();
            ((Employee) e9).setId(9);
            ((Employee) e9).setFirstName("MBUSA");
            ((Employee) e9).setLastName("RAPHAEL");
            ((Employee) e9).setCnss("22LSILJ7760262");

            e9.add();
            System.out.println("Employee inserted successfully!");
            
            IPerson e10 = new Employee();
            ((Employee) e10).setId(10);
            ((Employee) e10).setFirstName("MBUKA");
            ((Employee) e10).setLastName("ISAAC");
            ((Employee) e10).setCnss("22LSILJ680194");

            e10.add();
            System.out.println("Employee inserted successfully!");

            
            IPerson s6 = new Student(6, "MIRIAM", "DORCAS", "22LIAGELJ10364");
            s6.add();
            System.out.println("Student 6 inserted successfully!");
            
            IPerson s7 = new Student(7, "MILKA", "BERNICE", "23LIAGELJ1070648");
            s7.add();
            System.out.println("Student 7 inserted successfully!");

            IPerson s8 = new Student(8, "MIGISHA", "DANIEL", "23LIAGELJ1070858");
            s8.add();
            System.out.println("Student 8 inserted successfully!");
            
            IPerson s9 = new Student(9, "MBUSA", "RAPHAEL", "22LSILJ7760262");
            s9.add();
            System.out.println("Student 9 inserted successfully!");

            IPerson s10 = new Student(10, "MBUKA", "ISAAC", "22LSILJ680194");
            s10.add();
            System.out.println("Student 10 inserted successfully!");

            e6.showDynamicIdentity(((Employee) e6).getId());
            System.out.println("-----------------------------------------");
            e7.showDynamicIdentity(((Employee) e7).getId());
            System.out.println("-----------------------------------------");
            e8.showDynamicIdentity(((Employee) e8).getId());
            System.out.println("-----------------------------------------");
            e9.showDynamicIdentity(((Employee) e9).getId());
            System.out.println("-----------------------------------------");
            e10.showDynamicIdentity(((Employee) e10).getId());
            System.out.println("-----------------------------------------");

            
            s6.showDynamicIdentity(((Student) s6).getId());
            System.out.println("-----------------------------------------");
            s7.showDynamicIdentity(((Student) s7).getId());
            System.out.println("------------------------------------------");
            s8.showDynamicIdentity(((Student) s8).getId());
            System.out.println("-----------------------------------------");
            s9.showDynamicIdentity(((Student) s9).getId());
            System.out.println("-----------------------------------------");
            s10.showDynamicIdentity(((Student) s10).getId());
            System.out.println("------------------------------------------");

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Failed to insert records into the Database");
            e.printStackTrace();
        } 
    }
}
