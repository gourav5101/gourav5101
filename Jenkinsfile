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
      //when  {expression {prams.pr_scan ==true || prams.daily_scan == true}}
      steps {
          script {
             echo 'this is pr or pr scan '
             if (prams.pr_scan == true || prams.daily_scan == true) {
            try{
             skipRemainingStages = 'false'
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
      //when { expression {params.daily_scan ==true && skipRemainingStages == false }}
      steps {
         script{
            echo 'this is pr or daily scan '
             if (params.daily_scan ==true && skipRemainingStages == false) {
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
    }
    stage ('deply_stage') {
      //when  {expression {skipRemainingStages == true }}
      steps {
          script {
              if (skipRemainingStages == true) {
                echo 'this is deply'
                echo "${skipRemainingStages}"
              }else {
                echo 'no if'
            }
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
}