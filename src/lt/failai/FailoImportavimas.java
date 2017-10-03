package lt.failai;

import lt.duombaze.MyDBModel;

import java.io.BufferedReader;
import java.io.FileReader;

public class FailoImportavimas {


    private FileReader _in = null;
    private BufferedReader _bufferis;





    public void importuotiAutomobilius(MyDBModel duombaze) {

        try {
            _in = new FileReader("auto.txt");
            _bufferis = new BufferedReader(_in);
        } catch (Exception e) {

        }
        try {
            String eilute = _bufferis.readLine();
            while (eilute != null) {
                String[] zodziai = eilute.split("\\|");
                duombaze.simpleExecute("INSERT INTO `Automobiliai` " +
                        "(`modelis`, `marke`, `aprasymas`, `max_greitis`) " +
                        "values " +
                        "('" + zodziai[0] + "','" + zodziai[1] + "','" + zodziai[2] + "','" + zodziai[3] + "')");
                eilute = _bufferis.readLine();
            }
            _bufferis.close();
            _in.close();
        } catch (Exception e) {

        }
    }

    public void importuotiBaudas(MyDBModel duombaze) {

        try {
            _in = new FileReader("baudos.txt");
            _bufferis = new BufferedReader(_in);
        } catch (Exception e) {

        }
        try {
            String eilute = _bufferis.readLine();
            while (eilute != null) {
                String[] zodziai = eilute.split("\\|");
                duombaze.simpleExecute("INSERT INTO `nusizengimas` " +
                        "(`auto_id`, `aprasymas`, `bauda`, `greitis`) " +
                        "values " +
                        "('" + zodziai[0] + "','" + zodziai[1] + "'," + zodziai[2] + ", " + zodziai[3] + ")");
                eilute = _bufferis.readLine();
            }
            _bufferis.close();
            _in.close();
        } catch (Exception e) {

        }
    }
}