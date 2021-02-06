#!/bin/sh
docker build  -t jenkins-master-dsl .
docker run --rm -v /var/run/docker.sock:/var/run/docker.sock  -v /home/ubuntu/repos/:/data  -p 8080:8080    --name jenkins-master-dsl jenkins-master-dsl
