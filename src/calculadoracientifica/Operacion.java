package calculadoracientifica;

import java.util.Scanner;

public abstract class Operacion {

    protected double num1;
    protected double num2;
    protected double resultado;

    //Constructores
    public Operacion() {
        this.num1 = 0;
        this.num2 = 0;
        this.resultado = 0;
    }

    public Operacion(double num1, double num2, double resultado) {
        this.num1 = num1;
        this.num2 = num2;
        this.resultado = resultado;
    }

    //Getters y Setters
    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    //Metodos
    public void ingresar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el primer numero: ");
        this.num1 = scanner.nextDouble();
        System.out.println("Ingrese el segundo numero: ");
        this.num2 = scanner.nextDouble();
    }

    public abstract void operar();

    public void imprimir() {
        System.out.printf("El resultado es: %.2f\n", this.resultado);
    }
}

//Herencia
class Suma extends Operacion {

    public Suma() {
        super();
    }

    public Suma(double num1, double num2, double resultado) {
        super(num1, num2, resultado);
    }

    @Override
    public void operar() {
        this.resultado = this.num1 + this.num2;
    }
}

class Resta extends Operacion {

    public Resta() {
        super();
    }

    public Resta(double num1, double num2, double resultado) {
        super(num1, num2, resultado);
    }

    @Override
    public void operar() {
        this.resultado = this.num1 - this.num2;
    }
}

class Multiplicacion extends Operacion {

    public Multiplicacion() {
        super();
    }

    public Multiplicacion(double num1, double num2, double resultado) {
        super(num1, num2, resultado);
    }

    @Override
    public void operar() {
        this.resultado = this.num1 * this.num2;
    }
}

class Division extends Operacion {

    public Division() {
        super();
    }

    public Division(double num1, double num2, double resultado) {
        super(num1, num2, resultado);
    }

    @Override
    public void ingresar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el numerador: ");
        this.num1 = scanner.nextDouble();
        System.out.println("Ingrese el denominador: ");
        this.num2 = scanner.nextDouble();
    }

    @Override
    public void operar() {
        if (this.num2 != 0) {
            this.resultado = this.num1 / this.num2;
        } else {
            System.out.println("Error: No se puede dividir entre cero.");
            this.resultado = 0;
        }
    }
}

class Potencia extends Operacion {

    public Potencia() {
        super();
    }

    public Potencia(double num1, double num2, double resultado) {
        super(num1, num2, resultado);
    }

    @Override
    public void ingresar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la base: ");
        this.num1 = scanner.nextDouble();
        System.out.println("Ingrese el exponente: ");
        this.num2 = scanner.nextDouble();
    }

    @Override
    public void operar() {
        this.resultado = Math.pow(num1, num2);
    }
}

class Raiz extends Operacion {

    public Raiz() {
        super();
    }

    public Raiz(double num1, double num2, double resultado) {
        super(num1, num2, resultado);
    }

    @Override
    public void ingresar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el numero base: ");
        this.num1 = scanner.nextDouble();
        System.out.println("Ingrese la numero de la raiz: ");
        this.num2 = scanner.nextDouble();
    }

    @Override
    public void operar() {
        this.resultado = Math.pow(num1, (1.0 / num2));
    }
}

class Seno extends Operacion {

    public Seno() {
        super();
    }

    public Seno(double num1, double num2, double resultado) {
        super(num1, num2, resultado);
    }

    @Override
    public void ingresar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el angulo en grados: ");
        this.num1 = scanner.nextDouble();
    }

    @Override
    public void operar() {
        double radianes;
        radianes = Math.toRadians(this.num1);
        this.resultado = Math.sin(radianes);
    }
}

class Coseno extends Operacion {

    public Coseno() {
        super();
    }

    public Coseno(double num1, double num2, double resultado) {
        super(num1, num2, resultado);
    }

    @Override
    public void ingresar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el angulo en grados: ");
        this.num1 = scanner.nextDouble();
    }

    @Override
    public void operar() {
        double radianes;
        radianes = Math.toRadians(this.num1);
        this.resultado = Math.cos(radianes);
    }
}

class Tangente extends Operacion {

    public Tangente() {
        super();
    }

    public Tangente(double num1, double num2, double resultado) {
        super(num1, num2, resultado);
    }

    @Override
    public void ingresar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el angulo en grados: ");
        this.num1 = scanner.nextDouble();
    }

    @Override
    public void operar() {
        if (this.num1 % 90 == 0) {
            System.out.println("La tangente de " + this.num1 + " es indefinida.");
            this.resultado = Double.NaN;
        } else {
            double radianes = Math.toRadians(this.num1);
            this.resultado = Math.tan(radianes);
        }
    }
}

class TrinomioCuadradoPerfecto extends Operacion {

    private String var;
    private double a, b, c;

    @Override
    public void ingresar() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la variable: ");
        this.var = sc.next();
        System.out.print("Ingrese el termino 1: ");
        this.a = sc.nextDouble();
        System.out.print("Ingrese el termino 2: ");
        this.b = sc.nextDouble();
        System.out.print("Ingrese el termino 3 (constante): ");
        this.c = sc.nextDouble();
    }

    @Override
    public void operar() {
        double r1 = Math.sqrt(Math.abs(a));
        double r3 = Math.sqrt(Math.abs(c));

        if (Math.abs(Math.abs(b) - (2 * r1 * r3)) < 0.0001) {
            String signo = (b >= 0) ? "+" : "-";
            String t1 = (r1 == 1) ? var : r1 + var;

            System.out.println("Resultado: (" + t1 + " " + signo + " " + r3 + ")²");
        } else {
            System.out.println("No es un Trinomio Cuadrado Perfecto.");
        }
    }
}
