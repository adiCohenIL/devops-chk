#!groovy

import jenkins.model.*
import hudson.security.*
import jenkins.security.s2m.AdminWhitelistRule

def instance = Jenkins.getInstance()

//def user = 'admin'
//def pass = 'admin'

def user = new File("/run/secrets/jenkins-adm-name").text.trim()
def pass = new File("/run/secrets/jenkins-adm-pass").text.trim()

println "Creating user " + user + "..."

def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount(user, pass)
instance.setSecurityRealm(hudsonRealm)

def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
instance.setAuthorizationStrategy(strategy)
instance.save()

Jenkins.instance.getInjector().getInstance(AdminWhitelistRule.class).setMasterKillSwitch(false)


println "User " + user + " was created"
