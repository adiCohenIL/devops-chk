# DevOps Interview Test

## Welcome to Qwilt

In this repository you'll find Light-weight continuous deployment exercise. 

## General Guide-Lines

- Your work and configuration should be visible and you will be instructed to
  present them.
- We expect a running "Dummy" service, and a working automated deployment work-flow. 
- Use this repository as the workspace for everything you build and configure 


## Let's Begin
1. You will do the exercise on EC2 machine , please download [devops-candidate.pem](./devops-candidate.pem) 
and login to EC2 by:  
```sh
ssh  -i <devops-candidate.pem full path> ubuntu@18.202.36.113
```

2. Clone this repository https://github.com/adiCohenIL/devops-chk on EC2

   **Make sure you create your own branch to work on !**

3. This repostitory contains dummy nodeJS app in CICD-exercise directory (See `package.json` and `app.js`)
#### Dummy Service setup
* cd CICD-exercise
* Install Node dependencies with: `npm install`
* Run service: `npm run start`

#### Dummy service has health check:

- `GET` http://localhost:3000/health - ⚠️ Randomly reports unhealthy!

4. Create a Dockerfile for the Dummy service for being able to run the service as a Docker container.
5. Docker registry is available on EC2 , called **qwilt-registry**
#### Get images in regisry

```sh
curl -X GET http://qwilt-registry:5000/v2/_catalog
```
#### Get tags of image in regisry
```sh
curl -X GET http://qwilt-registry:5000/v2/<image-name>/tags/list
```

6. Jenkins is available on  **http://18.202.36.113:8080**  
   Edit "Ci Cycle" jo to create and upload docker image to registry
   **Note: versioning of image is expected
   **build groovy file should be saved in /home/ubuntu/repos/devops-chk/CICD-exercise/ci_jenkinsfile **
7. Add Jenkins task to deploy to EC2 machine ( get image from registry and run it) 
8. Bonus:  add health check to your service (in the dockerfile)
   
## Good Luck


Copyright © 2021 Qwilt
