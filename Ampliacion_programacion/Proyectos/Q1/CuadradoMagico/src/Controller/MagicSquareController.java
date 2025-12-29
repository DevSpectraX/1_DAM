package Controller;

import java.util.Scanner;

public class MagicSquareController {
    Scanner scanner = new Scanner(System.in);
    private int n;
    private int magicSum;
    private int [][]square;

    public void startSquare(){
        System.out.println("¿Cuántas casillas quieres para tu cuadrado mágico?");
        n = scanner.nextInt();
        // La constante mágica es (n*(n*n) +1)/2, el total de las sumas siempre sera esa formula
        magicSum = (n*(n*n + 1))/2;
        square = new int[n][n];
        searchAlgorithm();


    }

    private void searchAlgorithm(){
        int attempt = 0;
        do {
            generateMatrix();
            attempt++;

        }while (!rowSum() || !columnSum() || !firstDiagonalSum() || !secondDiagonalSum());

        System.out.println("===CUADRADO MÁGICO ENCONTRADO===");
        printResult(square);
        System.out.println("La constante mágica es: "+magicSum);
        System.out.println("Número de intentos: "+attempt);

    }


    private void generateMatrix(){
        
        //Creo un array de numeros de n*n y los añado al array (i+1)
        int[] numbers = new int[n*n];
        int index = 0;
        for (int i = 0; i < n*n; i++){
            numbers[i] = i + 1;                
            }

        /*Hay un algoritmo que se llama "Fisher-Yates"
        que funciona recorriendo el array al reves, y
        asignamos a una variable temporal el ultimo indice,
        luego con un math.random elejimos una posicion al azar
        y pasamos el ultimo indice a esa posicion y el elemento
        de esta posicion la pasamos al ultimo*/

        for (int i = numbers.length -1; i > 0; i--) {
            int j = (int)(Math.random() * (i+1));
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
            
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                square[i][j] = numbers[index];
                index++;

            }

        }
    }
        


    private boolean rowSum(){
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += square[i][j];

            }
            if (sum != magicSum){
                return false;
            }

        }
        return true;
    }


    private boolean columnSum(){
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += square[i][j];

            }
            if (sum != magicSum)
                return false;

        }
        return true;
    }


    private boolean firstDiagonalSum(){
        int sum = 0;

        for (int i = 0; i < n; i++) {
            // La i coincide con la posicion de la diagonal cada vez que se itera
            sum += square[i][i];
        }
        if (sum != magicSum){
            return false;
        }
        
        else return true;
    }


    private boolean secondDiagonalSum(){
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += square[i][n - 1 - i]; // empieza en fila i, columna n-1-i
        }
        if (sum != magicSum){
            return false;
        }

        else return true;

    }


    public void printResult (int [][]square){
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                System.out.print(square[i][j] + " ");
            }
            System.out.println();

        }
    }
}
