(ns bank-ocr.machine
  (:require [clojure.string :as str]))

;;# 4 lines long
;;# line is 27 characters
;;# letters 3 characters wide
;;# 4th line blank


(defn get-rows [line-data]
  (map #(partition 3 %) (str/split-lines line-data)))

(defn get-position [data idx]
  (when (not= data "")
    (let [[row1 row2 row3] (get-rows data)]
      (str (apply str (nth row1 idx))
           (apply str (nth row2 idx))
           (apply str (nth row3 idx))))))

(defn get-number [data idx]
  (case (get-position data idx)
    " _ | ||_|"  0
    "     |  |"  1
    " _  _||_ "  2
    " _  _| _|"  3
    "   |_|  |"  4
    " _ |_  _|"  5
    " _ |_ |_|"  6
    " _   |  |"  7
    " _ |_||_|"  8 
    " _ |_| _|"  9

    :err  ))

(defn get-number-list [number-str]
  (for [idx (range 9)]
    (get-number number-str idx)))

(defn str->int [s]
  #?(:clj  (java.lang.Integer/parseInt s)
     :cljs (js/parseInt s)))

(defn parse [number-str]
  (str->int (str/join "" (get-number-list number-str))))
