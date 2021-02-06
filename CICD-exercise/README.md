# Exercise I - NodeJS CI/CD

## Objectives

1. [ ] 🐳 Create a `Dockerfile` for the **Dummy** NodeJS service in this
  directory. (See `package.json` and `app.js`)
2. [ ] 📥 Deploy "Dummy" service as a **Docker container**.
3. [ ] ⚙️  Automate "Dummy" **build** process as a Docker image with Jenkins job triggered when repository is updated.
4. [ ] 🔄 Automate "Dummy" **deployment** with Ansible script or Jenkins job .
5. [ ] 🤒 Add Health-check monitoring for the "Dummy" service.

## Guide-Lines

- We expect a running "Dummy" service, and a working automated deployment work-flow. 
- Your work and configuration should be visible and you will be instructed to
  present them.
- Use this repository as the workspace for everything you build and configure 

   📌  **create your own branch to work on !** 

   📌  **build groovy file** should be saved in /home/ubuntu/repos/devops-chk/CICD-exercise/ci_jenkinsfile

## Let's Begin

The current directory contains the source-code for the "Dummy" NodeJS service. 
Your goal is writing a `Dockerfile` for being able to run the service as a 
Docker container and automate the build & deployment work-flow.


### Dummy Service Usage

**Prerequisites**:
- [ ] [GitHub](https://github.com) account

**Setup**:

1. Install Node dependencies with: `npm install`
2. Run service: `npm run start`

The service has health check:

- `GET` http://localhost:3000/health - ⚠️ Randomly reports unhealthy!



## Good Luck!
