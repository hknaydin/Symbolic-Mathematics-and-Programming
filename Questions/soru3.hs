gray :: [[[Char]]]
gray = ["0","1"] : [ addbit (concatreverse bs) | bs <- gray]
    where concatreverse xs = xs ++ (reverse xs)
          addbit xs = [if n < (halfLength )then "0" ++x else "1" ++ x | (x, n)<- zip xs [0..] ]
            where halfLength = div (length xs) 2