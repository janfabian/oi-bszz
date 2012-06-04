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

void initStep (String[] a, int[] z, int [] k, int[] d){
  int pos = a[0].length()-1;
  int c;             
  for (int i = 0; i < z.length; i++)    
    z[i] = k[i] = -1; // empty
    for (int i = 0; i < a.length; i++) {  
      c = (int) a[i].charAt(pos);         
      if (z[c] == -1)                        
      k[c]= z[c] = i;                    
      else {
      d[k[c]] = i;                 
      k[c] = i;
    } 
  } 
}

void radixStep(String[]a, int pos, int[] z, int[] k, 
  int[] d, int[] z1, int[] k1, int[] d1){
  int j;        
  int c;        
  for (int i = 0; i < z.length; i++)  
  z1[i] = k1[i] = -1;            
  for (int i = 0; i < z.length; i++)  
    if (z[i] != -1) {                 
      j = z[i];                      
      while (true) {                  
        c = (int) a[j].charAt(pos);   
        if (z1[c] == -1)            
          k1[c]= z1[c] = j;           
        else {
          d1[k1[c]] = j;           
          k1[c2] = j;
        }
      if (j == k[i]) break;
      j = d[j];                     
    }   
  } 
}