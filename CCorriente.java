public class CCorriente extends Cuenta{

    public CCorriente(String iban) {
        super(iban);
    }

    public CCorriente(String iban, double saldo) {
        super(iban, saldo);
    }

    @Override
    public double interesesGenerados() {
        return (this.getSaldo()*interesAnual)/100;
    }
}
