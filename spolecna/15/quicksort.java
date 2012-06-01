class quicksort {
  public static void main(String[] args) {
    int[] array = { 1, 2, -1, 0, 11, -1, 22, 1 };
    qSort(array, 0, array.length - 1);
    for (int i : array) {
      System.out.print(i+" | ");
    }
  }

  private static void qSort(int a[], int low, int high) {
    int iL = low, iR = high;
    int pivot = a[low];
    do {
      while (a[iL] < pivot) iL++;
      while (a[iR] > pivot) iR--;
      if (iL < iR) {
        swap(a,iL, iR);
        iL++; iR--; }
      else
        if (iL == iR) { iL++; iR--;}
    } while( iL <= iR);
    if (low < iR)  qSort(a, low, iR);
    if (iL < high) qSort(a, iL, high);
  }  
  
  private static void swap(int a[], int i, int j) {
    int tmp = a[i];
    a[i]    = a[j];
    a[j]    = tmp ;
  }
}
