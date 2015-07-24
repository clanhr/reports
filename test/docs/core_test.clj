(ns docs.core-test
  (:require [clojure.test :refer :all]
            [docs.core :as core]))

(def data [["Superman" "30" "10" "20" "20"]
           ["Batman" "50" "2" "30" "29"]])

(def workbook "Report")
(def filename "reports.xlsx")

(deftest create-spreadsheet-test
  (core/vacations-balance-report {:data data
                                  :workbook workbook
                                  :filename filename})
  (let [result (core/read-vacations-balance-report {:filename filename
                                                    :workbook workbook})
        header (first result)
        data-result (rest result)
        first-data-result (first data-result)
        second-data-result (second data-result)]
    (is (= 3 (count result)))

    (testing "header"
      (is (not (empty? (:free-days header))))
      (is (not (empty? (:reserved-days header))))
      (is (not (empty? (:enjoyed-days header))))
      (is (not (empty? (:days header))))
      (is (not (empty? (:name header)))))

    (testing "first data"
      (is (not (empty? (:free-days first-data-result))))
      (is (not (empty? (:reserved-days first-data-result))))
      (is (not (empty? (:enjoyed-days first-data-result))))
      (is (not (empty? (:days first-data-result))))
      (is (not (empty? (:name first-data-result)))))

    (testing "second data"
      (is (not (empty? (:free-days second-data-result))))
      (is (not (empty? (:reserved-days second-data-result))))
      (is (not (empty? (:enjoyed-days second-data-result))))
      (is (not (empty? (:days second-data-result))))
      (is (not (empty? (:name second-data-result)))))))
