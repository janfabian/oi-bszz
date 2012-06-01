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
}