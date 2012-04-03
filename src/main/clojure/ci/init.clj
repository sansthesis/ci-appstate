(ns ci.init
  (:gen-class)
  (:require [ci.git :as git]
            [postal.core :as mail]
            [ci.email :as email]))

(defn -main
  ([& m] (mail/send-message #^{:host "smtp.gmail.com"
                               :port 465
                               :user (first m)
                               :pass (second m)
                               :ssl true}
                              {:from (first m)
                               :to (nth m 2)
                               :subject (nth m 3)
                               :body [:alternative
                                      {:type "text/plain"
                                       :content "This is a test."}
                                      {:type "text/html"
                                       :content (email/test-email)}]})))
