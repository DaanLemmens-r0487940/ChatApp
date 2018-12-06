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

function loadMessages(button){

}