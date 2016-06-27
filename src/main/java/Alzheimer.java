/**
 * Created by ezequiel on 25/06/16.
 */
import classes.Paciente;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Alzheimer {
    public static final void main(final String[] args) throws IOException {
        String filenameToRead = "data2.csv";
        String filenameToWrite = "data2-results.csv";
        ArrayList<Paciente> pacients = getPacientsFromFile(filenameToRead);
        processPacients(pacients);
        processResults(pacients);
        writePacientsResult(filenameToWrite,pacients);
    }

    public static ArrayList<Paciente> getPacientsFromFile(String fileName) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(fileName));
        String[] nextLine;
        ArrayList<Paciente> pacients = new ArrayList<Paciente>();
        // First line
        reader.readNext();
        while ((nextLine = reader.readNext()) != null) {
            if (nextLine != null) {
                Paciente pac = Paciente.createPacient(nextLine);
                pacients.add(pac);
            }
        }
        return pacients;

    }

    private static void processPacients(ArrayList<Paciente> pacients) {
        KieServices ks = KieServices.Factory.get();
        // From the kie services, a container is created from the classpath
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession ksession = kc.newKieSession("Alzheimer");
        for( Paciente pacient : pacients) {
            ksession.insert(pacient);
        }
        ksession.fireAllRules();
        ksession.dispose();
    }

    private static void processResults(ArrayList<Paciente> pacients) {
        KieServices ks = KieServices.Factory.get();
        // From the kie services, a container is created from the classpath
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession ksession = kc.newKieSession("Alzheimer-result");
        for( Paciente pacient : pacients) {
            ksession.insert(pacient);
        }
        ksession.fireAllRules();
        ksession.dispose();
    }

    private static void writePacientsResult(String fileName,ArrayList<Paciente> pacients) {
        boolean alreadyExists = new File(fileName).exists();

        try {
            // use FileWriter constructor that specifies open for appending
            CSVWriter csvOutput = new CSVWriter(new FileWriter(fileName, true), ',');
            String[] line = new String[10];
            line[0]   = "Id";
            line[1]   = "Orientación temporal";
            line[2]   = "Orientación espacial";
            line[3]   = "Daños aprendisaje";
            line[4]   = "Daños atencion calculo";
            line[5]   = "Daños memoria";
            line[6]   = "Daños lenguaje";
            line[7]   = "Debe consultar al médico";
            csvOutput.writeNext(line);
            for( Paciente pacient : pacients) {
                line[0] = Integer.toString(pacient.getId());
                line[1] = pacient.getOrientacionTemporal();
                line[2] = pacient.getOrientacionEspacial();
                line[3] = pacient.getDanosAprendisaje();
                line[4] = pacient.getDanosAtencionCalculo();
                line[5] = pacient.getDanosMemoria();
                line[6] = pacient.getDanosLenguaje();
                line[7] = Boolean.toString(pacient.isConsulta());
                csvOutput.writeNext(line);
            }
            csvOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for( Paciente pacient : pacients) {
        }
    }


}
