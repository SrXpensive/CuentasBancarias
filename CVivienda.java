public class CVivienda extends Cuenta{
    private double ingresoMensual;
    private double bonificacion;

    public CVivienda(String iban, double ingresoMensual, double bonificacion) {
        super(iban);
        this.ingresoMensual = ingresoMensual;
        this.bonificacion = bonificacion;
        this.setSaldo(2*this.ingresoMensual);
    }

    @Override
    public double interesesGenerados() {
        return (this.getSaldo()*interesAnual)/12+getBonificacion();
    }

    public double getIngresoMensual() {
        return ingresoMensual;
    }

    public double getBonificacion() {
        return bonificacion;
    }
}
