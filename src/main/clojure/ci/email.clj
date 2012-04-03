(ns ci.email)

(defn substitute
  ([template value-map]
     (reduce #(apply clojure.string/replace %1 %2) template (map #(vector (str (first %)) (str (second %))) value-map))))

(defn test-email
  [] (substitute (slurp "src/main/resources/server-up.html") {:app-name "Costner"
                                                              :environment-title "Development"
                                                              :app-url "http://costner-development.meltdemo.com/costner/"
                                                              :scm-url "https://github.com/meltmedia/costner/"
                                                              :issue-url "http://jira.meltdev.com/browse/RUI"
                                                              :environment-scope "Development servers are used by developers to test the latest merged code on a hosted server.  Validation should occur on a development server before merging development items into the stable branch."
                                                              :environment-lifespan "Development will only reflect this specific changeset until the next successful update to the master branch of this application in Git."}))
