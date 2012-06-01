/** 
 * Razeni slevanim (od nejvyssiho)
 * @param array pole k serazeni
 * @param aux pomocne pole stejne delky jako array
 * @param left prvni index na ktery se smi sahnout
 * @param right posledni index, na ktery se smi sahnout
 */
public static void mergeSort(int[] array, int[] aux, int left, int right) {
    if(left == right) return; 
    int middleIndex = (left + right)/2;
    mergeSort(array, aux, left, middleIndex);
    mergeSort(array, aux, middleIndex + 1, right);
    merge(array, aux, left, right);
  
    for (int i = left; i <= right; i++) {
        array[i] = aux[i];
    }
}    

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
