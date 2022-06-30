//import buildStatus
//import groovy.json.JsonBuilder
def buildStatuses =[]
@Library('jenkins-shared-library')_
import buildStatus
import groovy.json.JsonBuilder

//def env.json = new JsonBuilder( buildStatuses ).toPrettyString()
pipeline {
    agent any
	parameters {
        choice(choices: ['false' , 'true'],name: 'pr_scan')
        choice(choices: ['false' , 'true'],name: 'daily_scan')
	}
  stages {
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
          sh 'docker rmi -f pylint_image'
          sh "docker build -t pylint_image -f pylint.Dockerfile . --label 'ci-docker-build=true'"
          sh 'docker run --rm -it -v ${PWD}:/code pylint_image'
          sh 'cat pylint.log'
          recordIssues(
            tool: pyLint(name : 'pylint Error', pattern:'pylint.log'), 
          )
          */
          buildStatuses << new buildStatus ( test_name: 'pylint', status: true )
          //buildStatuses << new buildStatus ( test_name: 'pylint', status: true )
        }
      }
    }
    /*
    stage ('pytest scan') {
      steps {
        script{
          echo 'pytest'
          /*sh 'docker rmi -f pytest_image'
          sh "docker build -t pytest_image -f pytest.Dockerfile . --label 'ci-docker-build=true'"
          sh 'docker run --rm -it -v ${PWD}:/code pytest_image_image'
          junit testResults: 'pytest_result.xml',skipPublishingChecks: true
          buildStatuses << new buildStatus ( test_name: 'pylint', status: true )
          //buildStatuses << new buildStatus ( test_name: 'pytest', status: true )
        }
      }
    }
    */
    stage ('update Build Staus') {
      steps {
        script{
          echo 'pytest'
          /*sh 'docker rmi -f pytest_image'
          sh "docker build -t pytest_image -f pytest.Dockerfile . --label 'ci-docker-build=true'"
          sh 'docker run --rm -it -v ${PWD}:/code pytest_image_image'
          junit testResults: 'pytest_result.xml',skipPublishingChecks: true
          */
          buildStatuses << new buildStatus ( test_name: 'pylint', status: true )
          //buildStatuses << new buildStatus ( test_name: 'pytest', status: true )
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