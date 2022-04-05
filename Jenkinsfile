def skipRemainingStages ='1'
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
      }
    }
    stage ('pr_stage') {
      when  {expression {prams.pr_scan ==true || prams.daily_scan == true}}
      steps {
          script {
             echo 'this is pr or pr scan '
            try{
             skipRemainingStages = '2'
             print skipRemainingStages = ${skipRemainingStages}
             echo "${skipRemainingStages}"
            }catch (err) {
            echo "Caught: ${err}"
            currentBuild.result = 'SUCCESS'
            return
            }
          }
        }
    }
    stage ('daily_stage') {
      when { expression {params.daily_scan ==true && skipRemainingStages == '1' }}
      steps {
         script{
            echo 'this is pr or daily scan '
             try{
             skipRemainingStages = 'false'
             print skipRemainingStages = ${skipRemainingStages}
             echo "${skipRemainingStages}"
             }catch(err){
             echo "Caught: ${err}"
            currentBuild.result = 'SUCCESS'
            return
             }
          }
        }
    }
    stage ('deply_stage') {
      when  {expression {skipRemainingStages == '1' }}
      steps {
        script {
            echo 'this is deply'
            echo "${skipRemainingStages}"
          }
        }
    }
    stage ('deploy2'){
      steps{
        echo'this is deploy2'
      }
    }
  }
}
