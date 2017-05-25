pipelineJob('Microtrader') {
    definition {
        cps {
        	sandbox()
            script(readFileFromWorkspace('Jenkinsfile'))
        }
    }
}