package model;

public class EquipeCirurgica {

    private Funcionario cirurgiaoPrincipal;

    private Funcionario cirurgiaoAssistente;

    private Funcionario enfermeiroChefe;

    private Funcionario anestesista;

    private Funcionario instrumentador;

    private Funcionario circulante;

    private int id;

    public EquipeCirurgica(Funcionario cirurgiaoPrincipal, Funcionario cirurgiaoAssistente, Funcionario enfermeiroChefe, Funcionario anestesista, Funcionario instrumentador, Funcionario circulante) {
        this.cirurgiaoPrincipal = cirurgiaoPrincipal;
        this.cirurgiaoAssistente = cirurgiaoAssistente;
        this.enfermeiroChefe = enfermeiroChefe;
        this.anestesista = anestesista;
        this.instrumentador = instrumentador;
        this.circulante = circulante;
       
    }

    public EquipeCirurgica() {
    }

    public Funcionario getCirurgiaoPrincipal() {
        return cirurgiaoPrincipal;
    }

    public void setCirurgiaoPrincipal(Funcionario cirurgiaoPrincipal) {
        this.cirurgiaoPrincipal = cirurgiaoPrincipal;
    }

    public Funcionario getCirurgiaoAssistente() {
        return cirurgiaoAssistente;
    }

    public void setCirurgiaoAssistente(Funcionario cirurgiaoAssistente) {
        this.cirurgiaoAssistente = cirurgiaoAssistente;
    }

    public Funcionario getEnfermeiroChefe() {
        return enfermeiroChefe;
    }

    public void setEnfermeiroChefe(Funcionario enfermeiroChefe) {
        this.enfermeiroChefe = enfermeiroChefe;
    }

    public Funcionario getAnestesista() {
        return anestesista;
    }

    public void setAnestesista(Funcionario anestesista) {
        this.anestesista = anestesista;
    }

    public Funcionario getInstrumentador() {
        return instrumentador;
    }

    public void setInstrumentador(Funcionario instrumentador) {
        this.instrumentador = instrumentador;
    }

    public Funcionario getCirculante() {
        return circulante;
    }

    public void setCirculante(Funcionario circulante) {
        this.circulante = circulante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    
    
    
    
    
}
