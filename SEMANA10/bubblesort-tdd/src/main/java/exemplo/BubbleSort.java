package exemplo;

public class BubbleSort {

    private final int[] numeros;

    public BubbleSort(int[] numeros) {
        this.numeros = numeros;
    }

    public void ordenar() {
        for (int fim = numeros.length - 1; fim > 0; fim--) {
            boolean trocou = false;
            for (int atual = 0; atual < fim; atual++) {
                if (numeros[atual] > numeros[atual + 1]) {
                    int temporario = numeros[atual];
                    numeros[atual] = numeros[atual + 1];
                    numeros[atual + 1] = temporario;
                    trocou = true;
                }
            }
            if (!trocou) {
                break;
            }
        }
    }

    public int[] getNumeros() {
        return numeros;
    }
}
