package models

import (
	"time"
)

type ModelConnector struct {

}

type NewMessage struct {
	MessageTime	time.Time
	User		string
	Content		string
}

type JoinConnector struct {
	User	string
	Id      string
}

type LeaveConnector struct {

}

type LoginConnector struct {
	User	string
	Id 	string
}

type RegisterConnector struct {

}

var (
	LoginChan = make(chan LoginConnector, 10)
	UnloginChan = make(chan LoginConnector, 10)
)

