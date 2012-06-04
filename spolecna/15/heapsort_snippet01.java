/**
 * Heapsort - razeni haldou
 * @param array pole k serazeni
 * @param descending true, pokud ma byt pole serazeno sestupne, false pokud vzestupne
 */
public static void heapSort(Comparable[] array, boolean descending) {
    for (int i = array.length / 2 - 1; i >= 0; i--) {
        repairTop(array, array.length - 1, i, descending ? 1 : -1);
    }
    for (int i = array.length - 1; i > 0; i--) {
        swap(array, 0, i);
        repairTop(array, i - 1, 0, descending ? 1 : -1);
    }
}

/**
 * Umisti vrchol haldy na korektni misto v halde (opravi haldu)
 * @param array pole k setrizeni
 * @param bottom posledni index pole, na ktery se jeste smi sahnout
 * @param topIndex index vrsku haldy
 * @param order smer razeni 1 == sestupne, -1 == vzestupne
 */
private static void repairTop(Comparable[] array, int bottom, int topIndex, int order) {
    Comparable tmp = array[topIndex];
    int succ = topIndex * 2 + 1;
    if (succ < bottom && array[succ].compareTo(array[succ + 1]) == order) {
        succ++;
    }

    while (succ <= bottom && tmp.compareTo(array[succ]) == order) {
        array[topIndex] = array[succ];
        topIndex = succ;
        succ = succ * 2 + 1;
        if (succ < bottom && array[succ].compareTo(array[succ + 1]) == order) {
            succ++;
        }
    }
    array[topIndex] = tmp;
}