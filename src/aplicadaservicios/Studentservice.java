/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicadaservicios;
import aplicadadatos.Student;
import java.util.ArrayList;
/**
 *
 * @author Labing
 */
public class Studentservice {
    //simular una base de datos
    ArrayList<Student> baseDatos;
    public Studentservice(){
        this.baseDatos=new ArrayList<Student>();
    }

    public ArrayList<Student> getBaseDatos() {
        return baseDatos;
    }

    public void setBaseDatos(ArrayList<Student> baseDatos) {
        this.baseDatos = baseDatos;
    }
    
    //Primer Servicio
    public void insertar(Student student){
        this.baseDatos.add(student);
    }
    public int tamanoStudent(){
        return this.baseDatos.size();
    }
}
