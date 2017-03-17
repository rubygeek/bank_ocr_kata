(ns bank-ocr.machine-test
  (:require [clojure.test :refer [deftest is testing]]
            [bank-ocr.machine :refer :all]))

(def all-zeros (str " _  _  _  _  _  _  _  _  _  \n" 
                    "| || || || || || || || || | \n" 
                    "|_||_||_||_||_||_||_||_||_| \n"
                    "                           ")) 

(def all-ones (str "                           \n"
                   "  |  |  |  |  |  |  |  |  | \n"
                   "  |  |  |  |  |  |  |  |  | \n"
                   "                          "))

(def all-twos (str " _  _  _  _  _  _  _  _  _ \n" 
                   " _| _| _| _| _| _| _| _| _|\n"
                   "|_ |_ |_ |_ |_ |_ |_ |_ |_ " ))

(def all-nums (str "    _  _     _  _  _  _  _ \n"
                   "  | _| _||_||_ |_   ||_||_|\n"
                   "  ||_  _|  | _||_|  ||_| _| "))


(deftest test-get-rows-is-three
  (is (= 4 (count (get-rows all-zeros)))))

(deftest test-get-rows-zeros
  (is (= '(\space \_ \space) (first (first (get-rows all-zeros))))))

(deftest test-get-rows-zeros-str
  (is (= " _ " (apply str (first (first (get-rows all-zeros)))))))

(deftest test-get-position 
  (is (= " _ | ||_|" (get-position all-zeros 1)))
  (is (= "     |  |" (get-position all-ones 1)))
  (is (= " _  _||_ " (get-position all-twos 1)))
)

(deftest test-get-number
  (is (= 0 (get-number all-zeros 0)))
  (is (= 1 (get-number all-ones 0)))
  (is (= :err (get-number "" 0))))

(deftest test-parse
  (is (= 000000000 (parse all-zeros)))
  (is (= 111111111 (parse all-ones)))
  (is (= 123456789 (parse all-nums))))




