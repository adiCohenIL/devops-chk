
FROM jenkins/jenkins:lts

# handle jenkins plugin
ENV JEN_REF /usr/share/jenkins/ref
ENV JENKINS_UC_DOWNLOAD 'http://ftp-nyc.osuosl.org/pub/jenkins'

COPY jenkins-home/plugins.txt $JEN_REF/
RUN \
  ATTEMPTS=3 \
  /usr/local/bin/install-plugins.sh < $JEN_REF/plugins.txt

COPY jenkins-home/jenkins-adm-name /run/secrets/jenkins-adm-name
COPY jenkins-home/jenkins-adm-pass /run/secrets/jenkins-adm-pass

# Configure Jenkins
USER root

COPY jenkins-home/jobs $JEN_REF/jobs/
COPY jenkins-home/init.groovy.d $JEN_REF/init.groovy.d/
COPY jenkins-home/dsl $JEN_REF/dsl/
COPY jenkins-home/security.groovy  $JEN_REF/init.groovy.d/security.groovy
COPY jenkins-home/security.groovy  $JEN_REF/init.groovy.d/security.groovy
RUN install -d -o jenkins -g jenkins -m 0770 /var/log/jenkins

# Install Docker from official repo
RUN apt-get update -qq && \
    apt-get install -qqy apt-transport-https ca-certificates curl gnupg2 software-properties-common && \
    curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add - && \
    apt-key fingerprint 0EBFCD88 && \
    add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/debian $(lsb_release -cs) stable" && \
    apt-get update -qq && \
    apt-get install -qqy docker-ce && \
    usermod -aG docker jenkins && \
    chown -R jenkins:jenkins $JENKINS_HOME/

USER jenkins
ENV JAVA_OPTS="-Xmx8192m \
		-Dorg.eclipse.jetty.server.Request.maxFormContentSize=100000000 \
		-Dorg.apache.commons.jelly.tags.fmt.timeZone=America/Los_Angeles \
		-Dhudson.diyChunking=false \
		-Djenkins.install.runSetupWizard=false"
ENV JENKINS_OPTS=" --handlerCountMax=300 --logfile=/var/log/jenkins/jenkins.log"
