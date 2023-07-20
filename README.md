<h2>Reuse these images instead of creating and pushing images</h2>
<h3>Currency Conversion Service</h3>
<ul>
    <li>Image: <code>baturayacarturk/mmv2-currency-conversion-service:0.0.1-SNAPSHOT</code></li>
    <li>URL: <a href="http://localhost:8100/currency-conversion-feign/from/USD/to/TL/quantity/{some value}" target="_blank">http://localhost:8100/currency-conversion-feign/from/USD/to/TL/quantity/{some value}</a></li>
    <li>Command to run the container: <code>docker run -p 8100:8100 baturayacarturk/mmv2-currency-conversion-service:0.0.1-SNAPSHOT</code></li>
</ul>

<h3>Currency Exchange Service</h3>
<ul>
    <li>Image: <code>baturayacarturk/mmv2-currency-exchange-service:0.0.1-SNAPSHOT</code></li>
    <li>URL: <a href="http://localhost:8000/currency-exchange/from/USD/to/TL" target="_blank">http://localhost:8000/currency-exchange/from/USD/to/TL</a></li>
</ul>

<h2>Kubernetes Commands</h2>
<ul>
    <li>Create a Deployment for Currency Conversion Service:</li>
    <code>kubectl create deployment currency-conversion-rest-api --image=baturayacarturk/mmv2-currency-conversion-service:0.0.1-SNAPSHOT</code>
    <li>Expose Currency Conversion Service as a LoadBalancer:</li>
    <code>kubectl expose deployment currency-conversion-rest-api --type=LoadBalancer --port=8100</code>
    <li>Scale the Currency Conversion Service Deployment to 3 replicas:</li>
    <code>kubectl scale deployment currency-conversion-rest-api --replicas=3</code>
    <li>Autoscale the Currency Conversion Service Deployment based on CPU utilization:</li>
    <code>kubectl autoscale deployment currency-conversion-rest-api --max=10 --cpu-percent=70</code>
    <li>Edit the Currency Conversion Service Deployment to set <code>minReadySeconds</code> to 15 seconds:</li>
    <code>kubectl edit deployment currency-conversion-rest-api #minReadySeconds: 15</code>
</ul>
