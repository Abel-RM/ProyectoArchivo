import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.File;
import java.io.IOException;

public class LeerPdf {

    public static void leer(String ruta, Line lines) {
        String parsedText = "";
        int lastPage = 0;
        try {
            PDDocument pdDocument = PDDocument.load(new File(ruta));
            PDFTextStripper pdfStripper = new PDFTextStripper();
            lastPage = pdDocument.getNumberOfPages();
            for(int i=1; i<=lastPage; i++){
                pdfStripper.setStartPage(i);
                pdfStripper.setEndPage(i);
                parsedText = pdfStripper.getText(pdDocument);
                lines.insert(parsedText);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
