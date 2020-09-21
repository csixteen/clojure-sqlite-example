(defproject music "0.1.0"
  :description "Simple Clojure SQLite example"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/java.jdbc "0.7.8"]
                 [org.xerial/sqlite-jdbc "3.23.1"]]
  :main ^:skip-aot music.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
