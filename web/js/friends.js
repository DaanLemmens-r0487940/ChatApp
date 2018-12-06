var xHRObject = new XMLHttpRequest();

//window.onload = friendList;


function friendList() {
    xHRObject.open("GET", "Controller?action=GetFriends", true);
    xHRObject.onreadystatechange = getFriendListData;
    xHRObject.send(null);
}

function getFriendListData() {
    console.log("GET FRIEND LIST");
    if (xHRObject.readyState == 4) {
        if (xHRObject.status == 200) {
            //alert(getFriendListRequest.responseText);
            var response = JSON.parse(xHRObject.responseText);
            var tbody = document.getElementById("friendListBody")


            //FOR ALL FRIENDS IN THE JSON GET EMAIL (userid) AND STATUS;
            for (i = 0; i < response.length; i++) {
                var firstName = response[i]["firstName"];
                var status = response[i].status;


                var tr = document.createElement('tr');
                var tdUser = document.createElement('td');
                var tdStatus = document.createElement('td');

                //CHATGEDEELTE
                tdUser.innerHTML = firstName;
                tdStatus.innerHTML = status;

                tr.appendChild(tdUser);
                tr.appendChild(tdStatus);

                //START WITH CHILDNODES, TBODY ITSELF IS [0] CHILDNODE: TEXT
                //SO [0+1] = [1], THE FIRST NODE IS EMPTY AND WILL BE THE FIRST FRIEND, APPEND IT
                //NEXT [1+1] = [2], THE SECOND NODE IS ALSO EMPTY AND WILL BE THE SECOND FRIEND, APPEND IT
                //WITH THE NEXT RELOAD OF THE FRIENDS THERE WILL ALREADY BE 3 CHILDS: TEXT, TR, TR
                //AGAIN AT [0+1] = [1], THE FIRST NODE IS NOT EMPTY THIS TIME, THE FIRST FRIEND IS ALREADY IN IT, REPLACE IT
                //THIS GOES ON..
                if (tbody.childNodes[i + 1] != null) {
                    tbody.replaceChild(tr, tbody.childNodes[i + 1]);
                } else {
                    tbody.appendChild(tr);
                }

            }


            //CHECK EVERY TEN SECONDS IF FRIEND IS ONLINE/OFFLINE
            //ALSO SHOW NEW FRIENDS THAT HAVE BEEN ADDED
            setTimeout("friendList()", 10000);

        }
    }

}

//MORE CHAT