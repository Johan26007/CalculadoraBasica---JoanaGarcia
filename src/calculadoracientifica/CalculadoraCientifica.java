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
            System.out.println("10. Trinomio cuadrado perfecto:");
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
                case 10 ->
                    operacion = new TrinomioCuadradoPerfecto();
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
    }

