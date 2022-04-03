pipeline {
  agent any
  parameters {
    string(name: 'tag', defaultValue: '', description: 'Tag to Build')
    choice(choices: ['dev','test','uat','stag','pre-prod','prod'], name: 'environment', description: 'Environment to build')
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