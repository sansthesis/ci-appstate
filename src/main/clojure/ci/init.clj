(ns ci.init
  (:require [ci.git :as git]))

(defn -main
  ([& m] (git/set-credentials (first m) (second m))))
