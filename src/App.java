public class App {
    public static void main(String[] args) throws Exception {

        Carro basico = new Carro("Basico", TipoCombustivel.GASOLINA, 10, 55);
        Carro esportivo = new Carro("Esportivo", TipoCombustivel.GASOLINA, 6, 45);
        Carro utilitario = new Carro("Utilitario",TipoCombustivel.DIESEL, 10, 70);
        Carro suv = new Carro("SUV", new TanqueCombustivel(TipoCombustivel.FLEX, 55), TipoCombustivel.GASOLINA, 8, 55);
        Carro suvFlex = new Carro("SUVFlex", new TanqueCombustivel(TipoCombustivel.FLEX, 65), TipoCombustivel.FLEX, 8, 6, 65);

        System.out.println("Tipos de veiculos:");
        //System.out.println(basico);
        //System.out.println(esportivo);
        //System.out.println(utilitario);
        //System.out.println(suv);
        System.out.println(suvFlex);

        /*System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro basico com gasolina");
        basico.abastece(TipoCombustivel.GASOLINA, 55);
        System.out.println(basico);
        System.out.println("\nViajando com o carro basico");
        basico.viaja(250);
        basico.viaja(150);
        System.out.println(basico);*/
    }
}
