(ns example-3
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
  (let [dx (- x (/ screen-w 2))
        dy (- y (/ screen-h 2))
        r (sqrt (+ (* dx dx) (* dy dy)))
        c (int (+ 128.0 (* 128.0 (sin (/ r 8.0)))))]
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
  :title "Example 3 - concentric circles"
  :setup setup
  :draw draw
  :size [screen-w screen-h]
  )
