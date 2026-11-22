package exemplo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BubbleSortCoberturaTest {

    @Test
    void deveOrdenarDoisValoresInvertidos() {
        BubbleSort bubbleSort = new BubbleSort(new int[]{2, 1});

        bubbleSort.ordenar();

        assertArrayEquals(new int[]{1, 2}, bubbleSort.getNumeros());
    }
}
