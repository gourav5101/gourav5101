
pipeline {
    agent any
	parameters {
        choice(choices: ['false' , 'true'],name: 'pr_scan')
        choice(choices: ['false' , 'true'],name: 'daily_scan')
	}
  stages {
    stage ('common_steps') {
      steps {
        echo 'this is common steps'
        sh 'docker --version'
      }
    }
  }
}
