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