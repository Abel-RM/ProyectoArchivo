import javax.swing.*;

public class BuscadorDePalabras {
    public static void main(String[] args) {
        Line palabrasClave = new Line();
        String ruta = "";
        boolean p = false;
        try {
            JFileChooser fileChooser = new JFileChooser("C:\\Users\\abely\\Desktop\\Maestria\\semestre 2\\Arquitectura\\Proyectos\\Proyecto-Archivo\\src");
            fileChooser.showOpenDialog(null);
            ruta = fileChooser.getSelectedFile().getAbsolutePath();
            p =true;
        }catch (Exception ignored){}

        Input.leer(ruta, palabrasClave);

        Line palabrasPdf = new Line();

        LeerPdf.leer(ruta, palabrasPdf);

        System.out.println(palabrasPdf);
    }

}
