class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')
		
		"/posts"(controller: "postRest") {
		action = [ GET: "list", POST: "save" ]
		}
		"/posts/$id"(controller: "postRest") {
		action = [ GET: "show", PUT: "update", DELETE: "delete" ]
		}
	}
}
