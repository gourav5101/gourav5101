//import buildStatus
//import groovy.json.JsonBuilder
def buildStatuses =[]
@Library('jenkins-shared-library')_
import buildStatus
import groovy.json.JsonBuilder

pipeline {
    agent any
	parameters {
        choice(choices: ['false' , 'true'],name: 'pr_scan')
        choice(choices: ['false' , 'true'],name: 'daily_scan')
	}
  stages {
    stage ('sloccount scan') {
      steps {
        script{
          echo 'pylint'
            sh 'sloccount --duplicates --wide --details . > sloccount.sc'
            sloccountPublish encoding: '', pattern: ''
          
        }
      }
    }
  /*stages {
    stage ('pylint scan') {
      when {
        expression { params.pr_scan  == 'true' ||  params.daily_scan == 'true' }
      }
      steps {
        script{
          echo 'pylint'
          def pylintResult = [] as ArrayList
          pylintResult = pylint()
          updateBuildStatus(buildStatuses,pylintResult)
        }
      }
    }
    
    stage ('pytest scan') {
      steps {
        script{
          echo 'pytest'
          /*sh 'docker rmi -f pytest_image'
          sh "docker build -t pytest_image -f pytest.Dockerfile . --label 'ci-docker-build=true'"
          sh 'docker run --rm -it -v ${PWD}:/code pytest_image_image'
          junit testResults: 'pytest_result.xml',skipPublishingChecks: true
        }
      }
    }
    */
    stage ('update Build Staus') {
      steps {
        script{
          echo 'updateBuild Status'
          updateBuildStatus(buildStatuses)
        }
      }
    }
    stage ('deploy scan') {
      steps {
        script{
          echo 'deploy'
          deploy_app()
        }
      }
    }
  }
}