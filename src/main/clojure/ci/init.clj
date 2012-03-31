(ns ci.init)

(defn -main
  [& m] (println "ci.init loaded"))

(defn main [& m]
  (-main m))
