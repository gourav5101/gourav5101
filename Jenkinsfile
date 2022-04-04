pipeline {
    agent any
	parameters {
        choice(
            choices: ['PR' , 'dev'],
            name: 'REQUESTED_ACTION')
	}
    stages {
		stage('Stage 1') {
			steps {
                script {
				sh 'echo Stage 1'
				}
			}
		}
        stage('Stage 2') {
            steps {
                script {
				    sh 'echo Stage 2'
                    if (REQUESTED_ACTION == 'PR') {
                        stage ('Stage 3') {
                            sh 'echo Stage 3'
                        }
						stage ('Stage 4') {
                            sh 'echo Stage 4'
                        }
                    }
                    else{
                        stage ('Stage 5') {
                            sh 'echo Stage 5'
                        }
                    }
                }
            }
        }
	}
}