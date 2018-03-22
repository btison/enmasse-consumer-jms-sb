Enmasse playground: Spring Boot JMS consumer application. 

Uses the Qpid JMS Client library. 

* The application is meant to be deployed on OpenShift.
* To deploy to OpenShift using the Fabric8 Maven plugin:
```
$ mvn fabric8:deploy -Popenshift
```
* The application expects a ConfigMap named `consumer-jms--sb` containing an `application.properties` file.
* Example `application.properties`:
```
artemis.host=messaging.enmasse.svc.cluster.local
artemis.port=5671
artemis.query=sslEnabled=true&transport.trustAll=false&transport.verifyHost=true

amqphub.amqp10jms.remote-url=amqps://${amqp.host}:${amqp.port}?${amqp.query}
amqphub.amqp10jms.username=user
amqphub.amqp10jms.password=password

spring.jms.listener.concurrency=15
spring.jms.listener.max-concurrency=15
spring.jms.pub-sub-domain=false
spring.jms.subscription-shared=false

consumer.destination=queue-test
consumer.subscription=test

logging.factor=1
```
* The application expects a secret called `enmasse-truststore` containing a JKS truststore with the Enmasse messaging certificate.
* To create the truststore:
```
keytool -importcert -trustcacerts -file external-certs-messaging.crt -keystore enmasse.jks -storepass password -noprompt
```