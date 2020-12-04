package web.de.reclamos.grupo4.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import web.de.reclamos.grupo4.connectionManager;
import web.de.reclamos.grupo4.dto.registroDTO;
import web.de.reclamos.grupo4.email.EmailBody;
import web.de.reclamos.grupo4.email.EmailPort;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class registroDAO {

    @Autowired
    private EmailPort emailPort;

    private Connection conectar;


    public registroDAO() throws SQLException {
        this.conectar = connectionManager.conectarBD();

    }

    //crear usuario
    public void crearusuario(String rut, String nombre, String apellido, String direccion, String correo, String usuario, String clave) throws SQLException{
      String sql = "INSERT INTO usuarios_grupo4 (rut,nombre,apellido,direccion,correo,nom_usuario,clave,rol)" +
              "values(?,?,?,?,?,?,?,?)";

        PreparedStatement ps = conectar.prepareStatement(sql);
        ps.setString(1,rut);
        ps.setString(2,nombre);
        ps.setString(3,apellido);
        ps.setString(4,direccion);
        ps.setString(5,correo);
        ps.setString(6,usuario);
        ps.setString(7,clave);
        ps.setString(8,"usuario");
        ps.execute();
        
    }

    //modificar usuario

    public void modificarusuario(String rut, String nombre, String apellido, String direccion, String correo, String usuario, String clave) throws SQLException{
      String sql = "UPDATE usuarios_grupo4 " +
              "SET nombre=?,apellido=?,direccion=?,correo=?,nom_usuario=?,clave=? WHERE rut=?";

      PreparedStatement ps = conectar.prepareStatement(sql);

        ps.setString(1,nombre);
        ps.setString(2,apellido);
        ps.setString(3,direccion);
        ps.setString(4,correo);
        ps.setString(5,usuario);
        ps.setString(6,clave);
        ps.setString(7,rut);
        ps.execute();

    }

    //validar usuario

    public String validarUsuario(String usuario,String clave) throws SQLException {
        String sql = "select nom_usuario,clave,rol from usuarios_grupo4 where nom_usuario = ? and clave = ?";
        PreparedStatement ps = conectar.prepareStatement(sql);
        ps.setString(1,usuario);
        ps.setString(2,clave);
        ResultSet rs = ps.executeQuery();
        rs.next();

        String nom_usuario = rs.getString("nom_usuario");
        String claves = rs.getString("clave");
        String usuarios = rs.getString("rol");

        if (usuarios.equals("usuario")) {
            return "true";
        }
        else if (usuarios.equals("admin")) {
            return "false";
        }
        else{
            return "error";
        }
    }

    public registroDTO traerDatos(String usuario, String clave) throws SQLException {
        String sql = "select * from usuarios_grupo4 where nom_usuario = ? and clave = ? ";
        PreparedStatement ps = conectar.prepareStatement(sql);
        ps.setString(1, usuario);
        ps.setString(2, clave);
        ResultSet rs = ps.executeQuery();
        rs.next();

        String rut = rs.getString("rut");
        String nombre = rs.getString("nombre");
        String apellido = rs.getString("apellido");
        String direccion = rs.getString("direccion");
        String correo = rs.getString("correo");
        String nom_usuario = rs.getString("nom_usuario");
        String claves = rs.getString("clave");
        String rol = rs.getString("rol");

        registroDTO a = new registroDTO(rut,nombre,apellido,direccion,correo,nom_usuario,claves,rol);


        return a ;
    }

    public int validarCorreo (String correo) throws SQLException {
        String sql = "select correo from usuarios_grupo4 where correo=?";
        int ret = 0;
        PreparedStatement ps = conectar.prepareStatement(sql);
        ps.setString(1,correo);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            ret = 1;

        }
        return ret;
    }

    public int validarUser (String nom_usuario) throws SQLException {
        String sql = "select correo from usuarios_grupo4 where nom_usuario=?";
        int ret = 0;
        PreparedStatement ps = conectar.prepareStatement(sql);
        ps.setString(1,nom_usuario);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            ret = 2;

        }
        return ret;
    }

    public registroDTO traerDatosUsuariosPorRut(String rut) throws SQLException {
        String sql = "select * from usuarios_grupo4 where rut= ?";
        PreparedStatement ps = conectar.prepareStatement(sql);
        ps.setString(1, rut);
        ResultSet rs = ps.executeQuery();
        rs.next();

        String ruts = rs.getString("rut");
        String nombre = rs.getString("nombre");
        String apellido = rs.getString("apellido");
        String direccion = rs.getString("direccion");
        String correo = rs.getString("correo");
        String nom_usuario = rs.getString("nom_usuario");
        String claves = rs.getString("clave");
        String rol = rs.getString("rol");

        registroDTO a = new registroDTO(ruts, nombre, apellido, direccion, correo, nom_usuario, claves, rol);


        return a;
    }
}
