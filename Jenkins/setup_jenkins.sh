#!/bin/sh
docker build  -t jenkins-master-dsl .
docker run --rm -v /var/run/docker.sock:/var/run/docker.sock  -p 8080:8080  --name jenkins-master-dsl jenkins-master-dsl &
