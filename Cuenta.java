public abstract class Cuenta {
    private String iban;
    private double saldo;
    private boolean bloqueada;
    public static double interesAnual;

    public Cuenta(String iban){
        this.iban = iban;
        this.saldo = 0;
        this.bloqueada = false;
    }
    public Cuenta(String iban, double saldo){
        this.iban = iban;
        this.saldo = saldo;
        this.bloqueada = false;
    }

    public static void setInteresAnual(double interesAnual) {
        Cuenta.interesAnual = interesAnual;
    }

    public String getIban() {
        return iban;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isBloqueada() {
        return bloqueada;
    }

    public static double getInteresAnual() {
        return interesAnual;
    }
    public boolean ingresar(double cantidad){
        if(isBloqueada()){
            System.out.println("Cuenta bloqueada. Abortando operación");
            return false;
        }else{
            saldo += cantidad;
            return true;
        }
    }
    public boolean retirar(double cantidad){
        if(isBloqueada()){
            System.out.println("Cuenta bloqueada. Abortando operación");
            return false;
        }else if(cantidad > saldo){
            this.bloqueada = true;
            System.out.println("La cantidad a retirar es superior al saldo. Procedemos a bloquear la cuenta");
            return false;
        }else{
            saldo -= cantidad;
            return true;
        }
    }

    public String transferir(Cuenta destino, double cantidad){
        if(this.retirar(cantidad) && destino.ingresar(cantidad)){
            return "Transferencia realizada";
        }else
            return "No se ha podido realizar la operación";
    }
    public abstract double interesesGenerados();

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
