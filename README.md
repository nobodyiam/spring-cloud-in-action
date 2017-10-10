# Spring Cloud in Action

## Introduction

This is a demo Spring Boot project which shows the use of Spring Cloud families including:

* [Apollo](https://github.com/ctripcorp/apollo)
    - You need to follow the instructions below to prepare config data in Apollo first
* Spring Cloud Netflix
    - Eureka
    - Hystrix
    - Zuul
    - Ribbon

## Data Setup

1. Create app `spring-cloud-in-action`
	* Create a public namespace `TEST1.spring-cloud-in-action`
	* Fill the following config data using text mode into `TEST1.spring-cloud-in-action` namespace and release the config

		```properties
		debug = false
		info.id = ${spring.application.name}
		server.port = ${PORT:${SERVER_PORT:0}}

		logging.level.org.springframework.security = ERROR
		logging.level.com.netflix.eureka = ERROR
		logging.level.com.netflix.discovery = ERROR

		eureka.client.serviceUrl.defaultZone = http://127.0.0.1:10000/eureka/
		eureka.client.healthcheck.enabled = true
		eureka.client.registerWithEureka = true
		eureka.client.fetchRegistry = true
		eureka.client.eurekaServiceUrlPollIntervalSeconds = 60

		eureka.instance.preferIpAddress = true

		```
2. Create app `eureka-service`
	* Fill the following config data using text mode into `application` namespace and release the config

		```properties
		server.port = ${PORT:10000}

		eureka.client.registerWithEureka = false
		```
3. Create app `hystrix-dashboard`
	* Fill the following config data using text mode into `application` namespace and release the config

		```properties
		server.port = ${PORT:8010}
		```
4. Create app `reservation-client`
	* Fill the following config data using text mode into `application` namespace and release the config

		```properties
		server.port = ${PORT:9999}
		```
5. Create app `reservation-service`
	* Fill the following config data using text mode into `application` namespace and release the config

		```properties
		server.port = ${PORT:8000}

		# database
		spring.datasource.url = jdbc:h2:mem:~/reservationdb;mode=mysql;DB_CLOSE_ON_EXIT=FALSE;DB_CLOSE_DELAY=-1
		spring.jpa.hibernate.naming_strategy = org.hibernate.cfg.EJB3NamingStrategy
		spring.h2.console.enabled = true
		spring.h2.console.settings.web-allow-others = true
		spring.jpa.properties.hibernate.show_sql = true
		```
