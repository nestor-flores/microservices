#!/bin/bash

# This script is needed to build the app and generate the docker images


#MAVEN_HOME env variable - set this to your own instalation
MAVEN_HOME=../../Downloads/apache-maven-3.6.2/

# Do a maven build
$MAVEN_HOME/bin/mvn clean package -Dmaven.test.skip=true

# Start containers
docker-compose up --build