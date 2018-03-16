(ns cljbowl.core-test
  (:require [clojure.test :refer :all]
            [cljbowl.core :refer :all]))

(deftest a-test
  (testing "nil?"
    (is (thrown? IllegalStateException (full? nil))))
  (testing "full false"
    (is (not (full? (->Frame [] 0))))
    (is (not (full? (->Frame [5] 0)))))
  (testing "full true"    
    (is (full? (->Frame [0 0] 0)))
    (is (full? (->Frame [5 0] 5)))
    (is (full? (->Frame [0 5] 5)))
    (is (full? (->Frame [5 5] 10)))
    (is (full? (->Frame [10] 10))))) 
