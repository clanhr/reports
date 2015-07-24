(ns docs.core
  (:require [dk.ative.docjure.spreadsheet :as ss]))

(defn create-spreadsheet
  [data]
  (let [wb (ss/create-workbook (:workbook data)
                               (:data data))
        sheet (ss/select-sheet (:workbook data) wb)
        header-row (first (ss/row-seq sheet))]
    (do
      (ss/set-row-style! header-row (ss/create-cell-style! wb {:background :blue,
                                                               :font {:bold true}}))
      (ss/save-workbook! (:filename data) wb))))


(def vacations-balance-column-names
  ["Name" "Days" "Enjoyed Days" "Reserved Days" "Free Days"])

(defn vacations-balance-report
  [params]
  (create-spreadsheet (assoc params
                             :data
                             (cons vacations-balance-column-names (:data params)))))


(defn read-vacations-balance-report
  [data]
  (->> (ss/load-workbook (:filename data))
       (ss/select-sheet (:workbook data))
       (ss/select-columns {:A :name,
                           :B :days,
                           :C :enjoyed-days
                           :D :reserved-days
                           :E :free-days})))
