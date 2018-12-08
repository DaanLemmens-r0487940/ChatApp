startChat();

function startChat(email){

    if (document.getElementById("chat") != null){
        $("#chat").hide();
    }
}

let receiver = "";

function openChatScreen(email){
    //console.log("ID =  " + email);
    receiver = email;
    //set to 600
    setInterval(loadMessages, 600);
    $(document).ready(function(){
        //more fancy shit for this app, because i like doing this stuff
        $("#chat").hide().fadeIn(700);

        //when enter is pressed
        $('#message').unbind().keypress(function(event){
            if(event.keyCode == 13){
                sendMessage(email);
            }
        });

        //when clicked
        $("#sendMessage").unbind().click(function(){
            sendMessage(email);
            // $.post("Controller", {action: "SendMessage", m: message, r: receiver});
        });
    });
}


function sendMessage(receiver){
    let message = $("#message").val();
    $("#message").val('')

    console.log("Message will be send to: " + receiver);
    console.log("Message will be: " + message);
    $.post("Controller?action=SendMessage", {
        m : message,
        r : receiver
    });
}



function loadMessages() {
    console.log("Receive the conversation of this friend: " + receiver);
    if (receiver !== ""){
        $.ajax({
            type: "GET",
            url: "Controller?action=GetMessages&friend=" + receiver,
            dataType: "application/json",
            success: function (json) {

                var response = JSON.parse(json);
                //console.log(response);

             //   console.log(receiver);

               // if( $('#receiver').is(':empty') ) {
                   // var colon = response[0];
                    var split = receiver.split('@');
                    var name = split[0];
                    $('#receiver').empty();
                    $('#receiver').append($('<h3>' + name + '</h3>'));
               // }

                    $('#messages').empty();
                for (var i = 0; i < response.length; i++) {
                    $('#messages').append($('<p>' + response[i]+ '</p>'));
                }
            }
        });
    }


}
