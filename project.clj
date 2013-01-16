(defproject plasma-clj "1.0.0-SNAPSHOT"
  :description "Transliterations of example code for generating plasmas using quil"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [quil "1.6.0"]
                 [net.java.dev.jogl/jogl "1.1.1a"]]
  :native-dependencies [[net.java.dev.jogl/jogl-windows-i586 "2.4.2"]]
  :source-path "src/main/clojure/"
  :jvm-opts ["-Xmx1g" "-server"])
