pipeline {
  agent any
  parameters {
    string(name: 'tag', defaultValue: '', description: 'Tag to Build')
    choice(choices: ['dev','test','uat','stag','pre-prod','prod'], name: 'environment', defaultValue: '', description: 'Environment to build')
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