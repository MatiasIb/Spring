package web.de.reclamos.grupo4.dao;

import com.sun.org.apache.bcel.internal.generic.ARETURN;
import web.de.reclamos.grupo4.connectionManager;
import web.de.reclamos.grupo4.dto.reclamosDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class tablaReclamosDAO {

    private Connection conectar;

    public tablaReclamosDAO() throws SQLException {
        this.conectar = connectionManager.conectarBD();
    }

    //crear reclamo
    public void crear_reclamo (int num_reclamos, String rut, Date fecha, String categoria, String reclamo) throws SQLException{
        String sql = "INSERT INTO tablareclamos_grupo4 (num_reclamos,rut,fecha,categoria,reclamo,estado)" +
                "values(DEFAULT,?,?,?,?,?)";

        PreparedStatement ps = conectar.prepareStatement(sql);
        ps.setString(1,rut);
        ps.setDate(2,fecha);
        ps.setString(3,categoria);
        ps.setString(4,reclamo);
        ps.setString(5,"Pendiente");
         ps.execute();


    }
    //Eliminar reclamo
    public void eliminarReclamo (int num_reclamos) throws SQLException{
        String sql = "DELETE FROM tablareclamos_grupo4 Where num_reclamos = ?";
        PreparedStatement ps = conectar.prepareStatement(sql);
        ps.setInt(1,num_reclamos);
        ps.execute();

    }

    //Traer reclamo por rut
    public List<reclamosDTO> obtenerReclamos(String rut) throws SQLException{
        String sql = "SELECT * FROM tablareclamos_grupo4 where rut = ? ORDER BY num_reclamos desc";

        PreparedStatement ps = conectar.prepareStatement(sql);
        ps.setString(1,rut);
        ResultSet rs = ps.executeQuery();
        List<reclamosDTO> listaReclamos = new ArrayList<>();
        while (rs.next()) {
            int num_reclamos = rs.getInt("num_reclamos");
            String ruts = rs.getString("rut");
            Date fecha = rs.getDate("fecha");
            String categoria = rs.getString("categoria");
            String reclamo = rs.getString("reclamo");
            String comentarios = rs.getString("comentarios");
            String estado = rs.getString("estado");

            reclamosDTO a = new reclamosDTO(num_reclamos,ruts,fecha,categoria,reclamo,null,comentarios,estado);
            listaReclamos.add(a);
        }
        return listaReclamos;
    }

    //Traer todos los reclamos
    public List<reclamosDTO> traerTodosLosReclamos() throws SQLException{
        String sql = "SELECT * FROM tablareclamos_grupo4 ORDER BY num_reclamos desc";

        PreparedStatement ps = conectar.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<reclamosDTO> listaReclamos = new ArrayList<>();
        while (rs.next()) {
            int num_reclamos = rs.getInt("num_reclamos");
            String ruts = rs.getString("rut");
            Date fecha = rs.getDate("fecha");
            String categoria = rs.getString("categoria");
            String reclamo = rs.getString("reclamo");
            String antecedentes = rs.getString("antecedentes");
            String comentarios = rs.getString("comentarios");
            String estado = rs.getString("estado");

            reclamosDTO a = new reclamosDTO(num_reclamos,ruts,fecha,categoria,reclamo,antecedentes,comentarios,estado);
            listaReclamos.add(a);
        }
        return listaReclamos;
    }

    //AgregarComentario
    public void AgregarComentario(int num_reclamos, String comentario) throws SQLException {
        String sql = "update tablareclamos_grupo4 set comentarios = ? where num_reclamos = ?";

        PreparedStatement ps = conectar.prepareStatement(sql);
        ps.setString(1, comentario);
        ps.setInt(2, num_reclamos);
        ps.execute();
    }

    //AgregarAntecedentes
    public void AgregarAntecedentes(int num_reclamos, String antecedente) throws SQLException {
        String sql = "update tablareclamos_grupo4 set antecedentes = ? where num_reclamos = ?";

        PreparedStatement ps = conectar.prepareStatement(sql);
        ps.setString(1, antecedente);
        ps.setInt(2, num_reclamos);
        ps.execute();
    }

    // Cambiar estado a Resuelto
    public void resuelto(int num_reclamos) throws SQLException {
        String sql = "update tablareclamos_grupo4 set estado = 'Resuelto' where num_reclamos = ? ";

        PreparedStatement ps = conectar.prepareStatement(sql);
        ps.setInt(1,num_reclamos);
        ps.execute();
    }


    //Traer antecedente por numero
    public String traerAntecedente(int num_reclamos) throws SQLException {
        String sql = "select antecedentes from tablareclamos_grupo4 where num_reclamos = ?";

        PreparedStatement ps = conectar.prepareStatement(sql);

        ps.setInt(1,num_reclamos);
        ResultSet rs = ps.executeQuery();

        rs.next();

        String ante = rs.getString("antecedentes");


        return ante;
    }

    //Traer Comentario por numero
    public String traerComentario(int num_reclamos) throws SQLException {
        String sql = "select comentarios from tablareclamos_grupo4 where num_reclamos = ?";

        PreparedStatement ps = conectar.prepareStatement(sql);

        ps.setInt(1,num_reclamos);
        ResultSet rs = ps.executeQuery();

        rs.next();

        String ante = rs.getString("comentarios");


        return ante;
    }


}
