(ns com.easytaxi.api.positions
  (:require [clojure.data.json :as json]
            [clojure.string :as string]))

(def max-elements 60)
(def pi (. Math PI))
(def rad (/ 20 40))

(def center (hash-map :lat -23.54 :long -46.53))

(defn transform-coord [u v]
  (let [t (* 2 pi v)
        w (* rad (Math/sqrt u))]
    (conj '()
          (* w (Math/cos t))
          (* w (Math/sin t)))))

(defn make-pairs []
  (transform-coord (* 0.1 (rand)) (* 0.1 (rand))))

(defn generate-positions []
  (let [m max-elements 
        pattern "{\"lat\": %s, \"lon\": %s}"]
    (into '()
          (for [i (take m (repeatedly #(make-pairs)))]
            (format pattern
                    (- (center :lat) (first i))
                    (- (center :long) (second i)))))))

(defn get-random-positions []
  (let [pos (clojure.string/join "," (generate-positions))
        body (format "{\"positions\": [%s]}" pos)]
    {:status 200
     :headers {"Content-Type" "application/json"}
     :body body}))




