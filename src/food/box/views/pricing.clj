(ns food.box.views.pricing
  (:require [food.box.models.conf       :refer [PRICES SMALL REGULAR PREMIUM]]
            [food.box.views.application :refer :all]))

(defn- choose-button
  "Returns a form button to choose a food box."
  [value]
  [:form {:method "get" :action "/order"}
    [:input {:type "hidden" :name "box" :value value}]
    [:button.button-choose.pure-button {:type "submit"} "Choose"]])

(defn show
  "Displays the pricing table."
  []
  (layout true
    [:div.l-content
      
      ; PRICES
      [:div.pricing-tables.pure-g

        ; SMALL
        [:div#small-box.pure-u-1.pure-u-md-1-3
          [:div.pricing-table.pricing-table-free
            [:div.pricing-table-header
              [:h2 "SMALL"]
              [:span.pricing-table-price (get PRICES SMALL)
                                         [:span " per box"]]]

            [:ul.pricing-table-list
              [:li "FREE shipping worldwide"]
              [:li "..."]
              [:li "..."]
              [:li "..."]
              [:li "..."]
              [:li "..."]]

            (choose-button SMALL)]]

        ; REGULAR
        [:div#regular-box.pure-u-1.pure-u-md-1-3
          [:div.pricing-table.pricing-table-biz.pricing-table-selected
            [:div.pricing-table-header
              [:h2 "REGULAR"]
              [:span.pricing-table-price (get PRICES REGULAR)
                                         [:span " per box"]]]

            [:ul.pricing-table-list
              [:li "FREE shipping worldwide"]
              [:li "..."]
              [:li "..."]
              [:li "..."]
              [:li "..."]
              [:li "..."]]

            (choose-button REGULAR)]]

        ; PREMIUM
        [:div#premium-box.pure-u-1.pure-u-md-1-3
          [:div.pricing-table.pricing-table-enterprise
            [:div.pricing-table-header
              [:h2 "PREMIUM"]
              [:span.pricing-table-price (get PRICES PREMIUM)
                                         [:span " per box"]]]

            [:ul.pricing-table-list
              [:li "FREE shipping worldwide"]
              [:li "..."]
              [:li "..."]
              [:li "..."]
              [:li "..."]
              [:li "..."]]

            (choose-button PREMIUM)]]]

      ; INFORMATIONS
      [:div.information.pure-g

        ; DESCRIPTION
        [:div.pure-u-1.pure-u-md-1-2
          [:div.l-box
            [:h3.information-head "How it works"]
            [:p "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation."]]]

        ; PAYMENT
        [:div.pure-u-1.pure-u-md-1-2
          [:div.l-box
            [:h3.information-head "Payment"]
            [:p "After a successful order, you will receive an order confirmation with the bank account information via email. We well immediately ship the alps food box after receipt of the payment."]]]

        ; SUPPORT
        [:div.pure-u-1.pure-u-md-1-2
          [:div.l-box
            [:h3.information-head "Customer support"]
            [:p "Cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."]]]

        ; DELIVERY
        [:div.pure-u-1.pure-u-md-1-2
          [:div.l-box
            [:h3.information-head "DELIVERY"]
            [:p "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."]]]]]))
