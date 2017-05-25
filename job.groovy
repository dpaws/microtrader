pipelineJob('Microtrader') {
	triggers {
    	scm 'H/5 * * * *'
    }
    definition {
        cps {
        	sandbox()
            script(readFileFromWorkspace('Jenkinsfile'))
        }
    }
}