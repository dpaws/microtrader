node('DOCKER') {
    checkout scm

    try {
        stage('Test') {
            sh 'make test'
        }

        stage('Release') {
            sh 'make release'
        }

        stage('Publish') {
            sh 'make tag:default'
            withEnv(["DOCKER_USER=${DOCKER_USER}",
                     "DOCKER_PASSWORD=${DOCKER_PASSWORD}"]) {    
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