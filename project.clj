(defproject ci "1.0.0-SNAPSHOT"
  :description "Continuous Integration tooling"
  :url "https://github.com/jasonrose/ci-appstate"
  :source-path "src/main/clojure"
  :java-source-path "src/main/java"
  :compile-path "target/classes"
  :resources-path "src/main/resources"
  :test-path "src/test/clojure"
  :dev-resources-path "src/test/resources"
  :target-dir "target"
  :library-path "target/lib"
  :warn-on-reflection false
  :main ci.init
  :repl-init ci.init
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [clj-http "0.3.5"]
                 [org.clojure/data.json "0.1.2"]
                 [com.draines/postal "1.7.1"]])
