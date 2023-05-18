(defproject flexiana-plaftform-test "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[takeoff/clj-camel "2.1.0"]
                 [ch.qos.logback/logback-classic "1.4.7"]
                 [ch.qos.logback/logback-core "1.4.7"]
                 [org.slf4j/slf4j-api "2.0.7"]
                 [clj-http "3.12.3"]
                 [org.apache.camel/camel-http "3.13.0"]]
  :repl-options {:init-ns flexiana-plaftform-test.core}
  :main flexiana-plaftform-test.core)
