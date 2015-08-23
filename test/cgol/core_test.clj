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
        (is (= res ["x x"]))))
    (testing "Test Print a World that has 3 points"
      (let [res (print-world [{:x 1 :y 1} {:x 3 :y 1} {:x 1 :y 3}])]
        (is (= res ["x x" "   " "x  "])))))
  )
 
(deftest test-neighbours
  (testing "Test getting all of the neighbours for a cell with"
    (testing "no world"
      (let [expected nil]
        (is (= expected (neighbours {:x 1 :y 1} [])))))
    (testing "no neighbours"
      (let [expected nil]
        (is (= expected (neighbours 
                          {:x 1 :y 1} 
                          [{:x 3 :y 3} {:x 4 :y 4} {:x 4 :y 3}])))))
    (testing "Test world with neighbours"
      (let [expected [{:x 1 :y 2}]]
        (is (= expected (neighbours 
                          {:x 1 :y 1} 
                          [{:x 1 :y 2} {:x 4 :y 4} {:x 4 :y 3}])))))))
