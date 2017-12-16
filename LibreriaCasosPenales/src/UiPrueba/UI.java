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
        out.println("2. listar  clientes.");
        out.println("3. Registrar Cuenta.");
        out.println("4. Listar Cuentas.");
        out.println("5. Realizar Movimiento Bancario.");
        out.println("6. Listar Movimiento Bancarios.");
        out.println("7. Salir.");
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
                listarQuere(); 
            break;
            
            case 4:
               listarSecre();
            break;
            
            case 5:
               // realizarMovimiento();
            break;
            
            case 6:
               // listarMovimientosBancarios();
            break;
            
            case 7:
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

            miQuere.registrarQuerellante(cedula, direccion, nombre, apellido, telefono);
            out.println("Se registró correctamente");
            out.println();
            
        }catch (Exception e){
            out.println(e.getMessage());
        }
    }

 /**
 * Método encargado de registrar clientes
 * @see Asociación con el GestorCliente
 */  
/*    
    public static void registrarCliente() throws IOException, Exception
    {
        String identificacion;
        String nombre_completo;
        String usuario;
        String clave;
        out.println("Ingrese el numero de identificacion de el cliente:");
        identificacion = in.readLine();
        out.println("Ingrese el nombre completo del cliente:");
        nombre_completo = in.readLine();
        out.println("Ingrese un numbre de usuario para el cliente:");
        usuario = in.readLine();
        out.println("Ingrese la clave:");
        clave = in.readLine();
        out.println();
        miCliente.registrarCliente(identificacion, nombre_completo, clave, usuario);
    }   
*/ 
 /**
 * Método encargado de registrar un nueva Cuenta
 * @see Asociación con el GestorCliente
 */   
/*    
    public static void registrarCuenta() throws IOException{
        
        Cliente duennoCuenta;
        Moneda tipoMon;
        String numeroCuenta, cedula;
        double saldo;
        String opcMoneda;
        ArrayList<Moneda> monedas = new ArrayList<>();
        
        try{
            listarClientes();
            out.println("Ingrese la cédula del dueño de la cuenta");
            cedula = in.readLine();
            duennoCuenta = miCliente.buscarObjCliente(cedula);
            out.println();
            listarMonedas();
            // out.println(monedas);
            out.println("Digite el nombre de la moneda");
            opcMoneda = in.readLine();
            tipoMon = miMoneda.getMonedaPorId(opcMoneda);
            out.println();
            out.println("Ingrese el número de cuenta");
            numeroCuenta = in.readLine();
            out.println();
            out.println("Ingrese el inicial saldo");
            saldo = Double.parseDouble(in.readLine());
            out.println();
            
            miCuenta.registrarCuenta(numeroCuenta, duennoCuenta, saldo, tipoMon);
            
        }catch (Exception e){
            out.println(e.getMessage());
        }
        
    }
*/    
/* 
public static void realizarMovimiento() throws IOException{
        
        int tipo;
        double monto;
        LocalDate fecha;
        String nombreMoneda, numCuenta, cod;
        Moneda moneda;
        Cuenta cuentaAsignada;
        
        try{
            out.println("Seleccione el tipo de moviento que desea realizar");
            out.println("1 - Depósito");
            out.println("2 - Transferencia");
            out.println("3 - Transferencia a terceros");
            out.println();
            tipo = Integer.parseInt(in.readLine());
            listarMonedas();
            out.println("Seleccione el tipo de moneda para el deposito");
            out.println();
            nombreMoneda = in.readLine();
            moneda = miMoneda.getMonedaPorId(nombreMoneda);
            out.println();
            listarCuentasPersonales();
            out.println("Digite el numero de cuenta");
            numCuenta = in.readLine();
            cuentaAsignada = miCuenta.getCuentaPorId(numCuenta);
            out.println("Ingrese el monto");
            monto = Double.parseDouble(in.readLine());
            cod = "" + CodigoDelMovimiento++;
            fecha = LocalDate.now();

            miMovimiento.registrarMovimiento(tipo, monto, fecha, cod, moneda, cuentaAsignada);
            out.println("Se registró correctamente");
            out.println();
            
        }catch (Exception e){
            out.println(e.getMessage());
        } 
    }    
*/ 
 /**
 * Método encargado de listar los clientes
     * @throws java.lang.Exception
 * @see Asociación con el GestorCliente
 */
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
    
    public static void listarQuere() throws Exception
    {
        
        Querellante quere;
        String cedula;
        out.println("Ingrese la cédula.");
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