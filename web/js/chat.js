startChat();

function startChat(email){

    if (document.getElementById("chat") != null){
        $("#chat").hide();
    }
       // openChatScreen(email);
}

let receiver = "";

function openChatScreen(email){
    console.log("ID =  " + email);
//setInterval(getChat, 600);
   receiver = email;
   // var receiver = "an@ucll.be"
 setInterval(loadMessages, 6000);
    $(document).ready(function(){
        //more fancy shit for this app, because i like doing this stuff
        $("#chat").hide().fadeIn(700);


        $("#sendMessage").click(function(){
           var message = $("#message").val();
           $("#message").val('');
            $.post("Controller?action=SendMessage", {
                m : message,
                r : receiver
            });
           // $.post("Controller", {action: "SendMessage", m: message, r: receiver});
        });
        loadMessages();
    });
}



function loadMessages() {
    //console.log("FRIENDID:" + friend);


    //var receiver = "an@ucll.be"
    console.log(receiver);
    if (receiver !== ""){
        $.ajax({
            type: "GET",
            url: "Controller?action=GetMessages&friend=" + receiver,
            // dataType: "application/json",
            dataType: "application/json",
            success: function (json) {
                /*var data = JSON.parse(json);
                var chat = $("#messages")[0];
                // var chats = $("#chat");
                console.log(json);
                console.log(chat);
                console.log(data);
                //  console.log(chats);

                for (var i = 0; i < json.length; i++) {
                    var p = document.createElement('p');
                    p.innerHTML = json[i];
                    chat.appendChild(p);
                }*/

                var response = JSON.parse(json);
                console.log(response);

                $('#messages').empty();
                for (var i = 0; i < response.length; i++) {
                    $('#messages').append($('<p>' + response[i]+ '</p>'));
                }
            }
        });
    }


}
