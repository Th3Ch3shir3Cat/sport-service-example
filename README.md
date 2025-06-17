### Kotlin sample with signoz

This project show how we can use signoz in kotlin spring boot application

### How to run

First we should start Eureka service

```
cd serviceDiscovery
mvn clean install
sh ./script/start.sh
```

Check it http://localhost:8761

Start docker container with local db (PostgreSQL)

```
docker compose up -d --remove-orphans
```

Then start others services

```
cd sport-notification-service
mvn clean install
sh ./script/start.sh
```

```
cd sport-service
mvn clean install
sh ./script/start.sh
```

```
cd sport-team-management
mvn clean install
sh ./script/start.sh
```

All services contain opentelemetry-javaagent for to collect and send data to signoz

### Signoz settings

To signoz ottel collector config add

```
receivers:
  hostmetrics:
    collection_interval: 60s  # Frequency of metrics collection.
    scrapers:
      cpu: { }
      load: { }
      memory: { }
      disk: { }
      filesystem: { }
      network: { }
```
```
resourcedetection:
  system:
    hostname_sources: [ os ]
  resource/env:
    attributes:
      - key: deployment.environment
        value: staging
        action: upsert
```
```
exporters:
  otlp:
    endpoint: 0.0.0.0:4317
    tls:
      insecure: true
```
```
service:
  pipelines:
      metrics/hostmetrics:
        receivers: [ hostmetrics ]
        processors: [ resourcedetection, resource/env ]
        exporters: [ otlp ]
```

### Check and use api

All services contain swagger ui

http://localhost:7269/swagger-ui/index.html#/ - sport-service

http://localhost:7554/swagger-ui/index.html#/ - sport-notification-service

http://localhost:8672/swagger-ui/index.html#/ - sport-team-management