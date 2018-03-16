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
    (is (= [1] (roll [[]] 1)))))
