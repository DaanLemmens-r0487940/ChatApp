var addNewFriend = document.getElementById("addFriend");
addNewFriend.onclick = addFriend;
var xHRObject = new XMLHttpRequest();

function addFriend () {
    var friendUserId = document.getElementById("friendUserId").value;
    //why??
    var encode  = "friendUserId=" + encodeURIComponent(friendUserId);
    //FORM DUS POST
    xHRObject.open("POST", "Controller?action=AddFriend", true);
    //?????
    xHRObject.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xHRObject.send(encode);
    //?????
    document.getElementById("friendUserId").value = "";
}