(defproject com.taoensso/nippy "2.15.2"
  :author "Peter Taoussanis <https://www.taoensso.com>"
  :description "High-performance serialization library for Clojure"
  :url "https://github.com/ptaoussanis/nippy"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments "Same as Clojure"}
  :min-lein-version "2.3.3"
  :global-vars {*warn-on-reflection* true
                *assert*             true
                ;; *unchecked-math*  :warn-on-boxed
                }

  :dependencies
  [[org.clojure/clojure      "1.5.1"]
   [org.clojure/tools.reader "1.3.2"]
   [com.taoensso/encore      "2.126.2"]
   [org.iq80.snappy/snappy   "0.4"]
   [org.tukaani/xz           "1.8"]
   [org.lz4/lz4-java         "1.7.1"]]

  :profiles
  {;; :default [:base :system :user :provided :dev]
   :server-jvm {:jvm-opts ^:replace ["-server" "-Xms1024m" "-Xmx2048m"]}
   :1.5  {:dependencies [[org.clojure/clojure "1.5.1"]]}
   :1.6  {:dependencies [[org.clojure/clojure "1.6.0"]]}
   :1.7  {:dependencies [[org.clojure/clojure "1.7.0"]]}
   :1.8  {:dependencies [[org.clojure/clojure "1.8.0"]]}
   :1.9  {:dependencies [[org.clojure/clojure "1.9.0"]]}
   :1.10 {:dependencies [[org.clojure/clojure "1.10.1"]]}
   :test {:jvm-opts     ["-Xms1024m" "-Xmx2048m"
                         "-Dtaoensso.nippy.serializable-whitelist-base=base.1, base.2"
                         "-Dtaoensso.nippy.serializable-whitelist-add=add.1 , add.2"]
          :dependencies [[org.clojure/test.check        "1.1.0"]
                         [org.clojure/data.fressian     "1.0.0"]
                         [org.xerial.snappy/snappy-java "1.1.7.6"]]}
   :dev [:1.10 :test :server-jvm
         {:plugins
          [[lein-pprint  "1.3.2"]
           [lein-ancient "0.6.15"]
           [lein-codox   "0.10.7"]]}]}

  :codox
  {:language :clojure
   :source-uri "https://github.com/ptaoussanis/nippy/blob/master/{filepath}#L{line}"}

  :aliases
  {"test-all"   ["with-profile" "+1.10:+1.9:+1.8:+1.7:+1.6:+1.5" "test"]
   "deploy-lib" ["do" "deploy" "clojars," "install"]
   "start-dev"  ["with-profile" "+dev" "repl" ":headless"]}

  :repositories {"sonatype-oss-public"
                 "https://oss.sonatype.org/content/groups/public/"})
