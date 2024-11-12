package view;

import src.controller.Ordenamientos;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*; 

public class GUI implements ActionListener{
    JFrame ventana;
    JTextField txtDatos;
    JLabel lblIngreso, mensaje, tiempoEjecucion,tiempoEjecucion2;
    JList<Integer> listaDatos,listaDatos2, listaDatos3,listaDatos4;
    DefaultListModel<Integer> modelo, modelo2, modelo3, modelo4;
    JScrollPane scrollLista, scrollLista2, scrollLista3, scrollLista4;
    JButton agregar, eliminar, borrar, quickSort, shellSort;
    Ordenamientos ordenamientos;

    public GUI (){
        ventana = new JFrame();
        lblIngreso = new JLabel("Ingresar dato: ");
        txtDatos = new JTextField();
        txtDatos.setBounds(685, 20, 150, 40);

        txtDatos.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){  
            agregarDato();
            }
        });

        modelo = new DefaultListModel<>();
        modelo2 = new DefaultListModel<>();
        modelo3 = new DefaultListModel<>();
        modelo4 = new DefaultListModel<>();

        //Jlist datos
        listaDatos = new JList<>(modelo);
        listaDatos2= new JList<>(modelo2);
        listaDatos3 = new JList<>(modelo3);
        listaDatos4 = new JList<>(modelo4);

        scrollLista = new JScrollPane(listaDatos);
        scrollLista.setBounds(120,120,350,220);
        listaDatos.setForeground(Color.BLUE);

        scrollLista2 = new JScrollPane(listaDatos2);
        scrollLista2.setBounds(600, 120, 350,220);
        listaDatos2.setForeground(Color.GREEN);

        scrollLista3 = new JScrollPane(listaDatos3);
        scrollLista3.setBounds(120, 450, 350,220);
        listaDatos3.setForeground(Color.PINK);

        scrollLista4 = new JScrollPane(listaDatos4);
        scrollLista4.setBounds(600, 450, 350,220);
        listaDatos4.setForeground(Color.RED);

        //scrollLista.setViewportView();

        agregar = new JButton("Agregar");
        agregar.setBounds(375, 70, 170, 30);
        agregar.addActionListener(this);

        eliminar = new JButton("Eliminar");
        eliminar.setBounds(590, 70, 170, 30);
        eliminar.addActionListener(this);

        borrar = new JButton("Borrar lista");
        borrar.setBounds(870,70,170,30);
        borrar.addActionListener(this);

        quickSort = new JButton("QuickSort");
        quickSort.setBounds(215, 380,170, 30);

        ordenamientos = new Ordenamientos(); //MOVER DE LUGAR

        quickSort.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                qsort();
            }
        });
        
        shellSort = new JButton("ShellSort");
        shellSort.setBounds(700, 380,170,30);

        shellSort.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ssort();
            }
        });

        tiempoEjecucion = new JLabel();
        tiempoEjecucion.setBounds(895, 198, 300, 300);

        tiempoEjecucion2 = new JLabel();
        tiempoEjecucion2.setBounds(405,198,300,300);

        mensaje = new JLabel();
        mensaje.setBounds(670, 90, 220,40);

        ventana.setLayout(null);
        ventana.add(lblIngreso);
        ventana.add(txtDatos);
        ventana.add(scrollLista);
        ventana.add(scrollLista2);
        ventana.add(scrollLista3);
        ventana.add(scrollLista4);
        ventana.add(agregar);
        ventana.add(eliminar);
        ventana.add(borrar);
        ventana.add(quickSort);
        ventana.add(shellSort);
        ventana.add(mensaje);
        ventana.add(tiempoEjecucion);
        ventana.add(tiempoEjecucion2);

        ventana.setSize(1600, 800);
        ventana.setVisible(true);  
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

        public void actionPerformed(ActionEvent evento) {
            if (evento.getSource() == agregar) {
                agregarDato();
                mensaje.setText("Se agregó un nuevo elemento");
            } else if ( evento.getSource() == eliminar){
                eliminarDato(listaDatos.getSelectedIndex());
                eliminarDato(listaDatos2.getSelectedIndex());
                eliminarDato(listaDatos3.getSelectedIndex());
                eliminarDato(listaDatos4.getSelectedIndex());
            } else if (evento.getSource() == borrar) {
                borrarLista();
                mensaje.setText("Se borró la lista");
            }
        }

        private void agregarDato(){
            try {
                Integer Dato = Integer.parseInt(txtDatos.getText());
                modelo.addElement(Dato);
                modelo2.addElement(Dato);
                modelo3.addElement(Dato);
                modelo4.addElement(Dato);
                txtDatos.setText("");
            } catch(NumberFormatException e) {
                mensaje.setText("Error: Ingrese un numero valido");
            }
        }

        private void eliminarDato(int indice){
            if (indice >=0){
                modelo.removeElementAt(indice);
                modelo2.removeElementAt(indice);
                modelo3.removeElementAt(indice);
                modelo4.removeElementAt(indice);
            }else{
                mensaje.setText("NO se seleccionó ningún elemento");
            }
        }

        private void borrarLista(){
            modelo.clear();
            modelo2.clear();
            modelo3.clear();
            modelo4.clear();
            tiempoEjecucion.setText(null);
            tiempoEjecucion2.setText(null);
        }

    /*     public static void main(String[] args) {
            new GUI(); // Crear instancia de GUI para mostrar la ventana
        }*/

        //metodos para convertir las JListas a arreglo tipo INTEGER (Paramentro en Ordenamientos)
        private void qsort(){
            Integer [] lista = new Integer[modelo.getSize()];
            for (int i = 0; i < modelo.getSize(); i++){
                lista[i]= modelo.getElementAt(i);
            }
            
            long init = System.currentTimeMillis();

            ordenamientos.quickSort(lista);

            long end = System.currentTimeMillis();
            modelo.clear();
            
            //ahora que la lista ya esta ordenada, lo devuelve a JLista
            for (Integer numero : lista) {
                modelo.addElement(numero);
            }

            long tiempo = end - init;
            tiempoEjecucion2.setText("Quick Sort: " + tiempo + "ms");
        }

        private void ssort(){
            Integer [] lista = new Integer[modelo2.getSize()];
            for (int i = 0; i< modelo2.getSize(); i++){
                lista[i]=modelo2.getElementAt(i);
            }

            long init = System.currentTimeMillis();

            ordenamientos.shellSort(lista, lista.length);

            long end = System.currentTimeMillis();
            modelo2.clear();

            for (Integer numero : lista) {
                modelo2.addElement(numero);
            }

            long tiempo = end - init;
            tiempoEjecucion.setText("Shell Sort: " + tiempo +  "ms");
        }
      /*   private void calcularTiempo(long tiempoEjecucion){
            TiempoEjecucion.setText(tiempoEjecucion + " ms" );
        }
     */
}