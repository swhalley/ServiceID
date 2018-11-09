# Overview

Shows of Spring Boot Web and JDB using JDBCTemplate

# Usage

Requires java 8+, gradle and docker

## Start the Database

```
cd db
docker-compose up
```

add `-V` if you want a fresh volume within the docker container

## Run the App

```
gradle run
```
