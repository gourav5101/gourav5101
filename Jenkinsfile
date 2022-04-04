def skipRemainingStages ='true'
pipeline {
    agent any
	parameters {
        choice(choices: ['true' , 'false'],name: 'pr_scan')
        choice(choices: ['true' , 'false'],name: 'daily_scan')
	}
  stages {
    stage ('common_steps') {
      steps {
        echo 'this is common steps'
      }
    }
    stage ('pr_stage') {
      //when {expression (prams.pr_scan ==true || prams.daily_scan ==true)}
      steps {
          echo 'this is pr or daily scan '
          skipRemainingStages = 'false'
          echo "${skipRemainingStages}"
      }
    }
    stage ('daily_stage') {
      //when {expression (params.daily_scan ==true && skipRemainingStages == false )}
      steps {
          echo 'this is only daily scan'
          skipRemainingStages = 'false'
          echo "${skipRemainingStages}"

      }
    }
    stage ('deply_stage') {
      //when {expression (skipRemainingStages == true )}
      steps {
          echo 'this is deply'
          echo "${skipRemainingStages}"
        }
    }
  }
}