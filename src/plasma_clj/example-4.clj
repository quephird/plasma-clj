(ns example-4
  (:use quil.core)
  )

(def screen-w 1000)
(def screen-h 1000)

(defn setup []
  (smooth)
  (background 0)
  (no-loop)
  )

(defn color-function [x y]
  (let [c1 (+ 128.0 (* 128.0 (sin (/ x 8.0))))
        c2 (+ 128.0 (* 128.0 (sin (/ y 8.0))))
        c (int (/ (+ c1 c2) 2.0))]
    [c c c]
    )
  )

(defn draw []
  (doseq [x (range screen-w)]
    (doseq [y (range screen-h)]
      (let [c (color-function x y)]
        (set-pixel x y (apply color c))
        )
      )
    )
  )

(defsketch main
  :title "Example 4 - sum of two sine functions"
  :setup setup
  :draw draw
  :size [screen-w screen-h]
  )
