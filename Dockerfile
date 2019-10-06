FROM openjdk:8u191-jre-alpine3.8

# Workspace
WORKDIR /usr/share/udemy

# ADD .jar from target to image
ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar

# ADD suite files
ADD book-flight-module.xml book-flight-module.xml
ADD search-module.xml search-module.xml
ADD target/libs libs

# BROWSER
# HUB_HOST
# MODULE
ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE
