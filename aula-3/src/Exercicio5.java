import java.util.ArrayList;

interface IForma {
    void calcularArea();
    void calcularPerimetro();
}

abstract class Forma implements IForma {
    protected double area;
    protected double perimetro;

    public void mostrarDados() {
        System.out.println("área: " + this.area);
        System.out.println("perímetro: " + this.perimetro);
    }
}

class Circulo extends Forma {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    public void calcularArea() {
        this.area = 2 * Math.PI * (this.raio * this.raio);
    }

    @Override
    public void calcularPerimetro() {
        this.perimetro = 2 * Math.PI * this.raio;
    }
}

class Retangulo extends Forma {
    private double altura;
    private double largura;

    public Retangulo(double altura, double largura) {
        this.altura = altura;
        this.largura = largura;
    }

    @Override
    public void calcularArea() {
        this.area = this.altura * this.largura;
    }

    @Override
    public void calcularPerimetro() {
        this.perimetro = (this.altura * 2) + (this.largura * 2);
    }
}

public class Exercicio5 {
    public static void main(String[] args) {
        ArrayList<Forma> formas = new ArrayList<>();

        Forma rentangulo = new Retangulo(10, 10);
//        rentangulo.calcularArea();
//        rentangulo.calcularPerimetro();
//        rentangulo.mostrarDados();

        Forma circulo = new Circulo(10);
//        circulo.calcularPerimetro();
//        circulo.calcularArea();
//        circulo.mostrarDados();

        formas.add(rentangulo);
        formas.add(circulo);
    }
}
