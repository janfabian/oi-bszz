quicksort = (array, left = 0, right = array.length - 1) ->
  return array if left is right
  pivot         = array[left]
  leftBarrier   = left
  rightBarrier  = right

  while left <= right
    left++  while array[left]   < pivot
    right-- while array[right]  > pivot
    if left < right 
      [array[left], array[right]] = [array[right], array[left]]
      left++; right--
    else if left is right then left++; right--
  
  quicksort array, leftBarrier, right if leftBarrier  < right
  quicksort array, left, rightBarrier if left         < rightBarrier
  array

console.log quicksort [-3, 2, 2, 0, -3, -3, -3, 9, 0, 0]
console.log quicksort [-3]