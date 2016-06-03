(ns easytaxi_api.handler_test
  (:require [clojure.test :refer :all]
            [clojure.data.json :as json]
            [ring.mock.request :as mock]
            [com.easytaxi.api.handler :refer :all]))

(deftest test-app
  (testing "main route"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 200))
      (is (.contains (:body response) "<!DOCTYPE html>"))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404))))

  (testing "Get request"
    (let [response (app (mock/request :get "/positions"))]
      (is (= (:status response) 200))
      (is (= (count (json/read-json (:body response))) 1)))))
  
  


  
