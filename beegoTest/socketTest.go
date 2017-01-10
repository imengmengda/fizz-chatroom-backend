package main

import (
	"fmt"
	"github.com/googollee/go-socket.io"
	"log"
	"net/http"
)


func main() {

	fmt.Printf("socket server init\n")
	socketServer, err := socketio.NewServer(nil)
	if err != nil {
		fmt.Println("create socket server fail\n")
	}
	spSocketServer := socketServer.Of("/sp")

	spSocketServer.On("connection", func(socket socketio.Socket) {
		fmt.Printf("ID: %v on SPconnection\n", socket.Id())
		socket.Join("chat\n")
		socket.On("chat msg\n", func(msg string) {
			fmt.Printf("receive msg from ID: %v : %v\n", socket.Id(), msg)
		})
	})
	socketServer.On("connection", func(socket socketio.Socket) {
		fmt.Printf("ID: %v on connection\n", socket.Id())
		socket.Join("chat\n")
		socket.Emit("join ack", "%v has join the room", socket.Id())
		socket.On("chat msg", func(msg string) {
			fmt.Printf("receive msg from ID: %v : %v\n", socket.Id(), msg)
		})
	})
	socketServer.On("error", func(so socketio.Socket, err error) {
		log.Println("error:", err)
	})

	http.Handle("/socket.io/", socketServer)
	http.Handle("/", http.FileServer(http.Dir("../views")))
	log.Println("Serving at localhost:5000...")
	http.ListenAndServe(":5000", nil)
	//log.Fatal(go http.ListenAndServe(":8080", nil))
	log.Println("for debug")

}
