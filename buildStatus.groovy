package net.my.jenkins.workflow
import com.cloudbees.groovy.cps.NonCPS
import groovy.json.JsonBuilder
class buildStatus{
  String test_name
  Boolean status
}
def buildStatuses =[]