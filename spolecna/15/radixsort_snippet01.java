void radix_sort (String [] a) {
  int len   = ...; // number of chars used (2^16?)
  int [] z  = new int [len];
  int [] k  = new int [len];
  int [] z1 = new int [len];
  int [] k1 = new int [len];
  int [] d  = new int [a.length];
  int [] d1 = new int [a.length];
  int [] aux;
  initStep(a, z, k, d);       
  for (int p = a[0].length()-2; p >= 0; p-- ) {
    radixStep(a, p, z, k, d, z1, k1, d1); 
    aux = z; z = z1; z1 = aux;      
    aux = k; k = k1; k1 = aux;      
    aux = d; d = d1; d1 = aux;      
  } 
  output(a, z, k, d);             
}