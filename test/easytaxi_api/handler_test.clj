(ns easytaxi_api.handler_test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [com.easytaxi.api.handler :refer :all]))

(deftest test-app
  (testing "main route"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 200))
      (is (= (:body response) "hello"))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404))))

  (testing "Post request"
    (let [response (app (mock/request :post "/send"))]
      (is (= (:status response) 200))
      (is (= (:body response) "OK")))))
  
  


  
