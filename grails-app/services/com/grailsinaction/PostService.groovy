package com.grailsinaction

class PostException extends RuntimeException {
	String message
	Post post
}

class PostService implements RemotePostService {
	static expose = [ "rmi", "axis2" ]
	
	long createPost(String username, String content) {
		def user = User.findByUserId(username)
		if (!user) throw new RuntimeException("'$username' not found.")
		def post = createPost(user.id, content)
		if (!post) throw new RuntimeException("Creation failed.")
		return post.id
	}
	
	Post createPost(long userId, String content) {
		def user = User.findByUserId(userId)
		if (user) {
			def post = new Post(content: content)
			user.addToPosts(post)
			if (user.save()) {
				return post
			} else {
				throw new PostException(
				message: "Invalid or empty post", post: post)
			}
		}
		throw new PostException(message: "Invalid User Id")
	}
}
