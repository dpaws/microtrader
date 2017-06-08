node('docker') {
    checkout scm
    ansiColor('xterm') {
        try {
            stage('Test') {
                sh 'make test'
            }

            stage('Release') {
                sh 'make release'
            }

            stage('Publish') {
                sh 'make tag:default'
                 withCredentials([usernamePassword(
                    credentialsId: 'docker-hub',
                    usernameVariable: 'DOCKER_USER', 
                    passwordVariable: 'DOCKER_PASSWORD')]) {
                      sh 'make login'
                }
                sh 'make publish'
            }
        }
        finally {
            stage('Results') {
                step([$class: 'JUnitResultArchiver', testResults: '**/build/test-results/junit/*.xml'])
            }
            
            stage('Clean') {
                sh 'make clean'
                sh 'make logout'
            }
        }
    }
}