Reuse these images instead of creating and pushing images

baturayacarturk/mmv2-currency-conversion-service:0.0.1-SNAPSHOT
baturayacarturk/mmv2-currency-exchange-service:0.0.1-SNAPSHOT

URLS
Currency Exchange Service
http://localhost:8000/currency-exchange/from/USD/to/TL

Currency Conversion Service
http://localhost:81000/currency-conversion-feign/from/USD/to/TL/quantity/{some value}

Commands:
docker run -p 8100:8100 baturayacarturk/baturayacarturk/mmv2-currency-conversion-service:0.0.1-SNAPSHOT

kubectl create deployment currency-conversion-rest-api --image=baturayacarturk/mmv2-currency-conversion-service:0.0.1-SNAPSHOT
kubectl expose deployment currency-conversion-rest-api --type=LoadBalancer --port=8100
kubectl scale deployment currency-conversion-rest-api --replicas=3
kubectl autoscale deployment currency-conversion-rest-api --max=10 --cpu-percent=70
kubectl edit deployment currency-conversion-rest-api #minReadySeconds: 15
