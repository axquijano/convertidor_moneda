package com.alura.convertidor_moneda;

import java.util.Scanner;


public class Principal {

    private static final Scanner scanner = new Scanner(System.in);

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final ConsumoApi consumirApi = new ConsumoApi();

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            if (opcion == 7) {
                System.out.println("Cerrando la aplicación...");
                break;
            }
            double valorParaConvertir = leerValorParaConvertir();
            procesarConversion(opcion, valorParaConvertir);
        } while (opcion != 7);
    }

    private static void mostrarMenu() {
        System.out.println("*********************************************");
        System.out.println("Sea bienvenido/a al Conversor de Moneda");
        System.out.println("1) Dólar => Peso argentino");
        System.out.println("2) Peso argentino => Dólar");
        System.out.println("3) Dólar => Real brasileño");
        System.out.println("4) Real brasileño => Dólar");
        System.out.println("5) Dólar => Peso colombiano");
        System.out.println("6) Peso colombiano => Dólar");
        System.out.println("7) Salir");
        System.out.println("Elija una opción válida:");
        System.out.println("*********************************************");
    }

    private static int leerOpcion() {
        int opcion = -1;
        while (opcion < 1 || opcion > 7) {
            System.out.print("Ingrese una opción (1-7): ");
            String input = scanner.nextLine();
            if (esNumeroValido(input, 1, 7)) {
                opcion = Integer.parseInt(input);
                System.out.println(ANSI_BLUE + "La opción ingresada es: " + opcion + ANSI_RESET);
            } else {
                System.out.println(ANSI_RED + "Opción inválida. Intente nuevamente." + ANSI_RESET);
            }
        }
        return opcion;
    }

    private static double leerValorParaConvertir() {
        double valor = -1;
        while (valor < 0) {
            System.out.print("Ingrese el valor que desea convertir: ");
            String input = scanner.nextLine();
            if (esNumeroValido(input, 0, Double.MAX_VALUE)) {
                valor = Double.parseDouble(input);
//                System.out.println(ANSI_BLUE + "El valor ingresado es: " + valor + ANSI_RESET);
            } else {
                System.out.println(ANSI_RED + "Valor inválido. Intente nuevamente." + ANSI_RESET);
            }
        }
        return valor;
    }

    private static void procesarConversion(int opcion, double valorParaConvertir) {
        switch (opcion) {
            case 1 -> realizarConversion("USD", "ARS", valorParaConvertir);
            case 2 -> realizarConversion("ARS", "USD", valorParaConvertir);
            case 3 -> realizarConversion("USD", "BRL", valorParaConvertir);
            case 4 -> realizarConversion("BRL", "USD", valorParaConvertir);
            case 5 -> realizarConversion("USD", "COP", valorParaConvertir);
            case 6 -> realizarConversion("COP", "USD", valorParaConvertir);
            default -> System.out.println(ANSI_RED + "Opción no válida." + ANSI_RESET);
        }
    }

    private static void realizarConversion(String codeBase, String codeTarget, double valorParaConvertir) {
        Conversor conversor = consumirApi.obtenerDatos(codeBase, codeTarget);
        double valorConvertido = valorParaConvertir * conversor.conversionRate();
        System.out.println(ANSI_GREEN+"El valor de " + valorParaConvertir + " [" + codeBase + "] corresponde al valor final ==> "
                + valorConvertido + " [" + codeTarget + "]"+ANSI_RESET);
    }

    private static boolean esNumeroValido(String valor, double min, double max) {
        if (valor == null || valor.isBlank() || !valor.matches("\\d+(\\.\\d+)?")) {
            return false;
        }
        double numero = Double.parseDouble(valor);
        return numero >= min && numero <= max;
    }
}

//public class Principal {
//
//    public static Scanner leer = new Scanner(System.in);
//
//    public static final String ANSI_RED = "\u001B[31m";
//    public static final String ANSI_RESET = "\u001B[0m";
//    public static final String ANSI_BLUE = "\u001B[34m";
//    public static ConsumoApi consumirApi = new ConsumoApi();
//
//
//    public static void main(String[] args) {
//        int varOpcion = 0;
//        double valorParaConvertir = 0;
//        do{
//            menu();
//            var opc = leer.nextLine();
//            if(isNumber(opc)){
//                varOpcion = Integer.parseInt(opc);
//                System.out.println(ANSI_BLUE+ "La opcion ingresada es: "+ varOpcion+ ANSI_RESET);
//            }
//
//            System.out.println("Ingrese el valor que desea convertir: ");
//            var valor = leer.nextLine();
//            if(isNumber(valor)){
//                valorParaConvertir = Double.parseDouble(opc);
//                System.out.println(ANSI_BLUE+ "La opcion ingresada es: "+ varOpcion+ ANSI_RESET);
//            }
//
//            switch (varOpcion){
//                case 1:
//                    conversion("USD", "ARS", valorParaConvertir);
//                    break;
//                case 2:
//                    conversion("ARS", "USD", valorParaConvertir);
//                    break;
//                case 3:
//                    conversion("USD", "BRL", valorParaConvertir);
//                    break;
//                case 4:
//                    conversion("BRL", "USD", valorParaConvertir);
//                    break;
//                case 5:
//                    conversion("USD", "COP", valorParaConvertir);
//                    break;
//                case 6:
//                    conversion("COP", "USD", valorParaConvertir);
//                    break;
//                case 7:
//                    System.out.println("Cerrando la aplicacion ...");
//                    break;
//                default:
//                    System.out.println("Opcion invalida");
//            }
//        }while(varOpcion!=7);
//
//    }
//
//
//    public static void conversion (String codeBase, String codeTarget, Double valorParaConvertir){
//        Conversor conversor = consumirApi.obtenerDatos("USD", "ARS");
//        double valorConvertido = valorParaConvertir * conversor.conversionRate();
//        System.out.println("El valor de "+valorParaConvertir+" ["+codeBase+"] corresponde al valor final ==> "+valorConvertido+" ["+codeTarget+"]");
//    }
//    public static boolean  isNumber(String valor){
//        boolean bandera = false;
//        if (!valor.isBlank() && !valor.isEmpty() ){
//            if(valor.matches("\\d+")){
//                if(!valor.matches("[1-7]")){
//                    System.out.println(ANSI_RED + "Incorrecto, solo numeros del 1 al 7" + ANSI_RESET);
//                }else{
//                    bandera = true;
//                }
//            }else{
//                System.out.println(ANSI_RED+ "Solo numeros"+ ANSI_RESET);
//            }
//        }else{
//            System.out.println(ANSI_RED + "Cadena vacia" + ANSI_RESET);
//        }
//        return bandera;
//    }
//
//    public static void menu (){
//        System.out.println("*********************************************");
//        System.out.println("Sea bienvenido/a al Conversor de Moneda");
//        System.out.println("1) Dólar =>> Peso argentino");
//        System.out.println("2) Peso argentino ==> Dólar" );
//        System.out.println("3) Dólar =>> Real brasileño");
//        System.out.println("4) Real brasileño =>> Dólar");
//        System.out.println("5) Dólar =>> Peso colombiano  ");
//        System.out.println("6) Peso colombiano =>> Dólar");
//        System.out.println("7) Salir");
//        System.out.println("Elija una opción válida: ");
//        System.out.println("*********************************************");
//    }
//
//
//
//}
