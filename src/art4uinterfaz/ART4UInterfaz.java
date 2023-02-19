/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art4uinterfaz;

import art4ucad.Art4UCAD;
import static art4uinterfaz.Validacion.*;
import art4upojo.Ciudad;
import art4upojo.ExcepcionArt4UBD;
import art4upojo.Usuario;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Rim El abrouki
 * @version 1.0
 * @since AaD 1.0
 */
public class ART4UInterfaz {

    public ART4UInterfaz() {

    }
    static Scanner sc = new Scanner(System.in);
    static boolean salir = false;
    static int opcion;

    /**
     * @param args the command line arguments
     * @throws art4upojo.ExcepcionArt4UBD
     */
    public static void main(String[] args) throws ExcepcionArt4UBD, Exception {

        PropertyConfigurator.configure("logs\\log4j.properties");
        Logger loggerNavegacion = LogManager.getLogger("NAVEGACION");
        // MENU PRINCIPAL
        int opcion2;
        do {
            loggerNavegacion.info("Entrada en el Menu Principal");
            System.out.println(" ******** MENU PRINCIPAL ********* ");
            System.out.println("1.GESTION DE USUARIOS");
            System.out.println("2.GESTION DE CIDADES");
            System.out.println("0.SALIR");
            try {
                System.out.println("Por Favor, Dame una de las Opciones: ");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 0:
                        loggerNavegacion.info("Salida del Programa");
                        salir = true;
                        break;
                    case 1:
                        loggerNavegacion.info("Entrada en el Menu de GESTION DE USUARIOS");
                        System.out.println(" ******** GESTION DE USUARIOS *********** ");
                        menuGestionUsuarios();
                        break;
                    case 2:
                        loggerNavegacion.info("ENTRADA AL MENU DE GESTION DE CIUDADES");
                        System.out.println(" ******** GESTION DE CIUDADES *********** ");
                        menuGestionCiudades();
                        break;
                    default:
                        System.out.println("Solo un numero entre 0 y 2");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Debes insertar un numero entre 0 y 2 " + ex);
                sc.next();
            }

        } while (!salir);
        {
            System.out.println("Hasta Luego");

        }
    }

    public static void menuGestionUsuarios() throws ExcepcionArt4UBD, Exception {
        PropertyConfigurator.configure("logs\\log4j.properties");
        Logger loggerNavegacion = LogManager.getLogger("NAVEGACION");
        String[] args = null;
        do {
            loggerNavegacion.info("ENTRADA EN EL MENU GESTION DE USUARIO");
            System.out.println("1.Nuevo Usuario");
            System.out.println("2.Eliminar Usuario");
            System.out.println("3.Modificar Usuario");
            System.out.println("4.Consultar 1 Usuario");
            System.out.println("5.Mostrar Todos los Usuarios");
            System.out.println("0.Volver al Menu Principal");
            try {
                System.out.println("Por Favor, Dame una de las Opciones: ");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 0:
                        loggerNavegacion.info("SALIDA DEL MENU GESTION DE USUARIOS");
                        main(args);
                        break;
                    case 1:
                        loggerNavegacion.info("ENTRADA EN NUEVO USUARIO");
                        NuevoUsuario();
                        break;
                    case 2:
                        loggerNavegacion.info("ENTRADA EN ELIMINAR USUARIO");
                        EliminarUsuario();
                        break;
                    case 3:
                        System.out.println("\t--- ACTUALIZAR USUARIO ---");
                        ActualizarUsuario();
                        break;
                    case 4:
                        loggerNavegacion.info("ENTRADA EN MOSTRAR 1 USUARIO");
                        mostrarUsuario();
                        break;
                    case 5:
                        loggerNavegacion.info("ENTRADA EN MOSTRAR TODAS LOS USUARIOS");
                        MostrarUsuarios();
                        break;
                    default:
                        System.out.println("Solo un numero entre 0 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un numero entre 0 y 5 " + e);
                sc.next();
            }

        } while (!salir);
        System.exit(0);
    }

    public static void menuGestionCiudades() throws ExcepcionArt4UBD, Exception {
        PropertyConfigurator.configure("logs\\log4j.properties");
        Logger loggerNavegacion = LogManager.getLogger("NAVEGACION");
        String[] args = null;
        do {
            loggerNavegacion.info("ENTRADA EN EL MENU GESTION DE CIUDADES");
            System.out.println("1.Nuevo Ciudad");
            System.out.println("2.Eliminar Ciudad");
            System.out.println("3.Modificar Ciudad");
            System.out.println("4.Consultar 1 Ciudad");
            System.out.println("5.Mostrar Todos los Ciudades");
            System.out.println("0.Volver al Menu Principal");
            try {
                System.out.println("Por Favor, Dame una de las Opciones: ");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 0:
                        loggerNavegacion.info("SALIDA DEL MENU GESTION DE CIUDADES");
                        main(args);
                        break;
                    case 1:
                        loggerNavegacion.info("ENTRADA EN NUEVO CIUDAD");
                        NuevaCiudad();
                        break;
                    case 2:
                        loggerNavegacion.info("ENTRADA EN ELIMINAR CIUDAD");
                        EliminarCiudad();
                        break;
                    case 3:
                        loggerNavegacion.info("ENTRADA EN ACTUALIZAR CIUDAD");
                        ActualizarCiudad();
                        break;
                    case 4:
                        loggerNavegacion.info("ENTRADA EN MOSTRAR 1 CIUDAD");
                        mostrarCiudad();
                        break;
                    case 5:
                        loggerNavegacion.info("ENTRADA EN MOSTRAR TODOS LOS CIUDADES");
                        MostrarCiudades();
                        break;
                    default:
                        System.out.println("Solo un numero entre 0 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un numero entre 0 y 5 " + e);
                sc.next();
            }

        } while (!salir);
        System.exit(0);
    }

    /**
     * LOS METODOS DE LA CIUDAD
     */
    // NUEVA CIUDAD
    private static void NuevaCiudad() {
        try {
            Art4UCAD cad = new Art4UCAD();
            int registrosAfectados = 0;
            Ciudad ciudad = PedirDatosCiudad();
            System.out.printf("\t\t\tLos datos a insertar son: \n");
            System.out.printf("\t\t\tNombre de la Ciudad: %s \n", ciudad.getNombre());
            registrosAfectados = cad.insertarCiudad(ciudad);
            System.out.printf("%n\t\t\tCIUDAD CREADO CON EXITO!!%n");
        } catch (ExcepcionArt4UBD ex) {
            PropertyConfigurator.configure("logs\\log4j.properties");
            Logger loggerERROR = LogManager.getLogger("ERROR");
            loggerERROR.error(ex.getSentanciaSQL() + " \n " + ex.getCodigoError() + " - " + ex.getMensajeErrorAdministrador());
            System.out.println(ex);
        }
    }

    //METODO PARA LEER DATOS DE LA CIUDAD
    public static Ciudad PedirDatosCiudad() {
        String nombreCiudad;
        Ciudad c = new Ciudad();
        Scanner in = new Scanner(System.in);
        System.out.print("\t\t\tIntroduzca el Nombre de la Ciudad: ");
        nombreCiudad = in.nextLine();
        nombreCiudad = nombreCiudad.trim();
        while (!esString(nombreCiudad)) {
            System.out.println("\t\t\tEl Nombre de la Ciudad Introducido es invalido,Intenta de nuevo: ");
            nombreCiudad = in.nextLine();
            nombreCiudad = nombreCiudad.trim();
        }
        c.setNombre(nombreCiudad);
        return c;
    }

    /**
     * MOSTRAR UNA CIUDAD
     */
    public static void mostrarCiudad() {
        try {
            String cadena;
            Integer ciudadID;
            Scanner teclado = new Scanner(System.in);
            Art4UCAD cad = new Art4UCAD();
            Ciudad c = new Ciudad();
            //CIUDAD_ID
            System.out.println("Introduzca el ID de la Ciudad: ");
            cadena = teclado.nextLine();
            while (!esEntero(cadena)) {
                System.out.println("El ID de la Ciudad No es Un numero valid, Intenta de nuevo: ");
                cadena = teclado.nextLine();
            }
            ciudadID = Integer.parseInt(cadena);
            c = cad.leerCiudad(ciudadID);
            if (c.getNombre() == null) {
                System.out.printf("\t\t\tNo Encontrado\n");
            } else {
                System.out.printf("\t\t\t ---- CIUDAD ENCONTRADA ----\n");
                System.out.println("\t\t\t\tID    NOMBRE");
                System.out.printf("\t\t\t\t%-6s%-40s", c.getCiudadId(), c.getNombre());
                System.out.println("");
                System.out.printf("\t\t\t -----------------------------");
                System.out.println("");
            }
        } catch (ExcepcionArt4UBD ex) {
            PropertyConfigurator.configure("logs\\log4j.properties");
            Logger loggerERROR = LogManager.getLogger("ERROR");
            loggerERROR.trace("Esto es un trace");
            loggerERROR.error(ex.getSentanciaSQL() + " \n " + ex.getCodigoError() + " - " + ex.getMensajeErrorAdministrador());
            System.out.println(ex);
        }

    }

    //METODO QUE MUESTRA TODAS LAS CIUDADES
    private static void MostrarCiudades() {
        try {
            Art4UCAD cad = new Art4UCAD();
            ArrayList<Ciudad> listaCiudades = cad.leerCiudades();
            System.out.printf("\t\t------ CIUDADES -----\n");
            System.out.println("\t\tID    NOMBRE");
            Iterator<Ciudad> itrCiudades = listaCiudades.iterator();
            while (itrCiudades.hasNext()) {
                Ciudad c = itrCiudades.next();
                if (c.getCiudadId() >= 0) {
                    System.out.printf("\t\t%-6s%-40s", c.getCiudadId(), c.getNombre());
                }
                System.out.println("");
            }
        } catch (ExcepcionArt4UBD ex) {
            PropertyConfigurator.configure("logs\\log4j.properties");
            Logger loggerERROR = LogManager.getLogger("ERROR");
            loggerERROR.error(ex.getSentanciaSQL() + " \n " + ex.getCodigoError() + " - " + ex.getMensajeErrorAdministrador());
            System.out.println(ex);

        }

    }

    //METODO PARA ACTUALIZAR CIUDADES 
    private static void ActualizarCiudad() {
        try {
            Art4UCAD cad = new Art4UCAD();
            Scanner in = new Scanner(System.in);
            int registrosAfectados = 0;
            Integer ciudad;
            System.out.printf("\t\t\tIntroduzca el ID de la ciudad a modificar: ");
            ciudad = in.nextInt();
            Ciudad c = PedirDatosCiudad();
            c.setCiudadId(ciudad);
            boolean encontrado = encontrarCiudad(ciudad);
            if (encontrado == true) {
                registrosAfectados = cad.actualizarciudad(ciudad, c);
                System.out.printf("\t\t\tDATOS MODIFICADOS:\n");
                System.out.printf("\t\t\t\tNOMBRE CIUDAD: %s \n", c.getNombre());
                System.out.printf("%n\t\t\tCIUDAD MODIFICADO CON EXITO!!%n");
            } else {
                System.out.printf("\t\t\tEl ID de la Ciudad Introducida No existe.\n");
            }
        } catch (ExcepcionArt4UBD ex) {
            PropertyConfigurator.configure("logs\\log4j.properties");
            Logger loggerERROR = LogManager.getLogger("ERROR");
            loggerERROR.trace("Esto es un trace");
            loggerERROR.error(ex.getSentanciaSQL() + " \n " + ex.getCodigoError() + " - " + ex.getMensajeErrorAdministrador());
            System.out.println(ex);
        }

    }

    /**
     * METODO PARA ELIMINAR CIUDAD
     */
    private static void EliminarCiudad() {
        try {
            Art4UCAD cad = new Art4UCAD();
            Ciudad miCiudad = new Ciudad();
            Scanner in = new Scanner(System.in);
            int registrosAfectados = 0;
            Integer ciudadId;
            System.out.printf("\t\t\tDame el ID de la Ciudad a Eliminar:");
            String str = in.nextLine();
            while ((!Validacion.esEntero(str))) {
                System.out.println("El ID de la Ciudad No es un numero valido,Intenta de nuevo: ");
                ciudadId = in.nextInt();
            }
            ciudadId = Integer.parseInt(str);
            miCiudad = cad.leerCiudad(ciudadId);
            if (miCiudad.getNombre() == null) {
                System.out.printf("\t\t\tNO ENCONTRADO\n");
            } else {
                System.out.print("Seguro que desea Eliminar La ciudad de ID =" + ciudadId + " ? (S/N): ");
                str = in.nextLine();
                char resp = str.toLowerCase().charAt(0);
                if (resp == 'n' || resp == 'N') {
                    System.out.printf("\t\t\tOperracion Candelada\n");
                } else {
                    registrosAfectados = cad.eliminarCiudad(ciudadId);
                    System.out.printf("\t\t\tCIUDAD BORRADA CON EXITO!!\n");
                }
            }
        } catch (ExcepcionArt4UBD ex) {
            PropertyConfigurator.configure("logs\\log4j.properties");
            Logger loggerERROR = LogManager.getLogger("ERROR");
            loggerERROR.trace("Esto es un trace");
            loggerERROR.error(ex.getSentanciaSQL() + " \n " + ex.getCodigoError() + " - " + ex.getMensajeErrorAdministrador());
            System.out.println(ex);
        }
    }

    //METODO PARA ENCONTRAR LA CIUDAD 
    public static boolean encontrarCiudad(int id) {
        boolean encontrado = false;
        try {
            Art4UCAD cad = new Art4UCAD();
            Ciudad ciud = new Ciudad();
            ciud = cad.leerCiudad(id);
            if (ciud.getNombre() == null) {
                encontrado = false;
            } else {
                encontrado = true;
            }
        } catch (ExcepcionArt4UBD ex) {
            PropertyConfigurator.configure("logs\\log4j.properties");
            Logger loggerERROR = LogManager.getLogger("ERROR");
            loggerERROR.trace("Esto es un trace");
            loggerERROR.error(ex.getSentanciaSQL() + " \n " + ex.getCodigoError() + " - " + ex.getMensajeErrorAdministrador());
            System.out.println(ex);
        }
        return encontrado;
    }

    private static void NuevoUsuario() throws ParseException {
        try {
            Art4UCAD cad = new Art4UCAD();
            int registrosAfectados = 0;
            Usuario u = pedirDatosUsuario();
            registrosAfectados = cad.insertarUsuario(u);
            System.out.printf("\t\t\tLOS DATOS A INSERTAR DEL USUARIO SON: \n");
            System.out.printf("\t\t\t\tNOMBRE: %s \n", u.getNombre());
            System.out.printf("\t\t\t\tAPELLIDO: %s \n", u.getApellido());
            System.out.printf("\t\t\t\tGENERO: %s \n", u.getGenero());
            System.out.printf("\t\t\t\tFECHA DE NACIONAMIENTO: %s \n", u.getFechaNacio());
            System.out.printf("\t\t\t\tEMAIL: %s \n", u.getEmail());
            System.out.printf("\t\t\t\tTELEFONO: %s \n", u.getTelefono());
            System.out.printf("\t\t\t\tNUMERO DE LA TARJETA: %s \n", u.getNumeroTarjeta());
            //CIUDAD_ID
            System.out.printf("\t\t\t\tCIUDAD ID: %s \n", u.getCiudad().getCiudadId());
            System.out.printf("\t\t\t USUARIO CREADO CON EXITO!! \n");
        } catch (ExcepcionArt4UBD ex) {
            PropertyConfigurator.configure("logs\\log4j.properties");
            Logger loggerERROR = LogManager.getLogger("ERROR");
            loggerERROR.trace("Esto es un trace");
            loggerERROR.error(ex.getSentanciaSQL() + " \n " + ex.getCodigoError() + " - " + ex.getMensajeErrorAdministrador());
            System.out.println(ex);
        }
    }

    //Método que busca un Usuario
    public static boolean encontrarUsuario(int id) {
        boolean encontrado = false;
        try {
            Art4UCAD cad = new Art4UCAD();
            Usuario usuario = new Usuario();
            usuario = cad.leerUsuario(id);
            if (usuario.getNombre() == null) {
                encontrado = false;
            } else {
                encontrado = true;
            }
        } catch (ExcepcionArt4UBD ex) {
            PropertyConfigurator.configure("logs\\log4j.properties");
            Logger loggerERROR = LogManager.getLogger("ERROR");
            loggerERROR.trace("Esto es un trace");
            loggerERROR.error(ex.getSentanciaSQL() + " \n " + ex.getCodigoError() + " - " + ex.getMensajeErrorAdministrador());
            System.out.println(ex);
        }
        return encontrado;
    }

    //Método que lee un Usuario por teclado
    public static Usuario pedirDatosUsuario() throws ParseException {
        Scanner in = new Scanner(System.in);
        Ciudad c = new Ciudad();
        Usuario u = new Usuario();
        String str;
        Integer ciudadId = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //NOMBRE
        System.out.printf("\t\t\tIntroduzca el Nombre del Usuario: ");
        in = new Scanner(System.in);
        str = (in.nextLine()).trim();
        while (!Validacion.esString(str)) {
            System.out.printf("\t\t\tDato Erroneo,Introduzca el Nombre del Usuario: ");
            in = new Scanner(System.in);
            str = (in.nextLine()).trim();
        }
        u.setNombre(str);
        //APELLIDO
        System.out.printf("\t\t\tItroduzca el Apellido del Usario: ");
        in = new Scanner(System.in);
        str = (in.nextLine()).trim();
        while (!Validacion.esString(str)) {
            System.out.printf("\t\t\tDato Erroneo: Introduzca el Apellido del Usario: ");
            in = new Scanner(System.in);
            str = (in.nextLine()).trim();
        }
        u.setApellido(str);
        //GENERO
        System.out.printf("\t\t\tItroduzca el Genero del Usuario: ");
        in = new Scanner(System.in);
        str = (in.nextLine()).trim();
        while (!Validacion.ValidarGenero(str)) {
            System.out.printf("\t\t\tEl Genero puede tener Una de las Letras(V/M/O) como Respuesta.");
            System.out.printf("%n\t\t\tItroduzca El Genero de nuevo: ");
            in = new Scanner(System.in);
            str = (in.nextLine()).trim();
        }
        u.setGenero(str);
        //FECHA NACIONAMIENTO
        System.out.printf("\t\t\tItroduzca la Fecha de Navionamiento de este Formato: YYYY-MM-DD ");
        in = new Scanner(System.in);
        str = (in.nextLine()).trim();
        while (!Validacion.esFecha(str)) {
            System.out.printf("%n\t\t\tDato Erroneo: Introduzca la Fecha de Nacionamiento de Nuevo: ");
            in = new Scanner(System.in);
            str = (in.nextLine()).trim();
        }
        java.util.Date fecha;
        fecha = sdf.parse(str);
        java.sql.Date fechaSql = new java.sql.Date(fecha.getTime());
        u.setFechaNacio(fechaSql);
        //EMAIL
        System.out.printf("\t\t\tItroduzca el Email del Usuario: ");
        in = new Scanner(System.in);
        str = (in.nextLine()).trim();
        while (!Validacion.validaEmail(str)) {
            System.out.println("\t\t\t@ y . son campos obligatorios.");
            System.out.printf("%n\t\t\tItroduzca el Email de nuevo: ");
            in = new Scanner(System.in);
            str = (in.nextLine()).trim();
        }
        u.setEmail(str);
        //TELEFONO
        System.out.printf("\t\t\tIntroduzca el numero de Telefono del Usuario: ");
        in = new Scanner(System.in);
        str = (in.nextLine()).trim();
        while (!Validacion.esString(str)) {
            System.out.printf("%n\t\t\tIntroduzca el Numero de Telefono de nuevo: ");
            in = new Scanner(System.in);
            str = (in.nextLine()).trim();
        }
        u.setTelefono(str);
        //NUMERO TARJETA
        System.out.printf("\t\t\tIntroduzca el Numero de Tarjeta del Usuario: ");
        in = new Scanner(System.in);
        str = (in.nextLine()).trim();
        while (!Validacion.validarNumeroTarjeta(str)) {
            System.out.printf("\t\t\tEl Numero de Tarjeta debe tener 16 Digitos.");
            System.out.printf("%n\t\t\t\tIntroduzca el Numero de Tarjeta de nuevo: ");
            in = new Scanner(System.in);
            str = (in.nextLine()).trim();
        }
        u.setNumeroTarjeta(str);
        //CIUDAD_ID
        System.out.printf("\t\t\tIntroduzca el ID de la Ciudad: ");
        in = new Scanner(System.in);
        str = (in.nextLine()).trim();
        while (!Validacion.esEntero(str)) {
            System.out.printf("\t\t\tDato Erroneo: Introduzca el ID de la Ciudad de Nuevo: ");
            in = new Scanner(System.in);
            str = (in.nextLine()).trim();
        }
        ciudadId = Integer.parseInt(str);
        c.setCiudadId(ciudadId);
        u.setCiudad(c);
        return u;
    }

//METODO QUE ACTUALIZA UN USUARIO
    private static void ActualizarUsuario() throws Exception {
        try {
            Art4UCAD cad = new Art4UCAD();
            Scanner in = new Scanner(System.in);
            int registrosAfectados = 0;
            int usuarioId;
            System.out.printf("\t\t\tDame el ID del Usuario a Modificar:");
            usuarioId = in.nextInt();
            Usuario u = pedirDatosUsuario();
            u.setUsuarioId(usuarioId);
            boolean encontrado = encontrarUsuario(usuarioId);
            if (encontrado == true) {
                registrosAfectados = cad.actualizarUsuario(usuarioId, u);
                System.out.printf("\t\t\tUSUARIO MODIFICADO CON EXITO!!%n");
            } else {
                System.out.printf("\t\t\tEl ID del Usuario introducido no existe!!\n");
            }
        } catch (ExcepcionArt4UBD ex) {
            PropertyConfigurator.configure("logs\\log4j.properties");
            Logger loggerERROR = LogManager.getLogger("ERROR");
            loggerERROR.trace("Esto es un trace");
            loggerERROR.error(ex.getSentanciaSQL() + " \n " + ex.getCodigoError() + " - " + ex.getMensajeErrorAdministrador());
            System.out.println(ex);
        }

    }

    /**
     * MOSTRAR UN USUARIO
     */
    public static void mostrarUsuario() {
        try {
            String cadena;
            Integer usuarioID;
            Scanner teclado = new Scanner(System.in);
            Art4UCAD cad = new Art4UCAD();
            Usuario u = new Usuario();
            Ciudad c = new Ciudad();
            //CIUDAD_ID
            System.out.println("Introduzca el ID del Usuario: ");
            cadena = teclado.nextLine();
            while (!esEntero(cadena)) {
                System.out.println("El ID del Usuario no es Un numero valido,Intenta de nuevo: ");
                cadena = teclado.nextLine();
            }
            usuarioID = Integer.parseInt(cadena);
            u = cad.leerUsuario(usuarioID);
            if (u.getNombre() == null) {
                System.out.printf("\t\t\tNO ENCONTRADO\n");
            } else {
                System.out.printf("\t\t\t -------------------------------------------------------------------------------------- USUARIO ENCONTRADA ------------------------------------------------------------------------------------\n");
                System.out.println("\t\t\t\tID    NOMBRE              APELLIDO           GENERO                FECHA DE NACIONAMIENTO    EMAIL             TELEFONO               NUMERO DE TARJETA      CIUDAD_ID       \tCIUDAD_NOMBRE");
                System.out.printf("\t\t\t\t%-6s%-20s%-20s%-22s%-20s%-23s%-24s%-23s%-18s%-11s", u.getUsuarioId(), u.getNombre(), u.getApellido(), u.getGenero(), u.getFechaNacio(), u.getEmail(), u.getTelefono(), u.getNumeroTarjeta(), u.getCiudad().getCiudadId(), u.getCiudad().getNombre());
                System.out.println("");
                System.out.printf("\t\t\t -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("");
                System.out.println("CIUDADid: " + u.getCiudad().getCiudadId());
            }
        } catch (ExcepcionArt4UBD ex) {
            PropertyConfigurator.configure("logs\\log4j.properties");
            Logger loggerERROR = LogManager.getLogger("ERROR");
            loggerERROR.trace("Esto es un trace");
            loggerERROR.error(ex.getSentanciaSQL() + " \n " + ex.getCodigoError() + " - " + ex.getMensajeErrorAdministrador());
            System.out.println(ex);
        }

    }

    //Método que elimina un usuario 
    private static void EliminarUsuario() throws ClassNotFoundException {
        try {
            Art4UCAD cad = new Art4UCAD();
            Usuario usuario = new Usuario();
            Scanner in = new Scanner(System.in);
            int registrosAfectados = 0;
            Integer usuarioID;
            System.out.printf("\t\t\tIntroduzca el ID del Usuario a Eliminar: ");
            usuarioID = in.nextInt();
            if (usuarioID < 0) {
                System.out.println("El ID del Usuario no puede ser < 0.");
            } else {
                System.out.print("Seguro que desea eliminar el USUARIO de id=" + usuarioID + " ? (S/N)");
                in.nextLine();
                char resp = in.next().toLowerCase().charAt(0);
                if (resp == 'n' || resp == 'N') {
                    System.out.printf("\t\t\tOperacion Cancelada\n");
                } else {
                    registrosAfectados = cad.eliminarUsuario(usuarioID);
                    System.out.printf("\t\t\tUSUARIO BORRADO CON EXITO!!\n");
                }
            }
        } catch (ExcepcionArt4UBD ex) {
            PropertyConfigurator.configure("logs\\log4j.properties");
            Logger loggerERROR = LogManager.getLogger("ERROR");
            loggerERROR.error(ex.getSentanciaSQL() + " \n " + ex.getCodigoError() + " - " + ex.getMensajeErrorAdministrador());
            System.out.println(ex);
        }
    }

//Método que muestra todos los Usarios
    private static void MostrarUsuarios() {
        try {
            Art4UCAD cad = new Art4UCAD();
            ArrayList<Usuario> listaUsuarios = cad.leerUsuarios();
            System.out.println("\t\t\t\tID    NOMBRE              APELLIDO           GENERO                FECHA DE NACIONAMIENTO    EMAIL             TELEFONO               NUMERO DE TARJETA      CIUDAD_ID       \tCIUDAD_NOMBRE");
            Iterator<Usuario> itrUsuarios = listaUsuarios.iterator();
            while (itrUsuarios.hasNext()) {
                Usuario u = itrUsuarios.next();
                if (u.getUsuarioId() >= 0) {
                    System.out.printf("\t\t\t\t%-6s%-20s%-20s%-22s%-20s%-23s%-24s%-23s%-18s%-11s", u.getUsuarioId(), u.getNombre(), u.getApellido(), u.getGenero(), u.getFechaNacio(), u.getEmail(), u.getTelefono(), u.getNumeroTarjeta(), u.getCiudad().getCiudadId(), u.getCiudad().getNombre());
                }
                System.out.println("");
            }
        } catch (ExcepcionArt4UBD ex) {
            PropertyConfigurator.configure("logs\\log4j.properties");
            Logger loggerERROR = LogManager.getLogger("ERROR");
            loggerERROR.error(ex.getSentanciaSQL() + " \n " + ex.getCodigoError() + " - " + ex.getMensajeErrorAdministrador());
            System.out.println(ex);
        }
    }
}
