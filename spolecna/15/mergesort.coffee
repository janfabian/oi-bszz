mergeSort = (array, _left = 0, _right = array.length - 1) ->
  
  merge = (array) ->
    helperArray   = []
    rightBarrier  = array.length - 1
    middleBarrier = Math.floor rightBarrier/2
    left          = current = 0
    right         = middleBarrier + 1
    while left <= middleBarrier && right <= rightBarrier
      helperArray[current++] = if array[left] <= array[right] then array[left++] else array[right++]
    helperArray = helperArray.concat array.slice left, middleBarrier + 1
    helperArray = helperArray.concat array.slice right, rightBarrier + 1
    helperArray
  
  recursiveMergeSort = (left, right) ->  
    return array if left is right
    middle = Math.floor (left + right)/2
    # Dive into functional stack
    recursiveMergeSort left, middle
    recursiveMergeSort middle + 1, right
    # Here we come firstly with helperArray of size 2, or 1 for odd members of array
    helperArray = merge array.slice(left, right + 1)
    array.splice.apply array, [left, right + 1 - left].concat helperArray
    array

  recursiveMergeSort _left, _right  

console.log mergeSort [ 11, -2, 33, 0, 2, 2, -2, 1, 0 ]
console.log mergeSort [ 0, -1 ]
console.log mergeSort [ 9 ]