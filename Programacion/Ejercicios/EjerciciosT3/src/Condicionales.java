import java.util.Scanner;

public class Condicionales {
    Scanner scanner = new Scanner(System.in);
    public void ejercicio1(){   // Mayor de edad
        System.out.println("Introduce tu edad: ");
        int edad = scanner.nextInt();

        if (edad >= 18){
            System.out.println("Eres mayor de edad. Puedes votar");
        }
    }

    public void ejercicio2() {  // Numero positivo o negativo
        System.out.println("Introduce un número: ");
        int number = scanner.nextInt();

        if (number<0){
            System.out.println("El número es negativo.");
        } else if (number>0) {
            System.out.println("El número es positivo.");
        } else if (number == 0) {
            System.out.println("El número es 0.");

        }
    }

    public void ejercicio3(){   // Aprobado o suspenso
        System.out.println("Introduce tu nota(entre 0 y 10)");
        double nota = scanner.nextDouble();

        if (nota >= 5){
            System.out.println("¡Enhorabuena! Has aprobado");
        } else if (nota<5) {
            System.out.println("Lo siento, has suspendido");
        }
    }
    public void ejercicio4(){   // Descuento por compra

        System.out.println("Importe de la compra: ");
        double price = scanner.nextDouble();
        System.out.println(price);
        double finalPrice;
        if (price >= 100){
            finalPrice = price - (price*0.1);
        }
        else {finalPrice = price;
        }
        System.out.printf("Importe final: %.2f", finalPrice);

    }
    public void ejercicio5(){   // Número par o impar con mensaje
        System.out.println("Introduce un número: ");
        int number = scanner.nextInt();

        if (number%2 == 0){
            System.out.printf("El número %d es par", number);
        } else if (number%2 != 0) {
            System.out.printf("El número %d es impar", number);
        }
    }
    public void ejercicio6(){   // Acceso a contenido por edad
        System.out.println("Introduce tu edad: ");
        int edad = scanner.nextInt();

        if (edad >= 16){
            System.out.println("Acceso permitido. Puedes entrar.");
        } else if (edad < 16) {
            System.out.println("Acceso denegado. Debes tener al menor 16 años");
        }
    }
    public void ejercicio7(){   // Calificación con letra
        System.out.println("Introduce tu nota: ");
        double nota = scanner.nextDouble();

        if (nota < 5){
            System.out.println("Tu calificacion es: Suspenso");
        } else if (nota>=5 && nota <7) {
            System.out.println("Tu calificación es: Aprobado");

        } else if (nota >=7 && nota <9) {
            System.out.println("Tu calificación es: Notable");
        } else if (nota >=9) {
            System.out.println("Tu calificación es: Sobresaliente");
        }

    }
    public void ejercicio8(){   // Comparar dos números
        System.out.println("Introduce el primer número");
        int number1 = scanner.nextInt();
        System.out.println("Introduce el segundo número");
        int number2 = scanner.nextInt();

        if (number1>number2){
            System.out.printf("El número %d es mayor que %d", number1, number2);
        } else if (number1<number2) {
            System.out.printf("El número %d es menor que %d", number1, number2);
        } else if (number1 == number2) {
            System.out.printf("El número %d y el número %d son iguales", number1, number2);
        }


    }
    public void ejercicio9(){   // Calculadora de IMC básica
        System.out.println("Introduce tu peso (en kg): ");
        double peso = scanner.nextDouble();
        System.out.println("Introduce tu altura (en metros): ");
        double altura = scanner.nextDouble();

        double imc = peso / (altura*altura);

        System.out.printf("Tu IMC es: %.2f\n", imc);

        if (imc >= 18.5 && imc<=24.9){
            System.out.println("Estás en un peso normal");
        } else if (imc < 18.5) {
            System.out.println("Estás por debajo del peso normal");
        } else if (imc > 24.9) {
            System.out.println("Estás por encima del peso normal");
        }
    }
    public void ejercicio10(){  // Entrada a parque de atracciones

        System.out.println("Introduce tu altura (en cm): ");
        int altura = scanner.nextInt();

        int alturaMinima = 120;
        int alturaMaxima = 200;

        if (altura < alturaMinima){
            System.out.printf("No puedes subir a la atracción. Eres demasiado bajo\nAltura mínima %d",alturaMinima);
        } else if (altura > alturaMaxima) {
            System.out.printf("No puedes subir a la atracción. Eres demasiado alto\nAltura máxima %d", alturaMaxima);
        }
        else if (altura> alturaMinima && altura< alturaMaxima){
            System.out.println("Puedes montar en la atracción");
        }

    }
    public void ejercicio11(){  // Sistema de descuentos por niveles

        System.out.println("Importe de la compra: ");
        double price = scanner.nextDouble();
        System.out.println("¿Eres socio? (true/false)");
        boolean socio = scanner.nextBoolean();
        double discount = 0;

        System.out.printf("Importe original: %.2f\n", price);

        if (socio && price >= 200){
            discount = 20;

            System.out.println("Eres socio y tu compra es >= 200€");
            System.out.println("Descuento aplicado (20%): "+ (discount/100)*price);
            System.out.println("Importe final: "+(price-((discount/100)*price)));

        } else if (socio && price < 200) {
            discount = 10;

            System.out.println("Eres socio pero tu compra es < 200€");
            System.out.println("Descuento aplicado (10%): "+ (discount/100)*price);
            System.out.println("Importe final: "+(price-((discount/100)*price)));

        } else if (!socio && price >= 300) {
            discount = 5;

            System.out.println("No eres socio pero tu compra es >= 300€");
            System.out.println("Descuento aplicado (5%): "+ (discount/100)*price);
            System.out.println("Importe final: "+(price-((discount/100)*price)));
        }
        else {
            System.out.println("No eres socio y tu compra no es >= 300€");
            System.out.println("No tienes descuento");
            System.out.println("Importe final: "+(price-((discount/100)*price)));
        }

    }

    public void ejercicio12(){  // Validador de contraseña
        System.out.println("Introduce una contraseña");
        String contrasena = scanner.next();

        boolean cumpleLongitud = contrasena.length() > 7;
        boolean tieneNumero = contrasena.matches(".*[0-9].*");
        boolean prohibida = contrasena.equals("12345678");

        System.out.println("Longitud de la contraseña: "+contrasena.length());
        System.out.println("¿Tiene al menos 8 caracteres?: "+cumpleLongitud);
        System.out.println("¿Contiene al menos un número?: "+tieneNumero);
        System.out.println("¿Es una contraseña prohibida?: "+prohibida);

        if (cumpleLongitud && tieneNumero && !prohibida){
            System.out.println("¿Es válida?: "+(cumpleLongitud && tieneNumero && !prohibida));
            System.out.println("Contraseña válida");}

        else if (!cumpleLongitud){
            System.out.println("La contraseña debe tener mínimo 8 caracteres");
        }
        else if (!tieneNumero) {
            System.out.println("La contraseña debe tener al menos un número");

        } else if (prohibida) {
            System.out.println("La contraseña no puede ser: 12345678");

        }
    }
    public void ejercicio13() {     // Calculadora de precio de entradas
        System.out.println("Introduce tu edad: ");
        int edad = scanner.nextInt();
        System.out.println("Introduce el dia de la semana (1-7): ");
        int numSemana = scanner.nextInt();

        System.out.printf("Edad %d años\n", edad);
        String diaSemana = "";
        if (numSemana == 1){diaSemana = "Lunes";}
        else if (numSemana == 2){diaSemana = "Martes";}
        else if (numSemana == 3){diaSemana = "Miercoles";}
        else if (numSemana == 4){diaSemana = "Jueves";}
        else if (numSemana == 5){diaSemana = "Viernes";}
        else if (numSemana == 6){diaSemana = "Sabado";}
        else if (numSemana == 7){diaSemana = "Domingo";}

        System.out.printf("Dia de la semana: %s\n",diaSemana);

        boolean menor12 = edad<12;
        System.out.println("¿Eres menor de 12?: "+menor12);
        boolean menor18 = edad >=12 && edad<18;
        System.out.println("¿Tienes entre 12 y 17?: "+menor18);
        boolean mayor18 = edad >= 18 && edad < 65;
        boolean mayor64 = edad >=65;


        double precioEntrada = 0.0;

        if (menor12){
            System.out.printf("Precio de entrada: %.2f (Entrada gratuita para menores de 12 años)", precioEntrada);
        }
        else if (menor18 && numSemana == 2){

            System.out.println("¿Es martes?: "+(numSemana == 2));
            System.out.printf("Precio de entrada: %.2f€ (Entrada gratuita los martes)",precioEntrada);

        }
        else if (menor18 && numSemana != 2){
            precioEntrada = 5;
            System.out.printf("Precio de entrada: %.2f",precioEntrada);
        }
        else if (mayor18 && numSemana == 4) {
            precioEntrada = 7;
            System.out.println("¿Es jueves?: "+ (numSemana == 4));
            System.out.printf("Precio de entrada: %.2f€ (Entrada reducida los jueves)",precioEntrada);
        }
        else if (mayor18 && numSemana != 4){
            precioEntrada = 10;
            System.out.printf("Precio de entrada: %.2f€",precioEntrada);
        }

        else if (mayor64) {
            System.out.printf("Precio de entrada: %.2f€", precioEntrada);
        }
    }
    public void ejercicio14(){  // Elegibilidad para préstamo
        System.out.println("Introduce tu edad: ");
        int edad = scanner.nextInt();
        System.out.println("Introduce tus ingresos mensuales: ");
        double ingreso = scanner.nextDouble();
        System.out.println("¿Tienes deudas? (true/false): ");
        boolean deudas = scanner.nextBoolean();

        boolean edadRequired = edad >=21 && edad < 65;
        boolean ingresosRequired = ingreso > 1000;

        System.out.printf("¿Edad entre 21 y 65?: %b\n",edadRequired);
        System.out.printf("¿Ingresos >= 1000€?: %b\n",ingresosRequired);
        System.out.printf("¿Sin deudas pendientes?: %b\n",!deudas);

        boolean elegible = edadRequired && ingresosRequired && !deudas;
        System.out.println("¿Es elegible para el prestamo?: "+ elegible);
        if (edadRequired && ingresosRequired && !deudas){
            System.out.println("¡Felicidades! Eres elegible para solicitar el préstamo");

        } else if (!edadRequired && ingresosRequired && !deudas) {
            System.out.println("Lo sentimos, no eres elegible para el prestamos porque tu edad no encaja");
        } else if (!edadRequired && ingresosRequired && deudas) {
            System.out.println("Lo sentimos, no eres elegible para el prestamos porque no cumples la edad y tienes deudas");

        } else if (edadRequired && !ingresosRequired && !deudas){
            System.out.println("Lo sentimos, no eres elegible para el prestamos porque tus ingresos no son suficientes");}
        else if (edadRequired && ingresosRequired && deudas){
            System.out.println("Lo sentimos, no eres elegible para el prestamos porque tienes deudas pendientes");
        }
    }
    public void ejercicio15(){  // Sistemas de envío con múltiples condiciones

        System.out.println("Introduce el peso en kg: ");
        double peso = scanner.nextDouble();
        System.out.println("Introduce la distancia del envío en km: ");
        double km = scanner.nextDouble();
        System.out.println("¿Urgente? (true/false):");
        boolean urgente = scanner.nextBoolean();

        int precioBase = 5;
        int kgSinRecargo = 5;
        int suplementoKm = 10;
        double costeTotal;



        System.out.printf("Precio base: %d€\n", precioBase);

        if (peso < 5){
        System.out.printf("Peso: %.2fkg\n",peso);}
        else if (peso > 5) {
            double pesoExtra = peso - 5;
            System.out.printf("Peso: %.2fkg (Excede de 5kg en %.2fKg)\n",peso, pesoExtra);
            System.out.printf("Coste adicional por peso: "+pesoExtra*2+"€\n");
        }


        if (km < 100){
            System.out.printf("Distancia: %.2fkm\n",km);
        } else if (km > 100) {
            System.out.printf("Distancia: %.2fkm (mayor de 100km)\n",km);
            System.out.printf("Coste adicional por distancia: %d€\n", suplementoKm);

        }

        System.out.printf("¿Es envio urgente?: %b\n",urgente);


        if (peso < 5 && km < 100 && !urgente){
            System.out.printf("Coste total: %d€\n",precioBase);

        } else if (peso > 5 && km < 100 && !urgente) {
            costeTotal = precioBase + (peso - kgSinRecargo)*2;
            System.out.printf("El coste total es: %.2f€\n", costeTotal);

        } else if (peso < 5 && km > 100 && !urgente) {
            costeTotal = precioBase +suplementoKm;
            System.out.printf("El coste total es: %.2f€\n", costeTotal);

        }
        else if (peso < 5 && km < 100 && urgente){
            costeTotal = precioBase * 1.5;
            System.out.println("Recargo por urgencia (x1.5): "+((precioBase * 1.5)-precioBase)+"€");
            System.out.printf("El coste total es: %.2f€\n", costeTotal);
        } else if (peso > 5 && km > 100 && !urgente) {
            costeTotal = (precioBase + (peso - kgSinRecargo)*2) + suplementoKm;
            System.out.printf("El coste total es: %.2f€\n", costeTotal);
        } else if (peso < 5 && km > 100 && urgente) {
            costeTotal = (precioBase * 1.5)+ suplementoKm;
            System.out.println("Recargo por urgencia (x1.5): "+ (precioBase * 1.5)+"€");
            System.out.printf("El coste total es: %.2f€\n", costeTotal);

        } else if (peso > 5 && km < 100 && urgente) {
            costeTotal = (precioBase + (peso - kgSinRecargo)*2) * 1.5;
            System.out.println("Recargo por urgencia (x1.5): "+ ((precioBase + (peso - kgSinRecargo)* 1.5)-(precioBase + (peso - kgSinRecargo)))+"€");
            System.out.printf("El coste total es: %.2f€\n",costeTotal);

        }
        else if (peso > 5 && km > 100 && urgente) {
            costeTotal = (precioBase + (peso - kgSinRecargo)*2) * 1.5 + suplementoKm;
            System.out.println("Recargo por urgencia (x1.5): "+(((precioBase + (peso - kgSinRecargo)*2) * 1.5)-(precioBase + (peso - kgSinRecargo)*2))+"€");
            System.out.printf("El coste total es: %.2f€\n",costeTotal);}



        }
}
