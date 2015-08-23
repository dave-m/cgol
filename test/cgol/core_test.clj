(ns cgol.core-test
  (:require [clojure.test :refer :all]
            [cgol.core :refer :all]))


(deftest test-print-row
  (testing "Test printing out a row"
    (testing "all blank row"
      (is (= (print-row {:x 0} {:x 5} [{}]) "      ")))
    (testing "non blank row"
      (is (= (print-row {:x 0} {:x 5} [{:x 1 :y 23}]) " x    ")))))

(deftest test-print-world
  (testing "printing the world"
    (testing "Test Print a World that has only 1 dimension"
      (let [res (print-world [{:x 1 :y 1} {:x 3 :y 1}])]
        (is (= res ["x x "]))))
    (testing "Test Print a World that has 3 points"
      (let [res (print-world [{:x 1 :y 1} {:x 3 :y 1} {:x 1 :y 3}])]
        (is (= res ["x x" "   " "x  "])))))
  )
 
