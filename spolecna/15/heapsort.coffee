heapSort = (array, n = array.length - 1) ->
  repairTop = (array, top, bottom) ->
    i     = top
    j     = i * 2 + 1
    topVal= array[top]
    j++ if j < bottom and array[j] < array[j+1]
    while j <= bottom and topVal < array[j]
      array[i] = array[j]
      i  = j
      j *= 2 + 1
      j++ if j < bottom and array[j] < array[j+1]
    array[i]  = topVal
  
  for i in [Math.floor(n/2)..0] by -1 then repairTop(array, i, n) 
  for i in [n..0] by -1
    [array[0], array[i]] = [array[i], array[0]]
    repairTop array, 0, i-1
  array
        
console.log heapSort [ 1, 2, 3, -2, 0, 11, -2, 4 ]
console.log heapSort [ 1, -1 ]
console.log heapSort [ 0 ]