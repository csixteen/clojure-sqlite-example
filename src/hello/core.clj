(ns hello.core
  (:require [clojure.java.jdbc :refer :all])
  (:gen-class))

(def testdata
  {:artist "Janis Joplin",
   :album "Pearl",
   :song "Mercedes Benz"
   })

(def db
  {:classname   "org.sqlite.JDBC"
   :subprotocol "sqlite"
   :subname     "test.db"
   })

(defn create-db
  []
  (try
       (db-do-commands db
                       (create-table-ddl :playlist
                                         [[:artist :text]
                                          [:album :text]
                                          [:song :text]]))
       (catch Exception e
         (println (.getMessage e)))))

(defn print-result-set
  [result-set]
  (doseq [row result-set]
    (println row)))

(defn output
  []
  (query db ["select * from playlist"]))

(defn -main
  []
  (create-db)
  (insert! db :playlist testdata)
  (print-result-set (output)))
