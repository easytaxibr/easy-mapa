(ns com.easytaxi.api.handler
  (:require [clojure.java.io :only resource]
            [compojure.route :as route]
            [compojure.core :refer [defroutes GET POST]]
            [compojure.route :refer [resources not-found]]
            [ring.middleware.session :refer :all]
            [ring.middleware.nested-params :refer :all])
  (:use com.easytaxi.api.positions
        ring.middleware.resource
        ring.middleware.file
        [ring.middleware.params         :only [wrap-params]]
        [ring.middleware.keyword-params :only [wrap-keyword-params]]
        [ring.middleware.session.cookie :only [cookie-store]]))


(defroutes app-routes
  (GET "/" []
       (slurp (clojure.java.io/resource "index.html")))
  (GET "/positions" []
       (get-random-positions))
  (resources "/")
  (not-found "<b>Page not found</b>"))

(def app (-> app-routes
             (wrap-resource "public")))

