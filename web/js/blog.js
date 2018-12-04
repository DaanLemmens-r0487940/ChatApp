var webSocket;
var path = "ChatApp"

//DOE DIT ZOALS VORIGE KEER (friends ofzo), NIET ZOALS DIT. duus in jsp
var body = document.getElementById("blogBody");
body.onload = openSocket;


function openSocket() {
    console.log("Connection (Socket) opened.");

    //webSocket = new WebSocket("ws://localhost:8080/blog");
    //?? which one, or what does chatapp be in mine
    webSocket = new WebSocket("ws://localhost:8080/blog");



   /* webSocket.onopen = function (event) {
        writeResponse("Connection opened");
    };*/

    webSocket.onmessage = function(event){
        writeResponse(event.data);
    };

  /*  webSocket.onclose = function(event){
        writeResponse("Connection closed");
    };*/
}

function writeResponse(message){
    console.log(message);

    var message = JSON.parse(message);
    var commentOnTopic = message.topic;
    var name = message.name;
    var content = message.comment;
    var rating = message.rating;
    var topicMessages;

    console.log(commentOnTopic);





    //messages.innerHTML +="<br/>" + text;


    /*var messageParagraph = messages.childNodes[0];

    messageParagraph = document.createElement('p');

    var messageText = document.createTextNode(text);
    messageParagraph.appendChild(messageText);
    messages.appendChild(messageParagraph);*/
    switch(commentOnTopic){
        case "(1)Projectweek":
            topicMessages = document.getElementById("comment1");
            topicMessages.innerHTML += "<p><b>" + name + ": </b>" + content + "<b>|  Rating: "+ rating + "</b></p>";
            break;
        case "(2)Planning":
            topicMessages = document.getElementById("comment2");
            topicMessages.innerHTML += "<p><b>" + name + ": </b>" + content + "<b>|  Rating: "+ rating + "</b></p>";
            break;
        case "(3)Muziek":
            topicMessages = document.getElementById("comment3");
            topicMessages.innerHTML += "<p><b>" + name + ": </b>" + content + "<b>|  Rating: "+ rating + "</b></p>";
            break;
        case "(4)Examenvragen":
            topicMessages = document.getElementById("comment4");
            topicMessages.innerHTML += "<p><b>" + name + ": </b>" + content + "<b>|  Rating: "+ rating + "</b></p>";
            break;
        case "(5)Films":
            topicMessages = document.getElementById("comment5");
            topicMessages.innerHTML += "<p><b>" + name + ": </b>" + content + "<b>|  Rating: "+ rating + "</b></p>";
            break;
    }
}
//??????????????????????
//refreshen van blog met onthouden van comments
//zie friends??
function send(){
    var commentOnTopic = document.getElementById("commentTopic").value;
    var name = document.getElementById("name").value;
    var message = document.getElementById("comment").value;
    var rating = document.getElementById("rating").value;

    var error = document.getElementById("error");

    if (name == null ||  name == ''){
        error.innerHTML ="";
        error.innerHTML += "<li>Name can't be empty.</li>";
    }
    else if ( message == null || message == ''){
        error.innerHTML ="";
        error.innerHTML += "<li>Message can't be empty.</li>";
    }
    else if (rating < 1 || rating > 5){
        error.innerHTML ="";
        error.innerHTML += "<li> must be a number between 1 and 5.</li>";
    }
    else {
        error.innerHTML ="";

        var json = "{\"topic\" :\"" + commentOnTopic + "\", \"name\" :\"" + name + "\", \"comment\" :\"" + message + "\", \"rating\" :\"" + rating + "\"}";
        console.log(json);

        webSocket.send(json);
    }






   /* var text = document.getElementById("blog1Input").value;
    webSocket.send(text);*/
}
/*

function send2(){
    var text = document.getElementById("blog2Input").value;
    webSocket.send(text);
}

function send3(){
    var text = document.getElementById("blog3Input").value;
    webSocket.send(text);
}
function send4(){
    var text = document.getElementById("blog4Input").value;
    webSocket.send(text);
}
function send5(){
    var text = document.getElementById("blog5Input").value;
    webSocket.send(text);
}
*/




//ON LEAVING PAGE CLOSE? is this also with refresh?
function closeSocket(){
    console.log("Connection (Socket) closed.");
    webSocket.close();
}