# ClanHR's Reports Library [![Build Status](https://travis-ci.org/clanhr/reports.svg)](https://travis-ci.org/clanhr/reports)

[![Clojars Project](http://clojars.org/clanhr/reports/latest-version.svg)](http://clojars.org/clanhr/reports)

Installation
```reports``` is available as a Maven artifact from [Clojars](http://clojars.org/clanhr/reports)

With Leiningen/Boot:

```clojure
[clanhr/reports "0.1.0"]
```

Usage
-----
The functionalities are provided by the ```reports.core``` namespace.

First, require it in the REPL:

```clojure
(require '[reports.core :as reports])
```

Or in your application:

```clojure
(ns my-app.core
  (:require [reports.core :as reports]))
```

Here's how to generate a new vacations balance report using the library:

```clojure
(def data [["Superman" "30" "10" "20" "20"]
           ["Batman" "50" "2" "30" "29"]])

(def workbook "Report")
(def filename "reports.xlsx")

(defn create-spreadsheet-test
  (core/vacations-balance-report {:data data
                                  :workbook workbook
                                  :filename filename}))
```
