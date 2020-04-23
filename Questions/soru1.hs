take n ns = foldl coz [] ns
                where coz x y | ((length x) < n) = x ++ [y]
                               | otherwise = x ++ []
							   

drop n ns = foldl coz [] ns
                where coz x y | ((length ns) > ((length x)+n)) = x ++ [y]
							  | otherwise = (tail (x)) ++ [y]