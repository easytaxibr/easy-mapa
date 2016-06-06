(ns easytaxi.handler_test
  (:require [clojure.test :refer :all]
            [clojure.data.json :as json]
            [ring.mock.request :as mock]
            [com.easytaxi.api.handler :refer :all]
            [com.easytaxi.api.positions :refer :all]))

(deftest test-app-route
  (testing "Get main route"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 200))
      (is (.contains (:body response) "<!DOCTYPE html>"))))

  (testing "not-found"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404))))

  (testing "Get positions"
    (let [response (app (mock/request :get "/positions"))
          jsonobj (json/read-json (:body response))]
      (is (= (:status response) 200))
      (is (= (count (:positions jsonobj)) max-elements)))))
  
  


  
