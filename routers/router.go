package routers

import (
	"Fizz/controllers"
	"github.com/astaxie/beego"
)

func init() {
	beego.Router("/", &controllers.IndexController{})
	beego.Router("/join", &controllers.IndexController{}, "get:Join")

	//beego.Router("/chat", &controllers.ChatController{})
	//beego.Router("/websocket", &controllers.ChatController{}, "get:Join")
}
