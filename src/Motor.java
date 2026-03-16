public class Motor {

    private TipoCombustivel tipoMotor;
    private int consumo; // em quilometros por unidade. Ex: Km/Lt
    private int quilometragem;
    private in consumoAlcool;

    public Motor(TipoCombustivel tipoMotor, int consumo) {
        this.tipoMotor = tipoMotor;
        this.consumo = consumo;
    }

    public Motor(TipoCombustivel tipoMotor1, int consumo1, int consumo2) {
        this.tipoMotor = tipoMotor1;
        this.consumo = consumo1;
        this.consumoAlcool = consumo2;
    }

    public int getConsumo() {
        return this.consumo;
    }

    public TipoCombustivel getTipoMotor(){
        return this.tipoMotor;
    }

    public int getQuilometragem(){
        return this.quilometragem;
    }

    public int combustivelNecessario(int distancia) {
        return distancia / consumo;
    }

    public void percorre(int distancia) {
        quilometragem += distancia;
    }

    @Override
    public String toString() {
        return "Motor [consumo=" + consumo + ", quilometragem=" + quilometragem + ", tipoMotor=" + tipoMotor + "]";
    }
}