pipelineJob('ci') {
  displayName 'CI cycle'
  description 'Continuous Integration'
  logRotator {
    numToKeep(10)
  }
  properties {
    disableConcurrentBuilds()
  }
  definition {
    cpsScm {
      lightweight(true)
      scm {
        git {
          remote {
            url('https://github.com/adiCohenIL/devops-chk.git')
          }
          branch('*/master')
        }
        scriptPath('CICD-exercise/ci_jenkinsfile')
      }
    }
  }
}
