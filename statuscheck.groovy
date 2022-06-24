import buildStatus
import groovy.json.JsonBuilder
def buildStatuses =[]
buildStatuses << new buildStatus ( test_name: 'pylint', status: true )
buildStatuses << new buildStatus ( test_name: 'pytest', status: true )
println new JsonBuilder( buildStatuses ).toPrettyString()
