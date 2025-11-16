import java.util.Scanner;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        //Establecer variables

        var scanner = new Scanner(System.in);
        int opcion, opcion2, habitacion_doble = 8, habitacion_individual = 2, billete500 = 0,
                billete200 = 0, billete100 = 0, billete50 = 0, billete20 = 0, billete10 = 0, factura = 1,
                billete5 = 0, moneda2 = 0, moneda1 = 0, moneda05 = 0, moneda02 = 0, moneda01 = 0,
                moneda005 = 0, moneda002 = 0, moneda001 = 0, reservas_finali = 0, dinero, opcion3 = 0, opcion4,
                sumaNoches = 0, folio = 1, opcionReserva, billete500res = 100000, billete200res = 200000, billete100res = 300000,
                billete50res = 300000, billete20res = 200000, billete10res = 200000, billete5res = 300000,
                moneda2res = 500000, moneda1res = 500000, moneda05res = 500000, moneda02res = 50000,
                moneda01res = 500000, moneda005res = 500000, moneda002res = 500000, moneda001res = 500000, reserva = 0, noche = 0, nocheDinero = 0;

        String nombre_completo = "", usuarioAdmin = "admin", contraseniaAdmin = "1234", contraseniaIngresada = "",
                usuarioIngresado = "", respuestaUsu = "";

        float dineroIntro, precioProducto, cambio = 0, iva, precioMasIva = 0, precioTot = 0;

        boolean deseaReser;

        LocalDate fechaActual = LocalDate.now();

        System.out.println("""
                ██╗  ██╗ ██████╗ ████████╗███████╗██╗          ██████╗██╗██╗   ██╗██████╗  █████╗ ██████╗     ██████╗ ███████╗    ███╗   ███╗ █████╗ ██████╗ ████████╗ ██████╗ ███████╗
                ██║  ██║██╔═══██╗╚══██╔══╝██╔════╝██║         ██╔════╝██║██║   ██║██╔══██╗██╔══██╗██╔══██╗    ██╔══██╗██╔════╝    ████╗ ████║██╔══██╗██╔══██╗╚══██╔══╝██╔═══██╗██╔════╝
                ███████║██║   ██║   ██║   █████╗  ██║         ██║     ██║██║   ██║██║  ██║███████║██║  ██║    ██║  ██║█████╗      ██╔████╔██║███████║██████╔╝   ██║   ██║   ██║███████╗
                ██╔══██║██║   ██║   ██║   ██╔══╝  ██║         ██║     ██║██║   ██║██║  ██║██╔══██║██║  ██║    ██║  ██║██╔══╝      ██║╚██╔╝██║██╔══██║██╔══██╗   ██║   ██║   ██║╚════██║
                ██║  ██║╚██████╔╝   ██║   ███████╗███████╗    ╚██████╗██║╚██████╔╝██████╔╝██║  ██║██████╔╝    ██████╔╝███████╗    ██║ ╚═╝ ██║██║  ██║██║  ██║   ██║   ╚██████╔╝███████║
                ╚═╝  ╚═╝ ╚═════╝    ╚═╝   ╚══════╝╚══════╝     ╚═════╝╚═╝ ╚═════╝ ╚═════╝ ╚═╝  ╚═╝╚═════╝     ╚═════╝ ╚══════╝    ╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝    ╚═════╝ ╚══════╝
                                                                                                                                                                                      \s\n""");


        //Menu principal
        do {
            System.out.print("""
                    Menú
                    ===============================
                    1º- Ver estado de habitaciones
                    2º- Hacer una reserva
                    3º- Checkout de habitaciones
                    4º- Administración
                    
                    Seleccione una opción: """);


            //Elegir opción
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                //Registro de habitaciones ocupadas o libres
                case 1:
                    System.out.printf("""
                            \n|    Habitaciones dobles libres    |    Habitaciones individuales libres   |
                             ================================== =======================================
                            |   Hay %d habitaciones libres      |      Hay %d habitaciones libres        |
                             --------------------------------------------------------------------------\n""", habitacion_doble, habitacion_individual);
                    System.out.println("Pulsa una tecla para continuar");
                    scanner.nextLine();
                    break;

                //Reserva de habitaciones
                case 2:
                    System.out.println("RESERVA DE HABITACIONES");
                    System.out.println("""                   
                            Que tipo de habitacion te gustaría reservar
                            =============================================
                            1º- Habitación doble
                            2º- Habitación individual
                            ---------------------------------------------""");

                    opcion2 = Integer.parseInt(scanner.nextLine());
                    switch (opcion2) {
                        //Habitación doble
                        case 1:
                            System.out.println("""
                                    Habitación para dos personas.
                                    Precio: 60€ por noche
                                    """);

                            //Esto es para que no sea brusca la llegada de otro menu
                            System.out.println("Pulse una tecla para continuar...");
                            scanner.nextLine();
                            System.out.println("""
                                        ¿Desea reservar?
                                    ==================================
                                    1.- Sí
                                    2.- No""");

                            opcionReserva = Integer.parseInt(scanner.nextLine());

                            //Check para saber si quedan habitaciones
                            if (habitacion_individual == 0) {
                                System.out.println("No quedan más habitaciones individuales");
                                Thread.sleep(1000);
                            } else {
                                switch (opcionReserva) {
                                    case 1:
                                        //Requisitos para completar la factura
                                        System.out.println("Introduzca nombre y apellidos");
                                        nombre_completo = scanner.nextLine();
                                        System.out.println("Introduce las noches que te vas a quedar");
                                        noche = Integer.parseInt(scanner.nextLine());
                                        nocheDinero = 60;
                                        sumaNoches = noche * nocheDinero;
                                        habitacion_doble--;

                                        System.out.println("La reserva se ha realizado con exito.");
                                        Thread.sleep(1000);
                                        break;

                                    case 2:
                                        //Esto es para que no sea brusca la llegada de otro menu
                                        System.out.println("Has salido del menú...");
                                        Thread.sleep(1000);
                                        break;
                                    default:
                                        System.out.println("Opción incorrecta...");
                                        Thread.sleep(1000);
                                }
                            }
                            break;

                        //Habitacion individual
                        case 2:
                            System.out.println("""
                                    Habitación para una persona.
                                    Precio: 45€ por noche
                                    """);

                            //Esto es para que no sea brusca la llegada de otro menu
                            System.out.println("Pulse una tecla para continuar...");
                            scanner.nextLine();
                            System.out.println("""
                                        ¿Desea reservar?
                                    ==================================
                                    1.- Sí
                                    2.- No""");

                            opcionReserva = Integer.parseInt(scanner.nextLine());

                            //Check para saber si quedan habitaciones
                            if (habitacion_individual == 0) {
                                System.out.println("No quedan mas habitaciones individuales");
                                Thread.sleep(1000);
                            } else {
                                switch (opcionReserva) {
                                    case 1:
                                        //Requisitos para completar la factura
                                        System.out.println("Introduzca nombre y apellidos");
                                        nombre_completo = scanner.nextLine();
                                        System.out.println("Introduce las noches que te vas a quedar");
                                        noche = Integer.parseInt(scanner.nextLine());
                                        nocheDinero = 45;
                                        sumaNoches = noche * nocheDinero;
                                        habitacion_individual--;
                                        //Esto es para que no sea brusca la llegada de otro menu
                                        System.out.println("La reserva se ha realizado con exito.");
                                        Thread.sleep(1000);
                                        break;

                                    case 2:
                                        //Esto es para que no sea brusca la llegada de otro menu
                                        System.out.println("Has salido del menú...");
                                        Thread.sleep(1000);
                                        break;

                                    default:
                                        System.out.println("Opción incorrecta...");
                                        Thread.sleep(1000);
                                }
                            }
                    }
                    break;

                //Chekout
                case 3:
                    //Esto se usa para conseguir la fecha
                    LocalDate fechaFutura = fechaActual.plusDays(noche);
                    //Aqui se saca el importe del iva
                    iva = (int) (sumaNoches * 0.21);
                    precioMasIva = iva + sumaNoches;

                    //Aqui sacamos el ticket
                    System.out.println("FACTURA/TICKET");

                    System.out.println("-------------------------------------");
                    System.out.println("Numero de folio: " + folio);
                    folio++;
                    System.out.println("fecha: " + fechaActual);
                    System.out.println("Factura: " + factura);
                    factura++;
                    System.out.println("""
                            Compañia: Hotel ciudad
                                           de
                                         Martos
                            """);
                    System.out.println("Dirección: C. Ciudad de Martos, 23600 Martos, Jaén");
                    System.out.println("CIF: N43987259");
                    System.out.println("Teléfono: 953 55 17 11");
                    System.out.println("E-mail: hotelciudadmartos@gmail.com");
                    System.out.println("--------------------------------------");

                    System.out.printf("Nombre: %s ", nombre_completo);
                    System.out.print(" |Entrada: " + fechaActual + " |Salida: " + fechaFutura);
                    System.out.printf(" |Noches: %d   |Tarifa: %.2f\n", noche, precioMasIva);

                    System.out.println("--------------------------------------");
                    System.out.printf("Total sin impuestos: %s\nImpuesto IVA del 21%% aplicado: %s\nTotal con impuestos: %s\n",
                            sumaNoches, iva, precioMasIva);

                    do {
                        //Esta parte es para sacar el menor cambio posible
                        System.out.print("Caunto dinero va a Introducir: ");
                        dineroIntro = Float.parseFloat(scanner.nextLine());
                        if (precioMasIva > dineroIntro) System.out.println("Cantidad insuficiente");
                    } while (dineroIntro < precioMasIva);
                    cambio = dineroIntro - precioMasIva;
                    System.out.println("Su cambio es de: " + cambio);
                    //Calculo de la menor cantidad
                    while (cambio >= 500) {
                        billete500++;
                        cambio -= 500;
                    }
                    while (cambio >= 200) {
                        billete200++;
                        cambio -= 200;
                    }
                    while (cambio >= 100) {
                        billete100++;
                        cambio -= 100;
                    }
                    while (cambio >= 50) {
                        billete50++;
                        cambio -= 50;
                    }
                    while (cambio >= 20) {
                        billete20++;
                        cambio -= 20;
                    }
                    while (cambio >= 10) {
                        billete10++;
                        cambio -= 10;
                    }
                    while (cambio >= 5) {
                        billete5++;
                        cambio -= 5;
                    }
                    while (cambio >= 2) {
                        moneda2++;
                        cambio -= 2;
                    }
                    while (cambio >= 1) {
                        moneda1++;
                        cambio -= 1;
                    }
                    while (cambio >= 0.5) {
                        moneda05++;
                        cambio -= 0.5;
                        cambio = (float) Math.round(cambio * 100) / 100;
                    }
                    while (cambio >= 0.2) {
                        moneda02++;
                        cambio -= 0.2;
                        cambio = (float) Math.round(cambio * 100) / 100;
                    }
                    while (cambio >= 0.1) {
                        moneda01++;
                        cambio -= 0.1;
                        cambio = (float) Math.round(cambio * 100) / 100;
                    }
                    while (cambio >= 0.05) {
                        moneda005++;
                        cambio -= 0.05;
                        cambio = (float) Math.round(cambio * 100) / 100;
                    }
                    while (cambio >= 0.02) {
                        moneda002++;
                        cambio -= 0.01;
                        cambio = (float) Math.round(cambio * 100) / 100;
                    }
                    while (cambio > 0) {
                        moneda001++;
                        cambio -= 0.01;
                        cambio = (float) Math.round(cambio * 100) / 100;
                    }
                    //Para mostrar solo las monedas y billetes que se dan en el cambio
                    if (billete500 > 0) System.out.println("Hay: " + billete500 + " billetes de 500€");
                    if (billete200 > 0) System.out.println("Hay: " + billete200 + " billetes de 200€");
                    if (billete100 > 0) System.out.println("Hay: " + billete100 + " billetes de 100€");
                    if (billete50 > 0) System.out.println("Hay: " + billete50 + " billetes de 50€");
                    if (billete20 > 0) System.out.println("Hay: " + billete20 + " billetes de 20€");
                    if (billete10 > 0) System.out.println("Hay: " + billete10 + " billetes de 10€");
                    if (billete5 > 0) System.out.println("Hay: " + billete5 + " billetes de 5€");
                    if (moneda2 > 0) System.out.println("Hay: " + moneda2 + " monedas de 2€");
                    if (moneda1 > 0) System.out.println("Hay: " + moneda1 + " monedas de 1€");
                    if (moneda05 > 0) System.out.println("Hay: " + moneda05 + " monedas de 0.5€");
                    if (moneda02 > 0) System.out.println("Hay: " + moneda02 + " monedas de 0.2€");
                    if (moneda01 > 0) System.out.println("Hay: " + moneda01 + " monedas de 0.1€");
                    if (moneda005 > 0) System.out.println("Hay: " + moneda005 + " monedas de 0.05€");
                    if (moneda002 > 0) System.out.println("Hay: " + moneda002 + " monedas de 0.02€");
                    if (moneda001 > 0) System.out.println("Hay: " + moneda001 + " monedas de 0.01€");

                    billete500res -= billete500;
                    billete200res -= billete200;
                    billete100res -= billete100;
                    billete50res -= billete50;
                    billete20res -= billete20;
                    billete10res -= billete10;
                    billete5res -= billete5;
                    moneda2res -= moneda2;
                    moneda1res -= moneda1;
                    moneda05res -= moneda05;
                    moneda02res -= moneda02;
                    moneda01res -= moneda01;
                    moneda005res -= moneda005;
                    moneda002res -= moneda002;
                    moneda001res -= moneda001;

                    reserva++;

                    //Esto es para que no sea brusca la llegada de otro menu
                    System.out.println("Pulsa una tecla para continuar...");
                    scanner.nextLine();
                    break;

                //menu de admin
                case 4:
                    System.out.println("MENU DE ADMINISTRADORES");
                    //Control de usuarios
                    do {
                        System.out.println("Introduce el usuario");
                        usuarioIngresado = scanner.nextLine();
                        System.out.println("Introduce la contraseña");
                        contraseniaIngresada = scanner.nextLine();
                        if ((!usuarioIngresado.equals(usuarioAdmin) || !contraseniaIngresada.equals(contraseniaAdmin))) {
                            System.out.println("El usuario o contraseña incorrecta");
                            System.out.println("Pulsa una tecla para continuar");
                            scanner.nextLine();
                        } else if (usuarioIngresado.equals(usuarioAdmin) && contraseniaIngresada.equals(contraseniaAdmin)) {
                            System.out.println("Usuario y contraseña correcta");
                        }
                    } while ((!usuarioIngresado.equals(usuarioAdmin) || !contraseniaIngresada.equals(contraseniaIngresada)));
                    //check
                    if (usuarioAdmin.equals(usuarioIngresado) && contraseniaAdmin.equals(contraseniaIngresada)) {
                        System.out.println("Inicio de sesión exitoso");
                        do {
                            //Cuando se complete de manera exitosa el login saldrá el menu de admin
                            System.out.println("""                            
                                    Menú admin
                                    ======================================================================
                                    1º- Consultar los ingresos totales y el número de reservas finalizadas
                                    2º- Consultar las monedas restantes para el cambio
                                    3º- Salir del menú de admin
                                    4º- Apagar el software
                                    """);
                            opcion3 = Integer.parseInt(scanner.nextLine());

                            switch (opcion3) {
                                //Consulta ingresos y reservas finalizadas
                                case 1:
                                    precioTot += precioMasIva;
                                    System.out.printf("Las ganancaias totales son de: %.2f €", precioTot);
                                    System.out.printf("Se han realizado %d reservas\n", reserva);
                                    System.out.println("Pulsa una tecla para continuar");
                                    scanner.nextLine();
                                    break;

                                //monedas restantes para pago
                                case 2:
                                    System.out.printf("Quedan %d billetes de 500€\n", billete500res);
                                    System.out.printf("Quedan %d billetes de 200€\n", billete200res);
                                    System.out.printf("Quedan %d billetes de 100€\n", billete100res);
                                    System.out.printf("Quedan %d billetes de 50€\n", billete50res);
                                    System.out.printf("Quedan %d billetes de 20€\n", billete20res);
                                    System.out.printf("Quedan %d billetes de 10€\n", billete10res);
                                    System.out.printf("Quedan %d monedas de 2€\n", moneda2res);
                                    System.out.printf("Quedan %d monedas de 1€\n", moneda1res);
                                    System.out.printf("Quedan %d monedas de 0.5€\n", moneda05res);
                                    System.out.printf("Quedan %d monedas de 0.2€\n", moneda02res);
                                    System.out.printf("Quedan %d monedas de 0.1€\n", moneda01res);
                                    System.out.printf("Quedan %d monedas de 0.05€\n", moneda005res);
                                    System.out.printf("Quedan %d monedas de 0.02€\n", moneda002res);
                                    System.out.printf("Quedan %d monedas de 0.01€\n", moneda001res);
                                    System.out.println("Pulsa una tecla para continuar");
                                    scanner.nextLine();
                                    break;
                                case 3:
                                    System.out.println("Saliendo del menú");
                                    break;
                                //apagar software
                                case 4:
                                    System.out.println("A continuacion se apagara el sistema ");
                                    Thread.sleep(1000);
                                    break;

                                default:
                                    System.out.println("Opción incorrecta");
                            }
                        } while (opcion3 != 3 && opcion3 != 4);

                    } else {
                        System.out.println("Usuario o contraseña incorrectos");
                    }

                    break;

                default:
                    System.out.println("La opción marcada es incorrecta");
            }
            //este while es del case 3 del menu de admin como condición de cierre
        } while (opcion3 != 4);
    }
}
