package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DBContext {

    public static Connection connection = null;

    public Connection connect() {
        // Doi ten database cac thu o day
        String server = "localhost";
        String port = "1433";
        String database = "HaoHao";
        String user = "sa";
        String password = "1";

        try {
            // Khai bao driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://"
                    + server + ":" + port + ";databaseName=" + database + ";"
                    + "user=" + user + ";password=" + password + ";");
//                    + ";encrypt=true;" + "trustServerCertificate=true;");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    public static void main(String[] args) {
        System.out.println(new DBContext().connect());
    }
}
