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

(defn calc-frame [current nframes]
  (cond
    (empty? nframes) (apply + current)
    ; strike
    (= 1 (count current)) (+ 10 (calc-frame (first nframes) (rest nframes)))
    ; spare
    (= 10 (apply + current)) (+ 10 ((first nframes) 0))
    :else (apply + current)))

(defn calc-score [frames]
  (loop [[f & r] frames
         score []]
    (if (nil? f)
      score
      (recur r (conj score (calc-frame f r))))))
      
