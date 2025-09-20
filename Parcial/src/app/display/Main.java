package app.display;

//import packages
import app.servicios.Gestor_del_servicio;
import app.servicios.Servicio;
import app.usuarios.clientes.Cliente;
import app.usuarios.clientes.Mascota_clase;
import app.usuarios.prestadores_de_servicio.Domiciliario;
import app.vehiculos.TipoVehiculo;

// import utilities
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final Gestor_del_servicio gestor = new Gestor_del_servicio();

    public static void main(String[] args) {
        int opcion = 0;
        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Registrar un cliente");
            System.out.println("2. Registrar domiciliario");
            System.out.println("3. Asignar servicios pendientes");
            System.out.println("4. Ver servicios completados y costo total");
            System.out.println("5. Solicitar servicio de Vacunacion");
            System.out.println("6. Solicitar Otro Servicio (Transporte, Paseo, etc.)");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> registrarCliente();
                case 2 -> registrarDomiciliario();
                case 3 -> asignarServicios();
                case 4 -> verCompletados();
                case 5 -> solicitarServicioVacunacion();
                case 6 -> solicitarOtroServicio();
                case 7 -> System.out.println("Cerrando sesion");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 7);
    }

    private static void registrarCliente() {
        System.out.println("--- Registro de Nuevo Cliente ---");
        System.out.print("Nombre del cliente: ");
        String nombre = sc.nextLine();
        System.out.print("Número de teléfono: ");
        String numero = sc.nextLine();
        System.out.print("Dirección: ");
        String direccion = sc.nextLine();

        System.out.println("--- Datos de la Mascota ---");
        System.out.print("Nombre de la mascota: ");
        String nombreMascota = sc.nextLine();
        System.out.print("Raza de la mascota: ");
        String razaMascota = sc.nextLine();

        Mascota_clase mascota = new Mascota_clase(nombreMascota, razaMascota);
        Cliente nuevoCliente = gestor.registrarCliente(nombre, numero, direccion, mascota);
        System.out.println("Cliente '" + nuevoCliente.getNombre() + "' registrado con ID: " + nuevoCliente.getId());
    }

    private static void registrarDomiciliario() {
        System.out.println("--- Registro de Nuevo Domiciliario ---");
        System.out.print("Nombre del domiciliario: ");
        String nombre = sc.nextLine();
        System.out.print("Número de teléfono: ");
        String numero = sc.nextLine();
        System.out.println("Tipo de Vehículo (1=BICICLETA, 2=MOTO): ");
        System.out.print("> ");
        int tipoVehiculoInt = Integer.parseInt(sc.nextLine());

        TipoVehiculo vehiculo = (tipoVehiculoInt == 2) ? TipoVehiculo.MOTO : TipoVehiculo.BICICLETA;

        Domiciliario nuevoDomiciliario = gestor.registrarDomiciliario(nombre, numero, vehiculo);
        System.out.println("Domiciliario '" + nuevoDomiciliario.getNombre() + "' registrado con ID: " + nuevoDomiciliario.getId());
    }

    private static void asignarServicios() {
        System.out.println("--- Buscando y asignando servicios pendientes... ---");
        int asignados = gestor.asignarServiciosPendientes();
        if (asignados == 0) {
            System.out.println("No se encontraron servicios pendientes para asignar.");
        }
    }

    private static void verCompletados() {
        System.out.println("\n--- Reporte de Servicios Completados ---");
        List<Servicio> serviciosCompletados = gestor.getServiciosCompletados();
        if (serviciosCompletados.isEmpty()) {
            System.out.println("Aún no hay servicios completados.");
        } else {
            for (Servicio servicio : serviciosCompletados) {
                String nombreDomiciliario = (servicio.getDomiciliario() != null) ? servicio.getDomiciliario().getNombre() : "N/A";
                System.out.printf("ID: %d | Cliente: %s | Domiciliario: %s | Costo: $%.2f%n",
                        servicio.getId(), servicio.getCliente().getNombre(), nombreDomiciliario, servicio.calcularCosto());
            }
        }
        System.out.printf("----------------------------------------%n");
        System.out.printf(" Costo Total Acumulado: $%.2f%n", gestor.getCostoTotalServiciosCompletados());
    }

    private static void solicitarServicioVacunacion() {
        if (gestor.getClientes().isEmpty()) {
            System.out.println("Primero debe registrar al menos un cliente.");
            return;
        }
        System.out.println("--- Solicitar Servicio de Vacunación ---");
        System.out.println("Clientes disponibles:");
        gestor.getClientes().forEach(cliente -> System.out.println("ID: " + cliente.getId() + " | Nombre: " + cliente.getNombre()));
        System.out.print("ID del cliente que solicita el servicio: ");
        int idCliente = Integer.parseInt(sc.nextLine());

        System.out.print("Dirección de Origen: ");
        String origen = sc.nextLine();
        System.out.print("Dirección de Destino: ");
        String destino = sc.nextLine();

        System.out.print("Distancia en KM para la visita: ");
        int distancia = Integer.parseInt(sc.nextLine());

        Servicio nuevoServicio = gestor.crearServicioVacunacion(idCliente, origen, destino, distancia);
        if (nuevoServicio != null) {
            System.out.println("Servicio de vacunación creado con ID: " + nuevoServicio.getId() + ". Costo total: $" + nuevoServicio.calcularCosto());
            System.out.println("El servicio está pendiente de asignación. Use la opción 3 del menú.");
        } else {
            System.out.println("Error al crear el servicio. Verifique el ID del cliente.");
        }
    }

    private static void solicitarOtroServicio() {
        if (gestor.getClientes().isEmpty()) {
            System.out.println("Primero debe registrar al menos un cliente.");
            return;
        }
        System.out.println("--- Solicitar Otro Servicio ---");
        System.out.println("Clientes disponibles:");
        gestor.getClientes().forEach(cliente -> System.out.println("ID: " + cliente.getId() + " | Nombre: " + cliente.getNombre()));
        System.out.print("ID del cliente que solicita el servicio: ");
        int idCliente = Integer.parseInt(sc.nextLine());

        System.out.print("Dirección de Origen: ");
        String origen = sc.nextLine();
        System.out.print("Dirección de Destino: ");
        String destino = sc.nextLine();

        System.out.println("--- Tipo de Servicio ---");
        System.out.println("1. Transporte de Mascota");
        System.out.println("2. Paseo Ecológico");
        System.out.println("3. Entrega de Comida/Juguetes");
        System.out.print("Seleccione el tipo de servicio: ");
        int tipo = Integer.parseInt(sc.nextLine());

        double valorVariable = 0;
        switch (tipo) {
            case 1 -> { System.out.print("Distancia en KM: "); valorVariable = Double.parseDouble(sc.nextLine()); }
            case 2 -> { System.out.print("Cantidad de horas: "); valorVariable = Double.parseDouble(sc.nextLine()); }
            case 3 -> { System.out.print("Valor del producto: "); valorVariable = Double.parseDouble(sc.nextLine()); }
            default -> { System.out.println("Tipo de servicio no válido."); return; }
        }

        Servicio nuevoServicio = gestor.crearOtroServicio(tipo, idCliente, origen, destino, valorVariable);
        if (nuevoServicio != null) {
            System.out.println("Servicio creado con ID: " + nuevoServicio.getId() + ". Costo total: $" + nuevoServicio.calcularCosto());
            System.out.println("El servicio está pendiente de asignación. Use la opción 3 del menú.");
        } else {
            System.out.println("Error al crear el servicio. Verifique el ID del cliente.");
        }
    }
}