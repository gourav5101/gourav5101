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
  }
  if (params.environment == 'uat'){
    stages{
      stage {
        steps{
          echo 'this is if'
        }
      }
    }
  }
  else{
    stages{
      stage {
        steps{
          echo 'this is else'
        }
      }
    }
  }
}