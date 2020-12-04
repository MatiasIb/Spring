package web.de.reclamos.grupo4.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.de.reclamos.grupo4.dao.registroDAO;
import web.de.reclamos.grupo4.dao.tablaReclamosDAO;
import web.de.reclamos.grupo4.dto.reclamosDTO;
import web.de.reclamos.grupo4.dto.registroDTO;
import web.de.reclamos.grupo4.email.EmailBody;
import web.de.reclamos.grupo4.email.EmailPort;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")


public class resource {
    @Autowired
    private EmailPort emailPort;

    // Registrarse
    @RequestMapping(method = RequestMethod.POST, value = "/registrar")
    public void registro(@RequestBody registroDTO data ) throws SQLException {
        new registroDAO().crearusuario(data.getRut(), data.getNombre(), data.getApellido(), data.getDireccion(), data.getCorreo(), data.getNom_usuario(), data.getClave());
        EmailBody emailBody = new EmailBody();
        emailBody.setEmail(data.getCorreo());
        emailBody.setSubject("¡Bienvenido a la pagina web de reclamos!");

        String emailcontent="\n" +
                "<div style=\"background-color: #2C3240 ; display: flex;\">\n" +
                "<img src=\"https://i.ibb.co/ZS9pp5b/libro.png\" alt=\"libro\" border=\"0\" style=\"height: 60px;width: 60px; \">  \n" +
                "<h2 style=\"color: white;margin-top: 10px; margin-left: 20px;\">Web de reclamos</h2>\n" +
                "\n" +
                "</div>\n" +
                "\n" +
                "<h2>Bienvenidos a la web de reclamos!</h2>\n" +
                "<p style=\"margin-bottom: 2px;\"  >Muchas gracias por registrarte en nuestra web, recuerda que este es solo un mensaje para recordarte que te registraste en nuestra web</p>\n" +
                "<p>Cualquier consulta dejarla al numero: </p>\n" +

                "\n" +
                "<br>\n" +
                "<br>\n" +
                "<div style=\"background-color: #2C3240; height: 60px; \"> </div>";


        emailBody.setContent(emailcontent);

        emailPort.sendEmail(emailBody);
        }


    // Modificar

    @RequestMapping(method = RequestMethod.PUT, value = "/modificar/{rut}")
    public void modificar(@PathVariable(name = "rut") String rut, @RequestBody registroDTO data) throws SQLException {
        new registroDAO().modificarusuario(rut, data.getNombre(), data.getApellido(), data.getDireccion(), data.getCorreo(), data.getNom_usuario(), data.getClave());
    }

    // Validar un Usuario

    @RequestMapping(method = RequestMethod.GET, value = "/validar/{nom_usuario}/{clave}")
    public String validarUsuario(@PathVariable String nom_usuario, @PathVariable String clave) throws SQLException {

        String a = new registroDAO().validarUsuario(nom_usuario, clave);

        return a;
    }

    // Traer los datos del usuario
    @RequestMapping(method = RequestMethod.GET, value = "/traer/{nom_usuario}/{clave}")
    public registroDTO traerUsuario(@PathVariable String nom_usuario, @PathVariable String clave) throws SQLException {

        registroDTO a = new registroDAO().traerDatos(nom_usuario, clave);

        return a;

    }

    // Crear Reclamo
    @RequestMapping(method = RequestMethod.POST, value = "/tabla_reclamo/crear_reclamo")
    public void reclamo(@RequestBody reclamosDTO reclamo) throws SQLException {
         new tablaReclamosDAO().crear_reclamo(reclamo.getNum_reclamos(), reclamo.getRut(), reclamo.getFecha(), reclamo.getCategoria(), reclamo.getReclamo());


    }

    // Eliminar Reclamo
    @RequestMapping(method = RequestMethod.DELETE, value = "/tabla_reclamo/eliminarReclamo/{num_reclamos}")
    public void eliminar(@PathVariable(name = "num_reclamos") int num_reclamos) throws SQLException {
        new tablaReclamosDAO().eliminarReclamo(num_reclamos);
    }

    // Traer Reclamos por rut
    @RequestMapping(method = RequestMethod.GET, value = "/tabla_reclamo/traerPorRut/{rut}")
    public List<reclamosDTO> listadeReclamos(@PathVariable(name = "rut") String rut) throws SQLException {
        List<reclamosDTO> listaobtenida = new tablaReclamosDAO().obtenerReclamos(rut);
        return listaobtenida;
    }

    //Traer todos los reclamos
    @RequestMapping(method = RequestMethod.GET, value = "/tabla_reclamo/traerTodos/")
    public List<reclamosDTO> TraerTodosLosReclamos() throws SQLException {
        List<reclamosDTO> todos = new tablaReclamosDAO().traerTodosLosReclamos();
        return todos;

    }

    //Agregar comentarios
    @RequestMapping(method = RequestMethod.PUT, value = "/tabla_reclamo/agregarComentarios/{num_reclamos}/{comentario}")
    public void agregarComentario(@PathVariable int num_reclamos, @PathVariable String comentario) throws SQLException {

        new tablaReclamosDAO().AgregarComentario(num_reclamos, comentario);

    }

    //Agregar antecedentes
    @RequestMapping(method = RequestMethod.PUT, value = "/tabla_reclamo/agregarAntecedentes/{num_reclamos}/{antecedente}")
    public void agregarAntecedentes(@PathVariable int num_reclamos, @PathVariable String antecedente) throws SQLException {

        new tablaReclamosDAO().AgregarAntecedentes(num_reclamos, antecedente);

    }

    //Agregar Cambiar Estado
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.PUT, value = "/tabla_reclamo/CambiarEstado/{num_reclamos}/")
    public void Resuelto(@PathVariable int num_reclamos) throws SQLException {

        new tablaReclamosDAO().resuelto(num_reclamos);

    }

    //Traer antecedente por numero de reclamo
    @RequestMapping(produces = "text/plain", method = RequestMethod.GET, value = "/tabla_reclamo/TraerAntecedentes/{num_reclamos}")
    public String Traer (@PathVariable int num_reclamos) throws SQLException {
        String a = new tablaReclamosDAO().traerAntecedente(num_reclamos);
        return a;
    }

    //Traer Comentario por numero de reclamo
    @RequestMapping(produces = "text/plain", method = RequestMethod.GET, value = "/tabla_reclamo/TraerComentario/{num_reclamos}")
    public String TraerComentario (@PathVariable int num_reclamos) throws SQLException {
        String a = new tablaReclamosDAO().traerComentario(num_reclamos);
        return a;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/validar/{correo}")
    public int validarCorreo(@PathVariable(name = "correo") String correo ) throws SQLException{

        int a = new registroDAO().validarCorreo(correo);

        return a;

    }

    @RequestMapping(method = RequestMethod.GET, value = "/validarUser/{nom_usuario}")
    public int validarUser(@PathVariable(name = "nom_usuario") String nom_usuario ) throws SQLException{

        int a = new registroDAO().validarUser(nom_usuario);

        return a;

    }

    @RequestMapping(method = RequestMethod.GET, value = "/traerDatos/{rut}")
    public registroDTO TraerDatosUsuariosPorRut(@PathVariable String rut) throws SQLException {

        registroDTO a = new registroDAO().traerDatosUsuariosPorRut(rut);

        return a;

    }
}
