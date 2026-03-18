public class Carro {

    private String modelo;
    private Motor motor;
    private TanqueCombustivel tanque;

    public Carro(String modelo, TipoCombustivel tipoCombustivel, int consumoMotor, int capacidadeTanque) {
        this.modelo = modelo;
        motor = new Motor(tipoCombustivel, consumoMotor);
        tanque = new TanqueCombustivel(tipoCombustivel, capacidadeTanque);
    }
    
public Carro(String modelo, TanqueCombustivel tanque, TipoCombustivel tipoCombustivel, int consumoMotor, int capacidadeTanque) {
        this.modelo = modelo;
        motor = new Motor(tipoCombustivel, consumoMotor);
        this.tanque = tanque;
    }
    
    public Carro(String modelo, TanqueCombustivel tanque, TipoCombustivel tipoCombustivel, int consumoGasolina, int consumoAlcool, int capacidadeTanque) {
        this.modelo = modelo;
        motor = new Motor(tipoCombustivel, consumoGasolina, consumoAlcool);
        this.tanque = tanque;
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
        if(motor.getConsumo() != 0 && motor.getConsumo2() != 0){
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
        TipoCombustivel tipoNoTanque = tanque.getTipoCombustivelAtual();
        int combustivelNecessario = motor.combustivelNecessario(distancia, tipoNoTanque);
        if (tanque.getCombustivelDisponivel() >= combustivelNecessario) {
            return distancia;
        } else {
            if (tipoNoTanque == TipoCombustivel.ALCOOL && motor.getConsumo2() > 0) {
                return tanque.getCombustivelDisponivel() * motor.getConsumo2();
            }
            return tanque.getCombustivelDisponivel() * motor.getConsumo();
        }
    }

    // Retorna true se conseguiu viajar
    public boolean viaja(int distancia) {
        TipoCombustivel tipoNoTanque = tanque.getTipoCombustivelAtual();
        int combustivelNecessario = motor.combustivelNecessario(distancia, tipoNoTanque);
        if (tanque.getCombustivelDisponivel() >= combustivelNecessario) {
            motor.percorre(distancia);
            tanque.gasta(combustivelNecessario);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Carro:\n  Modelo=" + modelo + "\n  Motor=" + motor + "\n  Tanque=" + tanque;
    }
}
