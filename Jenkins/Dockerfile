FROM jenkins/jenkins:jdk11

USER root

ENV JEN_REF /usr/share/jenkins/ref

RUN apt-get update && apt-get install -y lsb-release
RUN curl -fsSLo /usr/share/keyrings/docker-archive-keyring.asc \
  https://download.docker.com/linux/debian/gpg
RUN echo "deb [arch=$(dpkg --print-architecture) \
  signed-by=/usr/share/keyrings/docker-archive-keyring.asc] \
  https://download.docker.com/linux/debian \
  $(lsb_release -cs) stable" > /etc/apt/sources.list.d/docker.list
RUN apt-get update && apt-get install -y docker-ce-cli

COPY jenkins-home/jobs $JEN_REF/jobs/
COPY jenkins-home/init.groovy.d $JEN_REF/init.groovy.d/
COPY jenkins-home/dsl $JEN_REF/dsl/
COPY jenkins-home/security.groovy  $JEN_REF/init.groovy.d/security.groovy

USER jenkins

ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"

RUN jenkins-plugin-cli --plugins "config-file-provider credentials display-url-api git-client git-parameter git github-api github-branch-source github-oauth github-pullrequest github github-scm-trait-commit-skip git-server pipeline-github-lib groovy job-dsl junit plain-credentials scm-api ssh-credentials ssh structs workflow-multibranch"
