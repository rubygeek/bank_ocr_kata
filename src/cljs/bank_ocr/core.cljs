;; create the main project namespace
(ns bank-ocr.core
 (:require [bank-ocr.machine :as machine]))

;; Enable cljs to print to the JS console of the browser
(enable-console-print!)

;; print to the console
(println "Hello, World!")

(defn process-entry []
  (let [entry  (.-value (.getElementById js/document "entry"))]
  (machine/parse entry)
))


(defn show-result []
  (println "hello") 
  ;; verify that js/document exists and that it has a getElementById
  ;; property
  (if (and js/document
           (.-getElementById js/document))
    (let [result         (.getElementById js/document "parsed-value")
          entry (.-value (.getElementById js/document "entry"))]
      (println entry)
      (set! (.-value result) (process-entry))))) 





