import java.util.Scanner;

public class mensajesServices {

    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String registro = sc.nextLine();

        System.out.println("Escribe tu nombre");
        String nombre = sc.nextLine();

        Mensajes mensaje = new Mensajes();
        mensaje.setMensaje(registro);
        mensaje.setAutor_mensaje(nombre);
        MensajesDAO.crearMensajeDB(mensaje);
    }

    public static void listarMensajes(){
        MensajesDAO.listarMensajesDB();
    }

    public static void borrarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Coloca el ID del mensaje que deseas borrar");
        int id_mensaje = sc.nextInt();
        MensajesDAO.borrarMensaje(id_mensaje);
    }

    public static void  editarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu nuevo mensaje");
        String mensajeEditado = sc.nextLine();

        System.out.println("Escribe el ID del mensaje a editar");
        int numeroId = sc.nextInt();

        Mensajes actualizar = new Mensajes();
        actualizar.setMensaje(mensajeEditado);
        actualizar.setId_mensaje(numeroId);
        MensajesDAO.editarMensaje(actualizar);
    }
}
