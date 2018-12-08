startChat();

function startChat(email){

    if (document.getElementById("chat") != null){
        $("#chat").hide();
    }
}

let receiver = "";

function openChatScreen(email){
    console.log("ID =  " + email);
   receiver = email;
 setInterval(loadMessages, 6000);
    $(document).ready(function(){
        //more fancy shit for this app, because i like doing this stuff
        $("#chat").hide().fadeIn(700);

        //when enter is pressed
        $('#message').keypress(function(event){
            if(event.keyCode == 13){
                sendMessage(email);
            }
        });

        //when clicked
        $("#sendMessage").click(function(){
           sendMessage(email);
           // $.post("Controller", {action: "SendMessage", m: message, r: receiver});
        });
    });
}


function sendMessage(email){
    let message = $("#message").val();
    $("#message").val('');
    $.post("Controller?action=SendMessage", {
        m : message,
        r : receiver
    });
}



function loadMessages() {
    console.log(receiver);
    if (receiver !== ""){
        $.ajax({
            type: "GET",
            url: "Controller?action=GetMessages&friend=" + receiver,
            dataType: "application/json",
            success: function (json) {

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
