(ns food.box.store
  (:require [ring.adapter.jetty   :refer [run-jetty]]
            [food.box.models.conf :refer [PORT]]

            [ring.middleware [params         :refer [wrap-params]]
                             [nested-params  :refer [wrap-nested-params]]
                             [keyword-params :refer [wrap-keyword-params]]
                             [session        :refer [wrap-session]]
                             [flash          :refer [wrap-flash]]]

            [compojure [core  :refer [defroutes]]
                       [route :refer [resources]]]

            [food.box.controllers [pricing :as pricing]
                                  [order   :as order]])
            
  (:gen-class))

(defroutes routes
  pricing/routes
  order/routes
  (resources "/"))

(def app
  (-> routes
      wrap-flash
      wrap-session
      wrap-keyword-params
      wrap-nested-params
      wrap-params))

(defn -main [& args]
  (run-jetty app {:port  PORT
                  :join? false}))
