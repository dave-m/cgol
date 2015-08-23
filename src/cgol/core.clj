(ns cgol.core
  (:require clojure.pprint)
  (:gen-class))

;; A Singe Cell, consists of (x, y))
(defrecord Cell [x y])
;; The world, a sequence of **live** cells)
(defrecord World [world])

(defn neighbours [cell world])

(defn world-min [world]
  {:x (apply min (map :x world))
   :y (apply min (map :y world))})

(defn world-max [world]
  {:x (apply max (map :x world))
   :y (apply max (map :y world))})

(defn world-boundaries [world]
  [(world-min world)
   (world-max world)])
(defn dies? [cell world])
(defn spawns? [cell world])

(defn in? 
  "true if seq contains elm"
  [seq elm]
  (some #(= elm %) seq))

(defn print-row [wmin wmax row]
  (let [xvals (map :x row)]
    (clojure.string/join (map 
      #(if (in? xvals %) (str "x") (str " "))
      (range (:x wmin) (+ 1 (:x wmax)))))))

(defn print-world [world]
  ;; Get a list of rows, sorted by Y low -> high
  (let [wmin (world-min world)
        wmax (world-max world)]
    (reduce (fn [result rindex]
              (conj result (print-row wmin wmax 
                              (filter #(= rindex (:y %)) world))))
            []
            (range (:y wmin) (+ (:y wmax) 1)))))


(defn -main
  "Run Conways Game of Life"
  [& args]
  (let [world [{:x 1 :y 1} {:x 2 :y 1} {:x 3 :y 23} {:x -2 :y 4}]]
    (dorun (map println (print-world world)) )))
