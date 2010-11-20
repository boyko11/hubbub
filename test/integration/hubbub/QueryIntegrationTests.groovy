package hubbub

import grails.test.*
import com.grailsinaction.*

class QueryIntegrationTests extends GrailsUnitTestCase {
	
	void testBasicDynamicFinders() {
		def userOne = new User(userId: 'glen', password: 'secret', profile: new Profile(email: 'glen@glensmith.com')).save()
		def userTwo = new User(userId: 'peter', password: 'sesame', profile: new Profile(homepage: 'http://www.peter.com/')).save()
		
		assertNotNull userOne
		assertNotNull userTwo
		
		def user = User.findByPassword('sesame')
		
		assertEquals 'peter', user.userId
		
		user = User.findByUserIdAndPassword('glen', 'secret')
		
		assertEquals 'glen', user.userId
		
		def now = new Date()
		
		def users = User.findAllByDateCreatedBetween(now-1, now)
		
		assertEquals 2, users.size()
		
		def profiles = Profile.findAllByEmailIsNotNull()
		
		assertEquals 1, profiles.size()
	}
}
