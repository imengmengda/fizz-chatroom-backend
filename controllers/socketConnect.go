package controllers

/*
import (
	"Fizz/models"
	"time"
	"github.com/gorilla/websocket"
	"container/list"
)

type Subscription struct {
	Archive []models.Event
	New 	<-chan models.Event
}

type Subscriber struct {
	Name string
	Conn *websocket.Conn
}


var (
	subscribe = make(chan Subscriber, 20)
	unsubscribe = make(chan string, 20)
	publish = make(chan models.Event, 20)
	waitingList = list.New()
	subscribers = list.New()
)

func newEvent(eventType models.EventType, user, message string) models.Event {
	return models.Event{eventType, user, message, int(time.Now().Unix())}
}

func Join(user string, conn *websocket.Conn) {
	subscribe <- Subscriber{user, conn}
}

func Leave(user string) {
	unsubscribe <- user
}

func isUserOnline(subscribers *list.List, user string) bool {
	for item := subscribers.Front(); item != nil; item = item.Next() {
		if item..Value.(Subscriber).Name == user {
			return true
		}
	}
	return false
}

func subscribeHandler(sub *Subscriber) {

}

func unsubscribeHandler(unsub *string) {

}

func publistHandler(event *models.Event) {

}

func chatroomInit() {
	for {
		select {
		case sub := <-subscribe:
			subscribeHandler(&sub)
		case event := <-publish:
			publistHandler(&event)
		case unsub := <-unsubscribe:
			unsubscribeHandler(&unsub)
		}
	}
}

func init() {
	go chatroomInit()
}

*/
