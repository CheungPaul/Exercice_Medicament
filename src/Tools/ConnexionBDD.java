package Tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class ConnexionBDD
{
    private static Connection cnx;

    public ConnexionBDD() throws ClassNotFoundException, SQLException {
        //String pilote = "com.mysql.jdbc.Driver";
        String pilote = "com.mysql.cj.jdbc.Driver";
        Class.forName(pilote);
        cnx = DriverManager.getConnection("jdbc:mysql://localhost/suivimedical?serverTimezone="
                + TimeZone.getDefault().getID(), "root", "");
    }
    public static Connection getCnx() {
        return cnx;
    }
}
