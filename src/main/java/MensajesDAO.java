import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajesDAO {
    public static void crearMensajeDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();

        try (Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;

            try{
                String query = "INSERT INTO mensajes(mensaje, autor_mensajes) VALUES (?,?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1,mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("El mensaje fue creado correctamente");

            }catch (SQLException ex){
                System.out.println(ex);
            }

        }catch (SQLException e){
            System.out.println(e);
        }

    }

    public static void listarMensajesDB(){
        Conexion db_connect = new Conexion();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection conexion = db_connect.get_connection()){
            String query = "SELECT * FROM mensajes";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while(rs.next()){
                System.out.println("ID: "+rs.getInt("id_mensajes"));
                System.out.println("Nombre: "+rs.getString("mensaje"));
                System.out.println("Autor: "+rs.getString("autor_mensajes"));
                System.out.println("Fecha: "+rs.getDate("fecha_mensaje"));
            }

        }catch(SQLException e){
            System.out.println("No se encontraron registros");
            System.out.println(e);
        }
    }

    public static void borrarMensaje(int id_mensajes){
        Conexion db_connect = new Conexion();

        try (Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;

            try{
                String query = "DELETE FROM mensajes WHERE id_mensajes = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, id_mensajes);
                ps.executeUpdate();
                System.out.println("El mensaje fue borrado");
            }catch (SQLException ex) {
                System.out.println(ex);
                System.out.println("No se a podido borrar el mensaje");
            }

        }catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void  editarMensaje(Mensajes mensajes){
        Conexion db_connect = new Conexion();

        try (Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;

            try {
                String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensajes = ?";
                ps = conexion.prepareStatement(query);
                ps.setString(1,mensajes.getMensaje());
                ps.setInt(2,mensajes.getId_mensaje());
                System.out.println("El mensaje fue actualizado");
                ps.executeUpdate();
           } catch (SQLException ex) {
                System.out.println(ex);
                System.out.println("No se ha podido actualizar");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
