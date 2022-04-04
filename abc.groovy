pipeline {
  agent any
  parameters {
    string(name: 'tag', defaultValue: '', description: 'Tag to Build')
    choice(choices: ['dev','test','uat','stag','pre-prod','prod'], name: 'environment', description: 'Environment to build')
  }
  stages {
    stage ('scan'){
      parallel {
        stage ('build1') {
          steps {
            echo 'this is build'
            sh 'uname -a'
          }
        }
        stage ('build2') {
          steps {
            script {
              echo 'this is build2'           
            }
          }
        }
      }
    }
    stage ('check for exit') {
      steps {
        script{
          if (params.environment == 'uat'){
            echo 'exit'
            currentBuild.result = 'SUCCESS'
            return
          }
          else{
            stages {
              stage ('test in exit') {
                steps {
                echo 'this is test in exit'
                }
             }
              stage ('deploy in exit') {
                steps {
                  echo 'this is deploy in exit'
                }
              }
            }
          }
        } 
      } 
    }  
    /*stage ('test') {
      steps {
        echo 'this is test'
      }
    }
    stage ('deploy') {
      steps {
        echo 'this is deploy'
      }
    }
    */
  }
}
================================================
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
=================================================