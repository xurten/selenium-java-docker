# Selenium - docker project
- I create an automation framework in Java using testNG
## Getting Started
- Tests can be run via selenium grid or zalenium
- Jenkins file was created for:
    - building repostiory
    - building docker image
    - sending new image to dockerhub
### Prerequisites
It is recommended to have docker installed(https://docs.docker.com/docker-for-windows/)

## Running the tests

- Tests can be executed by runner https://github.com/xurten/seleniumdocker-runner

1. Open powershell.
2. Go to directory testrun.
3. Write command 
```
docker-compose up
```
Test create the docker containers and run all test cases.
### Logs
Logs from jenkins:

![alt text](https://i.ibb.co/XkbYrw4/photo-Of-Build.png)
