/**
 * Created by ezequiel on 25/06/16.
 */
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;

public class Alzheimer {
    public static final void main(final String[] args) throws IOException {
        processFile();
    }

    public static void processFile() throws IOException {
        String fileName = "data.csv";
        CSVReader reader = new CSVReader(new FileReader(fileName));
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            if (nextLine != null) {

                System.out.print(nextLine);
            }
        }
    }



}
