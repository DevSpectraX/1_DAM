import java.sql.SQLOutput;

public class Variables {
    public void ejercicio1() { // Definir y mostrar variables
        String nombre = "Ana";
        int edad = 25;
        String ciudad = "Madrid";

        System.out.println(nombre);
        System.out.println(edad);
        System.out.println(ciudad);
    }

    public void ejercicio2(){ // Modificar variables
        int puntuacionInicial = 0;
        System.out.println("Puntuación inicial: "+puntuacionInicial);

        puntuacionInicial++;
        System.out.println("Despues de la primera modificación: "+puntuacionInicial);

        puntuacionInicial += 45;
        System.out.println("Despues de la segunda modificación: "+puntuacionInicial);
    }

    public void ejercicio3(){   // Tipos de variables
    String nombre = "Carlos";
    int edad = 30;
    boolean esEstudiante = true;
    double altura = 1.45;
    char inicial = 'C';
    System.out.println(nombre + " -> es de tipo: "+ nombre.getClass().getSimpleName());
    System.out.println(edad + " -> es de tipo: "+ ((Object)edad).getClass().getSimpleName());
    System.out.println(esEstudiante + " -> es de tipo: "+ ((Object)esEstudiante).getClass().getSimpleName());
    System.out.println(altura + " -> es de tipo: "+ ((Object)altura).getClass().getSimpleName());
    System.out.println(inicial + " -> es de tipo: "+ ((Object)inicial).getClass().getSimpleName());
    }

    public void ejercicio4(){   // Variables con nombres descriptivos
        String titulo = "Don Quijote de la Mancha";
        String autor = "Miguel de Cervantes";
        int anoPublicación= 1605;
        int numberPaginas= 863;
        boolean disponibleBiblioteca= true;
        System.out.println("Título: "+titulo);
        System.out.println("Autor: "+autor);
        System.out.println("Año de publicación: "+anoPublicación);
        System.out.println("Número de paginas: "+numberPaginas);
        System.out.println("¿Disponibles en bibliotecas?: "+disponibleBiblioteca);
    }

    public void ejercicio5(){   // Declaración y uso de constantes
    final String NOMBREAPP = "MiApp";
    String version = "1.0.0";
    final double PI = 3.14159;
    String actualUser = "Laura";
    int level = 1;
    int points = 0;
    String updatedUser = "Miguel";
    int updatedLevel = 2;
    int updatedPoints = 150;

    System.out.println("Aplicación: " + NOMBREAPP);
    System.out.println("Versión: "+version);
    System.out.println("Valor de Pi: "+PI);
    System.out.println("Usuario actual: "+ actualUser);
    System.out.println("Nivel: "+level);
    System.out.println("Puntuación: " + points);
    System.out.println("Usuario Actualizado: "+updatedUser);
    System.out.println("Nivel acutualizado: "+updatedLevel);
    System.out.println("Puntuación actualizada: "+updatedPoints);


    }
    public void ejercicio6(){   // Operaciones aritméticas simples

        int number1 = 10;
        int number2 = 5;
        System.out.println("el resultado de la suma es: "+(number1+number2));
        System.out.println("el resultado de la resta es: "+(number1-number2));
        System.out.println("el resultado de la multimplicación es: "+(number1*number2));
        System.out.println("el resultado de la división es: "+(number1/number2));





    }
    public void ejercicio7(){   // Presentacion personal
    String nombre = "Elena";
    String apellidos = "García";
    int edad = 24;
    String ciudad = "Barcelona";

    System.out.println("¡Hola! Me llamo " +nombre+" "+apellidos);
    System.out.println("Tengo " +edad+" años y vivo en " +ciudad);



    }

    public void ejercicio8() {   // Calculadora de área de un rectángulo

    int base = 5;
    int altura = 3;
    System.out.println("El área del rectangulo es: "+ (base*altura));

    }

    public void ejercicio9() {   // Información de un producto
    String nombre = "Auriculares Bluetooth";
    double precio = 29.99;
    String codigo = "AUR-2023";
    boolean disponible = true;

    System.out.println("INFORMACIÓN DEL PRODUCTO");
    System.out.printf("Nombre: %s \nPrecio: %.2f€ \nCódigo: %s \nDisponible: %b", nombre, precio, codigo, disponible);


    }


    public void ejercicio10(){  // Conversión de temperaturas
    int celsius = 25;
    int fahrenheit = celsius * 9/5 + 32;

    System.out.printf("Temperatura en Celsius: %d \nTemperatura en Fahrenheit: %d", celsius, fahrenheit);



    }




}
