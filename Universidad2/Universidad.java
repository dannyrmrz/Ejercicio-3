//Universidad del Valle de Guatemala
//Autor: Daniela Ramírez de León
//No. Carné: 23053
//Programación Orientada a Objetos
//Ejercicio 3 - Arreglos Dinámicos
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Universidad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Estudiante> estudiantes = new ArrayList<>(); // Lista para almacenar a todos los estudiantes
        List<Sede> sedes = new ArrayList<>(); // Lista para almacenar sedes

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Ingresar notas");
            System.out.println("3. Ver estadísticas");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    // Registrar un nuevo estudiante
                    System.out.print("Nombre del estudiante: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido del estudiante: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Código único: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Fecha de nacimiento: ");
                    String fechaNacimiento = scanner.nextLine();
                    System.out.print("Correo electrónico: ");
                    String correo = scanner.nextLine();

                    System.out.println("Seleccione la sede:");
                    System.out.println("1. Campus Sur");
                    System.out.println("2. Campus Central");
                    System.out.println("3. Campus Altiplano");
                    System.out.print("Opción: ");
                    int opcionSede = scanner.nextInt();
                    Sede sede = null;

                    switch (opcionSede) {
                        case 1:
                            sede = buscarSede(sedes, "Campus Sur");
                            if (sede == null) {
                                sede = new Sede("Campus Sur");
                                sedes.add(sede);
                            }
                            break;
                        case 2:
                            sede = buscarSede(sedes, "Campus Central");
                            if (sede == null) {
                                sede = new Sede("Campus Central");
                                sedes.add(sede);
                            }
                            break;
                        case 3:
                            sede = buscarSede(sedes, "Campus Altiplano");
                            if (sede == null) {
                                sede = new Sede("Campus Altiplano");
                                sedes.add(sede);
                            }
                            break;
                        default:
                            System.out.println("Opción no válida");
                            break;
                    }

                    Estudiante estudiante = new Estudiante(nombre, apellido, codigo, fechaNacimiento, correo, sede);
                    sede.agregarEstudiante(estudiante);
                    estudiantes.add(estudiante);
                    System.out.println("Estudiante registrado exitosamente.");
                    break;
                case 2:
                    if (estudiantes.isEmpty()) {
                        System.out.println("Todavía no se ha registrado ningún estudiante.");
                    } else {
                        // Ingresar notas de exámenes
                        System.out.print("Ingrese el código único del estudiante: ");
                        String codigoEstudiante = scanner.nextLine();
                        Estudiante estudianteSeleccionado = buscarEstudiante(estudiantes, codigoEstudiante);

                        if (estudianteSeleccionado == null) {
                            System.out.println("Estudiante no encontrado.");
                        } else {
                            System.out.println("Ingrese las notas de los exámenes (ingrese 'x' si no realizó el examen):");
                            System.out.print("Matemática: ");
                            float notaMatematica = obtenerNota(scanner);
                            System.out.print("Lenguaje: ");
                            float notaLenguaje = obtenerNota(scanner);
                            System.out.print("Química: ");
                            float notaQuimica = obtenerNota(scanner);
                            System.out.print("Física: ");
                            float notaFisica = obtenerNota(scanner);
                            System.out.print("Comprensión Lectora: ");
                            float notaComprensionLectora = obtenerNota(scanner);
                            System.out.print("Estadística: ");
                            float notaEstadistica = obtenerNota(scanner);

                            // Agregar las notas al estudiante
                            estudianteSeleccionado.agregarNota(notaMatematica);
                            estudianteSeleccionado.agregarNota(notaLenguaje);
                            estudianteSeleccionado.agregarNota(notaQuimica);
                            estudianteSeleccionado.agregarNota(notaFisica);
                            estudianteSeleccionado.agregarNota(notaComprensionLectora);
                            estudianteSeleccionado.agregarNota(notaEstadistica);
                            System.out.println("Notas ingresadas exitosamente.");
                        }
                    }
                    break;
                case 3:
                    if (sedes.isEmpty()) {
                        System.out.println("Todavía no se ha ingresado ninguna nota.");
                    } else {
                        // Mostrar estadísticas por sede
                        mostrarEstadisticas(sedes);
                    }
                    break;
                case 4:
                    // Salir del programa
                    System.out.println("¡Hasta luego!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }

    private static float obtenerNota(Scanner scanner) {
        String entrada = scanner.nextLine().trim();
        if (entrada.equalsIgnoreCase("x")) {
            return -1.0f; // Representa que el estudiante no realizó el examen
        } else {
            try {
                return Float.parseFloat(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Ingrese una nota válida o 'x'.");
                return obtenerNota(scanner);
            }
        }
    }
        // Función para buscar una sede por nombre en la lista de sedes
        private static Sede buscarSede(List<Sede> sedes, String nombreSede) {
        for (Sede sede : sedes) {
            if (sede.getNombre().equalsIgnoreCase(nombreSede)) {
                return sede;
            }
        }
        return null;
    }

    // Función para buscar un estudiante por código único en la lista de estudiantes
    private static Estudiante buscarEstudiante(List<Estudiante> estudiantes, String codigoEstudiante) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCodigo().equalsIgnoreCase(codigoEstudiante)) {
                return estudiante;
            }
        }
        return null;
    }

    private static void mostrarEstadisticas(List<Sede> sedes) {
        for (Sede sede : sedes) {
            System.out.println("Sede: " + sede.getNombre());
            List<Float> notas = new ArrayList<>();

            for (Estudiante estudiante : sede.getEstudiantes()) {
                notas.addAll(estudiante.getNotas());
            }

            if (notas.isEmpty()) {
                System.out.println("Todavía no se ha ingresado ninguna nota.");
            } else {
                
                float promedio = calcularPromedio(notas);
                float mediana = calcularMediana(notas);
                float moda = calcularModa(notas);
                float desviacionEstandar = calcularDesviacionEstandar(notas);
                int cantidadEstudiantes = sede.getEstudiantes().size();
                float notaMinima = Collections.min(notas);
                float notaMaxima = Collections.max(notas);

                System.out.println("Promedio: " + promedio);
                System.out.println("Mediana: " + mediana);
                System.out.println("Moda: " + moda);
                System.out.println("Desviación Estándar: " + desviacionEstandar);
                System.out.println("Cantidad de Estudiantes Registrados: " + cantidadEstudiantes);
                System.out.println("Nota más baja: " + notaMinima);
                System.out.println("Nota más alta: " + notaMaxima);
            }
        }
    }

    //código de las funciones auxiliares calcularPromedio, calcularMediana, etc.
    private static float calcularPromedio(List<Float> notas) {
        float suma = 0;
        int count = 0;

        for (float nota : notas) {
            if (nota >= 0) {
                suma += nota;
                count++;
            }
        }

        return count > 0 ? suma / count : 0;
    }

    private static float calcularMediana(List<Float> notas) {
        List<Float> notasValidas = new ArrayList<>();

        for (float nota : notas) {
            if (nota >= 0) {
                notasValidas.add(nota);
            }
        }

        Collections.sort(notasValidas);

        int n = notasValidas.size();
        if (n % 2 == 0) {
            int middle1 = (n - 1) / 2;
            int middle2 = n / 2;
            return (notasValidas.get(middle1) + notasValidas.get(middle2)) / 2.0f;
        } else {
            int middle = n / 2;
            return notasValidas.get(middle);
        }
    }

    private static float calcularModa(List<Float> notas) {
        List<Float> notasValidas = new ArrayList<>();

        for (float nota : notas) {
            if (nota >= 0) {
                notasValidas.add(nota);
            }
        }

        if (notasValidas.isEmpty()) {
            return 0;
        }

        int maxCount = 0;
        float moda = notasValidas.get(0);

        for (int i = 0; i < notasValidas.size(); i++) {
            float notaActual = notasValidas.get(i);
            int count = 1;

            for (int j = i + 1; j < notasValidas.size(); j++) {
                if (notasValidas.get(j) == notaActual) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                moda = notaActual;
            }
        }

        return moda;
    }

    private static float calcularDesviacionEstandar(List<Float> notas) {
        float promedio = calcularPromedio(notas);
        float sumaCuadrados = 0;
        int count = 0;

        for (float nota : notas) {
            if (nota >= 0) {
                float diferencia = nota - promedio;
                sumaCuadrados += diferencia * diferencia;
                count++;
            }
        }

        float varianza = sumaCuadrados / (count - 1);
        return (float) Math.sqrt(varianza);
    }
}

