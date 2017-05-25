pipelineJob('Microtrader') {
	triggers {
  	scm 'H/5 * * * *'
  }
  definition {
		cpsScm {
      scm {
        git {
          remote {
            url("${GIT_URL}")
          }
          branch('master')
        }
      }
    	scriptPath('Jenkinsfile')
    }
  }
}

	