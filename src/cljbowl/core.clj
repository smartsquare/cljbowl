(ns cljbowl.core
  (:gen-class))

(defrecord Frame [pins-rolled score])

(defn full? [frame]
  (if (nil? frame)
    (throw (IllegalStateException. "Game not started!")))
  (or
       (= (count (:pins-rolled frame)) 2)
       (= (apply + (:pins-rolled frame)) 10)))

;(defn roll [frames pins]
;  (if (full? (last frames)
    
