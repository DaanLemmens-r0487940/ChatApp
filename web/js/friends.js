var xHRObject = new XMLHttpRequest();

function friendList() {
    xHRObject.open("GET", "Controller?action=GetFriends", true);
    xHRObject.onreadystatechange = getFriendListData;
    xHRObject.send(null);
}

function getFriendListData() {
    console.log("GET FRIEND LIST");
    if (xHRObject.readyState == 4) {
        if (xHRObject.status == 200) {

            var response = JSON.parse(xHRObject.responseText);
            console.log(response);
            var tbody = document.getElementById("friendListBody");


            //for all friends in json, get email, status and firstname
            for (i = 0; i < response.length; i++) {
                var firstName = response[i]["firstName"];
                let email = response[i].userId;
                var status = response[i].status;


                var tr = document.createElement('tr');
                var tdUser = document.createElement('td');
                var tdStatus = document.createElement('td');

                //chat part
                var tdChat = document.createElement('td');
                var chatButton = document.createElement('button');
                chatButton.type = 'submit';
                chatButton.innerHTML = 'Chat';

                chatButton.setAttribute('id', email);

                //call chat.js which will then call openchatscreen in chat.js
                chatButton.addEventListener("click", function(){
                    chat(email);
                });


                tdUser.innerHTML = firstName;
                tdStatus.innerHTML = status;

                tdChat.appendChild(chatButton);

                tr.appendChild(tdUser);
                tr.appendChild(tdStatus);

                tr.appendChild(tdChat);


                if (tbody.childNodes[i] != null) {
                    tbody.replaceChild(tr, tbody.childNodes[i]);
                } else {
                    tbody.appendChild(tr);
                }

            }

            setTimeout("friendList()", 1000);

        }
    }

}

function chat(email){
    openChatScreen(email);
}
