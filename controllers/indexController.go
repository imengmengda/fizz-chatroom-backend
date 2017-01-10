package controllers

import (
	"github.com/astaxie/beego"
	"Fizz/models"
	"log"
	"time"
)

type IndexController struct {
	beego.Controller
}

func (c *IndexController) Get() {
	//c.Data["Website"] = "beego.me"
	//c.Data["Email"] = "astaxie@gmail.com"

	c.TplName = "login.html"
}

func (c *IndexController) Login() {
	//loginUser := models.LoginConnector{}
	select {
	case  loginUser := <- models.LoginChan: {
		log.Println(loginUser)
		log.Println("login success")
		c.TplName = "chatroom.html"
	}
	case  <-time.After(1 * time.Second): {
		log.Println("login timeout")
	}
	}
	//c.TplName = "login.html"
}

func (c *IndexController) Join() {
	c.TplName = "chatroom.html"
	/*
	c.Data["FakeName"] = c.GetString("fake_name")
	c.Data["Password"] = c.GetString("password")
	//c.TplName = "login.html"
	//redirect after socket
	c.Redirect("/", 302)
	*/
	//log.Println("for debug")
	/*
	fakeName := c.GetString("user")
	c.Redirect("/chat?user=" + fakeName, 302)
	*/
	//return
	/*
	fmt.Println("debug")
	ws, err := websocket.Upgrade(c.Ctx.ResponseWriter, c.Ctx.Request, nil, 1024, 1024)
	if _, ok := err.(websocket.HandshakeError); ok {
		http.Error(c.Ctx.ResponseWriter, "Not a websocket handshake", 400)
		fmt.Println("haha")
		return
	} else if err != nil {
		beego.Error("Cannot setup WebSocket connection:", err)
		fmt.Print("huhu")
		return
	}
	ws.WriteMessage(websocket.TextMessage, []byte("client connection"))
	go func() {
		defer log.Println("the user has leave")
		for {
			_, p, err := ws.ReadMessage()
			if err != nil {
				return
			} else {
				log.Printf("server receive the msg: %v ", string(p))
				fmt.Println(p)
			}
		}
	} ()
	*/
}

