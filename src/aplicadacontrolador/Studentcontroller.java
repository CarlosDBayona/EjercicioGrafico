/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicadacontrolador;
import aplicadadatos.Student;
import aplicadaservicios.Studentservice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import aplicadavista.Studentview;
import javax.swing.JOptionPane;
/**
 *
 * @author Labing
 */
public class Studentcontroller implements ActionListener{
    private Studentview vista;
    private Studentservice modelo;
    public Studentcontroller(Studentview vista){
        this.vista=vista;
        this.modelo=new Studentservice();//conectado al modelo
        this.vista.setController(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("OK")){
        String name=this.vista.getTfName().getText();
        int roolno= Integer.parseInt(this.vista.getTfRoll().getText());
        Student student=new Student();
        student.setName(name);
        student.setRollno(roolno);
        this.modelo.insertar(student);
        this.vista.listaStudents(this.modelo.tamanoStudent());
        //redireccionar a la vista
        }
        else{
            if(e.getActionCommand().equals("Listar")){
                this.vista.listarSrudents(this.modelo.getBaseDatos());
                
            }
            else{
                if(e.getActionCommand().equals("Borrar")){
                    boolean flag=false;
                    String nombre=this.vista.getTfName().getText();
                    int Roll=Integer.parseInt(this.vista.getTfRoll().getText());
                    for (int i = 0; i < this.modelo.getBaseDatos().size(); i++) {
                        if(this.modelo.getBaseDatos().get(i).getName().equalsIgnoreCase(nombre)){
                            if(this.modelo.getBaseDatos().get(i).getRollno()==Roll){
                                this.modelo.getBaseDatos().remove(i);
                                flag=true;
                                break;
                            }
                        }
                    }
                    this.vista.BorrarStudents(flag);
                }else{
                    if(e.getActionCommand().equals("Actualizar")){
                        boolean flag=false;
                        String nombre=this.vista.getTfName().getText();
                        int Roll=Integer.parseInt(this.vista.getTfRoll().getText());
                        for (int i = 0; i < this.modelo.getBaseDatos().size(); i++) {
                            if(this.modelo.getBaseDatos().get(i).getName().equalsIgnoreCase(nombre)){
                                this.modelo.getBaseDatos().get(i).setRollno(Roll);
                                flag=true;
                                break;
                            }
                        }
                        this.vista.ActualizarStudents(flag);
                    }
                }
            }
        }
    }
    public void startApplication(){
        this.vista.setVisible(true);
    }
 //actualizar   
}
