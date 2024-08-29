package EjercicioEvaluadorDeClases;

import java.lang.reflect.Array;
import java.util.*;

public class LibretaDeNotas {
    public static void main(String[] args) {

        Scanner miScanner = new Scanner(System.in);

        // EJERCICIO 1
        /*System.out.println("Bienvenido al Evaluador de clases");
        System.out.println("Por favor ingresa la nota del 1 al 10 para la primera materia");
        Double materia1 = miScanner.nextDouble();
        System.out.println("Por favor ingresa la nota del 1 al 10 para la segunda materia");
        Double materia2 = miScanner.nextDouble();
        System.out.println("Por favor ingresa la nota del 1 al 10 para la tercera materia");
        Double materia3 = miScanner.nextDouble();

        Double promedioMaterias = (materia1 + materia2 + materia3)/3;

        if (Math.round(promedioMaterias) > 0 && Math.round(promedioMaterias) <= 3){
            System.out.println("No Aprobado. El promedio final es " + Math.round(promedioMaterias));
        } else if (Math.round(promedioMaterias) > 3 && Math.round(promedioMaterias) <= 5){
            System.out.println("Insuficiente. El promedio final es " + Math.round(promedioMaterias));
        } else if (Math.round(promedioMaterias) > 5 && Math.round(promedioMaterias) <= 8){
            System.out.println("Aceptable. El promedio final es " + Math.round(promedioMaterias));
        } else if (Math.round(promedioMaterias) > 8 && Math.round(promedioMaterias) <= 10){
            System.out.println("Excelente. El promedio final es " + Math.round(promedioMaterias));
        } else {
            System.out.println("Por favor, ingresa nuevamente para indicar notas válidas del 1 al 10.");
        }*/


        //EJERCICIO 2
        System.out.println("Bienvenido a la Libreta de Notas");

        System.out.println("Por favor ingresa la cantidad de alumnos");
        Integer cantidadAlumnos = miScanner.nextInt();

        System.out.println("Por favor ingresa la cantidad de notas por alumno");
        Integer cantidadNotas = miScanner.nextInt();

        Map<String, ArrayList<Integer>> infoEstudiantes = new HashMap<>(cantidadAlumnos);


        for (int i = 0; i < cantidadAlumnos; i++) {
            ArrayList<Integer> notas = new ArrayList<>();
            System.out.println("Por favor ingresa el nombre del alumno número " + (i+1));
            String nombreAlumno = miScanner.next();
            for (int j = 0; j < cantidadNotas; j++){
                System.out.println("Por favor ingresa la nota "+ (j+1) + " para el alumno " + nombreAlumno);
                Integer notaAlumno = miScanner.nextInt();
                notas.add(notaAlumno);
            }
            infoEstudiantes.put(nombreAlumno, notas);
        }

        //System.out.println(infoEstudiantes);

        for (String nombreAlumno : infoEstudiantes.keySet()) {
            ArrayList<Integer> notas = infoEstudiantes.get(nombreAlumno);
            //System.out.println(notas);
            Double promedio = 0D;
            for (Integer nota : notas) {
                promedio += nota;
            }
            promedio = promedio / notas.size();
            System.out.println("El promedio de " + nombreAlumno + " es " + promedio);
            System.out.println("El numero mas alto para "+ nombreAlumno + " es " + Collections.max(notas));
            System.out.println("El numero mas bajo para " + nombreAlumno + " es " + Collections.min(notas));
        }

        Integer opciones;
        do {
            System.out.println("~~~~~~~~~~ MENÚ DE OPCIONES ~~~~~~~~~~" + '\n' +
                    "Ingresa una opción del menú ó 0 para Salir del Menú. " + '\n' +
                    "1. Mostrar el Promedio de Notas por Estudiante. " + '\n' +
                    "2. Mostrar si la Nota es Aprobatoria o Reprobatoria por Estudiante. " + '\n' +
                    "3. Mostrar si la Nota está por Sobre o por Debajo del Promedio del Curso por Estudiante. " + '\n' +
                    "0. para Salir del Menú. "
            );
            opciones = miScanner.nextInt();
            System.out.println();
            switch (opciones) {
                case 1:
                    for (String nombre : infoEstudiantes.keySet()) {
                        float sumaNotas = 0f;
                        float promedio = 0f;
                        ArrayList<Integer> notas = infoEstudiantes.get(nombre);
                        for (Integer nota : notas) {
                            sumaNotas += nota;
                        }
                        promedio = sumaNotas / notas.size();

                        System.out.println("Promedio de " + nombre + ": "+ promedio);
                    }
                    break;

                case 2:
                    for (String nombre : infoEstudiantes.keySet()) {
                        float aprobado = 4f;
                        int contador = 0;
                        ArrayList<Integer> notas = infoEstudiantes.get(nombre);
                        System.out.println("** Informe de " + nombre + " **");

                        for (float nota : notas) {
                            contador++;
                            if (nota >= aprobado) {
                                System.out.println("Nota " + contador + ": Aprobado");
                            } else {
                                System.out.println("Nota " + contador + ": Reprobado");
                            }
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    float sumaTotal = 0f;
                    int notasTotal = cantidadAlumnos * cantidadNotas;


                    for (String nombre : infoEstudiantes.keySet()) {
                        ArrayList<Integer> notas = infoEstudiantes.get(nombre);
                        for (float nota : notas) {
                            sumaTotal += nota;
                        }
                    }

                    float promedioFinal = sumaTotal / notasTotal;


                    for (String nombre : infoEstudiantes.keySet()) {
                        ArrayList<Integer> notas = infoEstudiantes.get(nombre);
                        int contador = 0;

                        System.out.println("** Informe de " + nombre + " **");
                        for (float nota : notas) {
                            contador++;
                            if (nota > promedioFinal) {
                                System.out.println("Nota " + contador + ": Sobre");
                            } else if (nota < promedioFinal) {
                                System.out.println("Nota " + contador + ": Debajo");
                            } else {
                                System.out.println("Nota " + contador + ": Es igual");
                            }
                        }
                        System.out.println();
                    }
                    break;

                case 0:
                    System.out.println("Estás saliendo del menú.");
                    break;

                default:
                    System.out.println("¡Fatal!\nIngresa una opción que se encuentre dentro del menú.");
                    break;
            }
            System.out.println();
        } while (opciones != 0);
        System.out.println("¡Hasta la próxima!");




    }
}


