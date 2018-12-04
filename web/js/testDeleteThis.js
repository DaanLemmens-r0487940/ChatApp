//var statusRequest = new XMLHttpRequest();
document.getElementById("changeStatus").onclick = changeStatus;

var getFriendListRequest = new XMLHttpRequest();
window.onload = friendList;

function changeStatus () {
    var newStatusValue = document.getElementById("status").value;
    var currentStatus = document.getElementById("currentStatus");
    if (newStatusValue == "") {
        currentStatus.innerHTML = "Online";
    }
    else {
        currentStatus.innerHTML = newStatusValue;
    }
}

function friendList(){
    getFriendListRequest.open("GET", "Controller?action=GetFriends", true);
    getFriendListRequest.onreadystatechange = friendListData;
    getFriendListRequest.send(null);
}

function friendListData(){
    if (getFriendListRequest.status == 200){
        if (getFriendListRequest.readyState == 4){
            //alert(getFriendListRequest.responseText);
            var serverResponse = JSON.parse(getFriendListRequest.responseText);
            var friends = serverResponse.friendList;
            console.log("Friends")
            console.log(friends);

            var friendsTableBody = document.getElementById("friendList");
            var friendsTableRow = friendsTableBody.childNodes[0];

            if (friendsTableRow == null){
                friendsTableRow = document.createElement('tr');
                friendsTableRow.id ="friendText";

                var friendText = document.createTextNode(friends);
                friendsTableRow.appendChild(friendText);
                friendsTableRow.appendChild(friendsTableRow);
            }

            else {
                var friendText = document.createTextNode(friends);
                friendsTableRow.removeChild(friendsTableRow.childNodes[0]);
                friendsTableRow.appendChild(friendText);
            }
        }
    }
}