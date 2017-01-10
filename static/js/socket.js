/**
 * Created by lin on 16-12-30.
 */

var socket = io();


socket.on('message', function(msg){
    console.log(msg);
});

socket.on('connect', function(){
    console.log("connect success");
});

socket.on('disconnect', function(){
    console.log("connect success");
});

var sendTest = function () {
    var msg = document.getElementById("sendbox").value;
    //socket.emit(msg);
    var data = {my : msg};
    socket.send("send_message", data);
    socket.emit("new_msg", msg);
    console.log("debug");
}
