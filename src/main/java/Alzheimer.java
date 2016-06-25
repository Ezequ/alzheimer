/**
 * Created by ezequiel on 25/06/16.
 */
import com.opencsv.CSVReader;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Alzheimer {
    public static final void main(final String[] args) throws IOException {
        processFile();
    }

    public static void processFile() throws IOException {
        String fileName = "data.csv";
        CSVReader reader = new CSVReader(new FileReader(fileName));
        String[] nextLine;
        ArrayList<Paciente> pacients = new ArrayList<Paciente>();
        while ((nextLine = reader.readNext()) != null) {
            if (nextLine != null) {
                Paciente pac = Paciente.createPacient(nextLine);
                pacients.add(pac);
            }
        }
        processPacients(pacients);
    }

    private static void processPacients(ArrayList<Paciente> pacients) {
        KieServices ks = KieServices.Factory.get();
        // From the kie services, a container is created from the classpath
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession ksession = kc.newKieSession("AlzheimerKS");
        ksession.setGlobal( "list",
                new ArrayList<Object>() );
        for( Paciente pacient : pacients) {
            ksession.insert(pacient);
        }
        ksession.fireAllRules();
        ksession.dispose();
    }


}
