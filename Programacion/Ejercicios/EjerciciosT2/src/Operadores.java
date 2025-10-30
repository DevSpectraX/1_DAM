import java.util.Scanner;

public class Operadores {
    Scanner scanner = new Scanner(System.in);
    public void ejercicio1(){   // Operadores aritméticos básicos


        System.out.printf("Introduce el primer número: ");
        int number1 = scanner.nextInt();

        System.out.printf("Introduce el segundo número: ");
        int number2 = scanner.nextInt();

        System.out.println("El resultado de la suma es: " +(number1+number2));
        System.out.println("El resultado de la resta es: " +(number1-number2));
        System.out.println("El resultado de la multiplicación es: " +(number1*number2));
        System.out.println("El resultado de la división es: " +(number1/number2));
        System.out.println("El resultado del resto de la división es: " +(number1%number2));

    }

    public void ejercicio2 (){  // Comparación de números

        System.out.printf("Introduce el primer número: ");
        int number1 = scanner.nextInt();

        System.out.printf("Introduce el segundo número: ");
        int number2 = scanner.nextInt();

        System.out.printf("¿%d es mayor que %d?: %b\n", number1, number2, number1>number2);
        System.out.printf("¿%d es menor que %d?: %b\n", number1, number2, number1<number2);
        System.out.printf("¿%d es igual que %d?: %b\n", number1, number2, number1==number2);
        System.out.printf("¿%d es diferente de %d?: %b\n", number1, number2, number1!=number2);
        System.out.printf("¿%d es mayor o igual que %d?: %b\n", number1, number2, number1>=number2);
        System.out.printf("¿%d es menor o igual que %d?: %b\n", number1, number2, number1<=number2);

    }

    public void ejercicio3() {   // Operadores de asignación compuesta
    int value = 100;
    value +=50;
    System.out.println("Despues de sumar 50: "+ value);

    value -= 30;
    System.out.println("Despues de restar 30: "+ value);

    value *= 2;
    System.out.println("Despues de multiplicar por 2: "+ value);

    value /= 4;
    System.out.println("Despues de dividir por 4: "+ value);

    }

    public void ejercicio4(){  // Número par o impar
    System.out.print("Introduce un número: ");
    int value = scanner.nextInt();
    if (value % 2 == 0){
        System.out.printf("El número %d es par", value);
    } else if (value % 2 == 1) {
        System.out.printf("El número %d es impar", value);

    }
    }



    public void ejercicio5(){   // Operadores lógicos AND y OR
        System.out.println("¿Qué edad tienes?");
        int edad = scanner.nextInt();
        System.out.println("¿Tienes carnet de conducir?");
        boolean carnet = scanner.nextBoolean();

        System.out.println("¿Tienes carnet? "+ carnet);
        boolean validation = edad > 21 && carnet;
        System.out.println("¿Puedes alquilar un coche? "+ validation);
    }

    public void ejercicio6() {   // Calculadora de descuento
        System.out.println("Introduce el precio del producto:");
        double price = scanner.nextDouble();
        System.out.println("Introduce el porcentaje de descuento:");
        double discount = scanner.nextDouble();

        System.out.println("El precio final es: " +(price-(discount/100*price))+"€");

    }

    public void ejercicio7() {   // Operador NOT y condiciones compuestas

        System.out.println("¿Qué edad tienes?");
        int edad = scanner.nextInt();
        System.out.println("¿Eres estudiante?(true / false)");
        boolean estudiante = scanner.nextBoolean();

        System.out.println("¿Eres menor de 26 años? " + (edad < 26));
        System.out.println("¿Eres estudiante? " + estudiante);
        System.out.println("¿NO eres estudiante? " + !estudiante);
        System.out.println("¿Tienes descuento joven? (menor de 26) " + (edad < 26));
        System.out.println("¿Tienes descuento estudiante? " + (edad < 26 || estudiante));
        System.out.println("¿Tienes descuento especial? " + (edad < 26 && estudiante));

    }

    public void ejercicio9(){   // Sistema de calificaciones

        System.out.println("Nota examen Base de datos: ");
        double nota1 = scanner.nextDouble();
        System.out.println("Nota examen Programación: ");
        double nota2 = scanner.nextDouble();
        System.out.println("Nota examen Lenguaje: ");
        double nota3 = scanner.nextDouble();

        double notaMedia = (nota1+nota2+nota3)/3;
        boolean aprobado = nota1 >= 5 || nota2 >= 5 || nota3 >= 5;
        boolean notable = nota1 >= 7 || nota2 >= 7 || nota3 >= 7;
        boolean sobresaliente = nota1 >= 9 || nota2 >= 9 || nota3 >= 9;

        System.out.println("Nota media: "+notaMedia);
        System.out.println("¿Ha aprobado? "+aprobado);
        System.out.println("¿Tiene notable? "+notable);
        System.out.println("¿Tiene sobresaliente? "+sobresaliente);

    }

    public void ejercicio10(){  // Calculadora de salario con condiciones
        System.out.println("Introduce el salario por hora: ");
        double baseSalary = scanner.nextDouble();

        System.out.println("Introduce las horas trabajadas: ");
        double workHours = scanner.nextDouble();

        System.out.println("¿Has hecho horas extra? (true/false): ");
        boolean extraHours = scanner.nextBoolean();

        int horasNormales = 40;
        double horasExtra = workHours - horasNormales;
        boolean derechoHorasExtra = workHours>horasNormales;
        double normalSalary = baseSalary*(workHours-horasExtra);
        double extraSalary = (baseSalary*horasExtra)*2;
        double totalSalary = normalSalary+extraSalary;


        System.out.printf("¿Trabajaste mas de %d horas? %b\n", horasNormales, workHours>horasNormales);
        System.out.printf("¿Tienes derecho a horas extra? %b\n", derechoHorasExtra);
        System.out.printf("¿Se aplican horas extra? %b\n", derechoHorasExtra);
        System.out.printf("Salario por horas normales: %.2f€ \n", normalSalary);
        System.out.printf("Salario por horas extras: %.2f€ \n", extraSalary);
        System.out.printf("Salario total: %.2f€ ", totalSalary);





    }
}
