/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicadavista;
import aplicadadatos.Student;
import java.awt.Dimension;
import java.awt.FlowLayout;
import aplicadacontrolador.Studentcontroller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Labing
 */
public class Studentview extends JFrame{
    private JLabel lName; 
    private JTextField tfName;
    private JLabel lRoll;
    Studentcontroller Controller;
    private JTextField tfRoll;
    private JButton button;
    private JButton listar;
    private JButton borrar;
    public Studentview(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           
        setSize(new Dimension(150, 200)); 
        setTitle("A frame");
        setLayout(new FlowLayout());
        this.lName = new JLabel("Name: ");
        this.tfName = new JTextField(5);
        this.lRoll = new JLabel("Roll n°: ");
        this.tfRoll = new JTextField(5);
        this.button=new JButton("OK");
        this.listar=new JButton("Listar");
        this.borrar=new JButton("Borrar");
        setLayout(new FlowLayout());
        
        add(lName);
        add(tfName);
        add(lRoll);
        add(tfRoll);
        add(button);
        add(listar);
        add(borrar);
    
    }

    public JLabel getlName() {
        return lName;
    }

    public void setlName(JLabel lName) {
        this.lName = lName;
    }

    public JTextField getTfName() {
        return tfName;
    }

    public void setTfName(JTextField tfName) {
        this.tfName = tfName;
    }

    public JLabel getlRoll() {
        return lRoll;
    }

    public void setlRoll(JLabel lRoll) {
        this.lRoll = lRoll;
    }

    public JTextField getTfRoll() {
        return tfRoll;
    }

    public void setTfRoll(JTextField tfRoll) {
        this.tfRoll = tfRoll;
    }

    public Studentcontroller getController() {
        return Controller;
    }

    public void setController(Studentcontroller Controller) {
        this.Controller = Controller;
        this.button.addActionListener(Controller);
        this.listar.addActionListener(Controller);
        this.borrar.addActionListener(Controller);
    }
    
    public void listaStudents(int tamano){
        JOptionPane.showMessageDialog(null, tamano);
    }
    public void listarSrudents(ArrayList<Student> lista){
        JFrame frame=new JFrame();
        JPanel panel=new JPanel();
        frame.setSize(150, 150);
        panel.setMinimumSize(new Dimension(500,500));
        panel.setBorder(BorderFactory.createTitledBorder("Nombre / Roll Nº"));
        String[] datos=new String[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            datos[i]=lista.get(i).getName()+" / "+Integer.toString(lista.get(i).getRollno());
        }
        JList list=new JList(datos);
        list.setMinimumSize(new Dimension(200,200));
        list.setMaximumSize(new Dimension(300,300));
        panel.add(list);
        frame.add(panel);
        frame.setVisible(true);
    }
    public void BorrarStudents(Boolean flag){
        if (flag) {
            JOptionPane.showMessageDialog(null, "Se Ha eleiminado el estudiante correctamente");
        }else{
            JOptionPane.showMessageDialog(null, "No se ha podido eliminar");
        }
    }
}
