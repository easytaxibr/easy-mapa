(defproject clj-map-position "1.0.0"
  :description "Easy Mapa"
  :url ""
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [compojure "1.1.1"]
                 [ring/ring-core "1.3.0"]
                 [ring/ring-jetty-adapter "1.3.0"]
                 [org.clojure/data.json "0.2.6"]]
  :plugins [[lein-ring "0.8.11"]]
  :ring {:handler com.easytaxi.api.handler/app :port 3000}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                         [ring-mock "0.1.5"]]}})
