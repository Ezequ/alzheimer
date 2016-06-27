package classes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Leandro on 25/6/2016.
 */
public class Paciente {

    public static final int LOW = 1;
    public static final int MEDIUM = 2;
    public static final int HIGH = 3;
    public static String[] values = {"-","Bajo","Medio","Alto"};
    private int id;
    private int desempeno;
    private int desorientacion;
    private int ubicacion;
    private int comprension;
    private int planificar;
    private int iniciativa;
    private int personalidad;
    private int problemas;
    private int juicio;
    private int memoria;
    private int habla;

    private int orientacionTemporal;
    private int orientacionEspacial;
    private int danosAprendisaje;
    private int danosAtencionCalculo;
    private int danosMemoria;
    private int danosLenguaje;

    private int nivelesAltos;
    private int nivelesMedios;
    private int nivelesBajos;


    private boolean consulta;

    public Paciente(int desempeno, int desorientacion, int ubicacion, int comprension, int planificar, int iniciativa, int personalidad, int problemas, int juicio, int memoria, int habla, int id) {
        this.desempeno = desempeno;
        this.desorientacion = desorientacion;
        this.ubicacion = ubicacion;
        this.comprension = comprension;
        this.planificar = planificar;
        this.iniciativa = iniciativa;
        this.personalidad = personalidad;
        this.problemas = problemas;
        this.juicio = juicio;
        this.memoria = memoria;
        this.habla = habla;
        this.id = id;
        this.nivelesBajos=0;
        this.nivelesMedios=0;
        this.nivelesAltos=0;
    }

    public int getId() { return id; }

    public int getDesempeno() {
        return desempeno;
    }

    public void setDesempeno(int desempeno) {
        this.desempeno = desempeno;
    }

    public int getDesorientacion() {
        return desorientacion;
    }

    public void setDesorientacion(int desorientacion) {
        this.desorientacion = desorientacion;
    }

    public int getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getComprension() {
        return comprension;
    }

    public void setComprension(int comprension) {
        this.comprension = comprension;
    }

    public int getPlanificar() {
        return planificar;
    }

    public void setPlanificar(int planificar) {
        this.planificar = planificar;
    }

    public int getIniciativa() {
        return iniciativa;
    }

    public void setIniciativa(int iniciativa) {
        this.iniciativa = iniciativa;
    }

    public int getPersonalidad() {
        return personalidad;
    }

    public void setPersonalidad(int personalidad) {
        this.personalidad = personalidad;
    }

    public int getProblemas() {
        return problemas;
    }

    public void setProblemas(int problemas) {
        this.problemas = problemas;
    }

    public int getJuicio() {
        return juicio;
    }

    public void setJuicio(int juicio) {
        this.juicio = juicio;
    }

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    public int getHabla() {
        return habla;
    }

    public void setHabla(int habla) {
        this.habla = habla;
    }



    public static Paciente createPacient(String[] data) {
        int id = getAttributeValue(data, 0);
        int desempeno = getAttributeValue(data, 1);
        int desorientacion = getAttributeValue(data, 2);
        int ubicacion = getAttributeValue(data, 3);
        int comprension = getAttributeValue(data, 4);
        int planificar = getAttributeValue(data, 5);
        int iniciativa = getAttributeValue(data, 6);
        int personalidad = getAttributeValue(data, 7);
        int problemas = getAttributeValue(data, 8);
        int juicio = getAttributeValue(data, 9);
        int memoria = getAttributeValue(data, 10);
        int habla = getAttributeValue(data, 11);
        return new Paciente(desempeno, desorientacion, ubicacion, comprension, planificar, iniciativa, personalidad,
                problemas, juicio, memoria, habla, id);
    }


    protected static int getAttributeValue(String[] attributes, int position) {
        return position < attributes.length && !(attributes[position].equals("")) && Integer.valueOf(attributes[position]) >= 1 && Integer.valueOf(attributes[position]) <= 5 ? Integer.valueOf(attributes[position]) : 1;
    }

    // Setters de atributos finales //

    public void setOrientacionTemporal(int orientacionTemporal) {
        this.orientacionTemporal = orientacionTemporal;
    }

    public void setOrientacionEspacial(int orientacionEspacial) {
        this.orientacionEspacial = orientacionEspacial;
    }

    public void setDanosAprendisaje(int danosAprendisaje) {
        this.danosAprendisaje = danosAprendisaje;
    }

    public String getOrientacionTemporal() {
        return transformValue(orientacionTemporal);
    }

    public String getOrientacionEspacial() {
        return transformValue(orientacionEspacial);
    }

    public String getDanosAprendisaje() {
        return transformValue(danosAprendisaje);
    }

    public String getDanosAtencionCalculo() {
        return transformValue(danosAtencionCalculo);
    }

    public String getDanosMemoria() {
        return transformValue(danosMemoria);
    }

    public String getDanosLenguaje() {
        return transformValue(danosLenguaje);
    }

    public boolean isConsulta() {
        return consulta;
    }

    public String transformValue(int value) {
        return values[value];
    }


    public void setDanosAtencionCalculo(int danosAtencionCalculo) {
        this.danosAtencionCalculo = danosAtencionCalculo;
    }

    public void setDanosMemoria(int danosMemoria) {
        this.danosMemoria = danosMemoria;
    }

    public void setDanosLenguaje(int danosLenguaje) {
        this.danosLenguaje = danosLenguaje;
    }

    public void getNiveles(){
        if (this.nivelesAltos==0 && this.nivelesMedios ==0 && this.nivelesBajos==0){
            List<Integer> valores = new ArrayList();
            valores.add(this.orientacionTemporal);
            valores.add(this.orientacionEspacial);
            valores.add(this.danosAprendisaje);
            valores.add(this.danosAtencionCalculo);
            valores.add(this.danosMemoria);
            valores.add(this.danosLenguaje);
            Iterator it = valores.iterator();
            while (it.hasNext()){
                int valor =  (Integer)it.next();
                if (valor == 3){
                    this.nivelesAltos++;
                }
                if (valor == 2){
                    this.nivelesMedios++;
                }
                if (valor == 1){
                    this.nivelesBajos++;
                }
            }
        }
    }

    public void setConsulta(boolean consulta) {
        this.consulta = consulta;
    }

    public int getNivelesAltos() {
        this.getNiveles();
        return nivelesAltos;
    }

    public void setNivelesAltos(int nivelesAltos) {
        this.nivelesAltos = nivelesAltos;
    }

    public int getNivelesMedios() {
        this.getNiveles();
        return nivelesMedios;
    }

    public void setNivelesMedios(int nivelesMedios) {
        this.nivelesMedios = nivelesMedios;
    }

    public int getNivelesBajos() {
        this.getNiveles();
        return nivelesBajos;
    }

    public void setNivelesBajos(int nivelesBajos) {
        this.nivelesBajos = nivelesBajos;
    }
}