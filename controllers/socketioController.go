package controllers

import (
	"log"
	"github.com/googollee/go-socket.io"
	"runtime"
	"time"
	"encoding/json"
	"sync"
	"github.com/astaxie/beego"
	"fmt"
)

const websocketRoom = "/chat"

func init() {
	lastMessages := []string{}
	var lmMutex sync.Mutex
	// Sets the number of maxium goroutines to the 2*numberCPU + 1
	runtime.GOMAXPROCS((runtime.NumCPU() * 2) + 1)

	// Configuring socket.io Server
	sio, err := socketio.NewServer(nil)
	if err != nil {
		log.Fatal(err)
	}

	sio.On("connection", func(so socketio.Socket) {
		var username string
		username = "User-" + so.Id()
		log.Println("on connection", username)

		so.On("login", func(message string){
			log.Println("get the login msg")
			log.Println(message)
			//
			if message == "leave" {
				so.Leave(websocketRoom)
			}
			so.Emit("login success", "/join")
			//
			/*
			var returnFile = getFile()
			log.Println(returnFile)
			so.Emit("login success", returnFile)
			*/

			/*
			models.LoginChan <- models.LoginConnector{
				User: "linshaokui",
				Id:"mengmengd"}
			*/
			//so.BroadcastTo(websocketRoom,"message", message)
		})

		so.Emit("message", "welcome")

		so.Join(websocketRoom)

		so.On("new_msg", func(message string){
			log.Println("get the new msg")
			log.Println(message)
			if message == "leave" {
				so.Leave(websocketRoom)
			}
			so.BroadcastTo(websocketRoom,"message", message)
		})

		lmMutex.Lock()
		for i, _ := range lastMessages {
			so.Emit("message", lastMessages[i])
		}
		lmMutex.Unlock()

		so.On("joined_message", func(message string) {
			username = message
			log.Println("joined_message", message)
			res := map[string]interface{}{
				"username": username,
				"dateTime": time.Now().UTC().Format(time.RFC3339Nano),
				"type":     "joined_message",
			}
			jsonRes, _ := json.Marshal(res)
			so.Emit("message", string(jsonRes))
			so.BroadcastTo(websocketRoom, "message", string(jsonRes))
		})
		so.On("send_message", func(message string) {
			log.Println("send_message from", username)
			res := map[string]interface{}{
				"username": username,
				"message":  message,
				"dateTime": time.Now().UTC().Format(time.RFC3339),
				"type":     "message",
			}
			jsonRes, _ := json.Marshal(res)
			lmMutex.Lock()
			if len(lastMessages) == 100 {
				lastMessages = lastMessages[1:100]
			}
			lastMessages = append(lastMessages, string(jsonRes))
			lmMutex.Unlock()
			so.Emit("message", string(jsonRes))
			so.BroadcastTo(websocketRoom, "message", string(jsonRes))
		})
		so.On("disconnection", func() {
			log.Println("on disconnect", username)
		})
	})
	sio.On("error", func(so socketio.Socket, err error) {
		log.Println("error:", err)
	})

	// Sets up the handlers and listen on port 8080

	/*
	http.Handle("/socket.io/", sio)
	http.Handle("/static/", http.StripPrefix("/static/", http.FileServer(http.Dir("./static/"))))
	http.Handle("/", http.FileServer(http.Dir("./templates/")))

	// Default to :8080 if not defined via environmental variable.
	var listen string = os.Getenv("LISTEN")

	if listen == "" {
		listen = ":8080"
	}

	log.Println("listening on", listen)
	http.ListenAndServe(listen, nil)
	*/

	fmt.Println("debug/n")
	beego.Handler("/socket.io/", sio) //debug here
}

/*
func getFile() string {
	inputFile, err1 := os.OpenFile("views/chatroom.html", os.O_RDONLY, 0)
	if err1 != nil{
		log.Println("open file error")
		log.Println(err1)
	}
	defer inputFile.Close()
	buf, err2 := ioutil.ReadAll(inputFile)
	if err2 != nil {
		log.Println("read file error")
	}
	return string(buf)
}
*/
