(set-env!
 :source-paths #{"src/cljs" "src/cljc" "test"}
 :resource-paths #{"html"}

 :dependencies '[
                 [org.clojure/clojure "1.8.0"]         ;; add CLJ
                 [org.clojure/clojurescript "1.8.51"] ;; add CLJS
                 [adzerk/boot-cljs "1.7.170-3"]
                 [pandeiro/boot-http "0.7.3"]
                 [adzerk/boot-reload "0.4.8"]
                 [adzerk/boot-cljs-repl "0.3.0"]       ;; add bREPL
                 [com.cemerick/piggieback "0.2.1"]     ;; needed by bREPL
                 [weasel "0.7.0"]                      ;; needed by bREPL
                 [org.clojure/tools.nrepl "0.2.12"]
                 [adzerk/boot-test "1.2.0" :scope "test"]]) ;; needed by bREPL

(require '[adzerk.boot-cljs :refer [cljs]]
         '[pandeiro.boot-http :refer [serve]]
         '[adzerk.boot-test :refer :all]
         '[adzerk.boot-reload :refer [reload]]
         '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl]])


(deftask dev
  "Launch immediate feedback dev environment"
  []
  (comp
   (serve :dir "target")
   (watch)
   (reload)
   (cljs-repl) ;; before cljs
   (cljs)
   (target :dir #{"target"})))

