public class Carro {

    private String modelo;
    private Motor motor;
    private TanqueCombustivel tanque;

    public Carro(String modelo, TipoCombustivel tipoCombustivel, int consumoMotor, int capacidadeTanque) {
        this.modelo = modelo;
        motor = new Motor(tipoCombustivel, consumoMotor);
        tanque = new TanqueCombustivel(tipoCombustivel, capacidadeTanque);
    }
    
    public Carro(String modelo, TanqueCombustivel TanqueCombustivel, TipoCombustivel tipoCombustivel, int consumoMotor, int capacidadeTanque) {
        this.modelo = modelo;
        motor = new Motor(tipoCombustivel, consumoMotor);
        tanque = new TanqueCombustivel(TanqueCombustivel, capacidadeTanque);
    }

    public Carro(String modelo, TanqueCombustivel TanqueCombustivel, TipoCombustivel tipoCombustivel, int consumoMotor1, int consumoMotor2, int capacidadeTanque) {
        this.modelo = modelo;
        motor = new Motor(tipoCombustivel1, consumoMotor1, consumoMotor2);
        tanque = new TanqueCombustivel(TanqueCombustivel, capacidadeTanque);
    }

    public String getModelo() {
        return modelo;
    }

    public int getCombustivelDisponivel() {
        return tanque.getCombustivelDisponivel();
    }

    // Retorna a quantidade efetivamente abastecida
    public int abastece(TipoCombustivel tipoCombustivel, int quantidade) {
        int capacidadeLivre = tanque.getCapacidade() - tanque.getCombustivelDisponivel();
        if(Motor.consumo1 != 0 && Motor.consumo2 != 0){
            if (capacidadeLivre < quantidade) {
                tanque.abastece(tipoCombustivel, capacidadeLivre);
                return capacidadeLivre;
            } else {
                tanque.abastece(tipoCombustivel, quantidade);
                return quantidade;
            }
        }else{
            if (capacidadeLivre < quantidade) {
                tanque.abastece(tipoCombustivel, capacidadeLivre);
                return capacidadeLivre;
            } else {
                tanque.abastece(tipoCombustivel, quantidade);
                return quantidade;
            }
        }
    }

    // Retorna a distancia que consegue viajar com o combustivel remanescente
    public int verificaSePodeViajar(int distancia) {
        int combustivelNecessario = motor.combustivelNecessario(distancia);
        if (tanque.getCombustivelDisponivel() >= combustivelNecessario) {
            return distancia;
        } else {
            return tanque.getCombustivelDisponivel() * motor.getConsumo();
        }
    }

    // Retorna true se conseguiu viajar
    public boolean viaja(int distancia) {
        if (verificaSePodeViajar(distancia) >= distancia) {
            motor.percorre(distancia);
            tanque.gasta(motor.combustivelNecessario(distancia));
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Carro:\n  Modelo=" + modelo + "\n  Motor=" + motor + "\n  Tanque=" + tanque;
    }
}
