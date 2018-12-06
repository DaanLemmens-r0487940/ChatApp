startChat();

function startChat(button){
    if (document.getElementById("chat") != null){
        $("#chat").hide();
    }
    openChatScreen(button);
}

function openChatScreen(button){
    var receiver = button.id;

    $(document).ready(function(){
        //more fancy shit for this app, because i like doing this stuff
        $("#chat").hide().fadeIn(4000);


        $("#sendMessage").click(function(){
           var message = $("#message").val();
           $("#message").val('');
            $.post("Controller?action=SendMessage", {
                //change these names
                message : message,
                receiver : receiver
            });
        });
        loadMessages(button);
    });
}

function loadMessages(friendo){
    // console.log(friend.id

    //is actually the receiver, but lets call it friend for easy naming
    var friendo = friend.id;

    $.ajax({
       type : "GET",
       url : "Controller?action=GetMessages&friend=" + friendo,
        datatype : "application/json",
        succes : frunction(json) {
           var data = JSON.parse(json);
           var chat = $("#chat");

           for (var i = 0; i < data.length; i++){
               var p = document.createElement("p");
               p.innerHTML = data[i];
               chat.appendChild(p);
           }
    }
    });
    setTimeout(loadMessages(), 1000);
}