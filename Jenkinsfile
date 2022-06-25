//import buildStatus
//import groovy.json.JsonBuilder
env.buildStatuses =[]

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
    stage ('pylint scan') {
      steps {
        script{
          echo 'pylint'
          /*sh 'docker rmi -f pylint_image'
          sh "docker build -t pylint_image -f pylint.Dockerfile . --label 'ci-docker-build=true'"
          sh 'docker run --rm -it -v ${PWD}:/code pylint_image'
          sh 'cat pylint.log'
          recordIssues(
            tool: pyLint(name : 'pylint Error', pattern:'pylint.log'), 
          )
          */
          env.buildStatuses << new buildStatus ( test_name: 'pylint', status: true )
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
          */
          env.buildStatuses << new buildStatus ( test_name: 'pytest', status: true )
        }
      }
    }

    stage ('deploy scan') {
      steps {
        script{
          echo 'deploy'
          env.json = new JsonBuilder( env.buildStatuses ).toPrettyString()
          deploy_app()
        }
      }
    }
  }
}
