import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String rutaPdf = escogerArchivo("Escoge el archivo pdf");
        if (rutaPdf != null){
            String rutaTxt = escogerArchivo("Escoge el archivo de palabras clave");

            if (rutaTxt != null){
                Line palabrasClave = new Line();
                Line palabrasPdf = new Line();
                Line numeroPaginas = new Line();

                ArrayList<String> pdf = palabrasPdf.getAll();

                Buscador buscador = new Buscador(pdf, numeroPaginas);
                palabrasClave.addObserver(buscador);


                LeerPdf.leer(rutaPdf, palabrasPdf);
                Input.leer(rutaTxt, palabrasClave);
                String rutaOut = escogerArchivo("Escoge la ruta del archivo de salida");
                Output.escribir(rutaOut, numeroPaginas);


            }
        }
    }

    private static String escogerArchivo(String titulo){
        String ruta = null;
        int opc = 1;
        do{
            try {
                JFileChooser fileChooser = new JFileChooser("C:\\Users\\abely\\Desktop\\Maestria\\semestre 2\\Arquitectura\\Proyectos\\Proyecto-Archivo\\src");
                fileChooser.setDialogTitle(titulo);
                fileChooser.showOpenDialog(null);
                ruta = fileChooser.getSelectedFile().getAbsolutePath();
                opc = 1;
            }catch (Exception e){
                opc = JOptionPane.showConfirmDialog(null, "¿quieres terminar el programa?", "Salir", JOptionPane.OK_CANCEL_OPTION);
            }

        }while(opc == 2);

        return ruta;
    }

}