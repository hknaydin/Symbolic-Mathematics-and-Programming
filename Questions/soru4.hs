add :: Num a =>[a] -> [a] -> [a]
add [] _ = []
add (x:b) (y:i) = (x + y) :add b i


fAdd :: Num a => [[a]] -> [[a]] -> [[a]]
fAdd [] _ = []
fAdd (n:ns) (m:ms) = add n m : fAdd ns ms

--_____________________________________________

diva :: Fractional a => [a] -> a -> [a]
diva [] _ = []
diva x y = [sayi/y|sayi<-x]


fDiv :: Fractional a => [[a]] -> a -> [[a]]
fDiv [] _ = []
fDiv n m = [diva satir m | satir<-n ]
--______________________________________________

transpozal::Num a => [[a]]->[[a]] 
transpozal ([]:_) = []
transpozal x = (map head x) : transpozal (map tail x)

mul ::  Num a => [a] -> [a] -> [a]
mul [] _ = []
mul (e:es) (d:ds) = e * d : mul es ds

fMul :: Num a => [[a]] -> [[a]] -> [[a]]
fMul [] _ = []
fMul n m = [ [sum  (mul satirN satirM) | satirM <- ( transpozal m )] | satirN <- n ]
