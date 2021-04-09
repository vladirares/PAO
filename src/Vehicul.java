public abstract class Vehicul {
    protected final float coeficientViteza;
    protected final float coeficientVitezaOraDeVarf;
    protected final float coeficientConsum;
    private boolean esteVehiculPersonal;
    private float incarcaturaMaxima;

    public Vehicul(float coeficientViteza, float coeficientVitezaOraDeVarf, float coeficientConsum) {
        this.coeficientViteza = coeficientViteza;
        this.coeficientVitezaOraDeVarf = coeficientVitezaOraDeVarf;
        this.coeficientConsum = coeficientConsum;
    }

    public float getCoeficientViteza() {
        return coeficientViteza;
    }

    public float getCoeficientVitezaOraDeVarf() {
        return coeficientVitezaOraDeVarf;
    }

    public float getCoeficientConsum() {
        return coeficientConsum;
    }

    public float getIncarcaturaMaxima() {
        return incarcaturaMaxima;
    }

    public void setIncarcaturaMaxima(float incarcaturaMaxima) {
        this.incarcaturaMaxima = incarcaturaMaxima;
    }

    public boolean getEsteVehiculPersonal() {
        return esteVehiculPersonal;
    }

    public void setEsteVehiculPersonal(boolean esteVehiculPersonal) {
        this.esteVehiculPersonal = esteVehiculPersonal;
    }


}
