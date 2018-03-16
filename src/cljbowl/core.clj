(ns cljbowl.core
  (:gen-class))

(defn full? [frame]
  (if (nil? frame)
    (throw (IllegalStateException. "Game not started!")))
  (or
       (= (count frame) 2)
       (= (apply + frame) 10)))

(defn roll [frames pins]
  (if (full? (last frames))
    (conj frames [pins])
    (conj (butlast frames) (conj (last frames) pins))))



