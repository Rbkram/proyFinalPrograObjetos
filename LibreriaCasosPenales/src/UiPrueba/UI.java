/*
 * TITULO DEL PROYECTO: Aplicación bancaria
 * VERSIÓN: 3/12/2017
 * CÓMO INICIAR EL PROYECTO: Ejercutar la clase main de la clase UI
 * AUTOR: Olman Santamaría Acosta
 * INTRUCCIONES PARA EL USUARIO: Siga las los patrones establecidos para agregar funciones
 * Aplicación desarrolada con SQLServer como alamacenamiento de datos
 */
package UiPrueba;

/**
 *
 * @author Olman Santamaria Acosta
 */

/**
 * @param Paquetes importados para el funcionamiento de la aplicación
 * 
 */
import Objetos.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import Gestores.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class UI {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static int CodigoDelMovimiento = 0;
    static Gestor_Juez miJuez = new Gestor_Juez();
    static Gestor_Querellante miQuere = new Gestor_Querellante();
    static Gestor_Secretario miSecre = new Gestor_Secretario();
    static Gestor_Caso miCaso = new Gestor_Caso();

/**
 * @param args clase principal para inciar el código
 */
    public static void main(String[] args) {
        int opcion;
        boolean finalizar = false;
        
        do{
            try{
               mostarMenu();
               opcion = leerOpcion();
               finalizar = ejecutarOpcion(opcion); 
            } catch (Exception e) {
                out.println("Error UI: " + e.getMessage());
                out.println("Causa: " + e.getCause());
            } 
            
        }while(finalizar != true);
    }
    
/**
 * Método que muestra el menú principal de acciones para la aplicación al aplicacion.
 */
    public static void mostarMenu() {
        
        out.println("Seleccione una opción de la siguiente lista:");
        out.println("1. listar Jueces.");
        out.println("2. registrar querellante.");
        out.println("3. Buscar querellante.");
        out.println("4. Ver Secretario.");
        out.println("5. Registrar Caso.");
        out.println("6. Modificar Estado caso.");
        out.println("7. Listar Casos de Querellante.");        
        out.println("8. Salir.");
    }
 /**
 * Método encargado de procesar la opción elegida
 * @return opcion opción elegida por el usuario
 */   
    public static int leerOpcion() throws IOException {
        int opcion;
        
        out.println("Ingrese la opción que desea realizar: ");
        opcion = Integer.parseInt(in.readLine());
        out.println();
        
        return opcion;
    }
 /**
 * Método encargado de ejecutar las funciones para la interacción con el usuario y el almacenamiento
 * @param pOpcion resultado de la función de leerOpción, número de ipción ingresada por el usuario
 */     
    public static boolean ejecutarOpcion(int pOpcion) throws IOException, ClassNotFoundException, SQLException, Exception {
        boolean salir = false;
        
        switch(pOpcion) {
            
            case 1:
                listarJueces();
            break;
            
            case 2:
                regQuerellante();
            break;
            
            case 3:
                buscarQuerellante(); 
            break;
            
            case 4:
               listarSecre();
            break;
            
            case 5:
               registrarCaso();
            break;
            
            case 6:
               modificarEstadoCaso();
            break;

            case 7:
               listarCasosQuerellante();
            break;
            
            case 8:
                out.println("Gracias por usar nuestro sistema");
                salir = true;
            break;
            default:
                out.println("Ingrese una opción correcta");
            break;
            
        }
        return salir;    
    }
    
    
    public static void regQuerellante() throws IOException{
        
        String direccion,nombre, apellido, telefono, cedula;
        boolean registrado = false;
        
        try{
            out.println("Ingrese la cédula.");
            cedula = in.readLine();
            out.println();
            out.println("Ingrese el nombre.");
            nombre = in.readLine();
            out.println();
            out.println("Ingrese el apellido.");
            apellido = in.readLine();
            out.println();
            out.println("Ingrese telefono.");
            telefono = in.readLine();
            out.println();
            out.println("Ingrese direccion.");
            direccion = in.readLine();
            out.println();

            registrado = miQuere.registrarQuerellante(direccion, nombre, apellido, telefono, cedula);
            if (registrado) {
               out.println("Se registró correctamente");  
            } else {
               out.println("Ocurrió un error en el registro");
            }
        }catch (Exception e){
            out.println(e.getMessage());
        }
    }
    

    public static void registrarCaso() throws IOException{
        
        String numeroCaso, descripcion, idQuerellante;
        Querellante quere;
        boolean registrado = false;
        
        try{
            out.println("Ingrese el numero del caso.");
            numeroCaso = in.readLine();
            out.println();
            out.println("Ingrese la descripcion del caso.");
            descripcion = in.readLine();
            out.println();
            
            out.println("Ingrese la cédula del querellante por asignar.");
            idQuerellante = in.readLine();
            out.println();
            quere = miQuere.buscarObjQuerellante(idQuerellante);

            registrado = miCaso.ingresarCaso(numeroCaso, descripcion, quere.getCedula());
            if (registrado) {
               out.println("Se registró correctamente");  
            } else {
               out.println("Ocurrió un error en el registro");
            }
        }catch (Exception e){
            out.println(e.getMessage());
        }
    } 
    
    public static void modificarEstadoCaso() throws IOException{
        
        String idCaso, nuevoEstado, idJuez;
        
        try{
            
            out.println("Ingrese su cedula.");
            idJuez = in.readLine();
            listarCasosJuez(idJuez);
            out.println("Ingrese el numero de caso a modificar.");
            idCaso = in.readLine();
            out.println("Ingrese el nuevo estado.");
            nuevoEstado = in.readLine();
            
            miCaso.modificarEstado(idCaso, nuevoEstado);
            out.println("Modificación realizada");  

        }catch (Exception e){
            out.println(e.getMessage());
        }
    }  
    
    public static void listarJueces() throws Exception
    {
        ArrayList<Juez> listaJueces;
        listaJueces = miJuez.listarJueces();
        
        out.println("Jueces registrados");
        out.println("Identificacion" + " " + " " + "Nombre" + "\n");
        for(int i = 0; i < listaJueces.size(); i++){
            out.println(listaJueces.get(i).getCedula() + " "  + " "+ listaJueces.get(i).getNombre() + "\n");
        }
    }    

    public static void listarCasosJuez(String idJuez) throws Exception
    {
        ArrayList<Caso> listaCasos;
        listaCasos = miCaso.listarCasosJuez(idJuez);
        Querellante quere;
        
        out.println("Casos del juez");
        out.println("Numero Caso" + " " + " " + "Querellante" + "\n");
        for(int i = 0; i < listaCasos.size(); i++){
            quere = miQuere.buscarObjQuerellante(listaCasos.get(i).getQuerellante_aCargo_Id());
            out.println(listaCasos.get(i).getNumeroCaso() + " "  + " "+ quere.getNombre() + "\n");
        }
    } 

    public static void listarCasosQuerellante() throws Exception
    {
        String cedulaQuerellante;
        ArrayList<Caso> listaCasos;
        out.println("Ingrese la cedula del querellante.");
        cedulaQuerellante = in.readLine();
        out.println();
        listaCasos = miCaso.listarCasosQuerellante(cedulaQuerellante);
        
        out.println("Casos del querellante");
        out.println("Numero Caso" + " " + " " + "Estado" + "\n");
        for(int i = 0; i < listaCasos.size(); i++){
            out.println(listaCasos.get(i).getNumeroCaso() + " "  + " "+ listaCasos.get(i).getEstado()  + "\n");
        }
    } 
    
    public static void buscarQuerellante() throws Exception
    {
        
        Querellante quere;
        String cedula;
        out.println("Ingrese la cédula del querellante.");
        cedula = in.readLine();
        out.println();
        quere = miQuere.buscarObjQuerellante(cedula);
        
        out.println("Querellante:");
        out.println("Identificacion" + " " + " " + "Nombre" + "\n");
        out.println(quere.getCedula() + " "  + " "+ quere.getNombre() + "\n");
        
    }
    
    public static void listarSecre() throws Exception
    {
        ArrayList<Secretario> listaSecre;
        listaSecre = miSecre.listarSecretarios();
        
        out.println("Secretario registrados");
        out.println("Identificacion" + " " + " " + "Nombre" + "\n");
        for(int i = 0; i < listaSecre.size(); i++){
            out.println(listaSecre.get(i).getCedula() + " "  + " "+ listaSecre.get(i).getNombre() + "\n");
        }
    }

 /**
 * Método encargado de listar los monedas provenientes de la base de datos
 * @see Asociación con el GestorMonedas
 */   
/*    
    public static void listarMonedas() throws Exception
    {
        ArrayList<Moneda> listaMoneda;
        listaMoneda = miMoneda.getListaMonedas();
        
        out.println("Lista de monedas registradas");
        out.println("Moneda" + " " + " " + "Cambio" + "\n");
        for(int i = 0; i < listaMoneda.size(); i++){
            out.println(listaMoneda.get(i).getNombreMoneda() + " "  + " "+ listaMoneda.get(i).getTipoCambio() + "\n");
        }
    } 
 */   
 /**
 * Método encargado de listar las cuentas registradas
 * @see Asociación con el GestorCuentas
 */ 
/*    
    public static void listarCuentasPersonales() throws IOException, Exception{
        
        ArrayList<Cuenta> listaCuentas;
        listaCuentas = miCuenta.listarCuentas();
        
        out.println("Lista de cuentas registradas");
        for(int i = 0; i < listaCuentas.size(); i++){
            out.println("-Numero de Cuenta: "  + listaCuentas.get(i).getNumeroCuenta() + " "  + "-Cliente: "+ listaCuentas.get(i).getClienteString()+ " "  + "-Moneda: "+ listaCuentas.get(i).getMonedaString() + " "  + "-Saldo: "+ listaCuentas.get(i).getSaldo() + "\n");
        }
    }
*/    
 /**
 * Método encargado de listar los movimientos registrados
 * @see Asociación con el GestorCuentas
 */  
/*    
    public static void listarMovimientosBancarios() throws IOException, Exception{
        
        ArrayList<Movimientos> listaMoviminetos;
        listaMoviminetos = miMovimiento.listarMovimiento();
        
        out.println("Lista de movimientos bancarios");
        for(int i = 0; i < listaMoviminetos.size(); i++){
            out.println("-Tipo de movimiento: "  + listaMoviminetos.get(i).getTipoMovimiento()+ " "  + "-Codigo: "+ listaMoviminetos.get(i).getCodigoMovimiento()+ " "  + "-Cuenta: "+ listaMoviminetos.get(i).getCuentaAsociadaString() + " "  + "-Moneda: "+ listaMoviminetos.get(i).getTipoMonedaString()+ " " + "-Monto: "+ listaMoviminetos.get(i).getMontoMovimiento() + "\n");
        }
*/
    }  