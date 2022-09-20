# Project

You can find javadoc in the documentation folder

Also in the root you can find swagger.json and swagger.yaml files - use editor.swagger.io to create visual open API

The following were used in the project:
 - Java 11
 - Spring Boot
 - Spring DATA
 - Maven 3.6.3
 - Swagger
 - PostgreSQL 14
 - JUnit + Mockito

Tasks were set:
● Reads all the prices from the csv files (done)
● Calculates oldest/newest/min/max for each crypto for the whole month (done)
● Exposes an endpoint that will return a descending sorted list of all the cryptos, comparing the normalized range (i.e. (max-min)/min) (done)
● Exposes an endpoint that will return the oldest/newest/min/max values for a requested crypto (done)
● Exposes an endpoint that will return the crypto with the highest normalized range for a specific day (done)

Extra mile for recommendation service (optional):
● In XM we run everything on Kubernetes, so containerizing the recommendation service will add great value (not done)
● Malicious users will always exist, so it will be really beneficial if at least we can rate limit them (based on IP) (done)