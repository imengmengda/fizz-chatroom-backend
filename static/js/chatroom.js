/**
 * Created by lin on 17-1-1.
 */

var socket;

$(document).ready(function () {

    socket = new WebSocket("ws://localhost:8080/websocket");
    socket.onopen = function (event) {

        console.log("connected");
        socket.send("hi");

        socket.onmessage = function (event) {
            console.log("client receive msg", event);
        };
    };
});

function sendMsg() {
    var msg = document.getElementById("sendbox").value;
    socket.send(msg);
}