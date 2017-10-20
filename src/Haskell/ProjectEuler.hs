-- Haskell impl for project Euler questions
module ProjectEuler where

import Data.List

--Problem 1: Find sum of multiples of 3 or 5
sOfm :: Int -> Int
sOfm x = sum ((multiple 3 1 x) `union` (multiple 5 1 x))

multiple :: Int -> Int -> Int -> [Int]
multiple x y z 
  | x*y < z  = (x*y) : (multiple x (y+1) z )
  | otherwise = []
  
  
--Problem 2: Even fibonacci

evenFibSum :: Int -> Int
evenFibSum limit = sum $ (getEven limit) $ fib

getEven :: Int -> [Int] -> [Int]
getEven _ [] = []
getEven limit (x:xs) 
  | x`mod`2 == 0 && x <= limit = x : getEven limit xs
  | x <= limit             = getEven limit xs
  | otherwise              = []
  
fib :: [Int]
fib = 1:2:fib' 1 2
  where fib' x y = (x+y) : fib' y (x+y) 
  
-- Problem 3: Largest Prime factor

lpf :: Int -> Int
lpf x = undefined

--Problem 4: largest palindrome product-  largest palindrome made from the product of two 3-digit numbers

lpp :: Int
lpp = maximum [p | x <- [100..999], y <- [100..999], let p = x*y, isPalindrome p ]

isPalindrome :: Int -> Bool
isPalindrome x = x == (rev x)

rev :: Int -> Int
rev x = sumOfDigits 0 x
  where
    sumOfDigits :: Int -> Int -> Int
    sumOfDigits s 0 = s
    sumOfDigits s y = sumOfDigits ((s * 10) + y `mod`10) (y `div` 10) 
    
--Problem 5: What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20

evenDiv :: Int -> Int
evenDiv y = check y y

check :: Int -> Int -> Int
check x y | divAllVal x y = x
          | otherwise     = check (x+1) y

divAllVal :: Int -> Int -> Bool
divAllVal _ 1 = True
divAllVal x y = (x`mod`y == 0) && (divAllVal x (y-1))

-- Problem 6: difference between the sum of the squares of the first one hundred natural numbers and the square of the sum

sumSquareDiff :: Int-> Int
sumSquareDiff n = abs $ ((sumOfVals n * sumOfVals n) - (sumOfSquare n))

sumOfVals :: Int -> Int
sumOfVals n = (n*(n+1)) `div` 2

sumOfSquare :: Int -> Int
sumOfSquare 0 = 0
sumOfSquare n = (n*n) + sumOfSquare (n-1)

--Problem 7: nth Prime
nthPrime :: Int -> Int
nthPrime n = head (drop (n-1) primes)

primes :: [Int]
primes = [x | x <- [2..], isPrime x]--notDivisible x (x-1)]

--brute primality check. Inefficient
notDivisible :: Int -> Int -> Bool
notDivisible n 1          = True
notDivisible n divisor 
   | n `mod` divisor == 0 = False
   | otherwise            = notDivisible n (divisor-1) 

--Problem 8th: thirteen adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?
adjProd :: Integer -> Int -> Int
adjProd n digits = maxProd (digitList n) digits

maxProd :: [Int] -> Int -> Int
maxProd [] _ = 0
maxProd (x:xs) d = max (product (take d (x:xs))) (maxProd xs d)


digitList :: Integer -> [Int]
digitList x = case x`div`10 of
  0 -> [fromInteger x]
  y -> fromInteger (x`mod`10) : digitList y 

--Problem 9: There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find the product abc

pyProd :: Int
pyProd = head [x | b<-[1..], let m = (1000-b), let n = 1000*(500-b), let a = n `div` m, (==) (n `mod` m) 0, let c = 1000-a-b,let x = a*b*c ]

--Problem 10: sum of all the primes below two million

sumOfPrimes :: Int -> Int
sumOfPrimes x = sum (filter' (< x) primes)

filter' :: (Int ->  Bool) ->  [Int] -> [Int]
filter' p [] = []
filter' p (x:xs) 
  | p x       = x : filter' p xs
  | otherwise = []
  
--efficient primality check
isPrime :: Int -> Bool
isPrime 1 = False
isPrime 2 = True
isPrime 3 = True
isPrime n 
  | n`mod`2 == 0 || n`mod`3 == 0 = False
  | otherwise = divisible n 5
  
divisible :: Int -> Int -> Bool
divisible n i 
  | (i*i) <= n  = case n`mod`i == 0 || n`mod`(i+2) == 0 of
                    True -> False
                    False -> divisible n (i+6)
  | otherwise   = True


  
  
