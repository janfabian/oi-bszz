/**
 * Slevani pro Merge sort 
 * @param array pole k serazeni
 * @param aux pomocne pole (stejne velikosti jako razene)
 * @param left prvni index, na ktery smim sahnout
 * @param right posledni index, na ktery smim sahnout
 */
private static void merge(int[] array, int[] aux, int left, int right) {
    int middleIndex = (left + right)/2;
    int leftIndex = left; 
    int rightIndex = middleIndex + 1;
    int auxIndex = left;
    while(leftIndex <= middleIndex && rightIndex <= right) {
        if (array[leftIndex] >= array[rightIndex]) {
            aux[auxIndex] = array[leftIndex++];
        } else {
            aux[auxIndex] = array[rightIndex++];
        }
        auxIndex++;
    }
    while (leftIndex <= middleIndex) {
        aux[auxIndex] = array[leftIndex++];
        auxIndex++;
    }
    while (rightIndex <= right) {
        aux[auxIndex] = array[rightIndex++];
        auxIndex++;
    }
}    
