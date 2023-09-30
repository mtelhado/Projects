contaCaracteres :: (Eq a) => a -> [[a]] -> Int
contaCaracteres x y = sum [if x == n  then 1 else 0 |  ys <- y , n <- ys]

labInterior :: [String]
labInterior = ["*" ++ a ++ b ++ c ++ "*" | a <- ["S","F","*"," "] , b <- ["S","F","*"," "] , c <- ["S","F","*"," "] ]

labirintos5 :: [[String]]
labirintos5 = [["*****" , a , b , c , "*****" ] | a <- labInterior , b <- labInterior , c <- labInterior , contaCaracteres 'S' [a,b,c] == 1 ,  contaCaracteres 'F' [a,b,c] == 1]