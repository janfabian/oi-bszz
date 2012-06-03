_ = require 'underscore'

radixSort = (array) ->
  [ z, k, d, z1, k1, d1 ] = [ {}, {}, [], {}, {}, [] ]
  # initStep
  for word, i in array 
    c = _.last(word)
    if _.isUndefined z[c] then z[c] = k[c] = i
    else 
      d[k[c]] = k[c]
      k[c]    = i
  
  radixStep = (pos) ->
    for letter, j of z
      loop
        c = array[j].charAt()
        if _.isUndefined z1[c] then z1[c] = k1[c] = j
        else 
          d1[k1[c]] = j
          k1[c]     = j
        break if j is k[letter]
        j = d[j]
      
  for i in [array[0].length-2..0] by -1
    radixStep i
    [z, k, d, z1, k1, d1] = [z1, k1, d1, z, k, d]
    
  array