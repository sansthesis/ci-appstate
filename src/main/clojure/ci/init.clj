(ns ci.init
  (:gen-class)
  (:require [ci.git :as git]
            [postal.core :as mail]))

(defn -main
  ([& m] (mail/send-message #^{:host "smtp.gmail.com"
                               :port 465
                               :user (first m)
                               :pass (second m)
                               :ssl true}
                              {:from "jasoncrose@gmail.com"
                               :to "jasoncrose@gmail.com"
                               :subject "multipart/alternative test"
                               :body [:alternative
                                      {:type "text/plain"
                                       :content "This is a test."}
                                      {:type "text/html"
                                       :content "<html><head> </head><body><h1>Heading 1</h1><p>This is a test.</p></body></html>"}]})))
