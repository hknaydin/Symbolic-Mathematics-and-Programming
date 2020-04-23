fIdm n =  [ [if x == y then 1 else 0 | x <- [1..n]]
            | y <- [1..n]]