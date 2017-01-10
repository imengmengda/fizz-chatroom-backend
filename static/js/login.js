/**
 * Created by lin on 17-1-1.
 */

var login = function () {
    console.log("on login");
    /*
    var loginRequest = new XMLHttpRequest();
    var fakeName = document.getElementById("fake_name").value;
    var chatUrl = "http://localhost:8080/join?user=" + fakeName;

    /*
    loginRequest.open("GET", );



    $.get("http://localhost:8080/join?user=" + fakeName, {},
        function(data){
            console.log(data);
            //how to refresh the html with data?
        });

    console.log("debug");
    console.log("http://localhost:8080/join?user=" + fakeName);
    */
    var socket = io();
    socket.on('connect', function(){
        console.log("connected");
        var userInfo = getUserInfo();
        console.log(userInfo)
        socket.emit("login", "who");
        chatUrl = "http://localhost:8080/join?";
        //window.location.replace(chatUrl);
    });

    socket.on('disconnect', function(){
        console.log("disconnected");
    });

    socket.on('login success', function (msg) {
        console.log("login success");
        console.log(msg);
        window.location.href = msg;
    })

    socket.on('login fail', function (msg) {
        console.log("login fail");
    })



    //window.location.replace(chatUrl);
}

var register = function () {
    console.log("on register");
    var socket = io();
    socket.on('connect', function(){
        console.log("connected");
    });

    socket.on('disconnect', function(){
        console.log("disconnected");
    });

    socket.on('register success', function (msg) {
        console.log("register success");
    })

    socket.on('register fail', function (msg) {
        console.log("register fail");
    })

    socket.send("register", getUserInfo());
}

var getUserInfo = function () {
    var nickname = document.getElementById("nickname").value;
    var passwd = document.getElementById("password").value;
    //socket.emit(msg);
    var userInfo = {
        "nickname" : nickname,
        "passwd": passwd
                };
    return userInfo;
}