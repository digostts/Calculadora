public class Numero {
    private double valor;

    public Numero() {
        this(0.0);
    }

    public Numero(double valor) {
        this.valor = valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return this.valor;
    }
}
