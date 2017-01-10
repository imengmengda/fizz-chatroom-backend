package controllers

/*
import (
	"github.com/astaxie/beego"
	"net/http"
	"log"
	"github.com/gorilla/websocket"
)

type ChatController struct {
	beego.Controller
}

func (chatController *ChatController) Get() {
	//log.Println("one some ask for login")
	chatController.TplName = "chatroom.html"
}

func (chatController *ChatController) Join() {
	ws, err := websocket.Upgrade(chatController.Ctx.ResponseWriter, chatController.Ctx.Request, nil, 1024, 1024)
	if _, ok := err.(websocket.HandshakeError); ok {
		http.Error(chatController.Ctx.ResponseWriter, "Not a websocket handshake", 400)
		//fmt.Println("haha")
		return
	} else if err != nil {
		beego.Error("Cannot setup WebSocket connection:", err)
		//fmt.Print("huhu")
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
				ws.WriteMessage(websocket.TextMessage, p)
				//fmt.Println(p)
			}
		}
	} ()
}

*/