(ns cljbowl.core-test
  (:require [clojure.test :refer :all]
            [cljbowl.core :refer :all]))

(deftest fullness
  (testing "nil?"
    (is (thrown? IllegalStateException (full? nil))))
  (testing "full false"
    (is (not (full? [])))
    (is (not (full? [5]))))
  (testing "full true"    
    (is (full? [0 0]))
    (is (full? [5 0]))
    (is (full? [0 5]))
    (is (full? [5 5]))
    (is (full? [10]))))

(deftest rolling
  (testing "empty game"
    (is (= [[1]] (roll [[]] 1))))
  (testing "partial frame"
    (is (= [[5 5]] (roll [[5]] 5))))
  (testing "new frame"
    (is (= [[5 5] [5]] (roll [[5 5]] 5)))))


(deftest calcframe
  (testing "empty next frame"
    (is (= 8 (calc-frame [4 4] []))))
  (testing "simple frame"
    (is (= 8 (calc-frame [4 4] [[5 1]]))))
  (testing "first frame spare"
    (is (= 15 (calc-frame [4 6] [[5 1]]))))
  (testing "first frame strike"
    (is (= 16 (calc-frame [10] [[5 1]]))))
  (testing "three strikes in a row"
    (is (= 36 (calc-frame [10] [[10] [10] [5 1]])))))

(deftest calcscore
  (testing "simple score"
    (is (= [5 8 10] (calc-score [[1 4] [4 4] [0 10]]))))
  (testing "spare"
    (is (= [14 5] (calc-score [[5 5] [4 1]]))))
  (testing "strike strike spare"
    (is (= [34 24 14 5] (calc-score [[10] [10] [5 5] [4 1]])))))
