
multibranchPipelineJob('builds-npkill') {

  description '''
    Build npkill
    
    This service to find and remove old and heavy node_modules folders

    Repository: https://https://github.com/adiCohenIL/my-npkill
  '''

  branchSources {
    github {
      repoOwner('adiCohenIL')
      repository('my-npkill')
      id('my-npkill')
    }
  }

  factory {
    workflowBranchProjectFactory {
      scriptPath('Jenkinsfile')
    }
  }

  orphanedItemStrategy {
    discardOldItems {
      numToKeep(14)
    }
  }

}

