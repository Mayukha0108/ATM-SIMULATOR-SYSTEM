
package bank.management.system;

import java.sql.*;

public class Conn {

   Connection c;
   Statement s;
   public Conn() {
       try {
//         Class.forName(com.mysql.cj.jdbc.Driver); // Register driver class
           c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "mayukha0108");
           s = c.createStatement();
       } catch (Exception e) {
           System.out.println(e);
       }
   }
}
