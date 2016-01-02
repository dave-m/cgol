(defproject cgol "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/math.combinatorics "0.1.1"]] 
  :main ^:skip-aot cgol.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
