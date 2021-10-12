# SpringBoot-Microservice

Source: https://www.youtube.com/watch?v=BnknNTN8icw

Department Microservice:
	Port: 9001

User Microservice:
	Port: 9002

Service Registry:
	Port: 8761

API-GW(cloud-gaeway):
	Port: 9191

Git Config Server Repository:
	Url: https://github.com/sahilsoni91/config-server

Config Server:
	Port: 9292

Zipkin Server:
	Port: 9411

This repo also contains Postman collections to test Microservices REST endpoints.

Note: Hystrix Circuit Breaker and Hystrix Dashboard is not implemented while developing these microservice system because Hystrix and Hystrix Dashboard are now replaced by Resilience4J dependency and not compatible with SpringBoot 2.5.5 when these microservices are developed.
