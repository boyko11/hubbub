package com.grailsinaction

import grails.converters.XML

class PostRestController {
	
	def list = { render Post.list() as XML }
	def show = {
		Post post = Post.get(params.id)
		render post as XML
	}
	
	def save = {
		def xml = request.XML
		def post = new Post()
		post.content = xml.content.text()
		post.user = User.get(xml.user.@id.text())
		def markup
		if (post.save()) {
			markup = {
				status("OK")
			}
		}
		else {
			markup = {
				status("FAIL")
			}
		}
		render contentType: "application/xml; charset=utf-8",
		markup
	}
}
