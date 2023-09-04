//Universidad del Valle de Guatemala
//Autor: Daniela Ramírez de León
//No. Carné: 23053
//Programación Orientada a Objetos
//Ejercicio 3 - Arreglos Dinámicos
import java.util.ArrayList;
import java.util.List;

class Estudiante {
    private String nombre;
    private String apellido;
    private String codigo;
    private String fechaNacimiento;
    private String correo;
    private Sede sede;
    private List<Float> notas; // Lista para almacenar las notas de los exámenes

    public Estudiante(String nombre, String apellido, String codigo, String fechaNacimiento, String correo, Sede sede) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigo = codigo;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.sede = sede;
        this.notas = new ArrayList<>(); // Inicializa la lista de notas
    }

    public void agregarNota(float nota) {
        notas.add(nota);
    }

    // Getters para acceder a las propiedades privadas
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public Sede getSede() {
        return sede;
    }

    public List<Float> getNotas() {
        return notas;
    }
}