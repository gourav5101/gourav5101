pipeline {
  agent any
  parameters {
    string(name: 'tag', defaultvalue: '', description: 'Tag to Build')
    choice(choices: ['dev', 'test', 'staging', 'uat', 'pre-prod', 'prod'],name: 'environment', defaultvalue: '', description: 'Deploy to which environment')
    
  }
  stages {
    stage ('build') {
      steps {
        echo 'this is build'
        sh 'uname -a'
      }
    }
    stage ('test') {
      steps {
        echo 'this is tesr'
      }
    }
    
    stage ('deploy1') {
      steps {
        echo 'this is deploy1'
      }
    }
    stage ('deploy2') {
      steps {
        echo 'this is deploy2'
      }
    }
  }
}