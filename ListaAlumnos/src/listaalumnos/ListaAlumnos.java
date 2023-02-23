package listaalumnos;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaAlumnos {

    Scanner scanner = new Scanner(System.in);
    ArrayList<Alumno> lista = new ArrayList<Alumno>();

    public void ingresarAlumnos() {
        System.out.println("Ingrese el nombre del alumno:");
        String nombre = scanner.next();
        System.out.println("Ingrese el carnet del alumno:");
        String carnet = scanner.next();
        System.out.println("Ingrese la edad del alumno:");
        int edad = scanner.nextInt();
        System.out.println("Ingrese el género del alumno (M o F):");
        char genero = scanner.next().charAt(0);
        Alumno nuevo = new Alumno(nombre, carnet, edad, genero);
        if (edad < 0) {
            System.out.println("La edad no puede ser menor que cero");
            System.out.println("El alumno no ha sido agregado a la lista");
        } else if (genero != 'F' && genero != 'M') {
            System.out.println("el genero solo puede ser 'M' o 'F' ");
            System.out.println("El alumno no ha sido agregado a la lista");
        } else {
            lista.add(nuevo);
            System.out.println("El alumno ha sido agregado a la lista.");
        }
    }

    public void mostrarAlumnos() {
        for (Alumno alumno : lista) {
            System.out.println("Nombre: " + alumno.getNombre() + ", Carnet: " + alumno.getCarnet() + ", Edad: " + alumno.getEdad() + ", Género: " + alumno.getGenero());
        }
    }

    public void menu() {

        boolean salir = false;

        while (!salir) {
            System.out.println("___________________________________________");
            System.out.println("Qué acción desea realizar?");
            System.out.println("1. Ingresar un nuevo alumno.");
            System.out.println("2. Ver lista de alumnos en el sistema.");
            System.out.println("3. Salir");
            System.out.println("___________________________________________");

            int op = scanner.nextInt();

            switch (op) {
                case 1:
                    ingresarAlumnos();
                    break;
                case 2:
                    System.out.println("Lista de alumnos ingresados:");
                    System.out.println("");
                    System.out.println("-*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_");
                    mostrarAlumnos();
                    System.out.println("-*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_");
                    break;
                case 3:
                    System.out.println("Fin del programa");
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no disponible");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        ListaAlumnos menu = new ListaAlumnos();
        try {
            menu.menu();
            System.out.println("holaa");
        } catch (NumberFormatException e) {
            System.out.println("error");
        }
    }
}

class Alumno {

    private String nombre;
    private String carnet;
    private int edad;
    private char genero;

    public Alumno(String nombre, String carnet, int edad, char genero) {
        this.nombre = nombre;
        this.carnet = carnet;
        this.edad = edad;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCarnet() {
        return carnet;
    }

    public int getEdad() {
        return edad;
    }

    public char getGenero() {
        return genero;
    }
}
