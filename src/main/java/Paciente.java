/**
 * Created by Leandro on 25/6/2016.
 */
public class Paciente {

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

    private boolean consulta;

    public Paciente(int desempeno, int desorientacion, int ubicacion, int comprension, int planificar, int iniciativa, int personalidad, int problemas, int juicio, int memoria, int habla) {
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
    }

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

    public int getOrientacionTemporal() {
        return orientacionTemporal;
    }

    public void setOrientacionTemporal(int orientacionTemporal) {
        this.orientacionTemporal = orientacionTemporal;
    }
}