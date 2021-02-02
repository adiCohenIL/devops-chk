# Exercise I - NodeJS CI/CD

## Objectives

1. [ ] 👪 Create a `Dockerfile` for the **Dummy** NodeJS service in this
  directory. (See `package.json` and `app.js`)
1. [ ] 📥 Deploy "Dummy" service as a **Docker container**.
1. [ ] ⚙️ Automate "Dummy" **build** process as a Docker image with any tool
  or scripts you are familiar with.
1. [ ] 🔄 Automate "Dummy" **deployment** with Ansible scripts or Jenkins job.
1. [ ] 🔊 Bonus: Health-check monitoring for the "Dummy" service.

## Guide-Lines

- We expect a running "Dummy" service, and a working automated deployment work-flow. 
- Your work and configuration should be visible and you will be instructed to
  present them.
- Use this repository as the workspace for everything you build and configure.

## Let's Begin

The current directory contains the source-code for the "Dummy" NodeJS service. 
Your goal is writing a `Dockerfile` for being able to run the service as a 
Docker container and automate the build & deployment work-flow.


### Dummy Service Usage

**Prerequisites**:

- [ ] [GitHub](https://github.com) account
- [ ] [Docker](https://www.docker.com/products/docker-desktop)

**Setup**:

1. Clone repository: `git clone https://github.com/adiCohenIL/devops-chk.git`
2. Install Node dependencies with: `npm install`
3. Run service: `npm run start`

The service has healt check:

- `GET` http://localhost:3000/health - ⚠️ Randomly reports unhealthy!


## Appendix A

* [**GET**] http://localhost:3000/health
  * Report on health of the service
    * Response:
      * When system is healthy, HTTP status 200 (OK) and header
        `System-Health: true`.
      * If error occurs, HTTP status 500 and header `System-Health: false`.

## Good Luck!
