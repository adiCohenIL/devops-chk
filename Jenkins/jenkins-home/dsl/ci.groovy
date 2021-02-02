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
            url('https://github.com/adiCohenIL/test.git')
            //credentials('cwtservice-github-ssh')
          }
          branch('*/master')
        }
        scriptPath('ci_jenkinsfile')
      }
    }
  }
}
