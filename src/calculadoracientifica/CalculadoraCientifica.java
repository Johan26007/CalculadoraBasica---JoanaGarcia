package calculadoracientifica;

import java.util.Scanner;

public class CalculadoraCientifica {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Operacion operacion = null;
        int opcion = 0;

        while (opcion != 10) {
            System.out.println("**** CALCULADORA CIENTIFICA ****");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Potencia");
            System.out.println("6. Raiz");
            System.out.println("7. Seno");
            System.out.println("8. Coseno");
            System.out.println("9. Tangente");
            System.out.println("10. Factorizacion");
            System.out.println("11. Salir");
            System.out.println("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 ->
                    operacion = new Suma();
                case 2 ->
                    operacion = new Resta();
                case 3 ->
                    operacion = new Multiplicacion();
                case 4 ->
                    operacion = new Division();
                case 5 ->
                    operacion = new Potencia();
                case 6 ->
                    operacion = new Raiz();
                case 7 ->
                    operacion = new Seno();
                case 8 ->
                    operacion = new Coseno();
                case 9 ->
                    operacion = new Tangente();
                case 10 -> {
                    operacion = null;
                    menuFactorizacion(scanner);
                }
                case 11 ->
                    System.out.println("Saliendo del programa...");
                default -> {
                    System.out.println("Opcion invalida...");
                    continue;
                }
            }
            if ((opcion >= 1) && (opcion <= 11)) {
                operacion.ingresar();
                operacion.operar();
                operacion.imprimir();
            }

        }
    }

    //Menu para la factorizacion
    private static void menuFactorizacion(Scanner scanner) {
        Factorizacion factorizacion = null;
        int subOpcion = 0;

        while (subOpcion != 11) {
            System.out.println("**** MENU DE FACTORIZACION ****");
            System.out.println("1. Factor Comun (Monomio)");
            System.out.println("2. Factor Comun por Agrupacion");
            System.out.println("3. Trinomio Cuadrado Perfecto");
            System.out.println("4. Diferencia de Cuadrados Perfectos");
            System.out.println("5. Trinomio Cuadrado Perfecto por Adicion y Sustraccion");
            System.out.println("6. Trinomio de la forma x^2 + bx + c");
            System.out.println("7. Trinomio de la forma ax^2 + bx + c");
            System.out.println("8. Cubo Perfecto de Binomios");
            System.out.println("9. Suma o Diferencia de Cubos Perfectos");
            System.out.println("10. Suma o Diferencia de dos Potencias Iguales");
            System.out.println("11. Regresar al menu principal");
            System.out.println("Seleccione una opcion: ");
            subOpcion = scanner.nextInt();
            scanner.nextLine();

            switch (subOpcion) {
                case 1 -> {
                    factorizacion = new FactorComun();
                }
                case 2 -> {
                }
                case 3 -> {
                }
                case 4 -> {
                }
                case 5 -> {
                }
                case 6 -> {
                }
                case 7 -> {
                }
                case 8 -> {
                }
                case 9 -> {
                }
                case 10 -> {
                }
                case 11 -> {
                    System.out.println("Regresando al menu principal...");
                }
                default ->
                    System.out.println("Opcion invalida...");
            }

            if (factorizacion != null) {
                factorizacion.ingresar();
                factorizacion.operar();
                factorizacion.imprimir();
            }

        }
    }
}
