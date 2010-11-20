package com.grailsinaction

class UserController {
	def scaffold = true
	
	def search = {
	}
	
	def userSearchResults = {
		def users = User.findAllByUserIdLike("%${params.userId}%")
		return [ users: users, term : params.userId ]
	}
}
