
Download it from https://zipkin.io/pages/quickstart.html and start running the command:
$ RABBIT_URI=amqp://localhost java -jar zipkin.jar

And access its web console from http://localhost:9411/zipkin

Rabbit MQ:
$ sudo pacman -S rabbitmq
$ systemctl start rabbitmq.service

Netflix Eureka Naming Server webconsole: http://localhost:8761

Netflix Zuul Api Gateway: http://localhost:8765

Currency Exchange GET Request: http://localhost:8000/currency-exchange/from/USD/to/INR
Currency Exchange from API Gateway GET Request: http://localhost:8765/currency-exchange-service/currency-exchange/from/USD/to/INR

Currency Conversion GET Request: http://localhost:8100/currency-converter-feign/from/EUR/to/INR/quantity/1000
Currency Conversion from API Gateway GET Request: http://localhost:8765/currency-conversion-service/currency-converter-feign/from/EUR/to/INR/quantity/1000

Refresh Limits Service props from Spring Cloud Config:
$ git add .
$ git commit -m "props update"
POST http://localhost:8080/actuator/refresh (for real world, refreshing each instance would not be a good strategy, so here is where spring bus comes into picture)
POST http://localhost:8080/actuator/bus-refresh (this refreshes all instances for this service)

Here, Spring bus uses RabbitMQ