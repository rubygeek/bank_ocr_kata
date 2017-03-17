# Bank OCR Kata in Clojurescript

### Run CLJS repl
```
boot repl -c
(start-repl)
```



### User Story 2

Having done that, you quickly realize that the ingenious machine is not in fact infallible. Sometimes it goes wrong in its scanning. The next step therefore is to validate that the numbers you read are in fact valid account numbers. A valid account number has a valid checksum. This can be calculated as follows:

```
account number:  3  4  5  8  8  2  8  6  5
position names:  d9 d8 d7 d6 d5 d4 d3 d2 d1
checksum calculation: (d1+2*d2+3*d3 +..+9*d9) mod 11 = 0
```
5 + 6 * 2 +  8*3

we just talked through this last part


number .. convert to string ... reverse ...   zip with range   [ 5 1]  [6 2] [8 3]  

(def nums (reverse num-array))

(->> (for [x (range 1 10)
     :let [n (nth nums x)]]
  (* x n))
  apply +)
      

(mod sum 11)

