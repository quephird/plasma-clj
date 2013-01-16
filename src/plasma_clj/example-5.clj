(ns example-5
  (:use quil.core)
  (:import (java.awt Color))
  )

(def screen-w 250)
(def screen-h 250)

(def palette (atom nil))
(def buffer (atom nil))

(defn color-function [x y]
  (let [c1 (+ 128.0 (* 128.0 (sin (/ x 8.0))))
        c2 (+ 128.0 (* 128.0 (sin (/ y 8.0))))]
    (int (/ (+ c1 c2) 2.0))
    )
  )

(defn init-palette []
  (reset! palette (into {} (map #(vector % (color % 255 255)) (range 256))))
  )

(defn init-buffer []
  (reset! buffer
    (into {}
      (map #(vector % (@palette (apply color-function %)))
        (for [x (range screen-w) y (range screen-h)]
;        (for [x (range 100) y (range 100)]
          [x y]))))
  )

(defn setup []
  (smooth)
  (background 0)
  (color-mode :hsb)
  (init-palette)
  (init-buffer)
  )

(defn draw []
  (let [palette-shift (int (/ (millis) 10))]
    (doseq [x (range screen-w)]
      (doseq [y (range screen-h)]
        (set-pixel x y (@palette (mod (+ (@buffer [x y]) palette-shift) 256)))
        )
      )
    )
  )

(defsketch main
  :title "Example 5 - cycling colors"
  :setup setup
  :draw draw
  :size [screen-w screen-h]
  )
