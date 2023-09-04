//Universidad del Valle de Guatemala
//Autor: Daniela Ramírez de León
//No. Carné: 23053
//Programación Orientada a Objetos
//Ejercicio 3 - Arreglos Dinámicos
import java.util.ArrayList;
import java.util.List;

class Sede {
    private String nombre;
    private List<Estudiante> estudiantes; // Lista para almacenar estudiantes asignados a la sede

    public Sede(String nombre) {
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>(); // Inicializa la lista de estudiantes
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    // Getters para acceder a las propiedades privadas
    public String getNombre() {
        return nombre;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
}

