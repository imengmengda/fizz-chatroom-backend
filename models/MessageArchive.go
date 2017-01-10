package models

import (
	"container/list"
)

type EventType int

const (
	EVENT_JOIN = iota
	EVENT_LEAVE
	EVENT_MESSAGE
)

const archiveSize = 30

type Event struct {
	Type 		EventType
	User 		string
	Content 	string
	Timestamp 	int
}

var archive = list.New()

func NewArchive(event Event) {
	if (archive.Len() >= archiveSize) {
		archive.Remove(archive.Front())
	}
	archive.PushBack(event)
}

func GetEvents(lastReceivetime int) []Event {
	events := make([]Event, 0, archive.Len())
	for event := archive.Front(); event != nil; event = event.Next() {
		e := event.Value.(Event)
		if e.Timestamp > lastReceivetime {
			events = append(events, e)
		}
	}
	return events
}


