package calculadoracientifica;

import java.util.Scanner;

public abstract class Factorizacion {
    
    static Scanner scanner = new Scanner(System.in);
    protected String expresionOriginal;
    protected String resultado;

    //Constructores
    public Factorizacion() {
        this.expresionOriginal = "";
        this.resultado = "";
    }
    
    public Factorizacion(String expresionOriginal, String resultado) {
        this.expresionOriginal = expresionOriginal;
        this.resultado = resultado;
    }
    
    //Getters y Setters
    public String getExpresionOriginal() {
        return expresionOriginal;
    }
    public void setExpresionOriginal(String expresionOriginal) {
        this.expresionOriginal = expresionOriginal;
    }
    
    public String getResultado() {
        return resultado;
    }
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    //Metodos
    public abstract void ingresar();
    public abstract void operar();
    public void imprimir(){
        System.out.println("La expresion original es: " + this.expresionOriginal);
        System.out.println("El resultado es: " + this.resultado);
    }
}

//Herencia
class FactorComun extends Factorizacion {
    private String variable;
    private int coeficiente1, coeficiente2;
    private int exponente1, exponente2;
    
    public FactorComun(){
        super();
    }
    public FactorComun(String expresionOriginal, String resultado){
        super(expresionOriginal, resultado);
    }
    
    @Override
    public void ingresar() {
        System.out.println("*** FACTOR COMUN ****");
        System.out.println("Ingrese la variable: ");
        this.variable = scanner.nextLine();
        
        System.out.println("Ingrese el primer coeficiente: ");
        this.coeficiente1 = scanner.nextInt();
        System.out.println("Ingrese el exponente del primer termino: ");
        this.exponente1 = scanner.nextInt();
        System.out.println("Ingrese el segundo coeficiente: ");
        this.coeficiente2 = scanner.nextInt();
        System.out.println("Ingrese el exponente del segundo termino: ");
        this.coeficiente2 = scanner.nextInt();
    }
    
    @Override
    public void operar() {
        this.expresionOriginal = coeficiente1 + variable + "^" + exponente1 + " + " + coeficiente2 + variable + "^" + exponente2;
        int mcd = obtenerMCD(Math.abs(coeficiente1), Math.abs(coeficiente2));
        int menorExponente = Math.min(exponente1, exponente2);
        int nuevoCoeficiente1 = coeficiente1 / mcd;
        int nuevoCoeficiente2 = coeficiente2 / mcd;
        int nuevoExponente1 = exponente1 - menorExponente;
        int nuevoExponente2 = exponente2 - menorExponente;

        String termino1 = formatearTermino(nuevoCoeficiente1, variable, nuevoExponente1);
        String termino2 = formatearTermino(nuevoCoeficiente2, variable, nuevoExponente2);

        String signo = (nuevoCoeficiente2 >= 0) ? " + " : " ";

        String factorExtraido = mcd + variable + "^" + menorExponente;

        this.resultado = factorExtraido + "(" + termino1 + signo + termino2 + ")";
    }

    private int obtenerMCD(int a, int b) {
        while (b != 0) {
            int temporal = b;
            b = a % b;
            a = temporal;
        }
        return a;
    }

    private String formatearTermino(int coeficiente, String variable, int exponente) {
        switch (exponente) {
            case 0:
                return String.valueOf(coeficiente);
            case 1:
                return coeficiente + variable;
            default:
                return coeficiente + variable + "^" + exponente;
        }
    }
}

