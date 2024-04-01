import java.util.ArrayList;

public class Banca {
    public static ArrayList<Cuenta> cuentas = new ArrayList<>();
    public static void main(String[] args) {
        CCorriente cuenta1 = new CCorriente("ES23-4567-8765");
        CCorriente cuenta2 = new CCorriente("ES54-5674-8934",4500);
        CVivienda cuenta3 = new CVivienda("ES90-3241-4365",3400,450);
        CVivienda cuenta4 = new CVivienda("",1650,760);
        cuentas.add(cuenta1);
        cuentas.add(cuenta2);
        cuentas.add(cuenta3);
        cuentas.add(cuenta4);
        Cuenta.setInteresAnual(3.5);
        System.out.println("Intereses");
        System.out.println("----------");
        System.out.printf("Cuenta 1: %.2f",cuentas.get(0).interesesGenerados());
        System.out.println();
        System.out.printf("Cuenta 2: %.2f",cuentas.get(1).interesesGenerados());
        System.out.println();
        System.out.printf("Cuenta 3: %.2f",cuentas.get(2).interesesGenerados());
        System.out.println();
        System.out.printf("Cuenta 4: %.2f",cuentas.get(3).interesesGenerados());
        System.out.println();
        System.out.println("Cuenta 1: saldo antes del ingreso: "+cuentas.get(0).getSaldo());
        cuentas.get(0).ingresar(324.50);
        System.out.println("Cuenta 1: saldo despues del ingreso: "+cuentas.get(0).getSaldo());
        System.out.println("Cuenta 2: saldo antes de la retirada: "+cuentas.get(1).getSaldo());
        cuentas.get(1).retirar(324.24);
        System.out.println("Cuenta 2: saldo despues de la retirada: "+cuentas.get(1).getSaldo());
        System.out.println("Cuenta 4: saldo antes de la tranferencia a la cuenta 2: "+cuentas.get(3).getSaldo());
        cuentas.get(3).transferir(cuenta2,250.54);
        System.out.println("Tras la transferencia: Cuenta 4: "+cuentas.get(3).getSaldo()+", Cuenta 2: "+cuentas.get(1).getSaldo());
        System.out.println("Intento retirar una cantidad que no tengo: ");
        cuentas.get(3).retirar(4000);
        System.out.println("Ahora intento ingresar en la misma cuenta, pero: ");
        cuentas.get(3).ingresar(25);
    }
}
