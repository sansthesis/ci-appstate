(ns ci.git
  (:require [clj-http.client :as client]
            [clojure.data.json :as json]))

(def state (atom {}))

(defn set-credentials
  ([user pwd] (swap! state assoc :user user :pwd pwd)
              @state))

(defn get-credentials
  ([] (select-keys @state '(:user :pwd))))

(defn list-closed-pull-requests
  ([username password owner project]
    (reverse (sort-by :closed_at (json/read-json (:body (client/get (str "https://api.github.com/repos/" owner "/" project "/pulls") {:basic-auth [username password] :query-params {:state "closed"}}))))))
  ([username password owner project start]
    (filter #(>= 0 (compare start (:closed_at %))) (list-closed-pull-requests username password owner project))))
