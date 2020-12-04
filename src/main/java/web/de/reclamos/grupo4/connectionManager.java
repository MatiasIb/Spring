package web.de.reclamos.grupo4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionManager {

    private static Connection conectar = null;

    public static Connection conectarBD()throws SQLException {

        if (conectar==null)
            conectar = DriverManager.getConnection("jdbc:postgresql://forgedb.netbyteoss.com:5443/forge_alumnos",
                    "jbecerra","B20.96");
        return conectar;
    }

}
