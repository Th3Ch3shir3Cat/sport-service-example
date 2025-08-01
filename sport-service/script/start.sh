#!/bin/bash

[ -z "$JAVA_XMS" ] && JAVA_XMS=512m
[ -z "$JAVA_XMX" ] && JAVA_XMX=512m

set -e

 # OpenTelemetry:
 # https://github.com/open-telemetry/opentelemetry-java-instrumentation
 JAVA_OPTS="${JAVA_OPTS} \
   -Xms${JAVA_XMS} \
   -Xmx${JAVA_XMX} \
   -Dapplication.name=sport-service-java \
   -Dotel.metrics.exporter=none \
   -Dotel.traces.exporter=otlp \
   -Dotel.resource.attributes=service.name=sport-service-java \
   -Dotel.exporter.otlp.traces.endpoint=http://0.0.0.0:4318/v1/traces \
   -Dotel.exporter.otlp.metrics.endpoint=http://0.0.0.0:4318/v1/metrics \
   -Dotel.service.name=sport-service-java \
   -Dotel.javaagent.debug=false \
   -javaagent:./agents/opentelemetry-javaagent.jar"



exec java ${JAVA_OPTS} \
  -jar "./target/sport-service-0.0.1-SNAPSHOT.jar" \