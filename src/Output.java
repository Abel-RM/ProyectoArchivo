import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Output {

    public static void escribir(String ruta, Line np){
        ArrayList<String> salida = np.getAll();
        File fichero = new File(ruta);
        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(ruta));
            if (!fichero.exists()) {
                fichero.createNewFile();

            }

            for (String item : salida) {
                try {
                    bw.write(item + "\n");
                } catch (IOException var9) {
                    var9.printStackTrace();
                }
            }

            try {
                bw.close();
            } catch (IOException var8) {
                var8.printStackTrace();
            }


        } catch (IOException var10) {
            var10.printStackTrace();
        }




    }
}
