import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("ALL")
public class Buscador implements Observer {
    ArrayList<String> pdf;
    Line numeroPaginas;
    Alphabetizer alphabetizer;

    public Buscador(ArrayList<String> pdf, Line numeroPaginas) {
        this.pdf = pdf;
        this.numeroPaginas = numeroPaginas;
        alphabetizer = new Alphabetizer(this.numeroPaginas);
        numeroPaginas.addObserver(alphabetizer);
    }

    @Override
    public void update(Observable o, Object arg) {
        String palabraClave = arg.toString().toLowerCase();
        String temp = "";

        for (int i = 0; i < pdf.size(); i++){
            //pdf.get(i).toLowerCase().contains(palabraClave)
            //"\n\ndafcourse dsgds\n\r".matches(".*[^\\r\\n]+"+palabraClave+"\\s"+"[^\\r\\n]+.*"
            // palabra  {4,2,3,45,}
            if (pdf.get(i).toLowerCase().contains(palabraClave)){
                temp += (i+1)+",";
            }
        }
        temp = temp.substring(0,temp.length()-1);
        numeroPaginas.insert(palabraClave+"\t\t"+"{"+temp+"}");

    }
}
