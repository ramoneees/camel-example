(ns flexiana-plaftform-test.core
  (:require [clj-camel.core :as c]
            [clj-camel.util :as cu])
  (:import (org.apache.camel ProducerTemplate)))

(def ctx (c/camel-context))
;; Define the OpenWeatherMap endpoint URL and API key
(def api-endpoint "https://api.openweathermap.org/data/2.5/weather")
(def api-key "374375cade0b557f6ff8ef1771107df5") ; replace with your OpenWeatherMap API key
;; Define a function to generate the OpenWeatherMap URL for a given city
(def geo-endpoint (str "http://api.openweathermap.org/geo/1.0/direct?q=London&limit=5&appid=" api-key))

(def weather-url
  (str api-endpoint "?lat=51.5156177" "&lon=-0.0919983" "&appid=" api-key "&units=metric"))


(def test-route (c/route-builder (c/from "timer:mytimer?repeatCount=1")
                                 (c/route-id "geo-route")
                                 (c/to-d weather-url)
                                 (c/to "direct:test")))

(def route2 (c/route-builder (c/from "direct:test")
                             (c/route-id "test-route")
                             (c/log "route2 ${body}")
                             (c/to "direct:result")))




(defn -main
  "I don't do a whole lot ... yet."
  []

  (c/add-routes ctx test-route route2)
  (.start ctx)
  (Thread/sleep 10000)
  (.shutdown ctx))
